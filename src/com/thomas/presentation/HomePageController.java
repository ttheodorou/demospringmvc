package com.thomas.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.thomas.domaine.Employe;
import com.thomas.service.IEmployeManager;

public class HomePageController extends AbstractController {
	
	private IEmployeManager employeManager;
	

	public IEmployeManager getEmployeManager() {
		return employeManager;
	}


	public void setEmployeManager(IEmployeManager employeManager) {
		this.employeManager = employeManager;
	}


	public HomePageController() {
		super();
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Employe> listeDesEmployes = employeManager.getAllEmploye();
		
		
		return new ModelAndView("home", "employes",	listeDesEmployes);
	}

}
