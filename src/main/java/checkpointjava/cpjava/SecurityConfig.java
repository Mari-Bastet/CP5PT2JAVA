package checkpointjava.cpjava;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig  {

	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception 
	{
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)
				.formLogin(form -> {form.loginPage("/logn").permitAll();
				form.defaultSuccessUrl("/index");
				})
				.authorizeHttpRequests(reg -> {reg.requestMatchers("/signup","/css/**").permitAll();
				reg.anyRequest().authenticated();
				}).build();
				
	}

}

