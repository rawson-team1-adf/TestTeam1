/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Material;
import modelo.Silla;

/**

 @author Arlen
 */
public class Gestor
{

    public static DefaultComboBoxModel<Material> materiales = new DefaultComboBoxModel();
    public static DefaultComboBoxModel<Silla> sillas = new DefaultComboBoxModel();

    public static final int DB_UCANACCESS = 1,
            DB_MYSQL_LOCALHOST = 2;

    /**
     Conecta a la BD dedfdfdfdf tipo 'dbType', abriendo el esquema apuntado por 'dbFile'.
     <p>
     @param dbType tipo de BD relacional:<br>RDB.DB_UCANACCESS<br>RDB.DB_MYSQL_LOCALHOST
     @param dbFile fichero que apunta al esquema
     <p>
     @return {@code Connection} para manipular la conexión, {@code null} en caso de error
     */
    /**
     Conecta a la BD de tipo 'dbType', abriendo el esquema apuntado por 'dbFile', usando el login 'user' + 'passwd'.
     <p>
     @param dbType tipo de BD relacional:<br>RDB.DB_UCANACCESS<br>RDB.DB_MYSQL_LOCALHOST
     @param dbFile fichero que apunta al esquema
     @param user   nombre de usuario (de no existir, asignar {@code null})
     @param passwd clave de usuario (de no existir, asignar {@code null})
     <p>
     @return {@code Connection} para manipular la conexión, {@code null} en caso de error
    Los datos para la conexion se encuentran en el archivo properties
     */
    public static Connection connect(int dbType)
    {
        Properties prop = new Properties();
        try
        {
            prop.load(new FileInputStream("src/Config/config.properties"));
        }
        catch(IOException ex)
        {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE,null,ex);
        }
        Connection con = null;
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String pass = prop.getProperty("password");
        try
        {
            switch(dbType)
            {
                case DB_UCANACCESS:
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    url = "jdbc:ucanaccess://" + prop.getProperty("ruta");
                    break;
                case DB_MYSQL_LOCALHOST:
                    Class.forName("com.mysql.jdbc.Driver");
                    url = prop.getProperty("rutaSql");
                    break;
                default:
                    return null;
            }
        }
        catch(ClassNotFoundException ex)
        {
            return null;
        }
        Connection c;
        try
        {
            if(user != null && pass != null)
            {
                c = DriverManager.getConnection(url,user,pass);
            }
            else
            {
                c = DriverManager.getConnection(url);
            }
        }
        catch(SQLException ex)
        {
            c = null;
        }
        return c;
    }
    /**
     Finaliza (commit) cualquier transacción en curso y cierra la conexión liberando los recursos JDBC usados por la misma.
     <p>
     @param c conexión a cerrar
     <p>
     @return true cuando se garantiza un estado de cierre, false en caso contrario
     */
    public static boolean disconnect(Connection c)
    {
        try
        {
            if(c.isClosed())
            {
                return true;
            }
            c.commit();
            c.close();
            return true;
        }
        catch(SQLException ex)
        {
            return false;
        }
    }
    /**
     Ejecuta la consulta 'sql' sobre la conexión 'db', devolviendo un {@code ResultSet} de sólo lectura, navegable según {@code resultSet_isNavigable()}.<br>
     <p>
     @param db  conexión con la BD
     @param sql sentencia SQL de consulta (SELECT usualmente)
     <p>
     @return tabla consulta navegable, {@code null} en caso de error
     */
/**
    consulta que llena el combo materiales
    */
    public static void loadMateriales()
    {
        Connection con = connect(1);
        try
        {
            Statement consulta = con.createStatement();
            ResultSet rs = consulta.executeQuery("select * from material");
            while(rs.next())
            {
                materiales.addElement(new Material(rs.getInt("codMaterial"),rs.getString("tipo"),rs.getFloat("precio")));
            }
            rs.close();
            disconnect(con);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error de conexión");
        }
    }
    //consulta que llena el combo sillas
    public static void loadSillas()
    {
        Connection con = connect(1);
        try
        {
            Statement consulta = con.createStatement();
            ResultSet rs = consulta.executeQuery("select * from silla");
            while(rs.next())
            {
                Material m = getMaterial(rs.getInt("codMaterial"));
                sillas.addElement(new Silla(m.getCod(),m.getTipo(),m.getPrecio(),
                                            rs.getInt("id"),rs.getString("estilo"),rs.getInt("giratoria"),rs.getInt("reclinable")));
            }
            rs.close();
            disconnect(con);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error de conexión");
        }
    }
    public static void insertarMaterial(String tipo,float f)
    {
        Connection con = connect(1);
        try
        {
            PreparedStatement consulta = con.prepareStatement("insert into material (tipo,precio) values (?,?)");
            consulta.setString(1,tipo);
            consulta.setFloat(2,f);
            consulta.executeUpdate();
            consulta.close();
            con.commit();
        }
        catch(SQLException ex)
        {
            try
            {
                con.rollback();
            }
            catch(SQLException ex1)
            {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void updateMaterial(int cod,String tipo,float precio)
    {
        Connection con = connect(1);
        try
        {
            PreparedStatement consulta = con.prepareStatement("update material set tipo=?, precio=? where codMaterial=?");
            consulta.setInt(3,cod);
            consulta.setString(1,tipo);
            consulta.setFloat(2,precio);
            consulta.executeUpdate();
            consulta.close();
            con.commit();
        }
        catch(SQLException ex)
        {
            try
            {
                con.rollback();
            }
            catch(SQLException ex1)
            {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE,null,ex1);
            }
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException ex)
            {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
    public static void updateSeat(int cod,int id,String estilo,int gira,int reclina)
    {
        Connection con = connect(1);
        try
        {
            PreparedStatement consulta = con.prepareStatement("update silla set codMaterial=?, estilo=?, giratoria=?,reclinable=? where id=?");
            consulta.setInt(1,cod);
            consulta.setString(2,estilo);
            consulta.setInt(3,gira);
            consulta.setInt(4,reclina);
            consulta.setInt(5,id);
            consulta.executeUpdate();
            consulta.close();
            con.commit();
        }
        catch(SQLException ex)
        {
            try
            {
                con.rollback();
            }
            catch(SQLException ex1)
            {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE,null,ex1);
            }
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException ex)
            {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
//metodo general delete al que se le pasa la sentencia sql
    public static int delete(String sql)
    {
        Connection con = connect(1);
        int error = 0;
        try
        {
            Statement consulta = con.createStatement();
            consulta.execute(sql);
            consulta.close();
            con.commit();
        }
        catch(SQLException ex)
        {
            try
            {
                con.rollback();
            }
            catch(SQLException ex1)
            {
                error = ex1.getErrorCode();
            }
            error = ex.getErrorCode();
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException ex)
            {
                error = ex.getErrorCode();
            }
        }
        return error;
    }

    public static void insertSilla(int codMaterial,String estilo,int gira,int reclina)
    {
        Connection con = connect(1);
        try
        {
            PreparedStatement consulta = con.prepareStatement("insert into silla (codMaterial,id,estilo,giratoria,reclinable) values (?,?,?,?,?)");
            consulta.setInt(1,codMaterial);
            consulta.setInt(2,0);
            consulta.setString(3,estilo);
            consulta.setInt(4,gira);
            consulta.setInt(5,reclina);
            consulta.executeUpdate();
            consulta.close();
            con.commit();
        }
        catch(SQLException ex)
        {
            try
            {
                con.rollback();
            }
            catch(SQLException ex1)
            {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void updateMateriales()
    {
        materiales.removeAllElements();
        loadMateriales();
    }
    public static void updateSillas()
    {
        sillas.removeAllElements();
        loadSillas();
    }
// metodo que devuelve un meterial buscado x codigo en el combo materiales
    public static Material getMaterial(int cod)
    {
        Material m = null;
        for(int i = 0; i < materiales.getSize(); i++)
        {
            if(materiales.getElementAt(i).getCod() == cod)
            {
                m = materiales.getElementAt(i);
            }
        }
        return m;
    }
//método general de consultas de silla que genera una tabla
    /**
    
    @param sql sentencia sql
    */
    public static void consultarSillas(String sql)
    {
        Connection con = connect(1);
        try
        {
            Statement consulta = con.createStatement();
            ResultSet rs = consulta.executeQuery("sql");
            while(rs.next())
            {
                Material m = getMaterial(rs.getInt("codMaterial"));
                Silla s = new Silla(m.getCod(),m.getTipo(),m.getPrecio(),rs.getInt("id"),rs.getString("estilo"),rs.getInt("giratoria"),rs.getInt("reclinable"));
            }
            rs.close();
            disconnect(con);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
