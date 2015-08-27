package models;

import models.base.BlogModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Elliott on 8/27/15.
 */
public class Comment extends BlogModel{
    public String comment;
    public String Date;

    public Comment() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date = dateFormat.format(new Date());
    }
}
