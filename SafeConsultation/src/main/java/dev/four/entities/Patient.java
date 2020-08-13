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
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int pid;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "height")
	private double height;
	
	@Column(name = "weight")
	private double weight;
	
	@Column(name = "blood_type")
	private String bloodType;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Appointment> appointments;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int pid, String username, String password, int age, double height, double weight, String bloodType) {
		super();
		this.pid = pid;
		this.username = username;
		this.password = password;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bloodType = bloodType;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", height=" + height + ", weight=" + weight + ", bloodType=" + bloodType + "]";
	}

}
