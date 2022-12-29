/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.sp.franciscomorato.contractmanager.controller;

import br.gov.sp.franciscomorato.contractmanager.model.Company;
import br.gov.sp.franciscomorato.contractmanager.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author vinicius
 */
@Controller
@RequestMapping("/company")
public class CompanyControler {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String company(Model model)
    { 
        model.addAttribute("company", companyService.findAll());
        return "company/company";
    }

    @GetMapping("/cadastro")
    public String car()
    {
        return "company/cadastro";
    }

    @PostMapping(value = "/save")
    public ModelAndView save(Company company, RedirectAttributes status)
    {
        try
        {
            status.addFlashAttribute("success", "Usuario cadastrado com sucesso!");
            companyService.save(company);
        } 
        catch (Exception e) 
        {
            status.addFlashAttribute("success", "Empresa cadastrado com sucesso!");
            System.out.println("Erro ai salvar a empresa" + e.getMessage());
        }
        return new ModelAndView("redirect:/company");
    }

    @PostMapping(value = "/delete/{id}")
    public ModelAndView delete (@PathVariable Integer id, RedirectAttributes ra)
    {
        try {
            companyService.delete(id);
            ra.addFlashAttribute("sucess", "Empresa deletada com sucesso");
        } catch (Exception e) {
        System.out.println("Erro ao apagar a empresa: " + e.getMessage());
        }
        return new ModelAndView("redirect:/copany/company");
    }

    
    
    
    
    @GetMapping(value = "/serch")
    public String search (@RequestParam("id") Integer id, Model model)
    {
      model.addAttribute("car", companyService.findById(id));  
      return "company/company";
    }

}
