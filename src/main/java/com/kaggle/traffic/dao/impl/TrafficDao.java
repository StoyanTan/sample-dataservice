package com.kaggle.traffic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.kaggle.traffic.dao.ITrafficDao;
import com.kaggle.traffic.model.Filter;
import com.kaggle.traffic.model.TrafficIncident;

public class TrafficDao implements ITrafficDao {

	private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("h2");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
	
	public List<TrafficIncident> getTraffic(Filter filter) {

		EntityManager em = TrafficDao.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();  
		CriteriaQuery<TrafficIncident> cq = cb.createQuery(TrafficIncident.class);
		Root<TrafficIncident> traffic = cq.from(TrafficIncident.class);
		
		if(filter == null || filter.getFilterCriteria() == null) {
			cq.select(traffic);
		} else {
			cq.select(traffic).where(cb.equal(traffic.get(filter.getFilterCriteria()), filter.getValue()));
		}

		return em.createQuery(cq).setMaxResults(100).getResultList();
	}
}
