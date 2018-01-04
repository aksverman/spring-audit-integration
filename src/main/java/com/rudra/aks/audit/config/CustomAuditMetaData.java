package com.rudra.aks.audit.config;

import org.audit4j.core.MetaData;

public class CustomAuditMetaData implements MetaData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3464905616415514727L;

	/**
	 * Use this method to provide the actor from environment
	 * f. e. - logged user can be returned as actor for the event. 
	 *
	 */
	public String getActor() {
		return "anonymous";
	}

}
