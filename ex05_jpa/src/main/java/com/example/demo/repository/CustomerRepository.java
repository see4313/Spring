package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByNameLike(String name);
	
	
	@Query("select u from Customer u where u.phone like %?1% order by name desc") // Customer = 클래스명(대소문자 구별해서 사용)
	List<Customer> findByPhone(String phone); // String phone이 '%?1%'에 들어감 
	

	@Query("select u from Customer u where u.phone like %:phone% or name like %:name% order by name desc") 
	List<Customer> findByPhoneOrName(@Param("phone") String phone, @Param("name") String name); // @Param 에서 사용하는 이름은 위에 쿼리문작성할 때 사용되는 이름과 동일.
}
