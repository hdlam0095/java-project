package lamhd.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lamhd.spring.security.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		// The pages does not require login
		http.authorizeRequests().antMatchers("/", "/index", "/login", "/logout").permitAll();
		// /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
		// If no login, it will redirect to /login page.

		http.authorizeRequests().antMatchers("/user_admin").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");
		// For ADMIN only.
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/users/**").access("hasRole('ROLE_USER')");
		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/login").loginPage("/login").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/index").failureUrl("/login?error=true")//
				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/index");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

	}

}

/** https://o7planning.org/en/11543/create-a-login-application-with-spring-boot-spring-security-spring-jdbc */
// @Override
// protected void configure(HttpSecurity http) throws Exception {
//
// http.csrf().disable();
//
// // The pages does not require login
// http.authorizeRequests().antMatchers("/", "/login",
// "/logout").permitAll();
//
// // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
// // If no login, it will redirect to /login page.
// http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER',
// 'ROLE_ADMIN')");
//
// // For ADMIN only.
// http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
//
// // When the user has logged in as XX.
// // But access a page that requires role YY,
// // AccessDeniedException will be thrown.
// http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//
// // Config for Login Form
// http.authorizeRequests().and().formLogin()//
// // Submit URL of login page.
// .loginProcessingUrl("/j_spring_security_check") // Submit URL
// .loginPage("/login")//
// .defaultSuccessUrl("/userAccountInfo")//
// .failureUrl("/login?error=true")//
// .usernameParameter("username")//
// .passwordParameter("password")
// // Config for Logout Page
// .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
//
// }
/** Mã hóa password khi tạo user */
// public static String encrytePassword(String password) {
// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
// return encoder.encode(password);
// }
//
// public static void main(String[] args) {
// String password = "123";
// String encrytedPassword = encrytePassword(password);
//
// System.out.println("Encryted Password: " + encrytedPassword);
// }
// }
