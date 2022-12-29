/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author iii
 */
@Entity
@Getter
@Setter
public class Contract implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contract_id;
    
    @ManyToMany
    private List<User> manager;
    
    @ManyToOne
    private Company company;
    
    private String number;
    
    public Contract ()
    {
        
    }
    
    public Contract (String number, List<Company> company, List<User> manager )
    {
        this.manager = manager;
        this.number = number;
    }
    
}
