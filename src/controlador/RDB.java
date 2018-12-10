package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 Soluciones básicas JDBC a operaciones con una Relational DataBase. El uso de sentencias preparadas sería manual a partir de un {@code Connection c}:<p>
<pre><code>
PreparedStatement x = c.prepareStatement("UPDATE cliente SET telefono = ? WHERE dni='55543347T';");
x.setString(1,"123456789");
x.executeUpdate();
x.close();
</code></pre>
 @author 
 */
public class RDB
{

    public static ResultSet query(Connection db,String sql)
    {
        if(db == null)
            return null;
        ResultSet rs;
        try
        {
            rs = db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
        }
        catch(SQLException ex)
        {
            rs = null;
        }
        return rs;
    }
    /**
     Ejecuta la actualización 'sql' sobre la conexión 'db', devolviendo el número de filas actualizadas.
     <p>
     @param db  conexión con la BD
     @param sql sentencia SQL de actualización (INSERT, UPDATE o DELETE usualmente)
     <p>
     @return número de filas actualizadas, -1 en caso de error
     */
    public static int update(Connection db,String sql)
    {
        if(db == null)
            return -1;
        int n;
        try
        {
            n = db.createStatement().executeUpdate(sql);
        }
        catch(SQLException ex)
        {
            n = -1;
        }
        return n;
    }
    /**
     Devuelve una cadena con una representación tabulada de 'table'.<br>
     <p>
     @param db    conexión con la BD
     @param table nombre de la tabla
     @param mfw   <i>max field width</i>, debe ser mayor que cero. Número máximo de caracteres a imprimir para cualquier valor de la tabla
     <p>
     @return cadena citada, {@code "EMPTY"} si está vacía, o {@code null} en caso de error
     */
    public static String table_toString(Connection db,String table,int mfw)
    {
        return resultSet_toString(query(db,"SELECT * FROM " + table),mfw);
    }
    /**
     Devuelve una cadena con una representación tabulada de la tabla consulta 'rs'.<br>
     Requiere que 'rs' sea navegable, ver {@code resultSet_isNavigable()}.<br>
     Este método dejará el cursor al frente de 'rs', justo antes de la primera fila.
     <p>
     @param rs  {@code ResultSet} de entrada
     @param mfw <i>max field width</i>, debe ser mayor que cero. Número máximo de caracteres a imprimir para cualquier valor de la tabla consulta
     <p>
     @return cadena citada, {@code "EMPTY"} si está vacía, o {@code null} en caso de error
     */
    public static String resultSet_toString(ResultSet rs,int mfw)
    {
        if(rs == null)
            return null;
        int width = resultSet_getWidth(rs), height = resultSet_getHeight(rs);
        if(width == -1 || height == -1 || mfw <= 0 || !resultSet_isNavigable(rs))
            return null;
        if(width == 0)
            return "EMPTY";
        Object[] columns = new Object[width];
        for(int i = 0; i < width; i++)
            columns[i] = new ArrayList<String>();
        try
        {
            if(!rs.first())
                return "EMPTY";
            for(int c = 1; c <= width; c++)
                ((ArrayList<String>)columns[c - 1]).add(rs.getMetaData().getColumnLabel(c).toUpperCase());
            do
                for(int c = 1; c <= width; c++)
                    ((ArrayList<String>)columns[c - 1]).add(rs.getString(c));
            while(rs.next());
            rs.beforeFirst();
        }
        catch(SQLException ex)
        {
            return null;
        }
        int[] mfws = getMFWs(columns,mfw);
        int sepLen = 3 * width + 1; //Se calculará el ancho de la línea separadora en la tabla impresa
        for(int w : mfws)
            sepLen += w;
        String line = getLineSeparator(sepLen) + "\n";
        StringBuilder str = new StringBuilder(line);
        for(int r = 0; r <= height; r++) //<= debido a que hay que incluir la línea de los nombres de las columnas
        {
            str.append("|");
            for(int f = 0; f < width; f++)
                str.append(getFixedField(((ArrayList<String>)columns[f]).get(r),mfws[f]));
            str.append("\n").append(line);
        }
        return str.toString();
    }
    /**
     Dada la tabla consulta en 'rs', devuelve su número de columnas.
     <p>
     @param rs {@code ResultSet} de la consulta
     <p>
     @return ancho de la tabla consulta, -1 en caso de error
     */
    public static int resultSet_getWidth(ResultSet rs)
    {
        if(rs == null)
            return -1;
        int n;
        try
        {
            n = rs.getMetaData().getColumnCount();
        }
        catch(SQLException e)
        {
            n = -1;
        }
        return n;
    }
    /**
     Dada la tabla consulta en 'rs', devuelve su número de filas.<br>
     Requiere que 'rs' sea navegable, ver {@code resultSet_isNavigable()}.<br>
     Este método dejará el cursor al frente de 'rs', justo antes de la primera fila.
     <p>
     @param rs {@code ResultSet} de la consulta
     <p>
     @return alto de la tabla consulta, -1 en caso de error
     */
    public static int resultSet_getHeight(ResultSet rs)
    {
        if(rs == null || !resultSet_isNavigable(rs))
            return -1;
        int n;
        try
        {
            if(!rs.last())
                return 0;
            n = rs.getRow();
            rs.beforeFirst();
        }
        catch(SQLException e)
        {
            n = -1;
        }
        return n;
    }
    /**
     Comprueba si una tabla consulta 'rs' es navegable hacia delante y atrás en sus filas, esto es, <u>no es</u> de tipo {@code ResultSet.TYPE_FORWARD_ONLY}.
     <p>
     @param rs {@code ResultSet} de entrada
     <p>
     @return true cuando se puede navegar hacia delante y atrás en las filas, false si <u>no se pudo garantizar</u>
     */
    public static boolean resultSet_isNavigable(ResultSet rs)
    {
        if(rs == null)
            return false;
        boolean is;
        try
        {
            is = rs.getType() != ResultSet.TYPE_FORWARD_ONLY;
        }
        catch(SQLException e)
        {
            is = false;
        }
        return is;
    }

    private static String getLineSeparator(int width)
    {
        StringBuilder str = new StringBuilder();
        str.append('|');
        for(int i = 0; i < width - 2; i++)
            str.append('-');
        str.append('|');
        return str.toString();
    }
    private static String getFixedField(String field,int width)
    {
        if(field.length() > width)
            field = field.substring(0,width);
        StringBuilder str = new StringBuilder(" " + field);
        int space = width - field.length();
        for(int i = 0; i < space; i++)
            str.append(' ');
        str.append(" |");
        return str.toString();
    }
    private static int[] getMFWs(Object[] columns,int mfw)
    {
        int j = 0;
        int[] mfws = new int[columns.length];
        for(Object o : columns)
        {
            ArrayList<String> column = (ArrayList<String>)o;
            int mfwAct = 1;
            for(String field : column)
                if(field.length() > mfwAct)
                    mfwAct = field.length();
            if(mfwAct > mfw)
                mfwAct = mfw;
            mfws[j++] = mfwAct;
        }
        return mfws;
    }
}
