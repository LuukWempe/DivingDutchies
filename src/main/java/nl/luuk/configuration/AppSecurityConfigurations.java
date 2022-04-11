package nl.luuk.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nl.luuk.services.DiverService;
import nl.luuk.services.SpecialtyService;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class AppSecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity
            .ignoring()
            .antMatchers("/resources/**");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests()
            .antMatchers(
            "/",
            "/login",
            "/register",
            "/console",
            "/open/**").permitAll()
            .antMatchers(
                "/diver/**").hasRole("DIVER")
            .antMatchers(
                "/admin/**").hasRole("ADMIN")
            .and()
            
            .csrf().disable()
            
            .authorizeRequests()
            .and()
            .headers().frameOptions().sameOrigin()

            .and()
            .formLogin()
            .loginPage("/loginpage.html")
            	//.loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login")
            .and()
                .logout()
                .logoutSuccessUrl("/home")
                .logoutUrl("/logout")
                .invalidateHttpSession(true);
             
    }


    @Autowired
    public DataSource dataSource;
    
    @Autowired
    public DiverService diverService;
    
    @Autowired
    public SpecialtyService specialtyService;

  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        auth
           .userDetailsService(diverService)
           .passwordEncoder(encoder)

           .and()
           .jdbcAuthentication()
           .dataSource(dataSource)
           .passwordEncoder(encoder);

        
        //Admin
        diverService.registerDiver("luukwempe","ADMIN", "Luuk", "Wempe", encoder.encode("hallo"), "luukwempe@hotmail.com", true, true);
        }

}