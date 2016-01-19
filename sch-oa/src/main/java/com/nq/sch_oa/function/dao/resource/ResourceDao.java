package com.nq.sch_oa.function.dao.resource;

import java.util.List;

import com.nq.sch_oa.function.model.oracle.SchResource;

public interface ResourceDao {
	public List<SchResource> getListData(int start, int limit);
	public long getListCount();	
	public List<SchResource> getListData();
	public boolean saveSchResource(SchResource bean); 
	public boolean deleteSchResource(SchResource bean);
	public SchResource getById(String id);
}
