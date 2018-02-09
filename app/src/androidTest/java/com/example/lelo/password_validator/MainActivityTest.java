package com.example.lelo.password_validator;

import android.graphics.Color;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Lelo on 2/8/2018.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void feedbackResponse() throws Exception {
        onView(withId(R.id.editText_password))
                .perform(clearText())
                .perform(typeText("BESTpass68"),closeSoftKeyboard());
        onView(withId(R.id.button_validate))
                .perform(click());
        onView(withId(R.id.textView_feedback))
                .check(matches(withText("Badass")));

        onView(withId(R.id.editText_password))
                .perform(clearText())
                .perform(typeText("   "),closeSoftKeyboard());
        onView(withId(R.id.button_validate))
                .perform(click());
        onView(withId(R.id.textView_feedback))
                .check(matches(withText("Pathetic")));
    }

//    @Test
//    public void buttonFailureColor() throws Exception {
//        onView(withId(R.id.editText_password))
//                .perform(clearText())
//                .perform(typeText("bad pass"),closeSoftKeyboard());
//        onView(withId(R.id.button_validate))
//                .perform(click())
//                .check(matches(hasTextColor(Color.parseColor("#DD1E42"))));
//    }

//    @Test
//    public void buttonSuccessColor() throws Exception {
//        onView(withId(R.id.editText_password))
//                .perform(clearText())
//                .perform(typeText("GOOD6436pass"),closeSoftKeyboard());
//        onView(withId(R.id.button_validate))
//                .perform(click())
//                .check(matches(hasTextColor(Color.parseColor("#40CF1A"))));
//    }

}