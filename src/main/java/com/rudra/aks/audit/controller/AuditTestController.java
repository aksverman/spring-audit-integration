/**
 * 
 */
package com.rudra.aks.audit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rudra.aks.audit.config.RudraAuditor;

/**
 * @author ankush
 *
 */

@RestController
@RequestMapping("/")
public class AuditTestController {

	static Logger LOGGER = LoggerFactory.getLogger(AuditTestController.class);
	@RequestMapping(path = "/getName/{name}", method = RequestMethod.GET)
	public String	getName(@PathVariable("name") String name) {
		
		RudraAuditor auditor = new RudraAuditor();
		auditor.setUserId(101);
		auditor.setUserName(name);
		auditor.setMethodName("getName()");
		
		auditor.audit();
		
		if(name != null)
			return name;
		else 
			return "dummy";
	}
}
