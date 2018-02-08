package com.example.lelo.password_validator;

import android.util.Log;

/**
 * Created by Lelo on 2/8/2018.
 */

public class Validator {

    public int getPasses(String password) {
        int numOfRules = 5;
        int totalFails = 0;

        if (password.equals("password")) {
            Log.i("Rule 1", "failed");
            totalFails++;
        }

        if (password.length() < 8) {
            Log.i("Rule 2", "failed");
            totalFails++;
        }

        if (password.matches(".*[A-Z].*[A-Z].*")) {
            Log.i("Rule 3", "failed");
            totalFails++;
        }

        if (password.matches(".*[a-z].*")) {
            Log.i("Rule 4", "failed");
            totalFails++;
        }

        if (password.matches(".*[0-9].*[0-9].*")) {
            Log.i("Rule 5", "failed");
            totalFails++;
        }

        return numOfRules - totalFails;
    }

}
