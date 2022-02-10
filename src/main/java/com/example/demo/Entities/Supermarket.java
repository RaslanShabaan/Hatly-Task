package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "Supermarket-gen", sequenceName = "Supermarket", initialValue = 200, allocationSize = 1)
@Table(name = "Supermarket")
public class Supermarket {

	@Column(name = "first_name")
	private String arabic_name;

	@Column(name = "english_name")
	private String english_name;
	@Column(name = "address")
	private String address;
	@Column(name = "activation")
	private String activation;

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	@Column(name = "image")
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArabic_name() {
		return arabic_name;
	}

	public void setArabic_name(String arabic_name) {
		this.arabic_name = arabic_name;
	}

	public String getEnglish_name() {
		return english_name;
	}

	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}

	@Column(name = "Supermarket_id")
	private Long Supermarket_id;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Supermarket_id-gen")
	public Long getSupermarket_id() {
		return Supermarket_id;
	}

	public void setSupermarket_id(Long supermarket_id) {
		Supermarket_id = supermarket_id;
	}

	public String getFirst_name() {
		return arabic_name;
	}

	public void setFirst_name(String first_name) {
		this.arabic_name = first_name;
	}

}
