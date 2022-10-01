package com.kuehne.citiesapp.repository;

import com.kuehne.citiesapp.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Page<City> findAll(Pageable pageable);
    /**
     * Method to search cities by name-criteria
     * @param name
     * @return
     */
    City findByName(String name);
}
