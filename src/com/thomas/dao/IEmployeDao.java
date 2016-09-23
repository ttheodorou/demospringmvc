package com.thomas.dao;

import java.util.List;

import com.thomas.domaine.Employe;

public interface IEmployeDao {

	public void saveEmploye(Employe employe);

	public Employe getEmployeById(int id);

	public Employe getEmployeByLogin(String login);

	public int getEmployeCount();

	public List<Employe> getAllEmploye();

}
