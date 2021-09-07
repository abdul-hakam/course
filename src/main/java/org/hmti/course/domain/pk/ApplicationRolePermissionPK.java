/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationRolePermissionPK
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hmti.course.domain.pk.model.ApplicationPermission;
import org.hmti.course.domain.pk.model.ApplicationRole;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Aug 30, 2021
 * @see Data
 * @see AllArgsConstructor
 * @see NoArgsConstructor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ApplicationRolePermissionPK implements Serializable {

    @JoinColumn(referencedColumnName = "id", name = "roleId")
    @ManyToOne(optional = false)
    private ApplicationRole applicationRole;
    @JoinColumn(referencedColumnName = "id", name = "permissionId")
    @ManyToOne(optional = false)
    private ApplicationPermission applicationPermission;
}
