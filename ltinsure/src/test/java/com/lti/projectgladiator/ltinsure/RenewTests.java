package com.lti.projectgladiator.ltinsure;



import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.projectgladiator.ltinsure.beans.Address;
import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.InsurancePlan;
import com.lti.projectgladiator.ltinsure.beans.Payment;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.beans.User;
import static org.junit.Assert.*;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;
import com.lti.projectgladiator.ltinsure.dao.RenewDaoImpl;

public class RenewTests {
	
	@Autowired
	private RenewDaoImpl renewdao;
	
	@Test
	public void savePolicy() {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(2);
		vehicle.setType("4-Wheeler");
		vehicle.setModel("Santro GLS");
		vehicle.setManufacturer("Hyundai");
		vehicle.setDrivingLicense("UK07111");
		vehicle.setPurchaseDate(LocalDate.of(2008, 4, 21));
		vehicle.setRegistrationNo("UK07222");
		vehicle.setEngineNo("ENG333");
		vehicle.setChassisNo("CH444");
		vehicle.setEngineType("Petrol");
		vehicle.setLastRenewDate(LocalDate.of(2019, 8, 31));
		renewdao.save(vehicle);
	
		
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Rahul");
		customer.setEmailId("rahul@gmail");
		customer.setDateOfBirth(LocalDate.of(1998, 9, 12));
		customer.setContactNo(1234567899);
		renewdao.save(customer);
		
		InsurancePlan insurancePlan = new InsurancePlan();
		insurancePlan.setId(2);
		insurancePlan.setName("Comprehensive");
		insurancePlan.setType("4-Wheeler");
		insurancePlan.setAmount(3000);
		insurancePlan.setCommission(500);
		renewdao.save(insurancePlan);
		
		Payment payment = new Payment();
		payment.setId(2);
		payment.setAmount(3500);
		payment.setMode("Card");
		payment.setDate(LocalDate.of(2019, 8, 31));
		renewdao.save(payment);
		
		Policy policy = new Policy();
		policy.setId(2);
		policy.setIssueDate(LocalDate.of(2019, 8, 31));
		policy.setExpiryDate(LocalDate.of(2020, 8, 31));
		policy.setDuration(1);
		policy.setPolicyAmount(3000.0);
		policy.setStatus("Valid");
		renewdao.save(policy);
		
		User users = new User();
		users.setId(2);
		users.setEmailId("rahul@gmail");
		users.setPassword("abc111");
		users.setLastPasswordSet(LocalDate.of(2020, 1, 31));
		users.setRole("Customer");
		renewdao.save(users);
		
	}


}
