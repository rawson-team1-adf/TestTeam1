/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package modelo;

/**

 @author Arlen
 */
public class Material
{
    private int cod;
   private String tipo;
   private float precio;
    public Material(int cod,String tipo,float precio)
    {
        this.cod = cod;
        this.tipo = tipo;
        this.precio = precio;
    }
    public int getCod()
    {
        return cod;
    }
    public void setCod(int cod)
    {
        this.cod = cod;
    }
    public String getTipo()
    {
        return tipo;
    }
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    public float getPrecio()
    {
        return precio;
    }
    public void setPrecio(float precio)
    {
        this.precio = precio;
    }
 
    @Override
    public String toString()
    {
        return ""+cod+"-"+tipo;
    }
    
}
