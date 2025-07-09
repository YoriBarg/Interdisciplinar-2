/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interdisciplinar;


/**
 *
 * @author yurib
 */
public class Time {
    private int idTime;
    private String nomet;
    private String CorPrimaria;
    private String CorSecundaria;
    private String CorTerciaria;
    private String brasao;   
        
    public int getIdTime() { 
        return idTime; }
    
    public void setId(int id) { 
        this.idTime = id; }

    public String getTime() { 
        return nomet; }
    
    public void setTime(String nome) { 
        this.nomet = nome; }
    
    public String getCorPrimaria() { 
        return CorPrimaria; }
    
    public void setCorPrimaria(String CorPrimaria) { 
        this.CorPrimaria = CorPrimaria; }
    
    public String getCorSecundaria() { 
        return CorSecundaria; }
    
    public void setCorSecundaria(String CorSecundaria) { 
        this.CorSecundaria = CorSecundaria; }
    
    public String getCorTerciaria() { 
        return CorTerciaria; }
    
    public void setCorTerciaria(String CorTerciaria) { 
        this.CorTerciaria = CorTerciaria; }

    public String getBrasao() { 
        return brasao; }
    
    public void setBrasao(String brasao) { 
        this.brasao = brasao; }
}

