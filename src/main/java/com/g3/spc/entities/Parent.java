package com.g3.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Parent Bean")
public class Parent {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int parentId;
	
	@NotEmpty(message ="name should not be Null"  )
	@Size(min=3,max=15,message="name size should not exceed more than 15 characters")
	@ApiModelProperty(name = "Parent Name",value = "Hold the min 3 char product name",required = true)
	private String name;
	
	@OneToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="STUDENT_ID",referencedColumnName="userId")
	private Student student;
	
	@NotEmpty(message ="EmailId should not be Null"  )
	@ApiModelProperty(name = "Parent emailId")
	private String emailId;
	
	@NotEmpty(message ="MobileNumber should not be Null"  )
	@ApiModelProperty(name = "Parent PhoneNumber")
    private String mobileNumber;
    
	
   
	
    @OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="parentId")
	 private List<Concern> concern;
	

public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	

public Parent(int parentId, String name, String emailId, String mobileNumber, List<Concern> concern) {
	super();
	this.parentId = parentId;
	this.name = name;
	this.emailId = emailId;
	this.mobileNumber = mobileNumber;
	this.concern = concern;
}


    public Parent(int parentId,
		@NotEmpty(message = "name should not be Null") @Size(min = 3, max = 15, message = "name size should not exceed more than 15 characters") String name,
		Student student, @NotEmpty(message = "EmailId should not be Null") String emailId,
		@NotEmpty(message = "MobileNumber should not be Null") String mobileNumber, List<Concern> concern) {
	super();
	this.parentId = parentId;
	this.name = name;
	this.student = student;
	this.emailId = emailId;
	this.mobileNumber = mobileNumber;
	this.concern = concern;
}


	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	

	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	@JsonManagedReference
	public List<Concern> getConcern() {
	return concern;
    }


    public void setConcern(List<Concern> concern) {
	this.concern = concern;
     }




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concern == null) ? 0 : concern.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + parentId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (concern == null) {
			if (other.concern != null)
				return false;
		} else if (!concern.equals(other.concern))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId != other.parentId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Parent [parentId=" + parentId + ", name=" + name + ", student=" + student + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", concern=" + concern + "]";
	}




}