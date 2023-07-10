package com.domain.Controller;

import com.domain.Food.Food;
import com.domain.Produce.Produce;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produce")
public class ProduceController {
	//private ProduceRepo
	private ProduceService produceService;

	public ProduceController(ProduceService produceService) {
		this.produceService = produceService;
	}

	// Displays all produce
	@GetMapping("/produces")
	public List<Produce> getAllProduce(){
		return produceService.findAllProduce();
	}

	//get produce by produce Id
	@GetMapping("/{produceID}/byId")
	public Produce getProduceByProduceId(@PathVariable("produceID") Integer produceID){
		 return produceService.getProduceByProduceID(produceID);
	}
	//add products
	@PostMapping("/addProduce")
	public Produce addProduce(@RequestBody Produce produce) {
		return produceService.addNewProduce(produce);
		
	}
	@DeleteMapping(path = "deleteProd/{produceID}")
	public void deleteProduce(@PathVariable("produceID") Integer produceID){
		produceService.deleteProduce(produceID);
	}

	@PutMapping
	public Produce updateProduce(@RequestBody Produce produce){
		Produce oldProduce = produceService.findById(produce.getProduceID());
		return produceService.updateProduce(produce, oldProduce);
	}

	// Display all food
	@GetMapping("/foods")
	public List<Food>getAllFoods(){
		return produceService.findAllFood();
	}

	@PostMapping("/addFood")
	public Food addFood(@RequestBody Food food){
		return produceService.addNewFood(food);

	}

	@DeleteMapping(path = "deleteFood/{foodId}")
	public void deleteFood(@PathVariable("foodId") Integer foodId){

		produceService.deleteFood(foodId);
	}

	@PutMapping("/updateFood")
	public Food updateFood(@RequestBody Food food){
		Food oldFood = produceService.findById(food.getFoodId()).getFood();
		return produceService.updateFood(food, oldFood);

	}

	// Get all produces by farmer_id
	@GetMapping("/{farmerID}/byFarmer")
	public List<Produce> getAllProduceByFarmerID(@PathVariable Integer farmerID) {
		return produceService.findByFarmerID(farmerID);
	}
	
	// list of produces based on food category
	@GetMapping("/{foodID}/byFood")
	public List<Produce> getAllProduceByFoodID(@PathVariable Integer foodID) {
		Food food = produceService.findByFoodId(foodID);
		
		return produceService.produceByFoodObj(food);
	}
	

}
