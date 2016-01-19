package com.nq.sch_oa.function.service.organization.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nq.sch_oa.function.model.oracle.SchOrganization;
import com.nq.sch_oa.function.service.organization.OrganizationService;
import com.nq.sch_oa.function.dao.organization.OrganizationDao;

@Service("organizationServiceImpl")
public class OrganizationServiceImpl implements OrganizationService{

	@Resource(name = "organizationDaoImpl")
	private OrganizationDao orgDaoImpl;
	
	@Override
	public List<SchOrganization> getListData(int start, int limit) {
		// TODO Auto-generated method stub
		List<SchOrganization> list = orgDaoImpl.getListData(start, limit);
		return list;
	}

	@Override
	public long getListCount() {
		// TODO Auto-generated method stub
		return orgDaoImpl.getListCount();
	}

	@Override
	public List<SchOrganization> getListData() {
		// TODO Auto-generated method stub
		return orgDaoImpl.getListData();
	}

	@Override
	public boolean saveSchOrganization(SchOrganization bean) {
		// TODO Auto-generated method stub
		return orgDaoImpl.saveSchOrganization(bean);
	}

	@Override
	public boolean deleteSchOrganization(SchOrganization bean) {
		// TODO Auto-generated method stub
		return orgDaoImpl.deleteSchOrganization(bean);
	}

	@Override
	public SchOrganization getById(String id) {
		// TODO Auto-generated method stub
		return orgDaoImpl.getById(id);
	}

}
