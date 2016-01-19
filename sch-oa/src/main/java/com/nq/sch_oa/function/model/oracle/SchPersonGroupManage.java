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

@Entity(name="SchPersonGroupManage")
@Table(name ="Sch_Person_Group_Manage")
@Lazy(value=true)
@XmlRootElement
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class SchPersonGroupManage implements java.io.Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -9018870227786782403L;
	@Id
	@Column(name="group_manage_id", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO,generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	private int groupManageId;
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="person_id")
	private int personId;
	
	@Column(name="enable_flag")
	private String enableFlag;

	public int getGroupManageId() {
		return groupManageId;
	}

	public void setGroupManageId(int groupManageId) {
		this.groupManageId = groupManageId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	

}
