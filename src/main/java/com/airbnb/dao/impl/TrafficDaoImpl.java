package com.airbnb.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.airbnb.dao.TrafficDao;
import com.airbnb.model.Traffic;

public class TrafficDaoImpl implements TrafficDao{

	public List<Traffic> getTrafficOnHoliday(String holiday) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2"); 
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Traffic> cq = cb.createQuery(Traffic.class);
		Root<Traffic> traffic = cq.from(Traffic.class);
		
		cq.select(traffic).where(cb.equal(traffic.get("holiday"), holiday));
		
		return em.createQuery(cq).getResultList();
	}

}
