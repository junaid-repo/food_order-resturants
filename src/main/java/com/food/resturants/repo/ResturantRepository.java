package com.food.resturants.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.food.resturants.entities.ResturantsDetails;

import jakarta.transaction.Transactional;

public interface ResturantRepository extends JpaRepository<ResturantsDetails, Integer>{

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query(value="update resturants_details set resturant_code=?2 where id=?1", nativeQuery=true)
	void updateResturantCode(Integer id, String resName);

	@Query(value="select * from resturants_details rd where rd.resturant_code=?1", nativeQuery=true)
	ResturantsDetails findByResturantCode(String resturantCode);

	@Query(value="SELECT rd.resturant_Code FROM resturants_details rd, address aa\n"
			+ "where rd.address_id=aa.id\n"
			+ "and aa.pincode=?1\n"
			+ "and rd.resturant_code is not null", nativeQuery=true)
	List<String> getResturantCodeAccToPincode(String pincode);

	@Query(value="SELECT rm.resturant_code FROM resturant_menu rm \n"
			+ "where rm.resource_category =?\n"
			+ "OR rm.resource_type=?", nativeQuery = true)
	List<String> getResturantCodeAccToCatOrType(String category, String type);

}
