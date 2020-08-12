package dev.four.entities;

public class Doctor {
	
	private int did;
	private String username;
	private String password;
	private String specialty;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int did, String username, String password, String specialty) {
		super();
		this.did = did;
		this.username = username;
		this.password = password;
		this.specialty = specialty;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", username=" + username + ", password=" + password + ", specialty=" + specialty
				+ "]";
	}

}
