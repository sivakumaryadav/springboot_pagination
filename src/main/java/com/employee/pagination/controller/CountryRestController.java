package com.employee.pagination.controller;

import com.employee.pagination.model.Country;
import com.employee.pagination.service.CountryService;
import com.employee.pagination.service.CountryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    //http://localhost:9001/search/v1
    @GetMapping(path = "/search/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Country> findAll(){
        return countryService.findAll();
    }

    //http://localhost:9001/search/v1/:limit/:page
    @GetMapping(path = "/page-search/v1/{limit}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    private Page<Country> findAll(@PathVariable int limit, @PathVariable int page){
        return countryService.findAll(limit, page);
    }

    @PostMapping(path = "/save/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
    private Country findAll(@RequestBody Country country){
        return countryService.save(country);
    }

    @GetMapping(path = "/search/v1/{limit}/{page}/{orderBy}", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Country> findAll(@PathVariable Long limit, @PathVariable Long page, @PathVariable String orderBy){
        return countryService.findAll(limit, page, orderBy);
    }
}
