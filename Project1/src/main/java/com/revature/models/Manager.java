package com.revature.models;

public class Manager {
	
	private int id;
	private String fname;
	private String lname;
	private static String username;
	private static String pwd;
	
	public Manager() {
		super();
	}

	public Manager(int id, String fname, String lname, String username, String pwd) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		Manager.username = username;
		Manager.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		Manager.username = username;
	}

	public static String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		Manager.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", fname=" + fname + ", lname=" + lname + ", username=" + username + ", pwd=" + pwd
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Manager other = (Manager) obj;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (pwd == null) {
			if (Manager.pwd != null)
				return false;
		} else if (!pwd.equals(Manager.pwd))
			return false;
		if (username == null) {
			if (Manager.username != null)
				return false;
		} else if (!username.equals(Manager.username))
			return false;
		return true;
	}

}