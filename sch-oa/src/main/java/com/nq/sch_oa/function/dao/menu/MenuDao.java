package com.nq.sch_oa.function.dao.menu;

import java.util.List;

import com.nq.sch_oa.function.model.oracle.SchMenu;

public interface MenuDao {
	public List<SchMenu> getListData(int start, int limit);
	public long getListCount();	
	public List<SchMenu> getListData();
	public boolean saveSchMenu(SchMenu bean); 
	public boolean deleteSchMenu(SchMenu bean);
	public SchMenu getById(String id);
}
