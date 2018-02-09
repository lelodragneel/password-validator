package com.example.lelo.password_validator;

import android.util.Log;

/**
 * Created by Lelo on 2/8/2018.
 */

public class Validator {

    String password;
    int totalFails;
    int numOfRules;

    public Validator(String password) {
        this.password = password;
        numOfRules = 5;
    }

    public int getPasses() {
        totalFails = 0;

        if (password.equals("password") || password.equals("")) {
            Log.d("Rule 1", "failed");
            totalFails++;
        }

        if (password.length() < 8) {
            Log.d("Rule 2", "failed");
            totalFails++;
        }

        if (!password.matches(".*[A-Z].*[A-Z].*")) {
            Log.d("Rule 3", "failed");
            totalFails++;
        }

        if (!password.matches(".*[a-z].*")) {
            Log.d("Rule 4", "failed");
            totalFails++;
        }

        if (!password.matches(".*[0-9].*[0-9].*")) {
            Log.d("Rule 5", "failed");
            totalFails++;
        }

        return numOfRules - totalFails;
    }

    public String getStrength() {
        switch (getPasses()) {
            case 0:
                return "Abominable";
            case 1:
                return "Pathetic";
            case 2:
                return "Bad";
            case 3:
                return "Fine";
            case 4:
                return "Good";
            case 5:
                return "Badass";
            default:
                Log.e("getStrength", "something didn't work right in the switch");
                return "error";
        }
    }

    public boolean isAcceptable() {
        if (totalFails > 0) {
            return false;
        } else {
            return true;
        }
    }

}
