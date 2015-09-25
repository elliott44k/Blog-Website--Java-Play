package models;

import models.base.BlogModel;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kyleareanraines on 8/24/15.
 * Edit 1: 8/25/15 -EK
 * Edit 2: 8/27/15 -EK
 */

@Entity

//create constructor

public class BlogUser extends BlogModel {

    //instance variables
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long id;

    public String firstName;

    public String lastName;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false)
    public String email;


    //class constructor

    public BlogUser(String fName, String lName, String uName, String pWord, String email1) {
        firstName = fName;
        lastName = lName;
        username = uName;
        password = pWord;
        email = email1;
    }

    public BlogUser() {
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

//    @OneToMany(mappedBy = "id")
//    public List<BlogEntry> blogEntries;

//    public BlogUser findByUsername() {
//        // TODO: implement
//        BlogUser bu = null;
//        return bu;
//    }
}
