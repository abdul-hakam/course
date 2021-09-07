/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ProvinceRepository
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model.projection.dto.repository;

import java.util.List;
import org.hmti.course.domain.pk.ProvincePK;
import org.hmti.course.domain.pk.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Definition
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Aug 30, 2021
 * @see Repository
 * @see JpaRepository
 */
@Repository
public interface ProvinceRepository extends JpaRepository<Province, ProvincePK> {

    List<Province> findByProvinceIdentityCountryCountryIdentityCountryCode(Integer countryCode);
}
