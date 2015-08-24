package models;

import models.base.BlogModel;

import javax.persistence.Entity;

/**
 * Created by kyleareanraines on 8/24/15.
 */
@Entity
public class BlogUser extends BlogModel {

    public String firstName;
    public String lastName;

    public String username;
    public String email;

    public String getFullName() {
        // TODO: implement
        return null;
    }

    public BlogUser findByUsername() {
        // TODO: implement
        // return find("JPQL query goes here").first();
        return null;
    }
}