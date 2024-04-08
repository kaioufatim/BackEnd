package com.last.project.entities;

import com.last.project.dto.UserDto;
import com.last.project.enums.ERole;
import com.last.project.enums.UserRole;
import com.last.project.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String username;

    private String lastname;
    private String phone;

    //private UserRole role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public UserDto getDto(){
            UserDto userDto = new UserDto();

            userDto.setName(name);
            userDto.setEmail(email);
//            userDto.setRole(role);
            return userDto;
        }
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        // Initialize other fields as necessary
    }
}
