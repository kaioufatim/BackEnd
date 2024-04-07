package com.last.project.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.last.project.dto.AuthenticationRequest;
import com.last.project.dto.SignUpRequestDTO;
import com.last.project.dto.UserDto;
import com.last.project.entities.User;
import com.last.project.payload.request.SignUpRequest;
import com.last.project.repositories.UserRepository;
import com.last.project.services.authentification.AuthService;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
   // private AuthenticationManager authenticationManager;
    public static final String TOKEN_PREFIX ="Bearer ";
    public static final String HEADER_STRING ="Authorization";



    @PostMapping("/createur/signUp")
    public ResponseEntity<?>signupCreateur(@RequestBody SignUpRequestDTO signUpRequestDTO){
        if(authService.existParEmail(signUpRequestDTO.getEmail())){
            return new ResponseEntity<>("Createur deja exist avec cet email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser = authService.signupCreateur(signUpRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/entrepreneur/signUp")
    public ResponseEntity<?>signupEntrepreneur(@RequestBody SignUpRequestDTO signUpRequestDTO){
        if(authService.existParEmail(signUpRequestDTO.getEmail())){
            return new ResponseEntity<>("entrepreneur deja exist avec cet email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser = authService.signupEntrepreneur(signUpRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
//    @PostMapping("/authenticate")
//    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException, JSONException {
//        try{
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.getUsername(),authenticationRequest.getPassword()));
//        }catch (BadCredentialsException e){
//            throw new BadCredentialsException("Incorrect username or password",e);
//        }
//        final UserDetails userDetails= userDetailsServiceImp.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt =jwtUtil.generateToken(userDetails.getUsername());
//        User user = userRepository.findFirstByEmail(authenticationRequest.getUsername());
//        response.getWriter().write(new JSONObject()
//                .put("userId",user.getId())
//                .put("role",user.getRole())
//                .toString())
//
//        ;
//
//        response.addHeader("Access-Control-Expose-Headers","Authorization");
//        response.addHeader("Access-Control-Allow-Headers","Authorization"+
//                "X-PINOTHER,Origin,X-Requested-with,Content-Type,Accept,X-Cusom-header");
//        response.addHeader(HEADER_STRING,TOKEN_PREFIX);
//
//
//
//    }
}
