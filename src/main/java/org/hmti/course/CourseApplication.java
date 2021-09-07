package org.hmti.course;

import java.util.Currency;
import org.hmti.course.domain.StandardUser;
import org.hmti.course.domain.pk.ApplicationRolePermissionPK;
import org.hmti.course.domain.pk.CountryPK;
import org.hmti.course.domain.pk.ProvincePK;
import org.hmti.course.domain.pk.model.ApplicationPermission;
import org.hmti.course.domain.pk.model.ApplicationRole;
import org.hmti.course.domain.pk.model.ApplicationRolePermission;
import org.hmti.course.domain.pk.model.ApplicationUser;
import org.hmti.course.domain.pk.model.Country;
import org.hmti.course.domain.pk.model.Province;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.ApplicationPermissionService;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.ApplicationRolePermissionService;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.ApplicationRoleService;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.ApplicationUserService;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.CountryService;
import org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CourseApplication {
    
    @Autowired
    private ApplicationUserService applicationUserService;

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(applicationUserService);
        return daoAuthenticationProvider;
    }

    @Bean
    CommandLineRunner run(
            ApplicationRoleService applicationRoleService,
            ApplicationPermissionService applicationPermissionService,
            ApplicationRolePermissionService applicationRolePermissionService,
            CountryService countryService,
            ProvinceService provinceService) {
        return (String[] args) -> {
            /*
                =====================================================================================================
                |                                                                                                   |
                |                           Insert Role Operation                                                   |
                |                                                                                                   |
                =====================================================================================================
            */
            applicationRoleService.saveOrUpdate(new ApplicationRole(null, "TENRYUBITO", 
                    "The World Nobles, also known as the Celestial Dragons"));
            applicationRoleService.saveOrUpdate(new ApplicationRole(null, "PRESIDENT", "Head of state"));
            applicationRoleService.saveOrUpdate(new ApplicationRole(null, "GOVERNOR", 
                    "Public officials with the power to govern the executive branch of a non-sovereign or "
                            + "sub-national level of government."));
            applicationRoleService.saveOrUpdate(new ApplicationRole(null, "REGENT", "An appointed person "
                    + "to govern a district."));
            /*
                =====================================================================================================
                |                                                                                                   |
                |                           Insert Permission Operation                                             |
                |                                                                                                   |
                =====================================================================================================
            */
            applicationPermissionService.saveOrUpdate(new ApplicationPermission(null, "country:read", 
                    "Access to read country data"));
            applicationPermissionService.saveOrUpdate(new ApplicationPermission(null, "country:write", 
                    "Access to writing country data"));
            applicationPermissionService.saveOrUpdate(new ApplicationPermission(null, "province:read", 
                    "Access to read province data"));
            applicationPermissionService.saveOrUpdate(new ApplicationPermission(null, "province:write", 
                    "Access to writing province data"));
            /*
                =====================================================================================================
                |                                                                                                   |
                |                           Insert RolePermission Operation                                         |
                |                                                                                                   |
                =====================================================================================================
            */
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("TENRYUBITO"), 
                            applicationPermissionService.findByName("country:read")), null));
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("TENRYUBITO"), 
                            applicationPermissionService.findByName("country:write")), null));
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("TENRYUBITO"), 
                            applicationPermissionService.findByName("province:read")), null));
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("TENRYUBITO"), 
                            applicationPermissionService.findByName("province:write")), null));
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("PRESIDENT"), 
                            applicationPermissionService.findByName("country:read")), null));
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("PRESIDENT"), 
                            applicationPermissionService.findByName("province:read")), null));
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("PRESIDENT"), 
                            applicationPermissionService.findByName("province:write")), null));
//            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
//                    new ApplicationRolePermissionPK(applicationRoleService.findByName("GOVERNOR"), 
//                            applicationPermissionService.findByName("country:read")), null));
            applicationRolePermissionService.saveOrUpdate(new ApplicationRolePermission(
                    new ApplicationRolePermissionPK(applicationRoleService.findByName("GOVERNOR"), 
                            applicationPermissionService.findByName("province:read")), null));
            /*
                =====================================================================================================
                |                                                                                                   |
                |                           Insert User Operation                                                   |
                |                                                                                                   |
                =====================================================================================================
            */
            applicationUserService.saveOrUpdate(new ApplicationUser(null, new StandardUser("Saint Charloss", 
                    passwordEncoder().encode("booger")), applicationRoleService.findByName("TENRYUBITO")));
            applicationUserService.saveOrUpdate(new ApplicationUser(null, new StandardUser("Jokowi", 
                   passwordEncoder().encode("nganu")), applicationRoleService.findByName("PRESIDENT")));
            applicationUserService.saveOrUpdate(new ApplicationUser(null, new StandardUser("Ridwan Kamil", 
                    passwordEncoder().encode("emil")), applicationRoleService.findByName("GOVERNOR")));
            applicationUserService.saveOrUpdate(new ApplicationUser(null, new StandardUser("Anies Baswedan", 
                    passwordEncoder().encode("reshuffle")), applicationRoleService.findByName("GOVERNOR")));
            applicationUserService.saveOrUpdate(new ApplicationUser(null, new StandardUser("Dani Ramdan", 
                    passwordEncoder().encode("sementara")), applicationRoleService.findByName("REGENT")));
            /*
                =====================================================================================================
                |                                                                                                   |
                |                           Insert Country Operation                                                |
                |                                                                                                   |
                =====================================================================================================
            */
            countryService.saveOrUpdate(new Country(new CountryPK(62), "Indonesia", "ID", "IDN", "+62", 
                    Currency.getInstance("IDR"), "Wkwkwkwkwkwk Land"));
            countryService.saveOrUpdate(new Country(new CountryPK(60), "Malaysia", "MY", "MYS", "+60", 
                    Currency.getInstance("MYR"), "Negeri Jiran"));
            /*
                =====================================================================================================
                |                                                                                                   |
                |                           Insert Province Operation                                               |
                |                                                                                                   |
                =====================================================================================================
            */
            provinceService.saveOrUpdate(new Province(
                    new ProvincePK(countryService.findByCountryPK(new CountryPK(62)), 11), 
                    "D.I Nangroe Aceh Darussalam", "AC", "Aceh", 
                    "Daerah Istimewa Nangroe Aceh Darussalam"));
            provinceService.saveOrUpdate(new Province(
                    new ProvincePK(countryService.findByCountryPK(new CountryPK(62)),31), "DKI Jakarta",
                    "JK", "Jakarta", "Daerah Khusus Ibukota Jakarta"));
            provinceService.saveOrUpdate(new Province(
                    new ProvincePK(countryService.findByCountryPK(new CountryPK(60)),3), "Kuala Lumpur",
                    "KL", "Kuala", "Kuala Lumpur"));            
        };
    }
}
