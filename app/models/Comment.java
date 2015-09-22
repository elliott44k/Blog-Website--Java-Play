package models;

import models.base.BlogModel;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Elliott on 8/27/15.
 */

@Entity

public class Comment extends BlogModel {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public Long blogEntryid;

    @Column(nullable = false, length = 500)
    public String comment;

    public String date;

    public Comment(String uName, Long blogEntryid1, String comment1) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        uName = username;
        blogEntryid = blogEntryid1;
        comment = comment1;
        date = dateFormat.format(new Date());
    }

    public Comment() {
    }
}