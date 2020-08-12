package dev.four.entities;

public class Patient {
	
	private int pid;
	private String username;
	private String password;
	private int age;
	private double height;
	private double weight;
	private char bloodType;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int pid, String username, String password, int age, double height, double weight, char bloodType) {
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

	public char getBloodType() {
		return bloodType;
	}

	public void setBloodType(char bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", height=" + height + ", weight=" + weight + ", bloodType=" + bloodType + "]";
	}

}
