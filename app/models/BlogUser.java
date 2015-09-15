package models;

import models.base.BlogModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by kyleareanraines on 8/24/15.
 * Edit 1: 8/25/15 -EK
 * Edit 2: 8/27/15 -EK
 */

@Entity
public class BlogUser extends BlogModel {

    public String firstName;
    public String lastName;

    public String username;
    public String email;

    public String getFullName() {
        // TODO: implement

        return firstName + " " + lastName;
    }

    @OneToMany(mappedBy = "bloguser_id")
    public List<BlogEntry> blogEntries;

//    public BlogUser findByUsername() {
//        // TODO: implement
//        // return find("JPQL query goes here").first();
//
//        return getEntityManager().createQuery("select u from BlogUser u " +
//                                            "where u.username = :username")
//                                            .setParameter("username", :username)
//                                            .setMaxResults(1)
//                                            .getResultList();
//    }
}