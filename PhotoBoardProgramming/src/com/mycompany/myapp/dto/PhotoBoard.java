package com.mycompany.myapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PhotoBoard {
	private int bno;
	private String bid;
	private String btitle;
	private Date bdate;
	private String bcontent;
	private String boriginalfilename;
	private String bsavedfilename;
	private String bfilecontent;
	private int bhitcount;
	
	private MultipartFile battach;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date date) {
		this.bdate = date;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBoriginalfilename() {
		return boriginalfilename;
	}
	public void setBoriginalfilename(String boriginalfilename) {
		this.boriginalfilename = boriginalfilename;
	}
	public String getBsavedfilename() {
		return bsavedfilename;
	}
	public void setBsavedfilename(String bsavedfilename) {
		this.bsavedfilename = bsavedfilename;
	}
	public String getBfilecontent() {
		return bfilecontent;
	}
	public void setBfilecontent(String bfilecontent) {
		this.bfilecontent = bfilecontent;
	}
	public int getBhitcount() {
		return bhitcount;
	}
	public void setBhitcount(int bhitcount) {
		this.bhitcount = bhitcount;
	}
	public MultipartFile getBattach() {
		return battach;
	}
	public void setBattach(MultipartFile battach) {
		this.battach = battach;
	}
	
	
	
}
