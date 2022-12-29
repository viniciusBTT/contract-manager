/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author iii
 */
@Entity
@Data
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer company_id;
    
    private String fantasy_name;
    
    private String busines_name;
    
    private String phone;
    
    private String email;
    
    @Column(unique = true)
    private String cnpj;
    
    public Company ()
    {
        
    }
    
    public Company
        (String fantasy_name, String busines_name, String phone,
         String email, String cnpj)
    {
        this.fantasy_name = fantasy_name;
        this.busines_name = busines_name;
        this.phone = phone;
        this.email = email;
        this.cnpj = cnpj;
    }
    
    
}
