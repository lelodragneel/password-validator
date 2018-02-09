package com.example.lelo.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lelo on 2/8/2018.
 */
public class ValidatorTest {

    Validator validator;

    @Test
    public void getPasses() throws Exception {
        String pass_1 = "";
        String pass_2 = "    ";
        String pass_3 = "fjfhd";
        String pass_4 = "LoL";
        String pass_5 = "LoLhhhhh";
        String pass_6 = "LHIgiglGL2362";

        validator = new Validator(""); // doesn't matter what the constructor parameter is

        assertEquals(0, validator.getPasses(pass_1));

        assertEquals(1, validator.getPasses(pass_2));

        assertEquals(2, validator.getPasses(pass_3));

        assertEquals(3, validator.getPasses(pass_4));

        assertEquals(4, validator.getPasses(pass_5));

        assertEquals(5, validator.getPasses(pass_6));
    }

    @Test
    public void getStrength() throws Exception {
        String pass_1 = "";
        String pass_2 = "    ";
        String pass_3 = "fjfhd";
        String pass_4 = "LoL";
        String pass_5 = "LoLhhhhh";
        String pass_6 = "LHIgiglGL2362";

        validator = new Validator(pass_1);
        assertEquals("Abominable", validator.getStrength());

        validator = new Validator(pass_2);
        assertEquals("Pathetic", validator.getStrength());

        validator = new Validator(pass_3);
        assertEquals("Bad", validator.getStrength());

        validator = new Validator(pass_4);
        assertEquals("Fine", validator.getStrength());

        validator = new Validator(pass_5);
        assertEquals("Good", validator.getStrength());

        validator = new Validator(pass_6);
        assertEquals("Badass", validator.getStrength());
    }

    @Test
    public void isAcceptable() throws Exception {
        String failPass = "";
        String anotherFailPass = "862";
        String successPass = "LHIgiglGL2362";

        validator = new Validator(failPass);
        assertFalse(validator.isAcceptable());

        validator = new Validator(anotherFailPass);
        assertFalse(validator.isAcceptable());

        validator = new Validator(successPass);
        assertTrue(validator.isAcceptable());
    }

}