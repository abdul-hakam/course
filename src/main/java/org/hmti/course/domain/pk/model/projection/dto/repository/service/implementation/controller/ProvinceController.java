/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ProvinceController
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.controller;

import java.util.List;
import org.hmti.course.domain.pk.ProvincePK;
import org.hmti.course.domain.pk.model.Province;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.ProvinceService;
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
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul Hakam.<br>
 * Created on Aug 30, 2021
 * @see RestController
 * @see RequestMapping
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    
    @Autowired
    private ProvinceService provinceService;
    
    @GetMapping
    @PreAuthorize("hasAuthority('province:read')")
    public List<Province> findAll() {
        return provinceService.findAll();
    }
    
    @GetMapping("/{page}/{size}")
    @PreAuthorize("hasAuthority('province:read')")
    public Page<Province> findAll(@PathVariable(name = "page") int page, 
            @PathVariable(name = "size") int size) {
        String[] properties = {"identity.country.identity.countryCode","identity.provinceCode"};
        return provinceService.getPage(page, size, Sort.Direction.ASC, properties);
    }
    
    @GetMapping("/provinceCodeAndCountryCode")
    @PreAuthorize("hasAuthority('province:read')")
    public Province findByProvinceCodeAndCountryCode(@RequestParam(required = true) Integer provinceCode, 
            @RequestParam(required = true) Integer countryCode) {
        return provinceService.findByProvinceCodeAndCountryCode(provinceCode, countryCode);
    }
    
    @GetMapping("/countryCode")
    @PreAuthorize("hasAuthority('province:read')")
    public List<Province> findByCountryCode(@RequestParam(required = true) Integer countryCode) {
        return provinceService.findByCountryCode(countryCode);
    }
    
    @PostMapping
    @PreAuthorize("hasAuthority('province:write')")
    public void saveOrUpdate(@RequestBody Province province){
        provinceService.saveOrUpdate(province);
    }
    
    @DeleteMapping
    @PreAuthorize("hasAuthority('province:write')")
    public void deleteByProvincePK(@RequestBody ProvincePK provincePK){
        provinceService.deleteByProvincePK(provincePK);
    }
}
