package com.nq.sch_oa.function.model.oracle;

import java.util.Date;

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

@Entity(name="SchEmployee")
@Table(name ="sch_employee")
@Lazy(value=true)
@XmlRootElement
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class SchEmployee implements java.io.Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6984899976067060479L;
	
	@Id
	@Column(name="emp_id", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO,generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="position")
	private String position;
	
	@Column(name="join_date")
	private Date joinDate;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="org_id")
	private int orgId;
	
	@Column(name="nation")
	private String nation;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
}
