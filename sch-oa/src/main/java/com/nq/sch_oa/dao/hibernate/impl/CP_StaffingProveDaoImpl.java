package com.nq.sch_oa.dao.hibernate.impl;

import com.nq.sch_oa.dao.hibernate.impl.CP_Hibernate4DAOImpl;

public class CP_StaffingProveDaoImpl {
	private CP_Hibernate4DAOImpl  hibernate4DAOImpl;
	
	
	public CP_Hibernate4DAOImpl getHibernate4DAOImpl() {
		return hibernate4DAOImpl;
	}

	public void setHibernate4DAOImpl(CP_Hibernate4DAOImpl hibernate4daoImpl) {
		hibernate4DAOImpl = hibernate4daoImpl;
	}

	public void updateStaffingProveInfo(int proveId, String proveName,
			String fileName, String newPath, long operatorId) {
		
		System.out.println("************************proveName:"+proveName);
		System.out.println("************************proveName:"+proveName);
		System.out.println("************************proveName:"+proveName);
		System.out.println("************************proveName:"+proveName);
		System.out.println("************************proveName:"+proveName);
	}
}
