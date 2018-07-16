package com.spring.manager;

import java.util.List;

import com.spring.bo.EmployerRegistration;

public interface EmployerRegistrationManager {
	
	public List<EmployerRegistration> searchEmployerRegistrations();

	public void saveEmployerRegistration(EmployerRegistration employerRegistration);

	public EmployerRegistration searchEmployerRegistration(int id);

	public void deleteEmployerRegistration(int id);
	
	public List<EmployerRegistration> searchEmployerRegistration(String emplrName);
}
