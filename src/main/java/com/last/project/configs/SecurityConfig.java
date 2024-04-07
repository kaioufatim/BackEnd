////package com.last.project.configs;
////import com.last.project.security.jwt.AuthEntryPointJwt;
////import com.last.project.security.jwt.AuthTokenFilter;
//////import com.last.project.security.services.UserDetailsServiceImpl;
////import jakarta.servlet.Filter;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
////import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.AuthenticationEntryPoint;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
//
////@Configuration
////@EnableMethodSecurity
////public class SecurityConfig {
////    @Autowired
////    UserDetailsServiceImpl userDetailsService;
////
////    @Autowired
////    private AuthEntryPointJwt unauthorizedHandler;
////
////    @Bean
////    public Filter authenticationJwtTokenFilter() {
////        return new AuthTokenFilter();
////    }
////
////    @Bean
////    public DaoAuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
////
////        authProvider.setUserDetailsService(userDetailsService);
////        authProvider.setPasswordEncoder(passwordEncoder());
////
////        return authProvider;
////    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
////        return authConfig.getAuthenticationManager();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.csrf(csrf -> csrf.disable())
////                .exceptionHandling(exception -> exception.authenticationEntryPoint((AuthenticationEntryPoint) unauthorizedHandler))
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .authorizeHttpRequests(auth ->{
////                            auth.requestMatchers(antMatcher("/api/**")).permitAll();
////                            //auth.anyRequest().authenticated();
////                        }
////                );
////
////       // http.authenticationProvider(authenticationProvider());
////
////        //http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
////
////        return http.build();
////    }}
//////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.csrf(csrf -> csrf.disable())
////                .exceptionHandling(exception -> exception.authenticationEntryPoint((AuthenticationEntryPoint) unauthorizedHandler))
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .authorizeHttpRequests(auth ->{
////                            auth.antMatchers("/api/**").permitAll();
////
////                            auth.anyRequest().authenticated();
////                        }
////                );
////
////        http.authenticationProvider(authenticationProvider());
////
////        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
////
////        return http.build();
////    }
////}
//
//
//
//
//
//
////*********
//import com.last.project.security.jwt.AuthEntryPointJwt;
//import com.last.project.security.jwt.AuthTokenFilter;
//import com.last.project.security.services.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//
//@Configuration
//@EnableMethodSecurity
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//
//public class SecurityConfig {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/api/auth/**").permitAll()
//                                .requestMatchers("/api/test/**").permitAll()
//                                .requestMatchers("/createur/signUp").permitAll()
//                                .requestMatchers("/entrepreneur/signUp").permitAll()
//                                .anyRequest().authenticated()
//                );
//        http.authenticationProvider(authenticationProvider());
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}
