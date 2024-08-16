package com.food.resturants.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.resturants.entities.ResturantMenu;

public interface ResturantMenuRepository extends JpaRepository<ResturantMenu, Integer>{

	@Query(value="select * from resturant_menu rm where rm.resturant_code=?1 ", nativeQuery=true)
	List<ResturantMenu> findByResturantCode(String resturantCode);
	
	@Query(value="SELECT * FROM resturant_menu rm where rm.resource_category =?1 OR rm.resource_type=?2", nativeQuery=true)
	List<ResturantMenu> findFoodByCategoryOrType(String cat, String type);

}
