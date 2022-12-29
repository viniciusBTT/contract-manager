package br.gov.sp.franciscomorato.contractmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;




@ComponentScan(basePackages = {  
    "br.gov.sp.franciscomorato.contractmanager.model",
    "br.gov.sp.franciscomorato.contractmanager.configuration",
    "br.gov.sp.franciscomorato.contractmanager.controller",
    "br.gov.sp.franciscomorato.contractmanager.repository",
    "br.gov.sp.franciscomorato.contractmanager.service"
})

//informando onde estão os modelos das entidades 
@EntityScan(basePackages = {
    "br.gov.sp.franciscomorato.contractmanager.model"    
})

@EnableAutoConfiguration
public class ContractManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractManagerApplication.class, args);
	}

}
