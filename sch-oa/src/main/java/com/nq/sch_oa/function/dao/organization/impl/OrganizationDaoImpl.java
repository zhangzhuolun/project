package com.nq.sch_oa.function.dao.organization.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nq.sch_oa.function.dao.organization.OrganizationDao;
import com.nq.sch_oa.function.model.oracle.SchOrganization;
import com.nq.sch_oa.dao.hibernate.impl.CP_Hibernate4DAOImpl;

@Repository("organizationDaoImpl")
public class OrganizationDaoImpl implements OrganizationDao{

	private static final Logger logger = Logger.getLogger(OrganizationDaoImpl.class);
	
	@Resource(name = "hibernateDAO")
	private CP_Hibernate4DAOImpl hibernate4DAOImpl;
	@Override
	public List<SchOrganization> getListData(int start, int limit) {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchOrganization.class);
		criteria.setFirstResult(start);
		criteria.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<SchOrganization> list = criteria.list();
		return list;
	}

	@Override
	public long getListCount() {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchOrganization.class);
		return criteria.list().size();
	}

	@Override
	public List<SchOrganization> getListData() {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchOrganization.class);
		@SuppressWarnings("unchecked")
		List<SchOrganization> list =  criteria.list();
		return list;
	}

	@Override
	public boolean saveSchOrganization(SchOrganization schOrganization) {
		// TODO Auto-generated method stub
		boolean falg = false;
		try {
			SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			if (StringUtils.isBlank(schOrganization.getOrgId()+"")) {
				session.save(schOrganization);
				falg = true;
			} else {
				session.update(schOrganization);
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
	public boolean deleteSchOrganization(SchOrganization schOrganization) {
		// TODO Auto-generated method stub
		boolean falg = false;
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		if(StringUtils.isBlank(schOrganization.getOrgId()+"")){
			session.delete(schOrganization);
			falg = true;
		}
		tx.commit();
		return falg;
	}

	@Override
	public SchOrganization getById(String id) {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		SchOrganization schOrganization = (SchOrganization)session.get(SchOrganization.class,id);
		return schOrganization;
	}

}
