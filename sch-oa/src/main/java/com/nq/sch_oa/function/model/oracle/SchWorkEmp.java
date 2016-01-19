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

@Entity(name="SchWorkEmp")
@Table(name ="Sch_Work_Emp")
@Lazy(value=true)
@XmlRootElement
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class SchWorkEmp implements java.io.Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -3978735914161243005L;
	@Id
	@Column(name="work_emp_id", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO,generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	private int workEmpId;
	
	@Column(name="work_id")
	private int workId;
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="finish_flag")
	private String finishFlag;

	public int getWorkEmpId() {
		return workEmpId;
	}

	public void setWorkEmpId(int workEmpId) {
		this.workEmpId = workEmpId;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFinishFlag() {
		return finishFlag;
	}

	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}

}
