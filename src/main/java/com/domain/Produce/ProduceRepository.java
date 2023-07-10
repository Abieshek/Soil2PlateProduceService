package com.domain.Produce;


import com.domain.Food.Food;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduceRepository extends JpaRepository<Produce, Integer>{

	@Modifying
	@Query(value = "DELETE FROM produce p WHERE p.produce_id=?1", nativeQuery = true)
	void deleteById(Integer produceID);
	public List<Produce> findByFarmerID(int id);
	public List<Produce> findByFoodObj(Food food);

}
