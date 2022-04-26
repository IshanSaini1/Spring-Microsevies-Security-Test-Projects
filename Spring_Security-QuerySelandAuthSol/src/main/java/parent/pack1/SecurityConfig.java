package parent.pack1;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
public @Slf4j class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * //How to solve password Encoder Error
	 * https://www.codejava.net/frameworks/spring/there-is-no-passwordencoder-mapped
	 * -for-the-id-null OR Use
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Autowired
	private DataSource datasource;

	public SecurityConfig() {
		log.info("SecurityConfig Constructor");
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// In Memory User Addition
		// auth.inMemoryAuthentication().withUser("ABC").password(new
		// BCryptPasswordEncoder().encode("pass")).authorities("USER");

		//Implemented with SQL Database
		/*
		 * auth.jdbcAuthentication().dataSource(datasource)
		 * .usersByUsernameQuery("select username, password, enabled from Users " +
		 * "where username=?")
		 * .authoritiesByUsernameQuery("select username, authority from UserAuthorities "
		 * + "where username=?") .passwordEncoder(new BCryptPasswordEncoder());
		 */
		
		
	}
}
