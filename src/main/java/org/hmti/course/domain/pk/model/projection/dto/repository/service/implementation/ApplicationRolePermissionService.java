/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationRolePermissionService
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation;

import java.util.List;
import org.hmti.course.domain.pk.ApplicationRolePermissionPK;
import org.hmti.course.domain.pk.model.ApplicationRolePermission;
import org.hmti.course.domain.pk.model.projection.dto.repository.ApplicationRolePermissionRepository;
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
public class ApplicationRolePermissionService {

    @Autowired
    private ApplicationRolePermissionRepository applicationRolePermissionRepository;

    public List<ApplicationRolePermission> findAll() {
        return applicationRolePermissionRepository.findAll();
    }

    public Page<ApplicationRolePermission> getPage(int page, int size, Sort.Direction direction, String[] properties) {
        return applicationRolePermissionRepository.findAll(PageRequest.of(page, size, direction, properties));
    }

    public ApplicationRolePermission findByApplicationRolePermissionPK(
            ApplicationRolePermissionPK applicationRolePermissionPK) {
        return applicationRolePermissionRepository.findById(applicationRolePermissionPK).get();
    }
    
    public ApplicationRolePermission findByRoleIdAndPermissionId(Long roleId, Long permissionId) {
        ApplicationRolePermissionPK applicationRolePermissionPK = new ApplicationRolePermissionPK();
        applicationRolePermissionPK.getApplicationRole().setId(roleId);
        applicationRolePermissionPK.getApplicationPermission().setId(permissionId);
        return findByApplicationRolePermissionPK(applicationRolePermissionPK);
    }

    public void saveOrUpdate(ApplicationRolePermission applicationRolePermission) {
        applicationRolePermissionRepository.save(applicationRolePermission);
    }

    public void deleteByApplicationRolePermissionPK(ApplicationRolePermissionPK applicationRolePermissionPK) {
        applicationRolePermissionRepository.deleteById(applicationRolePermissionPK);
    }
    
    public void deleteByRoleIdAndPermissionId(Long roleId, Long permissionId) {
        ApplicationRolePermissionPK applicationRolePermissionPK = new ApplicationRolePermissionPK();
        applicationRolePermissionPK.getApplicationRole().setId(roleId);
        applicationRolePermissionPK.getApplicationPermission().setId(permissionId);
        deleteByApplicationRolePermissionPK(applicationRolePermissionPK);
    }
}
