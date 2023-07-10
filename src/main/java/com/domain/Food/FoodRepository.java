package com.domain.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Modifying
    @Query(value = "DELETE FROM foods f WHERE f.food_id=?1", nativeQuery = true)
    void deleteById(Integer foodId);

}
