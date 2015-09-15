package models;

import models.base.BlogModel;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Elliott on 8/27/15.
 */

@Entity
public class Comment extends BlogModel{
    public String comment;
    public String Date;

    public Comment() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date = dateFormat.format(new Date());
    }

    public List<Comment> comments;
}
