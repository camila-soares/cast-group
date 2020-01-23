//package exam.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	 private static final String[] PUBLIC_MATCHERS = {
//	            "/pessoa/**"
//
//	    };
//
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//            http.authorizeRequests()
//            .antMatchers(PUBLIC_MATCHERS).permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic();
//	}
//}
