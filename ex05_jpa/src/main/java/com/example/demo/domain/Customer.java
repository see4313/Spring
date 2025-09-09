package com.example.demo.domain;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import	lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
public class Customer {
	
	public Customer() {}
	
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	
	@Builder
	public Customer(String name, String phone, Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Long id;
	
	@Column(length = 20, nullable = false)
	private	String	name;
	
	@Column(length = 20, nullable = false, unique = true)
	private	String	phone;	
	
	@OneToOne // 1:1관계
	@JoinColumn(name = "address_id")
	Address address; // address를 참조.
}
