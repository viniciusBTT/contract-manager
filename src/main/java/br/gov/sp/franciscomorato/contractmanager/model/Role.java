/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author iii
 */
@Entity
@Data
public class Role {
    
    @Id
    private String role_name;
    
    public Role()
    {
        
    }
    
    public Role(String role_name)
    {
        this.role_name = role_name;
    }
    
}
