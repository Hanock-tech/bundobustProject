package com.tsp.bundobust.payload.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsp.bundobust.models.Employee;
import com.tsp.bundobust.payload.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Employee user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with Id: " + id));

		return UserDetailsImpl.build(user);
	}

}
