/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationPermissionRepository
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository;

import org.hmti.course.domain.pk.model.ApplicationPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Definition
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul Hakam.<br>
 * Created on Sep 2, 2021
 * @see Repository
 */
@Repository
public interface ApplicationPermissionRepository extends JpaRepository<ApplicationPermission, Long>{
    ApplicationPermission findByName(String name);
}
