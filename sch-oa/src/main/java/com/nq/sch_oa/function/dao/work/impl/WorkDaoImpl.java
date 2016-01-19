package com.nq.sch_oa.function.dao.work.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nq.sch_oa.function.dao.work.WorkDao;
import com.nq.sch_oa.function.model.oracle.SchWork;
import com.nq.sch_oa.dao.hibernate.impl.CP_Hibernate4DAOImpl;

@Repository("workDaoImpl")
public class WorkDaoImpl implements WorkDao{

	private static final Logger logger = Logger.getLogger(WorkDaoImpl.class);
	
	@Resource(name = "hibernateDAO")
	private CP_Hibernate4DAOImpl hibernate4DAOImpl;
	@Override
	public List<SchWork> getListData(int start, int limit) {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchWork.class);
		criteria.setFirstResult(start);
		criteria.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<SchWork> list = criteria.list();
		return list;
	}

	@Override
	public long getListCount() {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchWork.class);
		return criteria.list().size();
	}

	@Override
	public List<SchWork> getListData() {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchWork.class);
		@SuppressWarnings("unchecked")
		List<SchWork> list =  criteria.list();
		return list;
	}

	@Override
	public boolean saveSchWork(SchWork schWork) {
		// TODO Auto-generated method stub
		boolean falg = false;
		try {
			SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			if (StringUtils.isBlank(schWork.getWorkId()+"")) {
				session.save(schWork);
				falg = true;
			} else {
				session.update(schWork);
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
	public boolean deleteSchWork(SchWork schWork) {
		// TODO Auto-generated method stub
		boolean falg = false;
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		if(StringUtils.isBlank(schWork.getWorkId()+"")){
			session.delete(schWork);
			falg = true;
		}
		tx.commit();
		return falg;
	}

	@Override
	public SchWork getById(String id) {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		SchWork schWork = (SchWork)session.get(SchWork.class,id);
		return schWork;
	}

}
