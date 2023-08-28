package org.quarkus.samples.petclinic.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.FormParam;


@Entity
@Table(name = "users")
public class User extends PanacheEntity {


    @Column(name = "email")
    @NotEmpty
    @FormParam("email")
    @Email
    @NotBlank(message = "email may not be blank")
    public String email;

    @Column(name = "password_hash")
    @NotEmpty
    @FormParam("password") 
    public String password_hash;

    @Column(name = "salt")
    @NotEmpty
    @FormParam("salt") 
    public String salt;


    @Column(name = "iteration_count")
    @NotEmpty
    public String iterationCount;

    @Column(name = "role")
    @NotEmpty
    @FormParam("role")
    public String role;

    @Override
    public String toString() {
        return "User [email=" + email + ", password_hash=" + password_hash + ", salt=" + salt + ", iterationCount="
                + iterationCount + ", role=" + role + "]";
    }

    
   

}
