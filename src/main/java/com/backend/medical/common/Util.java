package com.backend.medical.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static Boolean isBirthdayValidation(String birthday) {
        Pattern pattern = Pattern.compile("\\d{4}=\\d{2}-\\{2}");
        Matcher matcher = pattern.matcher(birthday);
        return matcher.matches();
    }

    public static Boolean isPhoneValidation(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\{4}");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static String getGenderCode(String gender) {
        return gender.equals("남") ? "M" : "F";
    }
}
