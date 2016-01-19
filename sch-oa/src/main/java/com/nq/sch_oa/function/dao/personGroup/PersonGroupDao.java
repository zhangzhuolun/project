package com.nq.sch_oa.function.dao.personGroup;

import java.util.List;

import com.nq.sch_oa.function.model.oracle.SchPersonGroup;

public interface PersonGroupDao {
	public List<SchPersonGroup> getListData(int start, int limit);
	public long getListCount();	
	public List<SchPersonGroup> getListData();
	public boolean saveSchPersonGroup(SchPersonGroup bean); 
	public boolean deleteSchPersonGroup(SchPersonGroup bean);
	public SchPersonGroup getById(String id);
}
