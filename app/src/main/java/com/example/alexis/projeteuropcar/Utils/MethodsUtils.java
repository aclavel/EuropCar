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
    public static final String PATTERN_SIRET = "^[0-9]{14}$";

    public boolean checkRegexValidity(String pattern, String chaine){

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(chaine);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public boolean checkMail(String email) {
        return !email.isEmpty() && checkRegexValidity(PATTERN_MAIL, email);
    }

    public boolean checkSiret(String siret) {
        return !siret.isEmpty() && checkRegexValidity(PATTERN_SIRET, siret);
    }

}
