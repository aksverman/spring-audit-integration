/**
 * 
 */
package com.rudra.aks.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ankush
 *
 */

@SpringBootApplication
public class AuditBootIntegrationApp {

	public static void main(String args[]) {
		
		System.getProperties().put("server.port", 8099);
		SpringApplication.run(AuditBootIntegrationApp.class, args);
	}
}
