/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arul;

import java.net.BindException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Nithya
 */
public class CustomerFormController extends SimpleFormController{
    
    public CustomerFormController(){
        System.out.println("---CustomerFormController---");
	setCommandClass(Customer.class);
	setCommandName("customerForm");
    }
    
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        System.out.println("nsubmit-1");
        return new ModelAndView("cuis");
    }

    protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {
       System.out.println("nsubmit-2");
       return new ModelAndView("cuis");
    }

    protected ModelAndView onSubmit(Object command) throws Exception {
       System.out.println("nsubmit-3");
       Customer c= (Customer)command;
       return new ModelAndView("CustomerSuccess","customer",c);
    }
    
    
    
//    protected ModelAndView onSubmit(HttpServletRequest request,
//			         HttpServletResponse response, Object command, BindException errors)
//			throws Exception {
//        System.out.println("---CustomerFormController.onSubmit---");
//	Customer customer = (Customer)command;
//	System.out.println(customer);
//	return new ModelAndView("CustomerSuccess11","customer",customer);
//	
//    }
    
    @Override
    protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
        System.out.println("---CustomerController.formBackingObject---");
	Customer cust = new Customer();
	//Make "Spring MVC" as default checked value
	cust.setFavFramework(new String []{"Spring MVC"});
		
	//Make "Make" as default radio button selected value
	cust.setSex("M");
		
	//make "Hibernate" as the default java skills selection
	cust.setJavaSkills("Hibernate");
		
	//initilize a hidden value
	cust.setSecretValue("I'm hidden value");
		
	return cust;
    }
	
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
		System.out.println("---CustomerController.referenceData---");
		Map referenceData = new HashMap();
		
		//Data referencing for web framework checkboxes
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
		referenceData.put("webFrameworkList", webFrameworkList);
		
		//Data referencing for number radiobuttons
		List<String> numberList = new ArrayList<String>();
		numberList.add("Number 1");
		numberList.add("Number 2");
		numberList.add("Number 3");
		numberList.add("Number 4");
		numberList.add("Number 5");
		referenceData.put("numberList", numberList);
		
		//Data referencing for country dropdown box
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		referenceData.put("countryList", country);
		
		//Data referencing for java skills list box
		Map<String,String> javaSkill = new LinkedHashMap<String,String>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("Apache Wicket", "Apache Wicket");
		javaSkill.put("Struts", "Struts");
		referenceData.put("javaSkillsList", javaSkill);
		
		return referenceData;
    }
}
