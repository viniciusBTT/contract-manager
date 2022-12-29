/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author iii
 */
@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_invoice;
    
    private float value;
    
    private Date  due_date;
    
    @ManyToOne
    private Company company;
    
    
    public  Invoice()
    {
        
    }
    
    public Invoice(float value, Date due_date, Company company)
    {
        this.due_date = due_date;
        this.value = value;
        this.company = company;
    }        
    
}
