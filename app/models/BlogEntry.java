package models;

import models.base.BlogModel;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Elliott on 8/27/15.
 */


@Entity
public class BlogEntry extends BlogModel {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false, length = 2500)
    public String post;

    public String date;

    //constructor
    public BlogEntry(String uName, String post1) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        username = uName;
        post = post1;
        date = dateFormat.format(new Date());
    }

    public BlogEntry() {

    }
}
