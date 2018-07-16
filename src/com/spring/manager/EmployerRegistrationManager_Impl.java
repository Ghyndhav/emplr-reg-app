package com.spring.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.bo.EmployerRegistration;
import com.spring.das.EmployerRegistrationDAS;

@Service
public class EmployerRegistrationManager_Impl implements EmployerRegistrationManager {

	@Autowired
	private EmployerRegistrationDAS employerRegistrationDAS;
	@Override
	@Transactional
	public List<EmployerRegistration> searchEmployerRegistrations() {
		return employerRegistrationDAS.searchEmployerRegistrations();
	}
	@Override
	@Transactional
	public void saveEmployerRegistration(EmployerRegistration employerRegistration) {
			
		employerRegistrationDAS.saveEmployerRegistration(employerRegistration);
		
	}
	@Override
	@Transactional
	public EmployerRegistration searchEmployerRegistration(int id) {
		return employerRegistrationDAS.searchEmployerRegistration(id);
	}
	
	@Override
	@Transactional
	public void deleteEmployerRegistration(int id) {
		employerRegistrationDAS.deleteEmployerRegistration(id);
		
	}

	@Override
	@Transactional
	public List<EmployerRegistration> searchEmployerRegistration(String emplrName) {
		return employerRegistrationDAS.searchEmployerRegistration(emplrName);
	}
}
