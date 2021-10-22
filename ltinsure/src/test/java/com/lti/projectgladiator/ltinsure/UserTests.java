package com.lti.projectgladiator.ltinsure;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.projectgladiator.ltinsure.beans.Address;
import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.User;
import com.lti.projectgladiator.ltinsure.dao.UserDaoImpl;


public class UserTests{

	@Autowired
	UserDaoImpl userDao;
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setCreatedOn(LocalDate.now());
		user.setEmailId("abc@gmail.com");
		user.setLastLogin(LocalDateTime.now());
		user.setLastPasswordSet(LocalDate.now());
		user.setOtp("555555");
		user.setPassword("password");
		user.setRole("USER");
		
		userDao.save(user);
		System.out.println("User record added!");
	}
	
	@Test
	public void saveCustomer() {
			Customer customer = new Customer();
            customer.setName("Testing");
            customer.setContactNo(1234567890);
            customer.setDateOfBirth(LocalDate.now());
            customer.setEmailId("abc@gmail.com");

            Address address = new Address();
            address.setCity("Mumbai");
            address.setPincode(400001);
            address.setLandMark("Gateway of India");
            
            customer.setAddress(address);
            
            userDao.save(customer);
		}
	
	
	@Test
	public void findAll() {
		System.out.println(userDao.findAll());
	}
	
	@Test
	public void isUserPresent() {
		assertEquals(true, userDao.isUserPresent("abc@gmail.com"));
	}
	
	@Test
	public void isCustomerPresent() {
		System.out.println(userDao.isCustomerPresent("abc@gmail.com"));
		assertEquals(true, userDao.isCustomerPresent("abc@gmail.com"));
	}
	
	@Test
	public void findEmailPassword() {
		System.out.println(userDao.findByEmailPassword("abc@gmail.com", "password"));
		assertEquals("abc@gmail.com", userDao.findByEmailPassword("abc@gmail.com", "password").getEmailId());
	}
	
	@Test
	public void findUsingOTP() {
		System.out.println(userDao.findUserByOtp("555555"));
		assertEquals("abc@gmail.com", userDao.findUserByOtp("555555").getEmailId());
	}
	
	@Test
	public void findUsingEmail() {
		System.out.println(userDao.findUserByEmail("abc@gmail.com"));
		assertEquals("password", userDao.findUserByEmail("abc@gmail.com").getPassword());
	}

}
