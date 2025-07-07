package com.example.pttk.model;

import java.sql.Date;

public class Product {
	int productid;
	String name;
	double price;
	String decription, imagePath;
	Category category;
	Date publicationDate;
	String authorName, brand, batteryCapicity, screenSize, cameraResolution, material, color, size;
	
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", price=" + price + ", decription=" + decription
				+ ", imagePath=" + imagePath + ", category=" + category + ", publicationDate=" + publicationDate
				+ ", authorName=" + authorName + ", brand=" + brand + ", batteryCapicity=" + batteryCapicity
				+ ", screenSize=" + screenSize + ", cameraResolution=" + cameraResolution + ", material=" + material
				+ ", color=" + color + ", size=" + size + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productid, String name, double price, String decription, String imagePath, Category category,
			Date publicationDate, String authorName, String brand, String batteryCapicity, String screenSize,
			String cameraResolution, String material, String color, String size) {
		super();
		this.productid = productid;
		this.name = name;
		this.price = price;
		this.decription = decription;
		this.imagePath = imagePath;
		this.category = category;
		this.publicationDate = publicationDate;
		this.authorName = authorName;
		this.brand = brand;
		this.batteryCapicity = batteryCapicity;
		this.screenSize = screenSize;
		this.cameraResolution = cameraResolution;
		this.material = material;
		this.color = color;
		this.size = size;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBatteryCapicity() {
		return batteryCapicity;
	}

	public void setBatteryCapicity(String batteryCapicity) {
		this.batteryCapicity = batteryCapicity;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getCameraResolution() {
		return cameraResolution;
	}

	public void setCameraResolution(String cameraResolution) {
		this.cameraResolution = cameraResolution;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
