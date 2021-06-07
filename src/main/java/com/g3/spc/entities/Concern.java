package com.g3.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Concern Bean")
public class Concern {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int concernId;
	
	
	@NotNull
	private int pId;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="parentId")
	private Parent parent;
	
	
	@Enumerated(EnumType.STRING)
	@NotNull
	//@ApiModelProperty(name = "Parent ConcernType")
	private ConcernType concernType;
	
	@NotEmpty(message ="ConcernDescription should not be Null"  )
	@NotNull
	//@ApiModelProperty(name = "Parent ConcernDescription")
	private String concernDescription;
	
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@ApiModelProperty(name = "Parent ConcernParty")
	private ConcernParty concernParty;
	
	//@NotEmpty(message ="Resolved status of Concern should not be empty"  )
	@NotNull
	//@ApiModelProperty(name = "Parent ConcernType")
	private boolean resolved;
	
	//private String adminResponse;
	
	
	public Concern() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Concern(int concernId, int pId, Parent parent, ConcernType concernType,String concernDescription,
			ConcernParty concernParty, boolean resolved) {
		super();
		this.concernId = concernId;
		this.pId = pId;
		this.parent = parent;
		this.concernType = concernType;
		this.concernDescription = concernDescription;
		this.concernParty = concernParty;
		this.resolved = resolved;
	}
	
	



    public Concern(int concernId, int pId, ConcernType concernType,
			@NotEmpty(message = "ConcernDescription should not be Null") String concernDescription,
			ConcernParty concernParty, boolean resolved) {
		super();
		this.concernId = concernId;
		this.pId = pId;
		this.concernType = concernType;
		this.concernDescription = concernDescription;
		this.concernParty = concernParty;
		this.resolved = resolved;
	}




	public Concern(int concernId, ConcernType concernType,String concernDescription,
			ConcernParty concernParty, boolean resolved) {
		super();
		this.concernId = concernId;
		this.concernType = concernType;
		this.concernDescription = concernDescription;
		this.concernParty = concernParty;
		this.resolved = resolved;
	}




	@JsonBackReference
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public int getConcernId() {
		return concernId;
	}

	public void setConcernId(int concernId) {
		this.concernId = concernId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public ConcernType getConcernType() {
		return concernType;
	}

	public void setConcernType(ConcernType concernType) {
		this.concernType = concernType;
	}

	public String getConcernDescription() {
		return concernDescription;
	}

	public void setConcernDescription(String concernDescription) {
		this.concernDescription = concernDescription;
	}

	public ConcernParty getConcernParty() {
		return concernParty;
	}

	public void setConcernParty(ConcernParty concernParty) {
		this.concernParty = concernParty;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concernDescription == null) ? 0 : concernDescription.hashCode());
		result = prime * result + concernId;
		result = prime * result + ((concernParty == null) ? 0 : concernParty.hashCode());
		result = prime * result + ((concernType == null) ? 0 : concernType.hashCode());
		result = prime * result + pId;
		result = prime * result + (resolved ? 1231 : 1237);
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
		Concern other = (Concern) obj;
		if (concernDescription == null) {
			if (other.concernDescription != null)
				return false;
		} else if (!concernDescription.equals(other.concernDescription))
			return false;
		if (concernId != other.concernId)
			return false;
		if (concernParty != other.concernParty)
			return false;
		if (concernType != other.concernType)
			return false;
		if (pId != other.pId)
			return false;
		if (resolved != other.resolved)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Concern [concernId=" + concernId + ", concernType=" + concernType + ", concernDescription="
				+ concernDescription + ", concernParty=" + concernParty + ", resolved=" + resolved + "]";
	}




	

	

	
	
	}

