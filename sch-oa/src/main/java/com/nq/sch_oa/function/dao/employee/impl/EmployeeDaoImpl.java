package com.nq.sch_oa.function.dao.employee.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nq.sch_oa.function.dao.employee.EmployeeDao;
import com.nq.sch_oa.function.model.oracle.SchEmployee;
import com.nq.sch_oa.dao.hibernate.impl.CP_Hibernate4DAOImpl;

@Repository("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao{

	private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
	
	@Resource(name = "hibernateDAO")
	private CP_Hibernate4DAOImpl hibernate4DAOImpl;
	@Override
	public List<SchEmployee> getListData(int start, int limit) {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchEmployee.class);
		criteria.setFirstResult(start);
		criteria.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<SchEmployee> list = criteria.list();
		return list;
	}

	@Override
	public long getListCount() {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchEmployee.class);
		return criteria.list().size();
	}

	@Override
	public List<SchEmployee> getListData() {
		// TODO Auto-generated method stub
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(SchEmployee.class);
		@SuppressWarnings("unchecked")
		List<SchEmployee> list =  criteria.list();
		return list;
	}

	@Override
	public boolean saveSchEmployee(SchEmployee schEmployee) {
		// TODO Auto-generated method stub
		boolean falg = false;
		try {
			SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			if (StringUtils.isBlank(schEmployee.getEmpId()+"")) {
				session.save(schEmployee);
				falg = true;
			} else {
				session.update(schEmployee);
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
	public boolean deleteSchEmployee(SchEmployee schEmployee) {
		// TODO Auto-generated method stub
		boolean falg = false;
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		if(StringUtils.isBlank(schEmployee.getEmpId()+"")){
			session.delete(schEmployee);
			falg = true;
		}
		tx.commit();
		return falg;
	}

	@Override
	public SchEmployee getById(String id) {
		SessionFactory sf = hibernate4DAOImpl.getSessionFactory();
		Session session = sf.openSession();
		SchEmployee schEmployee = (SchEmployee)session.get(SchEmployee.class,id);
		return schEmployee;
	}

}
