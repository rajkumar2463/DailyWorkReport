package com.siso.profile.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class EmployerProfileEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long profileId;
	private String userName;
	private String GSTIN;
	private String alternateMobileNumber;
	private String pan;
	
	
	@Lob
	@Column(name = "profilepic", columnDefinition = "MEDIUMBLOB")
	private byte[] profilepic;

	
	public EmployerProfileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmployerProfileEntity(long profileId, String userName, String gSTIN, String alternateMobileNumber,
			String pan, byte[] profilepic) {
		super();
		this.profileId = profileId;
		this.userName = userName;
		GSTIN = gSTIN;
		this.alternateMobileNumber = alternateMobileNumber;
		this.pan = pan;
		this.profilepic = profilepic;
	}


	public long getProfileId() {
		return profileId;
	}


	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getGSTIN() {
		return GSTIN;
	}


	public void setGSTIN(String gSTIN) {
		GSTIN = gSTIN;
	}


	public String getAlternateMobileNumber() {
		return alternateMobileNumber;
	}


	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public byte[] getProfilepic() {
		return profilepic;
	}


	public void setProfilepic(byte[] profilepic) {
		this.profilepic = profilepic;
	}


	
	

	
	
}
