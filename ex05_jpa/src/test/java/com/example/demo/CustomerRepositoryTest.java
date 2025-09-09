package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Address;
import com.example.demo.domain.Customer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AddressRepository addressRepository;

//	@Test
	public void list() {
		List<Customer> list = customerRepository.findAll();
		list.forEach(System.out::println);
	}

//	@Test
	public void get() {

		Customer customer = customerRepository.findById(1L).get();
		System.out.println(customer);
	}

//	@Test
	public void delete() {
		// 단건조회
		Customer customer = customerRepository.findById(1L).get();

		// 삭제
		customerRepository.delete(customer);
	}

//	@Test
	public void insert() {
		Customer customer = new Customer("Kim", "010-2222-3333");
		customerRepository.save(customer);
		customerRepository.findAll().forEach(System.out::println);
	}

//	@Test
	public void update() {
		// 단건조회 (1번 사원의 이름 변경 -> 저장)
		Customer customer = customerRepository.findById(1L).get();

		// 이름변경
		customer.setName("son");

		// save
		customerRepository.save(customer);

		// 단건조회 결과출력
		System.out.println(customer);
	}

//	@Test // 검색조건
	public void findName() {
		customerRepository.findByNameLike("%so%").forEach(System.out::println);
	}

//	@Test // 검색조건
	public void findPhone() {
		customerRepository.findByPhone("1").forEach(System.out::println);
	}

//	@Test
	public void 일대일테스트() {
//		given(준비)
		Address addressEntity = Address.builder().zipcode("04411").address("대구").build();
		addressRepository.save(addressEntity);

		Customer customerentity = Customer.builder().name("길동").phone("011").address(addressEntity).build();
		customerRepository.save(customerentity);

		// when(실행)
		Customer customer = customerRepository.findById(1L).get();
		log.info(customer.getName() + ":" + customer.getAddress().getZipcode());

		// then(검증)
		assertEquals("04411", customer.getAddress().getZipcode());
	}

	@Test
	@Transactional
	void ManyToOneTest() {
		// when(실행)
		List<Customer> customer = customerRepository.findAllFetchJoin();
		// log.info(customer.getFirstName());
		customer.forEach(cust -> cust.getAddresses().forEach(addr -> log.info(addr.getZipcode())));
		// then(검증)
		assertEquals("04411", customer.get(0).getAddresses().get(0).getZipcode());
	}
}
