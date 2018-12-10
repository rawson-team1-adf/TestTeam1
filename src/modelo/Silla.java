/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package modelo;

/**

 @author Arlen
 */
public class Silla extends Material
{
   
    private int id;
    private String estilo;
    private int giratoria;
    private int reclinable;
  
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getEstilo()
    {
        return estilo;
    }
    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }
    public int getGiratoria()
    {
        return giratoria;
    }
    public void setGiratoria(int giratoria)
    {
        this.giratoria = giratoria;
    }
    public int getReclinable()
    {
        return reclinable;
    }
    public void setReclinable(int reclinable)
    {
        this.reclinable = reclinable;
    }
  
    public Silla(int codMaterial,String tipo,float precio,int id,String estilo,int giratoria,int reclinable)
    {
        super(codMaterial,tipo,precio);
     
        this.id = id;
        this.estilo = estilo;
        this.giratoria = giratoria;
        this.reclinable = reclinable;
    }
    @Override
    public int getCod()
    {
        return super.getCod(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString()
    {
        return ""+id+"-"+estilo;
    }
  

}
