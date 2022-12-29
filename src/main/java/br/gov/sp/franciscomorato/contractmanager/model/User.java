/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author vinicius
 */
@Entity
@Data
public class User implements Serializable
{
    @Id
    private String username;

    private String name;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User()
    {

    }

    public User(String username, String name, String password, Set<Role> roles)
    {
        this.username = username;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
}
