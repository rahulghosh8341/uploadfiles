package com.lti.projectgladiator.ltinsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.dao.RenewDao;
import com.lti.projectgladiator.ltinsure.exception.RenewServiceException;
import com.lti.projectgladiator.ltinsure.service.RenewService;
import com.lti.projectgladiator.ltinsure.status.Status;
import com.lti.projectgladiator.ltinsure.status.Status.StatusType;

@RestController
@CrossOrigin
public class RenewController {
	
	@Autowired
	private RenewService renewService;
	Status stu = new Status();	
	
	@Autowired
	private RenewDao renewRepo;
	
	@PostMapping(path = "/renew", consumes = "application/json", produces = "application/json")
	public Status renew(@RequestBody Policy policy) {
		Policy newPolicy = new Policy();
	  try {
		  stu = renewService.renewIns(policy);
		  newPolicy =  renewRepo.findByPolicyId(policy.getId());
		 
	   }
		catch(RenewServiceException e) {
			
			System.out.println(e.getMessage());
		
	}
	return stu;
	
	
}
}