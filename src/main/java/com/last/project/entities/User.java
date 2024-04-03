package com.last.project.entities;

import com.last.project.enums.ERole;
import com.last.project.repositories.RoleRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

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

//    private UserRole role;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "role_id")
private Role role;

    public User() {
    }

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(String name, String email, Object o) {
    }


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(  name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private List<Role> roles; // Change this to List<Role>


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Role> getRoles() {
//        return (Set<Role>) roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = (List<Role>) roles;
//    }

//    public void setRole(UserRole roleEntrepreneur) {
//    }
//    public void setRole(ERole roleEntrepreneur) {
//    }
//
//
//        public UserDto getDto(){
//            userDto.setName(name);
//            //  userDto.setRole(roles);
//            userDto.setEmail(email);
//            return userDto;
//        }
//    UserDto userDto = new UserDto();
//        userDto.setId(id);

}
