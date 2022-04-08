package com.employee.pagination.service;

import com.employee.pagination.model.Country;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CountryService {

    public List<Country> findAll();
    public Page<Country> findAll(int limit, int page);

    public Country save(Country country);

    public List<Country> findAll(Long limit, Long page, String orderBy);
}
