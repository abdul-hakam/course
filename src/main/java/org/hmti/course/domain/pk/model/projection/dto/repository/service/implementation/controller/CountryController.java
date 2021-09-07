/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : CountryController
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.controller;

import java.util.List;
import org.hmti.course.domain.pk.CountryPK;
import org.hmti.course.domain.pk.model.Country;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Aug 29, 2021
 * @see RestController
 * @see RequestMapping
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    @PreAuthorize("hasAuthority('country:read')")
    public List<Country> findAll() {
        return countryService.findAll();
    }
    
    @GetMapping("/{page}/{size}")
    @PreAuthorize("hasAuthority('country:read')")
    public Page<Country> findAll(@PathVariable(name = "page") int page, 
            @PathVariable(name = "size") int size) {
        String[] properties = {"identity.countryCode"};
        return countryService.getPage(page, size, Sort.Direction.ASC, properties);
    }
    
    @GetMapping("/countryCode")
    @PreAuthorize("hasAuthority('country:read')")
    public Country findByCountryCode(@RequestParam(required = true) Integer countryCode) {
        return countryService.findByCountryCode(countryCode);
    }
    
    @PostMapping
    @PreAuthorize("hasAuthority('country:write')")
    public void saveOrUpdate(@RequestBody Country country){
        countryService.saveOrUpdate(country);
    }
    
    @DeleteMapping
    @PreAuthorize("hasAuthority('country:write')")
    public void deleteByCountryPK(@RequestBody CountryPK countryPK){
        countryService.deleteByCountryPK(countryPK);
    }
}
