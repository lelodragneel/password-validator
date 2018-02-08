package com.example.lelo.password_validator;

import android.util.Log;

/**
 * Created by Lelo on 2/8/2018.
 */

public class Validator {

    public int getPasses(String password) {
        int numOfRules = 2;
        int totalFails = 0;

        if (password.equals("password")) {
            Log.i("Rule 1", "failed");
            totalFails++;
        }

        if (password.length() < 8) {
            Log.i("Rule 2", "failed");
            totalFails++;
        }

        return numOfRules - totalFails;
    }

}
