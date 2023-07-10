package com.domain.Controller;

import com.domain.Food.Food;
import com.domain.Food.FoodRepository;
import com.domain.Produce.Produce;
import com.domain.Produce.ProduceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceService {
	
	private ProduceRepository produceRepository;
	
	private FoodRepository foodRepository;
	
	
	
	public ProduceService(ProduceRepository produceRepository, FoodRepository foodRepository) {
		
		this.produceRepository = produceRepository;
		this.foodRepository = foodRepository;
	}

	// Displays all produce
	public List<Produce> findAllProduce(){
		return produceRepository.findAll();
	}
	
	// Display all food
	public List<Food> findAllFood(){
		return (List<Food>) foodRepository.findAll();
	}
	
	public Food findByFoodId(int id) {
		return foodRepository.findById(id).get();
	}
	
	public Food addNewFood(Food food) {
		return foodRepository.save(food);
	}
	
	
	//add new Produce
	public Produce addNewProduce(Produce produce) {

		return produceRepository.save(produce);
	}


	public void deleteProduce(Integer produceID) {

		produceRepository.deleteById(produceID);
	}


	public Produce updateProduce(Produce produce, Produce oldProduce) {
		produce.setFood(oldProduce.getFood());
		return produceRepository.save(produce);
		}
	public Produce findById(Integer produceID){
		 return produceRepository.findById(produceID).get();

	}

	public void deleteFood(Integer foodId) {
		foodRepository.deleteById(foodId);
	}

	public Food updateFood(Food food, Food oldFood) {
		food.setProduce(oldFood.getProduce());
		return foodRepository.save(food);
	}
	public List<Produce> findByFarmerID(Integer id) {
		return produceRepository.findByFarmerID(id);
	}
	
	
	public List<Produce> produceByFoodObj(Food food) {
		return produceRepository.findByFoodObj(food);
	}


	public Produce getProduceByProduceID(Integer produceID) {
		return produceRepository.findById(produceID).get();
	}
}


