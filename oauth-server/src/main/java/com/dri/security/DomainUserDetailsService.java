package com.dri.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dri.entity.Account;

@Service
public class DomainUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = this.findByName(username);
		
		if(account!=null) {
			return new User(
					account.getUserName(), 
					account.getPassWord(), 
					AuthorityUtils.createAuthorityList(account.getRoles()));
		}else {
			throw  new UsernameNotFoundException("用户["+username+"]不存在");
		}
		
	}

	
	
	private Account findByName(String username) {
		Account ac=new Account();
		if(!"username".equals("admin")) {
			return ac;
		}
		
		ac.setUserName(username);
		ac.setPassWord("123456");
		String[] roles= {"ROLE_QUERY","ROLE_ADMIN"};
		ac.setRoles(roles);
		return ac;
	}
}
