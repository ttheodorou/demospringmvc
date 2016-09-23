package com.thomas.service;

import java.util.List;

import com.thomas.dao.IEmployeDao;
import com.thomas.domaine.Employe;

public class EmployeManager implements IEmployeManager {

	private IEmployeDao employeDao;

	public IEmployeDao getEmployeDao() {
		return employeDao;
	}

	public void setEmployeDao(IEmployeDao employeDao) {
		this.employeDao = employeDao;
	}

	public EmployeManager() {
		super();
	}

	@Override
	public void saveEmploye(Employe employe) {
		employeDao.saveEmploye(employe);

	}

	@Override
	public Employe getEmployeById(int id) {
		Employe employe = employeDao.getEmployeById(id);
		return employe;
	}

	@Override
	public Employe getEmployeByLogin(String login) {
		Employe employe = employeDao.getEmployeByLogin(login);
		return employe;
	}

	@Override
	public int getEmployeCount() {
		int numEmployes = employeDao.getEmployeCount();
		return numEmployes;
	}

	@Override
	public List<Employe> getAllEmploye() {
		List<Employe> listesDesEmployes = employeDao.getAllEmploye();
		return listesDesEmployes;
	}

}
