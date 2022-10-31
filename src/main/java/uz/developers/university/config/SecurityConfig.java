package uz.developers.university.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //MINISTER, RECTOR, PRORECTOR, DEAN, CURATOR, STUDENT

    private final PasswordEncoder passwordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers(HttpMethod.GET,"/api/address","/api").hasAnyRole(UserRole.STUDENT.name(),UserRole.CURATOR.name(),UserRole.DEAN.name(),UserRole.PRORECTOR.name(),UserRole.RECTOR.name(),UserRole.MINISTER.name())
                .antMatchers(HttpMethod.POST,"/api/**").hasAnyRole(UserRole.STUDENT.name(),UserRole.CURATOR.name(),UserRole.RECTOR.name())
                .antMatchers(HttpMethod.PUT,"/api/**").hasAnyRole(UserRole.CURATOR.name(),UserRole.RECTOR.name())
                .antMatchers(HttpMethod.DELETE,"/api/**").hasAnyRole(UserRole.RECTOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder.encode("student"))
                .roles(UserRole.STUDENT.name()) //ROLE_STUDENT
                .build();

        UserDetails curator = User.builder()
                .username("curator")
                .password(passwordEncoder.encode("curator"))
                .roles(UserRole.CURATOR.name()) //ROLE_CURATOR
                .build();

        UserDetails dean = User.builder()
                .username("dean")
                .password(passwordEncoder.encode("dean"))
                .roles(UserRole.DEAN.name()) //ROLE_DEAN
                .build();

        UserDetails prorector = User.builder()
                .username("prorector")
                .password(passwordEncoder.encode("prorector"))
                .roles(UserRole.PRORECTOR.name()) //ROLE_PRORECTOR
                .build();

        UserDetails rector = User.builder()
                .username("rector")
                .password(passwordEncoder.encode("rector"))
                .roles(UserRole.RECTOR.name()) //ROLE_RECTOR
                .build();

        UserDetails minister = User.builder()
                .username("minister")
                .password(passwordEncoder.encode("minister"))
                .roles(UserRole.MINISTER.name()) //ROLE_MINISTER
                .build();

        return new InMemoryUserDetailsManager(
                student,
                curator,
                dean,
                prorector,
                rector,
                minister
        );
    }

}
