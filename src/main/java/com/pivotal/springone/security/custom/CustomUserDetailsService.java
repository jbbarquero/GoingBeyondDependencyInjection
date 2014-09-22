package com.pivotal.springone.security.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * Custom implementation of the UserDetailsService interface to support fetching the {@link CustomUserDetails} object
 * from a potentially custom table arrangement in a JDBC Database.
 * 
 * @see org.springframework.security.core.userdetails.UserDetailsService
 */
public class CustomUserDetailsService implements UserDetailsService {
	private JdbcTemplate jdbcTemplate;
	
	CustomUserDetailsService(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * This DAO implementation provides customized fetching of the {@link CustomUserDetails} object
	 * 
	 * @see CustomUserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		StringBuilder sql = new StringBuilder("SELECT u.username, u.password, u.phone, u.email, r.role  ");
		              sql.append("FROM USERS u ");
		              sql.append("INNER JOIN USER_ROLES ur on u.id = ur.user_id ");
		              sql.append("INNER JOIN ROLES r on r.id = ur.role_id ");
		              sql.append("WHERE u.username = ?");
		System.out.println(sql.toString() + " username=" + username);
		return jdbcTemplate.query(sql.toString(), new UserDetailsExtractor(), username);
	}
	
	class UserDetailsExtractor implements ResultSetExtractor<CustomUserDetails> {

		@SuppressWarnings("unchecked")
		@Override
		public CustomUserDetails extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			CustomUserDetails ud = null;
			while (rs.next()) {
				if (ud == null) {
					ud = new CustomUserDetails();
					ud.setUsername(rs.getString("USERNAME"));
					ud.setPassword(rs.getString("PASSWORD"));
					ud.setPhone(rs.getString("PHONE"));
					ud.setEmail(rs.getString("EMAIL"));
					ud.setAuthorities(new HashSet<GrantedAuthority>());
				}
				((Collection<GrantedAuthority>) ud.getAuthorities()).add(new SimpleGrantedAuthority(rs.getString("ROLE")));
			}
			if (ud == null) {
				throw new EmptyResultDataAccessException(1);
			}
			System.out.println("Created UserDetails: " + ud);
			return ud;
		}
		
	}
}
