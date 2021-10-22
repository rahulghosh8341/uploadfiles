package com.lti.projectgladiator.ltinsure;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;
import com.lti.projectgladiator.ltinsure.dao.PolicyDaoImpl;

public class PolicyTests {

	PolicyDaoImpl policydao;
	@Test
	public void saveTest() {
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
		policydao.submissionOfBuyInsuranceData(vehicle);
	
		
		
		Policy policy = new Policy();
		policy.setId(2);
		policy.setIssueDate(LocalDate.of(2019, 8, 31));
		policy.setExpiryDate(LocalDate.of(2020, 8, 31));
		policy.setDuration(1);
		policy.setPolicyAmount(3000.0);
		policy.setStatus("Valid");
		policydao.submitPolicyDate(policy);
		
	}
	
	@Test
	public void findbyId() {
		System.out.println(policydao.findInsuranceById(40001));
		assertEquals("LTI Finance", policydao.findInsuranceById(40001).getCompanyName());
	}
	
	@Test
	public void isVehicleInsured() {
		System.out.println(policydao.isSameVehicleIsInsuredAlready("EIJ3678377"));
		assertEquals(true, policydao.isSameVehicleIsInsuredAlready("EIJ3678377"));
	}
	
	@Test
	public void findVehicle(){
		System.out.println(policydao.findVehicleById(50001));
		assertEquals("ENG4748844", policydao.findVehicleById(50001).getEngineNo());
	}
	

}
