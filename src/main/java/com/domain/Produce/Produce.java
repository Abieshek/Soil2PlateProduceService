package com.domain.Produce;

import com.domain.Food.Food;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "produce")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "produceID")
public class Produce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produce_id")
	private Integer produceID;
	private String name;
	private String type;
	private Integer quantity;
	private Float price;
	private String description;
	@Column(name = "available_from")
	private Date availableFrom;
	@Column(name = "available_until")
	private Date availableUntil;
	@Column(name = "surplus_status")
	private Boolean surplusStatus;
	@Column(name = "produce_CO2")
	private Float produceCO2;
	private Integer calories;
	private String vitamins;
	@Column(name = "allergy_information")
	private String allergyInformation;

	// Produce to Farmer
	// @ManyToOne
	// @JoinColumn(name = "farmer_id") //used to reference farmerID
	@Column(name = "farmer_id")
	private Integer farmerID;

	// Produce To Food
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food foodObj;
	
	@Column(name = "image_link")
	private String imageLink;

	public Produce() {
	}

	public Produce(Integer produceID, String name, String type, Integer quantity, Float price, String description, Date availableFrom, Date availableUntil, Boolean surplusStatus, Float produceCO2, Integer calories, String vitamins, String allergyInformation, Integer farmerID, Food foodObj, String imageLink) {
		this.produceID = produceID;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.availableFrom = availableFrom;
		this.availableUntil = availableUntil;
		this.surplusStatus = surplusStatus;
		this.produceCO2 = produceCO2;
		this.calories = calories;
		this.vitamins = vitamins;
		this.allergyInformation = allergyInformation;
		this.farmerID = farmerID;
		this.foodObj = foodObj;
		this.imageLink = imageLink;
	}

	public Produce(String name, String type, Integer quantity, Float price, String description, Date availableFrom, Date availableUntil, Boolean surplusStatus, Float produceCO2, Integer calories, String vitamins, String allergyInformation, Integer farmerID, Food foodObj, String imageLink) {
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.availableFrom = availableFrom;
		this.availableUntil = availableUntil;
		this.surplusStatus = surplusStatus;
		this.produceCO2 = produceCO2;
		this.calories = calories;
		this.vitamins = vitamins;
		this.allergyInformation = allergyInformation;
		this.farmerID = farmerID;
		this.foodObj = foodObj;
		this.imageLink = imageLink;
	}

	// Getters and Setters
	public Integer getProduceID() {
		return produceID;
	}

	public void setProduceID(int produceID) {
		this.produceID = produceID;
	}

	public Integer getFarmerID() {
		return farmerID;
	}

	public void setFarmerID(int farmerID) {
		this.farmerID = farmerID;
	}
	
	@JsonBackReference
	public Food getFood() {
		return foodObj;
	}

	public void setFood(Food foodObj) {
		this.foodObj = foodObj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}

	public Date getAvailableUntil() {
		return availableUntil;
	}

	public void setAvailableUntil(Date availableUntil) {
		this.availableUntil = availableUntil;
	}

	public Boolean getSurplusStatus() {
		return surplusStatus;
	}

	public void setSurplusStatus(Boolean surplusStatus) {
		this.surplusStatus = surplusStatus;
	}

	public Float getProduceCO2() {
		return produceCO2;
	}

	public void setProduceCO2(Float produceCO2) {
		this.produceCO2 = produceCO2;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getVitamins() {
		return vitamins;
	}

	public void setVitamins(String vitamins) {
		this.vitamins = vitamins;
	}

	public String getAllergyInformation() {
		return allergyInformation;
	}

	public void setAllergyInformation(String allergyInformation) {
		this.allergyInformation = allergyInformation;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
}
