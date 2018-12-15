/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Omar
 */
public class Usuario {
    
    private int idSystemUser;
    private String name;
    private String role;
    private String password;

    public Usuario(int idSystemUser, String name, String role, String password) {
        this.idSystemUser = idSystemUser;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public int getIdSystemUser() {
        return idSystemUser;
    }

    public void setIdSystemUser(int idSystemUser) {
        this.idSystemUser = idSystemUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
