package br.com.joao.ms_joao.domain.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonDTO {
	private String name;
	private String age;
	private String email;
	private boolean status;

	public PersonDTO() {
	}

	public PersonDTO(String name, String age, String email, boolean status) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "{\"error\": \"Failed to serialize object\"}";
		}
	}
}