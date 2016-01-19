package com.nq.sch_oa.function.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

@Entity(name="SchMenu")
@Table(name ="sch_menu")
@Lazy(value=true)
@XmlRootElement
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class SchMenu implements java.io.Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -4707943038777337879L;
	
	@Id
	@Column(name="menu_id", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO,generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	private int menuId;

	@Column(name="menu_pid")
	private int menuPid;
	
	@Column(name="menu_name")
	private String menuName;
	
	@Column(name="menu_desc")
	private String menuDesc;
	
	@Column(name="menu_url")
	private String menuUrl;
	
	@Column(name="menu_level")
	private int menuLevel;
	
	@Column(name="enable_flag")
	private String enableFlag;
	
	@Column(name="create_date")
	private String createDate;
	
	@Column(name="update_date")
	private String upadeDate;
	

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getMenuPid() {
		return menuPid;
	}

	public void setMenuPid(int menuPid) {
		this.menuPid = menuPid;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpadeDate() {
		return upadeDate;
	}

	public void setUpadeDate(String upadeDate) {
		this.upadeDate = upadeDate;
	}
}
