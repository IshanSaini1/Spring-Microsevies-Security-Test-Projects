package com.example.limits.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(value = "limits-service-property-bean")
@ConfigurationProperties("limits-service")
public class Configuration {

	private Integer maximum;

	private Integer minimum;

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

}
