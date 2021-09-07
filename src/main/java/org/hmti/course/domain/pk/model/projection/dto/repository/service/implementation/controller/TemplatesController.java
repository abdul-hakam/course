/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : TemplatesController
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */
package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul
 * Hakam.<br>
 * Created on Sep 3, 2021
 * @see Controller
 * @see RequestMapping
 */
@Controller
public class TemplatesController {

    @RequestMapping("/login")
    public String getLoginView() {
        return "login";
    }
}
