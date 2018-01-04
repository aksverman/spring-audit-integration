/**
 * 
 */
package com.rudra.aks.audit.config;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.audit4j.core.AuditManager;
import org.audit4j.core.dto.AuditEvent;

/**
 * @author ankush
 *
 */
public class RudraAuditor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AuditManager manager;
	
	private int userId;
	
	private String methodName;
	
	private String userName;
	
	
	/**
	 * No-arg constructor to instantiate AuditManager
	 */
	public RudraAuditor() {
		manager = AuditManager.getInstance();
		
	}
	
	public void audit() {
		manager.audit(getAuditEvent());
	}

	private AuditEvent getAuditEvent() {
		AuditEvent auditEvent = new AuditEvent();
		auditEvent.setAuditId(this.userId);
		auditEvent.setActor(this.userName);
		auditEvent.setAction(this.methodName);
		auditEvent.setTimestamp(new Date());
		
		UUID uuid = UUID.randomUUID();
		auditEvent.setUuid(uuid.getLeastSignificantBits());
		
		return auditEvent;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
