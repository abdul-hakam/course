/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationPermissionService
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation;

import java.util.List;
import org.hmti.course.domain.pk.model.ApplicationPermission;
import org.hmti.course.domain.pk.model.projection.dto.repository.ApplicationPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Sep 2, 2021
 * @see Service
 * @see Transactional
 */
@Service
@Transactional
public class ApplicationPermissionService {

    @Autowired
    private ApplicationPermissionRepository applicationPermissionRepository;

    public List<ApplicationPermission> findAll() {
        return applicationPermissionRepository.findAll();
    }
    
    public ApplicationPermission findByName(String name) {
        return applicationPermissionRepository.findByName(name);
    }

    public Page<ApplicationPermission> getPage(int page, int size, Sort.Direction direction, String[] properties) {
        return applicationPermissionRepository.findAll(PageRequest.of(page, size, direction, properties));
    }

    public ApplicationPermission findById(Long id) {
        return applicationPermissionRepository.findById(id).get();
    }

    public void saveOrUpdate(ApplicationPermission applicationPermission) {
        applicationPermissionRepository.save(applicationPermission);
    }

    public void deleteById(Long id) {
        applicationPermissionRepository.deleteById(id);
    }
}
