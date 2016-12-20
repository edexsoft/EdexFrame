package com.edexsoft.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edexsoft.framework.security.User;
import com.edexsoft.framework.security.UserProfile;
import com.edexsoft.framework.security.IUserService;

@Service("ExexUserDetailsService")
public class ExexUserDetailsService implements UserDetailsService{
 
    @Autowired
    @Qualifier("UserService")
    private IUserService userService;
     
    // @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String account)
            throws UsernameNotFoundException {
        User user = userService.findByAccount(account);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(), 
                 user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(UserProfile userProfile : user.getUserProfiles()){
            System.out.println("UserProfile : "+userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
     
}