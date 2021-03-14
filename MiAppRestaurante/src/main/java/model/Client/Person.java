package model.Client;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "cliente")
@XmlAccessorType (XmlAccessType.FIELD)
public class Person implements Serializable{
	private String dni;
	private String name;
	private int age;
	
	
	public Person() {
	}
	
	public Person(String dni, String name, int age) {
		this.dni = dni;
		this.name = name;
		this.age = age;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Person [dni=" + dni + ", name=" + name + ", age=" + age + "]";
	}


	
}
