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

@Entity(name="SchResponsibility")
@Table(name ="Sch_Responsibility")
@Lazy(value=true)
@XmlRootElement
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class SchResponsibility implements java.io.Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 7224960576517488413L;
	
	@Id
	@Column(name="resp_id", unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO,generator="paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	private int resp_id;
	
	@Column(name="resp_code")
	private String respCode;
	
	@Column(name="resp_name")
	private String respName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="update_date")
	private Date updateDate;

	public int getResp_id() {
		return resp_id;
	}

	public void setResp_id(int resp_id) {
		this.resp_id = resp_id;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespName() {
		return respName;
	}

	public void setRespName(String respName) {
		this.respName = respName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	} 

}
