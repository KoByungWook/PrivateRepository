package com.mycompany.myapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PhotoBoardMember {
	private String mid;
	private String mpassword;
	private String mname;
	private int mage;
	private Date mdate;
	private String moriginalfilename;
	private String msavedfilename;
	private String mfilecontent;
	
	private MultipartFile mattach;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public String getMoriginalfilename() {
		return moriginalfilename;
	}
	public void setMoriginalfilename(String moriginalfilename) {
		this.moriginalfilename = moriginalfilename;
	}
	public String getMsavedfilename() {
		return msavedfilename;
	}
	public void setMsavedfilename(String msavedfilename) {
		this.msavedfilename = msavedfilename;
	}
	public String getMfilecontent() {
		return mfilecontent;
	}
	public void setMfilecontent(String mfilecontent) {
		this.mfilecontent = mfilecontent;
	}
	public MultipartFile getMattach() {
		return mattach;
	}
	public void setMattach(MultipartFile mattach) {
		this.mattach = mattach;
	}
}
