package dev.four.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d_id")
	private int did;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "specialty")
	private String specialty;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	@JsonManagedReference(value="doctorParent")
	private List<Appointment> appointments;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int did, String username, String password, String specialty, List<Appointment> appointments) {
		super();
		this.did = did;
		this.username = username;
		this.password = password;
		this.specialty = specialty;
		this.appointments = appointments;
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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", username=" + username + ", password=" + password + ", specialty=" + specialty;
	}

}
