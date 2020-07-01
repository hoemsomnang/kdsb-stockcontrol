package com.adminlte.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.adminlte.models.User;
import com.adminlte.services.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//BCryptPasswordEncoder encoder = passwordEncoder();
		User user=userService.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		System.out.print("username"+user.getUsername());
	    return user;
		//return new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword()),getGrantedAuthorities(user) );
	}
	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); } private Collection<GrantedAuthority>
	 * getGrantedAuthorities(User user){
	 * 
	 * Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
	 * if(user.getRoles().equals("ADMIN")){ grantedAuthority.add(new
	 * SimpleGrantedAuthority("ROLE_ADMIN")); } grantedAuthority.add(new
	 * SimpleGrantedAuthority("ROLE_USER")); return grantedAuthority; }
	 */

}
