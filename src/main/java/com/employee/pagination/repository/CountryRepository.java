package com.employee.pagination.repository;

import com.employee.pagination.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country,Long> {
    public List<Country> findAll();
}
