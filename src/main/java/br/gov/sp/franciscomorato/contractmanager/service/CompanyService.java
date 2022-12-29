/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.service;


import br.gov.sp.franciscomorato.contractmanager.model.Company;
import br.gov.sp.franciscomorato.contractmanager.repository.CompanyDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iii
 */
@Service
public class CompanyService  
{ 
    @Autowired
    private CompanyDAO companyDAO;
    
    public List<Company> findAll()
    {
        return companyDAO.findAll();
    }
    
   
    public Company save(Company company)
    {
        return companyDAO.save(company);
    }
    
     public Company findById(Integer id)
    {
        return companyDAO.findById(id).orElse(null);
    }

    public void delete(Integer id)
    {
        companyDAO.deleteById(id);
    }
            
             
     
}
