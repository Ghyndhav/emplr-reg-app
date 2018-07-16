package com.spring.das;

import java.util.List;

import com.spring.bo.EmployerRegistration;

public interface EmployerRegistrationDAS {
	
	public List<EmployerRegistration> searchEmployerRegistrations();

	public void saveEmployerRegistration(EmployerRegistration theCustomer);

	public EmployerRegistration searchEmployerRegistration(int id);

	public void deleteEmployerRegistration(int id);
	
	public List<EmployerRegistration> searchEmployerRegistration(String emplrName);

}
