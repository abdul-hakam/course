/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : UserController
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.controller;

import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import org.hmti.course.domain.pk.model.ApplicationUser;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Aug 30, 2021
 * @see RestController
 * @see RequestMapping
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @GetMapping
    @PreAuthorize("hasAuthority('country:read')")
    public List<ApplicationUser> findAll() {
        return applicationUserService.findAll();
    }

    @GetMapping("/currency")
    @PreAuthorize("hasAuthority('province:read')")
    public HashMap<String, Object> getCurrency() {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Currency availableCurrency : Currency.getAvailableCurrencies()) {
            HashMap<String, Object> hm = new HashMap<>();
            hm.put("currencyCode", availableCurrency.getCurrencyCode());
            hm.put("defaultFractionDigits", availableCurrency.getDefaultFractionDigits());
            hm.put("symbol", availableCurrency.getSymbol());
            hm.put("displayName", availableCurrency.getDisplayName());
            hashMap.put(availableCurrency.getCurrencyCode(), hm);
        }
        return hashMap;
    }
}
