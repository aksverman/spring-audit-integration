package com.rudra.aks.audit.config;

import java.util.HashMap;
import java.util.Map;

import org.audit4j.core.exception.HandlerException;
import org.audit4j.core.exception.InitializationException;
import org.audit4j.core.handler.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAuditHandler extends Handler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3042364197183735875L;

	
	private Logger logger;
	
	@Override
	public void init() throws InitializationException {
		logger = LoggerFactory.getLogger(getClass());
	}

	@Override
	public void stop() {
		//stop audit4j
	}

	@Override
	public void handle() throws HandlerException {
		
		Map<String, Object> messages = new HashMap<String, Object>();
		messages.put("_AuditActor", getAuditEvent().getActor());
		messages.put("_AuditAction", getAuditEvent().getAction());
		//messages.put("_AuditID", getAuditEvent().getAuditId());
		messages.put("_AuditTimeStamp", getAuditEvent().getTimestamp());
		messages.put("_AuditUUID", getAuditEvent().getUuid());
		
		logger.info(messages.toString());
	}

	
}