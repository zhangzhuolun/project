package com.nq.sch_oa.function.dao.work;

import java.util.List;

import com.nq.sch_oa.function.model.oracle.SchWork;

public interface WorkDao {
	public List<SchWork> getListData(int start, int limit);
	public long getListCount();	
	public List<SchWork> getListData();
	public boolean saveSchWork(SchWork bean); 
	public boolean deleteSchWork(SchWork bean);
	public SchWork getById(String id);
}
