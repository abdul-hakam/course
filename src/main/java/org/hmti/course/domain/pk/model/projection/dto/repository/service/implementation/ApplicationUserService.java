/*
 *  --------------------------------------------------------------------------
 *  PT. Tab Solutions - Abdul Hakam.
 *  
 *  Filename : ApplicationUserService
 *  Version :
 *  Application name : course
 *  Application description :
 *  
 *  Copyright (c) PT. Tab Solutions.
 *  --------------------------------------------------------------------------
 */

package org.hmti.course.domain.pk.model.projection.dto.repository.service.implementation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.hmti.course.domain.pk.model.ApplicationRolePermission;
import org.hmti.course.domain.pk.model.ApplicationUser;
import org.hmti.course.domain.pk.model.projection.dto.repository.ApplicationRolePermissionRepository;
import org.hmti.course.domain.pk.model.projection.dto.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class Definition.
 *
 * @author <a href="http://www.tabs.co.id/">PT. Tab Solutions</a> - Abdul Hakam.<br>
 * Created on Aug 29, 2021
 * @see Service
 * @see Transactional
 */
@Service
@Transactional
public class ApplicationUserService implements UserDetailsService{
    
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ApplicationRolePermissionRepository applicationRolePermissionRepository;

    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }

    public Page<ApplicationUser> getPage(int page, int size, Sort.Direction direction, String[] properties) {
        return applicationUserRepository.findAll(PageRequest.of(page, size, direction, properties));
    }
    
    public ApplicationUser findById(Long id) {
        return applicationUserRepository.findById(id).get();
    }
    
    public ApplicationUser findByUsername(String username) {
        return applicationUserRepository.findByStandardUserUsername(username).get();
    }
    
    public void saveOrUpdate(ApplicationUser applicationUser){
        applicationUserRepository.save(applicationUser);
    }
    
    public void deleteById(Long id){
        applicationUserRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByStandardUserUsername(username).get();
        List<ApplicationRolePermission> applicationRolePermissions = 
                applicationRolePermissionRepository.findByApplicationRolePermissionIdentityApplicationRoleId(
                        applicationUser.getRole().getId());
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = applicationRolePermissions.stream().map(
                applicationRolePermission -> new SimpleGrantedAuthority(
                        applicationRolePermission.getApplicationRolePermissionIdentity().getApplicationPermission().
                                getName())).collect(Collectors.toSet());
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + applicationUser.getRole().getName()));
        return User.builder()
                .username(applicationUser.getStandardUser().getUsername())
                .password(applicationUser.getStandardUser().getPassword())
                .authorities(simpleGrantedAuthorities)
                .build();
    }
}
