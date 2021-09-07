package org.hmti.course.domain;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Aug 30, 2021
 * @see Data
 * @see AllArgsConstructor
 * @see NoArgsConstructor
 * @see Embeddable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StandardUser implements Serializable {

    @Basic(optional = false)
    @Column(unique = true)
    private String username;
    @Basic(optional = false)
    private String password;

}
