package com.nq.sch_oa.function.dao.personGroup.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nq.sch_oa.function.dao.personGroup.PersonGroupDao;
import com.nq.sch_oa.function.model.oracle.SchPersonGroup;
import com.nq.sch_oa.dao.hibernate.impl.CP_Hibernate4DAOImpl;

@Repository("personGroupDaoImpl")
public class PersonGroupDaoImpl implements PersonGroupDao{

	private static final Logger logger = Logger.getLogger(PersonGroupDaoImpl.class);
	
	@Resource(name = "hibernateDAO")
	private CP_Hibernate4DAOImpl hibernate4DAOImpl;
	@Override
	public List<SchPersonGroup> getListData(int start, int limit) {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchPersonGroup.class);
		criteria.setFirstResult(start);
		criteria.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<SchPersonGroup> list = criteria.list();
		return list;
	}

	@Override
	public long getListCount() {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchPersonGroup.class);
		return criteria.list().size();
	}

	@Override
	public List<SchPersonGroup> getListData() {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchPersonGroup.class);
		@SuppressWarnings("unchecked")
		List<SchPersonGroup> list =  criteria.list();
		return list;
	}

	@Override
	public boolean saveSchPersonGroup(SchPersonGroup schPersonGroup) {
		// TODO Auto-generated method stub
		boolean falg = false;
		try {
			SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			if (StringUtils.isBlank(schPersonGroup.getGroupId()+"")) {
				session.save(schPersonGroup);
				falg = true;
			} else {
				session.update(schPersonGroup);
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
	public boolean deleteSchPersonGroup(SchPersonGroup schPersonGroup) {
		// TODO Auto-generated method stub
		boolean falg = false;
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		if(StringUtils.isBlank(schPersonGroup.getGroupId()+"")){
			session.delete(schPersonGroup);
			falg = true;
		}
		tx.commit();
		return falg;
	}

	@Override
	public SchPersonGroup getById(String id) {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		SchPersonGroup schPersonGroup = (SchPersonGroup)session.get(SchPersonGroup.class,id);
		return schPersonGroup;
	}

}
