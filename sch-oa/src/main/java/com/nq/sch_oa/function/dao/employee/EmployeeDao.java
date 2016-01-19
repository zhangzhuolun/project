package com.nq.sch_oa.function.dao.employee;

import java.util.List;

import com.nq.sch_oa.function.model.oracle.SchEmployee;

public interface EmployeeDao {
	public List<SchEmployee> getListData(int start, int limit);
	public long getListCount();	
	public List<SchEmployee> getListData();
	public boolean saveSchEmployee(SchEmployee bean); 
	public boolean deleteSchEmployee(SchEmployee bean);
	public SchEmployee getById(String id);
}
