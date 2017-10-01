package com.javaTest.rambabu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.Type;

//@Entity(name="USER_DETAILS")
@Entity
@Table(name="USER_DETAILS")
public class UserDetails implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ID")
	private int userId;
	private String userName;
	@Transient
	private String description;
	@Lob
	private String address;
	@Temporal (TemporalType.DATE)
	private Date joinedDate;
	
/*	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="country", column=@Column(name="HOME_COUNTRY")),
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PINCODE"))		
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;*/
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilo.gen",strategy="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo.gen", type = @Type(type="long"))
	private Collection<Address> listofAddress = new ArrayList<Address>();
	

    //@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	/*public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}*/
	
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", description=" + description
				+ ", address=" + address + ", joinedDate=" + joinedDate + "]";
	}
	
	
	public Collection<Address> getListofAddress() {
		return listofAddress;
	}
	public void setListofAddress(Collection<Address> listofAddress) {
		this.listofAddress = listofAddress;
	}
	
	
	

}
