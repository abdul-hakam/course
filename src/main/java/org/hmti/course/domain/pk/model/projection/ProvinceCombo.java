package org.hmti.course.domain.pk.model.projection;

import org.hmti.course.domain.pk.model.Country;

public interface ProvinceCombo {
    String getName();

    ProvincePKInfo getProvinceIdentity();

    interface ProvincePKInfo {
        Country getCountry();

        Integer getProvinceCode();
    }
}
