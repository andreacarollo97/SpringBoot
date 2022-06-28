package com.angularSpring.demoAngSpring.security;

import com.angularSpring.demoAngSpring.jwt.JwtEntryPoint;
import com.angularSpring.demoAngSpring.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;





@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {


    private final UserDetailsService userDetailService;

    private final JwtEntryPoint jwtEntryPoint;


    public MainSecurity(UserDetailsService userDetailService, JwtEntryPoint jwtEntryPoint){
        this.userDetailService = userDetailService;
        this.jwtEntryPoint = jwtEntryPoint;
    }


    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    private static final String[] ADMIN = {
            "/api/prenotazione/edit/**",
            "/api/prenotazione/elimina/**",
            "/api/prenotazione/detail/**",


    };
    private static final String[] USER = {
            "/api/prenotazione/listauto",
            "/api/prenotazione/salva",
            "/api/prenotazione/prenotazioni/**",
            "/api/auto/elenco",
    };

    private static final String[] SUPER = {
            "/api/parcoAuto/**",
    };

    private static final String[] SUPER_ADMIN= {
            "/api/user/**",
            "/api/auto/edit/**",
            "/api/auto/elimina/**",
            "/api/auto/detail/**",
            "/api/auto/salva/**",

    };

    private static final String[] SUPER_USER= {
            "/api/auto/elenco"
    };

  //toDo: studiare hasRole vs hasAuthority

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers(SUPER_ADMIN).hasAnyAuthority("ROLE_SUPER","ROLE_ADMIN")
                .antMatchers(SUPER_USER).hasAnyAuthority("ROLE_SUPER","ROLE_USER")
                .antMatchers(SUPER).hasAuthority("ROLE_SUPER")
                .antMatchers(ADMIN).hasAuthority("ROLE_ADMIN")
                .antMatchers(USER).hasAuthority("ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}


