package com.spring.das;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bo.EmployerRegistration;

@Repository
public class EmployerRegistrationDAS_Impl implements EmployerRegistrationDAS {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<EmployerRegistration> searchEmployerRegistrations() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<EmployerRegistration> theQuery = session.createQuery("from EmployerRegistration order by emplr_name ",EmployerRegistration.class);
		
		List<EmployerRegistration> employerRegistrations = theQuery.getResultList();
		
		return employerRegistrations;
	}


	@Override
	public void saveEmployerRegistration(EmployerRegistration employerRegistration) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employerRegistration);
	}


	@Override
	public EmployerRegistration searchEmployerRegistration(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(EmployerRegistration.class, id) ;
	}


	@Override
	public void deleteEmployerRegistration(int id) {
		Session session = sessionFactory.getCurrentSession();
		EmployerRegistration employerRegistration = session.get(EmployerRegistration.class, id);
		session.delete(employerRegistration);
	}

	@Override
	public List<EmployerRegistration> searchEmployerRegistration(String emplrName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(" FROM EmployerRegistration WHERE emplr_name = :emplrName");
		query.setParameter("emplrName", emplrName);
		return (List<EmployerRegistration>) query.getResultList();
	}

}
