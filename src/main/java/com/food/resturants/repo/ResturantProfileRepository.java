package com.food.resturants.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.resturants.entities.ResturantProfile;

public interface ResturantProfileRepository extends JpaRepository<ResturantProfile, Integer> {

}
