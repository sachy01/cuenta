/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajom03;

/**
 *
 * @author ASIX1
 */
public class Usuario {
    
    private String user;
    private String contraseña;
    private String rol;
    
    
    //Constructor

    public Usuario(String user, String contraseña, String rol) {
        this.user = user;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Usuario() {
    }
    
    
    
    //Getters y Setters

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
