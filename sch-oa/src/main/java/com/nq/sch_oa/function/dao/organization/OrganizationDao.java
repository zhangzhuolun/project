package com.nq.sch_oa.function.dao.organization;

import java.util.List;

import com.nq.sch_oa.function.model.oracle.SchOrganization;

public interface OrganizationDao {

	public List<SchOrganization> getListData(int start, int limit);
	public long getListCount();	
	public List<SchOrganization> getListData();
	public boolean saveSchOrganization(SchOrganization bean); 
	public boolean deleteSchOrganization(SchOrganization bean);
	public SchOrganization getById(String id);
}
