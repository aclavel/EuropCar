package com.example.alexis.projeteuropcar.Utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alexis on 09/04/2018.
 */

public class MethodsUtils {

    public MethodsUtils() {
    }

    public static final String PATTERN_MAIL = "^[A-Za-z0-9+_.-]+@(.+)$";

    public boolean checkMailValidity(String email){

        Pattern p = Pattern.compile(PATTERN_MAIL);
        Matcher m = p.matcher(email);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public boolean checkMail(String email) {
        return !email.isEmpty() && checkMailValidity(email);
    }

}
