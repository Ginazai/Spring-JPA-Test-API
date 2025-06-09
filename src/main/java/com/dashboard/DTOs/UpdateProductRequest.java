package com.dashboard.DTOs;

import java.time.LocalDateTime;

public class UpdateProductRequest {
	private String name;
	private float price;
	private String tags;
	private LocalDateTime createDate;
	private Boolean active;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
