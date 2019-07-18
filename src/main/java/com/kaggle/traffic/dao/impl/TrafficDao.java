package com.kaggle.traffic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.kaggle.traffic.dao.ITrafficDao;
import com.kaggle.traffic.model.Filter;
import com.kaggle.traffic.model.ParameterValueObject;
import com.kaggle.traffic.model.TrafficIncident;

public class TrafficDao implements ITrafficDao {

	private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("h2");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    EntityManager em = TrafficDao.getEntityManager();
	CriteriaBuilder cb = em.getCriteriaBuilder(); 
	
    public List<ParameterValueObject> getClustering(Filter filter) {
    	
    	CriteriaQuery<Tuple> query = cb.createTupleQuery();
        Root<TrafficIncident> traffic = query.from(TrafficIncident.class);
        query.select(cb.tuple(traffic.get(filter.getFilterCriteria()), cb.count(traffic.get(filter.getFilterCriteria()))))
        	.groupBy(traffic.get(filter.getFilterCriteria()));
        List<Tuple> resultList = em.createQuery(query).getResultList();
        
        	List<ParameterValueObject> objectResult = new ArrayList<>();
        	for (Tuple tuple : resultList){
        		if (tuple.get(0) == null){
        			continue;
        		} else {
        		ParameterValueObject object = new ParameterValueObject();
        		object.setParameter(tuple.get(0).toString());
        		object.setCount(tuple.get(1).toString());
        		objectResult.add(object);
        		}
        	}
        	return objectResult;
    }
    
	public List<TrafficIncident> getTraffic(Filter filter, int offset, int pageSize) {
 
		CriteriaQuery<TrafficIncident> cq = cb.createQuery(TrafficIncident.class);
		Root<TrafficIncident> traffic = cq.from(TrafficIncident.class);
		
		if(filter == null || filter.getFilterCriteria() == null) {
			cq.select(traffic);
		} else {
			cq.select(traffic).where(cb.equal(traffic.get(filter.getFilterCriteria()), filter.getValue()));
		}

		return em.createQuery(cq).setFirstResult(offset).setMaxResults(pageSize).getResultList();
	}

	@Override
	public TrafficIncident getIncidentById(Filter filter) {
		
		CriteriaQuery<TrafficIncident> cq = cb.createQuery(TrafficIncident.class);
		Root<TrafficIncident> traffic = cq.from(TrafficIncident.class);
		
		if(filter == null || filter.getFilterCriteria() == null) {
			return null;
		} else {
			cq.select(traffic).where(cb.equal(traffic.get(filter.getFilterCriteria()), filter.getValue()));
		}
		return em.createQuery(cq).getSingleResult();
		
	}
}
