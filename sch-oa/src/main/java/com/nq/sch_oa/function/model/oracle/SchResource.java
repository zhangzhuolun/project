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

@Entity(name="SchResource")
@Table(name ="Sch_Resource")
@Lazy(value=true)
@XmlRootElement
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class SchResource implements java.io.Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -7731502420795766544L;
	
	@Id
	@Column(name="resource_id", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO,generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	private int resourceId;
	
	@Column(name="resource_name")
	private String resourceName;
	
	@Column(name="resource_desc")
	private String resourceDesc;
	
	@Column(name="join_date")
	private Date joinDate;

	public int getResourceId() {
		return resourceId;
	}

	public void setResource_id(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
