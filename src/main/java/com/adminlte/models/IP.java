package com.adminlte.models;

public class IP {

	private int id;
	private int deptid;
	private String deptname;
	private String ip;
	private String macaddress;
	private String username;
	private String location;
	private String pcname;
	private String antivirus;
	private String ramark;
	private String extension;
	private String sn;
	public IP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IP(int id, int deptid, String deptname, String ip, String macaddress, String username, String location,
			String pcname, String antivirus, String ramark, String extension, String sn) {
		super();
		this.id = id;
		this.deptid = deptid;
		this.deptname = deptname;
		this.ip = ip;
		this.macaddress = macaddress;
		this.username = username;
		this.location = location;
		this.pcname = pcname;
		this.antivirus = antivirus;
		this.ramark = ramark;
		this.extension = extension;
		this.sn = sn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMacaddress() {
		return macaddress;
	}
	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public String getAntivirus() {
		return antivirus;
	}
	public void setAntivirus(String antivirus) {
		this.antivirus = antivirus;
	}
	public String getRamark() {
		return ramark;
	}
	public void setRamark(String ramark) {
		this.ramark = ramark;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
}
