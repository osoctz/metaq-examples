package cn.metaq.auth.security.config;

import cn.metaq.auth.security.userdetails.CustomUserDetailsService;
import cn.metaq.common.core.DaoTemplate;
import cn.metaq.data.jpa.BaseTemplate;
import cn.metaq.uaa.config.SecurityBizAutoConfiguration;
import cn.metaq.uaa.security.TokenAuthenticationFilter;
import cn.metaq.uaa.security.TokenHelper;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
//@AutoConfigureBefore(value = SecurityBizAutoConfiguration.class)
public class SecurityAutoConfiguration extends WebSecurityConfigurerAdapter {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private TokenHelper tokenHelper;

    @Bean
    public DaoTemplate template() {
        return new BaseTemplate(em);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint((HttpServletRequest request, HttpServletResponse response, AuthenticationException e)->response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()))
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/favicon.ico").permitAll()//不鉴权
                .antMatchers("/auth/**").permitAll() //鉴权端点不鉴权
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new TokenAuthenticationFilter(tokenHelper, userDetailsService()), BasicAuthenticationFilter.class)
                //.httpBasic()
                .csrf().disable();
    }
}
