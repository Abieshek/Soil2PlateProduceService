package com.domain.Food;


import com.domain.Produce.Produce;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "foods")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "foodId")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Integer foodId;
	@Column(name = "name")
	private String name;
	@Column(name="food_CO2")
	private Float foodCO2;
	@OneToMany(mappedBy = "foodObj", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Produce> produce;
	@Column(name = "image_link")
	private String imageLink;

	public Food() {
	}

	public Food(Integer foodId, String name, Float foodCO2, Set<Produce> produce, String imageLink) {
		this.foodId = foodId;
		this.name = name;
		this.foodCO2 = foodCO2;
		this.produce = produce;
		this.imageLink = imageLink;
	}

	public Food(String name, Float foodCO2, Set<Produce> produce, String imageLink) {
		this.name = name;
		this.foodCO2 = foodCO2;
		this.produce = produce;
		this.imageLink = imageLink;
	}

	// Getters and Setters
	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getFoodCO2() {
		return foodCO2;
	}

	public void setFoodCO2(Float foodCO2) {
		this.foodCO2 = foodCO2;
	}
	
	@JsonManagedReference
	public Set<Produce> getProduce() {
		return produce;
	}

	public void setProduce(Set<Produce> produce) {
		this.produce = produce;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
}