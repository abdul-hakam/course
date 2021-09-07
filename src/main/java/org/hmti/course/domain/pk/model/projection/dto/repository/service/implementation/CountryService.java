/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : CountryService
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation;

import org.hmti.course.domain.pk.CountryPK;
import org.hmti.course.domain.pk.model.Country;
import org.hmti.course.domain.pk.model.projection.dto.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul Hakam.<br>
 * Created on Aug 29, 2021
 * @see Service
 * @see Transactional
 */
@Service
@Transactional
public class CountryService {
    
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Page<Country> getPage(int page, int size, Sort.Direction direction, String[] properties) {
        return countryRepository.findAll(PageRequest.of(page, size, direction, properties));
    }
    
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Country findByCountryPK(CountryPK countryPK) {
        return countryRepository.findById(countryPK).get();
    }
    
    public Country findByCountryCode(Integer countryCode) {
        CountryPK countryPk = new CountryPK(countryCode);
        return this.findByCountryPK(countryPk);
    }
    
    public void saveOrUpdate(Country country){
        countryRepository.save(country);
    }
    
    public void deleteByCountryPK(CountryPK countryPK){
        countryRepository.deleteById(countryPK);
    }
}
