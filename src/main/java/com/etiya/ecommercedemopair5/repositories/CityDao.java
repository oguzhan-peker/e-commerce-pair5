package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
