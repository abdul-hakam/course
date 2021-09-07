/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationRolePermissionRepository
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository;

import java.util.List;
import org.hmti.course.domain.pk.ApplicationRolePermissionPK;
import org.hmti.course.domain.pk.model.ApplicationRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Definition
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul Hakam.<br>
 * Created on Sep 2, 2021
 */
@Repository
public interface ApplicationRolePermissionRepository extends 
        JpaRepository<ApplicationRolePermission, ApplicationRolePermissionPK>{
    List<ApplicationRolePermission> findByApplicationRolePermissionIdentityApplicationRoleId(Long roleId);
}
