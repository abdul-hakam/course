/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationRoleService
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation;

import java.util.List;
import org.hmti.course.domain.pk.model.ApplicationRole;
import org.hmti.course.domain.pk.model.projection.dto.repository.ApplicationRoleRepository;
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
 * Created on Aug 29, 2021
 * @see Service
 * @see Transactional
 */
@Service
@Transactional
public class ApplicationRoleService {
    
    @Autowired
    private ApplicationRoleRepository applicationRoleRepository;

    public List<ApplicationRole> findAll() {
        return applicationRoleRepository.findAll();
    }

    public Page<ApplicationRole> getPage(int page, int size, Sort.Direction direction, String[] properties) {
        return applicationRoleRepository.findAll(PageRequest.of(page, size, direction, properties));
    }
    
    public ApplicationRole findById(Long id) {
        return applicationRoleRepository.findById(id).get();
    }
    
    public ApplicationRole findByName(String name) {
        return applicationRoleRepository.findByName(name).get();
    }
    
    public void saveOrUpdate(ApplicationRole applicationRole){
        applicationRoleRepository.save(applicationRole);
    }
    
    public void deleteById(Long id){
        applicationRoleRepository.deleteById(id);
    }
}
