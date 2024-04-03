package com.last.project.services.servicesImp;

import com.last.project.dto.SignUpRequestDTO;
import com.last.project.dto.UserDto;
import com.last.project.entities.Role;
import com.last.project.entities.User;
import com.last.project.enums.ERole;
import com.last.project.enums.UserRole;
import com.last.project.payload.request.SignUpRequest;
import com.last.project.repositories.RoleRepository;
import com.last.project.repositories.UserRepository;
import com.last.project.services.authentification.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImp implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Assuming passwordEncoder is injected
        public UserDto signupCreateur(SignUpRequest signUpRequestDTO){
        User user = new User();
            Role strRoles = signUpRequestDTO.getRole();

            user.setName(signUpRequestDTO.getUsername());
       // user.setLastname(signUpRequestDTO.getEmail());
        user.setEmail(signUpRequestDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequestDTO.getPassword()));
       // user.setPhone(signUpRequestDTO.getPhone());
            Role userRole = roleRepository.findByName(ERole.ROLE_ENTREPRENEUR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            strRoles=userRole;
      //  user.setRole(UserRole.CREATEUR);
//        return userRepository.save(user).getDto();
            User savedUser = userRepository.save(user);
            return modelMapper.map(savedUser, UserDto.class);
                }

//    @Override
//    public UserDto signupCreateur(SignUpRequestDTO signUpRequestDTO) {
//        return null;
//    }

    public Boolean existParEmail(String email){
        return userRepository.findFirstByEmail(email) != null;
    }


    @Override
    public UserDto signupEntrepreneur(SignUpRequestDTO signUpRequestDTO ) {
        User user = new User();
       // Role strRoles = signUpRequestDTO.getRole();

        modelMapper.map(signUpRequestDTO, user); // Map properties from DTO to User

        // Handle password encryption separately
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequestDTO.getPassword()));

//        Role userRole = roleRepository.findByName(ERole.ROLE_ENTREPRENEUR)
//                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//        strRoles=userRole;


        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class); // Map User to UserDto
    }

//    public UserDto signupEntrepreneur(SignUpRequestDTO signUpRequestDTO) {
//        // 1. Validation (Optional)
//        // Add validation logic here if needed to ensure user-provided data meets requirements
//
//        // 2. Create a new User object
//        User user = new User();
//        user.setUsername(signUpRequestDTO.getName() + "." + signUpRequestDTO.getLastname());  // Assuming username generation
//        user.setEmail(signUpRequestDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(signUpRequestDTO.getPassword()));
//        user.setName(signUpRequestDTO.getName());
//        user.setLastname(signUpRequestDTO.getLastname());
//        user.setPhone(signUpRequestDTO.getPhone());
//
//        Role entrepreneurRole = roleRepository.findByName(ERole.ROLE_ENTREPRENEUR)
//                .orElseThrow(() -> new RuntimeException("Entrepreneur role not found"));
//
//        user.setRole(entrepreneurRole);
//
//            User savedUser = userRepository.save(user);
//            return modelMapper.map(savedUser, UserDto.class);
//
//    }


//    @Override
//    public UserDto signupEntrepreneur(SignUpRequestDTO signUpRequestDTO) {
//        User user = new User();
//        modelMapper.map(signUpRequestDTO, user); // Map properties from DTO to User
//
//        // Handle password encryption separately
//        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequestDTO.getPassword()));
//
////       user.setRole(UserRole.ENTREPRENEUR);
//        user.setRole(ERole.ROLE_ENTREPRENEUR);
//
//
//        User savedUser = userRepository.save(user);
//        return modelMapper.map(savedUser, UserDto.class); // Map User to UserDto
//    }


//    public UserDto signupEntrepreneur(SignUpRequestDTO signUpRequestDTO) {
//        User user = new User();
//        user.setName(signUpRequestDTO.getName());
//        user.setLastname(signUpRequestDTO.getLastname());
//        user.setEmail(signUpRequestDTO.getEmail());
//        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequestDTO.getPassword()));
//        user.setPhone(signUpRequestDTO.getPhone());
//
//      //  user.setRole(ERole.ROLE_ENTREPRENEUR);
//     //   return userRepository.save(user).getDto();
//    }
}
