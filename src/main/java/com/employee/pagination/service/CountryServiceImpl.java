package com.employee.pagination.service;

import com.employee.pagination.model.Country;
import com.employee.pagination.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Page<Country> findAll(int limit, int page) {
        Pageable pageable = PageRequest.of(page, limit);
        return countryRepository.findAll(pageable);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findAll(Long limit, Long page, String orderBy) {
        Pageable pageable = PageRequest.of(page.intValue(), limit.intValue(), Sort.by(orderBy).ascending());
        //PageRequest.of(page.intValue(), limit.intValue(), Sort.by(orderBy).ascending().and(Sort.by("id")));
        int size = page.intValue() + 1;
        int skipCount = (size - 1) * limit.intValue();
        return countryRepository.findAll().stream().skip(skipCount).limit(limit).collect(Collectors.toList());
    }
}
