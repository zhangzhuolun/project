package com.nq.sch_oa.function.dao.resource.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nq.sch_oa.function.dao.resource.ResourceDao;
import com.nq.sch_oa.function.model.oracle.SchResource;
import com.nq.sch_oa.dao.hibernate.impl.CP_Hibernate4DAOImpl;

@Repository("resourceDaoImpl")
public class ResourceDaoImpl implements ResourceDao{

	private static final Logger logger = Logger.getLogger(ResourceDaoImpl.class);
	
	@Resource(name = "hibernateDAO")
	private CP_Hibernate4DAOImpl hibernate4DAOImpl;
	@Override
	public List<SchResource> getListData(int start, int limit) {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchResource.class);
		criteria.setFirstResult(start);
		criteria.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<SchResource> list = criteria.list();
		return list;
	}

	@Override
	public long getListCount() {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchResource.class);
		return criteria.list().size();
	}

	@Override
	public List<SchResource> getListData() {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchResource.class);
		@SuppressWarnings("unchecked")
		List<SchResource> list =  criteria.list();
		return list;
	}

	@Override
	public boolean saveSchResource(SchResource schResource) {
		// TODO Auto-generated method stub
		boolean falg = false;
		try {
			SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			if (StringUtils.isBlank(schResource.getResourceId()+"")) {
				session.save(schResource);
				falg = true;
			} else {
				session.update(schResource);
				falg = true;
			}
			tx.commit();
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return falg;
	}

	@Override
	public boolean deleteSchResource(SchResource schResource) {
		// TODO Auto-generated method stub
		boolean falg = false;
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		if(StringUtils.isBlank(schResource.getResourceId()+"")){
			session.delete(schResource);
			falg = true;
		}
		tx.commit();
		return falg;
	}

	@Override
	public SchResource getById(String id) {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		SchResource schResource = (SchResource)session.get(SchResource.class,id);
		return schResource;
	}

}
