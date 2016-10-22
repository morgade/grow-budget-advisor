package com.mindthehippo.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindthehippo.budget.aggregate.budget.Item;
import com.mindthehippo.budget.application.dto.ItemDTO;
import com.mindthehippo.infrastructure.mock.MockService;
import java.io.IOException;
import static java.util.Collections.singletonMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 *
 * @author Marcelo
 */
// TODO: CHANGE TO OAuth based authentication
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    @Autowired
    MockService mockService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(this)
                .failureHandler(this)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");

        auth.inMemoryAuthentication().withUser("dennis").password("grow").roles("USER");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        Map m = new HashMap();
        m.put("user", authentication.getName());
        m.put("account", mockService.getAccount(authentication.getName()));
        mapper.writeValue(response.getWriter(), singletonMap("authenticated", m));
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        mapper.writeValue(response.getWriter(), singletonMap("failure", exception.getMessage()));
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        PropertyMap<Item, ItemDTO> itemMap = new PropertyMap<Item, ItemDTO>() {
            @Override
            protected void configure() {
                map().setCategory(source.getCategory().getText());
            }
        };
        modelMapper.addMappings(itemMap);
        return modelMapper;
    }
}
