/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationRoleRepository
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository;

import java.util.Optional;
import org.hmti.course.domain.pk.model.ApplicationRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Definition
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul Hakam.<br>
 * Created on Aug 29, 2021
 * 
 * @see Repository
 */
@Repository
public interface ApplicationRoleRepository extends JpaRepository<ApplicationRole, Long>{
    Optional<ApplicationRole> findByName(String name);
}
