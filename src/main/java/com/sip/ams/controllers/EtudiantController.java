package com.sip.ams.controllers;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.*;
@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
	
	public static List<Etudiant> students = new ArrayList<>();
	
	static {
		
		students.add(new Etudiant("Yosri",24,"y@gmail.com"));
		students.add(new Etudiant("Haitham",23,"h@gmail.com"));
		students.add(new Etudiant("Amine",25,"a@gmail.com"));
	}
	
	@RequestMapping("/list")
	public String listEtudiant(Model m)
	{
		
		m.addAttribute("students", students);
		return "etudiant/listEtudiant";
	}
	
	@GetMapping("/add")
	public String formAdd(Model m)
	{	Etudiant e = new Etudiant();
		m.addAttribute("etudiant", e);
		return "etudiant/addEtudiant";
	}
	
	@PostMapping("/add")
	//@ResponseBody
	//public String saveEtudiant(@RequestParam("nom") String nom,@RequestParam("email") String email,@RequestParam("age") int age)
	public String saveEtudiant(Etudiant etudiant)
	{	
		//return "etudiant/saveEtudiant";
		Etudiant e = new Etudiant(etudiant.getName(),etudiant.getAge(),etudiant.getEmail());
		//return nom +" "+email +" "+age;
		students.add(e);
		return "redirect:list";
		
	}
	@GetMapping("/delete/{email}")
	//@ResponseBody
	public String deleteEtudiant(@PathVariable("email") String mail)
	{
		int index=0;
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getEmail().equals(mail)) {
				students.remove(i);
				//index=i;
			}
		}
		//System.out.println(index);
		return "redirect:../list";
		//return "suppression"+mail;
		
	}
	
	
	
	@GetMapping("/update/{email}")
	//@ResponseBody
	public String getUpdateEtudiant(@PathVariable("email") String mail, Model m)
	{	
		int index = 0;
		
		for(int i=0; i<students.size(); i++)
		{
			if(students.get(i).getEmail().equals(mail))
			{
				index = i;
				break;
			}
		}
		
		Etudiant e = students.get(index);
		m.addAttribute("etudiant", e);

		
		return "etudiant/updateEtudiant";
	}
	
	@PostMapping("/update")
	//@ResponseBody
	public String updateEtudiant(Etudiant etudiant)
	{	
		int index = 0;
		
		for(int i=0; i<students.size(); i++)
		{
			if(students.get(i).getEmail().equals(etudiant.getEmail()))
			{
				index = i;
				break;
			}
		}
		
		students.get(index).setName(etudiant.getName());
		//students.get(index).setEmail(etudiant.getEmail());
		students.get(index).setAge(etudiant.getAge());


		
		return "redirect:list";
	}

}