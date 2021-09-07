/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : Province
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hmti.course.domain.pk.ProvincePK;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Aug 30, 2021
 * @see Data
 * @see AllArgsConstructor
 * @see NoArgsConstructor
 * @see Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Province implements Serializable {

    @EmbeddedId
    protected ProvincePK provinceIdentity;
    @Basic(optional = false)
    @Column(unique = true)
    private String name;
    @Basic(optional = false)
    @Column(unique = true)
    private String iSOName;
    @Basic(optional = false)
    @Column(unique = true)
    private String acronym;
    private String description;

    public String getInternationalISOName() {
        return this.provinceIdentity.getCountry().getISOCode2() + "-" + this.iSOName;
    }
    
    public String getCompleteProvinceCode() {
        return this.provinceIdentity.getCountry().getCountryIdentity().getCountryCode() + "." + 
                this.provinceIdentity.getProvinceCode();
    }
}
