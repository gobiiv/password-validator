package com.example.gobii.passwordvalidator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions
        .closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PasswordValidatorEspressoTest {

    private String STRONG_PW;
    private String WEAK_PW;
    private String STRONG_ALERT;
    private String WEAK_ALERT;

    @Rule
    public ActivityTestRule<PasswordValidator> mainActivity = new
            ActivityTestRule<>(PasswordValidator.class);

    @Before
    public void init() {
        // Specify a valid string.
        STRONG_PW = "Strongpw123";
        WEAK_PW = "weakpw";

        STRONG_ALERT = "Strong!";
        WEAK_ALERT = "Not Strong!";

    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.gobii.passwordvalidator", appContext
                .getPackageName());
    }

    @Test
    public void testWeakPasswordAlert() {
        // Type a weak password and then press the validate button.
        onView(withId(R.id.inputtxt1)).perform(typeText(WEAK_PW),
                closeSoftKeyboard());
        onView(withId(R.id.btn1)).perform(click());

        // Check that the alert displays 'Not Strong!'.
        onView(withId(R.id.outputtxt1)).check(matches(withText(WEAK_ALERT)));
    }

    @Test
    public void testStrongPasswordAlert() {
        // Type a strong password and then press the validate button.
        onView(withId(R.id.inputtxt1)).perform(typeText(STRONG_PW),
                closeSoftKeyboard());
        onView(withId(R.id.btn1)).perform(click());

        // Check that the alert displays 'Strong!'.
        onView(withId(R.id.outputtxt1)).check(matches(withText(STRONG_ALERT)));

    }
}
