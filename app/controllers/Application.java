package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

import models.*;
import org.hibernate.exception.DataException;
import play.data.validation.Validation;
import play.mvc.Controller;
import javax.persistence.*;

/**
 * This is the controller that will be used for all actions related to the blog
 */

//Render looks for template with the method name.html and sends to browser

public class Application extends Controller {

    public static void index() {
        BlogUser user = null;
//        Long userId = Long.valueOf(session.get("loggedInUser"));
//        if (userId != null) { user = BlogUser.findById(userId); }

        render(user);
    }

    public static void contact() { render(); }


    //registration page
    public static void register() {
        render();
    }

    public static void registerSubmit(String firstName, String lastName, String username, String password, String email) throws FileNotFoundException {

        if (BlogUser.count("username = ?", username) > 0) {
            //flash (message name in template, message)
            flash("error","Username already taken");
            register();
        }

        BlogUser user = new BlogUser(firstName, lastName, username, password, email);

        //persists the entity in the database
        try {
            user.save();
        }
        catch (PersistenceException e) {
            File file = new File("testsalotofthem.txt");
            PrintStream ps = new PrintStream(file);
            e.printStackTrace(ps);
        }
        session.put("loggedInUser", user.id);
        //session.get will return null or the userid if someone is logged in

        if (BlogUser.find("username = ?", username).first() != null)
        //last call in the method
        index();
    }

    public static void login(){
        render();
    }

    public static void loginSubmit(String username, String password){
        BlogUser bu = null;
//        Query query = select blogUser.username from BlogUser blogUser where blogUser.username like username


    }

   public static void entrySubmit(String username, String post) {
       if (session.isEmpty()) {
           flash("error", "Not logged in");
           login();
       }
       BlogEntry blog = new BlogEntry(username, post);
       blog.save();
       index();
   }



    public static void myHome() {
        render();
    }








    public static void testPage() {
        String var1 = "TEST TEXT";
        render(var1);
    }

    public static void testAction(String username) {
        if (username == null || username.equals("")) {
            flash("error", "This is an error message that you can access in the page");
            testPage();
        }
        BlogUser user = BlogUser.find("username = ?", username) != null ? (BlogUser)BlogUser.find("username = ?", username).first() : null;
        if (user == null) {
            Validation.addError("field.username", "User not found. Wrong username?");
        }
        if (Validation.hasErrors()) {
            testPage();
        }
        testPage();
    }
}