package com.rudra.aks.audit.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.audit4j.core.handler.ConsoleAuditHandler;
import org.audit4j.core.handler.Handler;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.audit4j.core.layout.SimpleLayout;
import org.audit4j.integration.spring.SpringAudit4jConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableAspectJAutoProxy
public class AuditConfig {


    /*
     * File Handler for audit4j
     * This will allow to store audit logs to file
     *    
     */
	@Bean
    public FileAuditHandler fileAuditHandler() {
    	FileAuditHandler fileAuditHandler = new FileAuditHandler();
    	fileAuditHandler.setProperties(fileProperties());
    	return fileAuditHandler;
    }

    /*
     * Default behavior for audit configuration is from 'audit4j.conf.yaml'
     * SpringAudit4jConfig provided way to configure programmatically
     * with various options as below.
     * 
     */
    @Bean
    public SpringAudit4jConfig springAudit4jConfig() {
        SpringAudit4jConfig springAudit4jConfig = new SpringAudit4jConfig();
        springAudit4jConfig.setLayout(new SimpleLayout());
        List<Handler> handlers = new ArrayList<Handler>();
        
        handlers.add(new CustomAuditHandler());
        
        //handlers.add(new ConsoleAuditHandler());
        //handlers.add(databaseHandler());
        //handlers.add(fileAuditHandler());
        springAudit4jConfig.setHandlers(handlers);
        springAudit4jConfig.setMetaData(new CustomAuditMetaData());

        return springAudit4jConfig;
    }
    
    /*@Bean
    public AuditAspect auditAspect() {
        AuditAspect auditAspect = new AuditAspect();
        return auditAspect;
    }*/
    
    private Map<String, String> fileProperties() {
    	HashMap<String,String> map = new HashMap<String, String>();
    	map.put("log.file.location", ".");
    	return map;
    }
    
}
