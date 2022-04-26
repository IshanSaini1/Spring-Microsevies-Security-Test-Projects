package com.example.limits.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Limits {

	@JsonProperty(value = "Max")
	private Integer maximum;

	@JsonProperty(value = "Min")
	private Integer minimum;

	public Limits(Integer minimum_limits, Integer maximum_limits) {
		this.maximum = maximum_limits;
		this.minimum = minimum_limits;
	}

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
