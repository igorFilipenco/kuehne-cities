package com.kuehne.citiesapp.repository;

import com.kuehne.citiesapp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    /**
     * Method to search cities by name-criteria
     * @param name
     * @return
     */
    City findByName(String name);
}
