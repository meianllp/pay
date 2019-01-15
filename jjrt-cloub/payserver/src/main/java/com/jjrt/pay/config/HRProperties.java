package com.jjrt.pay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/pay.yml")
@ConfigurationProperties(prefix="huarui")
public class HRProperties {
	
	@Value("${appID}") 
	private String appID;
	 
	@Value("${appSecret}") 
	private String appSecret;

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
}