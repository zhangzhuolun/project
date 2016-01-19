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

@Entity(name="SchMenuResp")
@Table(name ="Sch_MenuResp")
@Lazy(value=true)
@XmlRootElement
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class SchMenuResp implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2603836584565347730L;
	
	@Id
	@Column(name="resp_menu_id", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO,generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	private int respMenuId;
	
	@Column(name="resp_id")
	private int respId;
	
	@Column(name="menu_id")
	private int menuId;

	public int getRespMenuId() {
		return respMenuId;
	}

	public void setRespMenuId(int respMenuId) {
		this.respMenuId = respMenuId;
	}

	public int getRespId() {
		return respId;
	}

	public void setRespId(int respId) {
		this.respId = respId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

}
