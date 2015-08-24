package controllers;

import play.*;
import play.data.validation.Validation;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 * This is the controller that will be used for all actions related to the blog
 */

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void testPage() {
        String var1 = "TEST TEXT";
        render(var1);
    }

    public static void testAction(String username) {
        if (username == null || username.equals("")) {
            flash("error", "This is an error message that you can access in the page");
            renderTemplate("testPage.html");
        }
        BlogUser user = BlogUser.find("username = ?", username) != null ? (BlogUser)BlogUser.find("username = ?", username).first() : null;
        if (user == null) {
            Validation.addError("field.username", "User not found. Wrong username?");
        }
        if (Validation.hasErrors()) {
            renderTemplate("testPage");
        }
        renderTemplate("testPage");
    }
}