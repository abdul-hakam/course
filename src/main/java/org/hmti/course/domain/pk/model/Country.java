/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : Country
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model;

import java.io.Serializable;
import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.*;
import org.hmti.course.domain.pk.CountryPK;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Aug 29, 2021
 * @see Data
 * @see AllArgsConstructor
 * @see NoArgsConstructor
 * @see Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CountryPK countryIdentity;
    @Column(unique = true)
    private String name;
    @Column(unique = true, length = 2)
    private String iSOCode2;
    @Column(unique = true, length = 3)
    private String iSOCode3;
    @Column(unique = true)
    private String telephoneCode;
    private Currency currency;
    private String description;
}
