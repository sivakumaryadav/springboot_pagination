package com.employee.pagination.service;

import com.employee.pagination.model.Country;
import com.employee.pagination.repository.CountryRepository;
import org.assertj.core.util.Arrays;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Specification;

@SpringBootTest
public class CountryServiceTest extends Specification {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    def "CountryService findAll method" () {
        Country country = new Country();
        country.setId(1L)

        given:
            //def c = countryRepository.findAll() --> Arrays.asList(country);*/
            def mockCustomers = []
                mockCustomers << Arrays.asList(country)
                countryRepository.findAll() >> mockCustomers
        when:
            List<Country> c = countryService.findAll();
        then:
            c.size() == 1
    }
}
