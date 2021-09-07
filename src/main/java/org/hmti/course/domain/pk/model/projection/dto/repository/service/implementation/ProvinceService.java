/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ProvinceService
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation;

import java.util.List;
import org.hmti.course.domain.pk.ProvincePK;
import org.hmti.course.domain.pk.model.Country;
import org.hmti.course.domain.pk.model.Province;
import org.hmti.course.domain.pk.model.projection.dto.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul Hakam.<br>
 * Created on Aug 30, 2021
 * @see Service
 * @see Transactional
 */
@Service
@Transactional
public class ProvinceService {
    
    @Autowired
    private ProvinceRepository provinceRepository;
    
    public List<Province> findAll(){
        return provinceRepository.findAll();
    }
    
    public Page<Province> getPage(int page, int size, Sort.Direction direction, String[] properties) {
        return provinceRepository.findAll(PageRequest.of(page, size, direction, properties));
    }
    
    public Province findByProvincePK(ProvincePK provincePK) {
        return provinceRepository.findById(provincePK).get();
    }
    
    public Province findByProvinceCodeAndCountryCode(Integer provinceCode, Integer countryCode) {
        Country country = new Country();
        country.getCountryIdentity().setCountryCode(countryCode);
        return findByProvincePK(new ProvincePK(country, provinceCode));
    }
    
    public List<Province> findByCountryCode(Integer countryCode) {
        return provinceRepository.findByProvinceIdentityCountryCountryIdentityCountryCode(countryCode);
    }
    
    public void saveOrUpdate(Province province){
        provinceRepository.save(province);
    }
    
    public void deleteByProvincePK(ProvincePK provincePK){
        provinceRepository.deleteById(provincePK);
    }
}
