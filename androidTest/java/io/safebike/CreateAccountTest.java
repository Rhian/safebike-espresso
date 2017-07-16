package io.safebike;

// MainActivityInstrumentationTest.java

import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.openLinkWithText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import android.support.test.rule.ActivityTestRule;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.safebike.ui.login.LoginActivity;
import io.safebike.ui.main.MainActivity;

/**
 * Created by Rhian on 17/09/16.
 */
public class CreateAccountTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void loginIsVisible() {
        onView(withId(R.id.sign_in_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void scanButtonVisible() {
        onView(withId(R.id.scan_message)).check(matches(isDisplayed()));
    }

    @Test
    public void registerAccount() {
        onView(withId(R.id.sign_in_btn)).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.link_signup)).perform(click());
        onView(withId(R.id.input_fname)).perform(typeText("Rhian"));
        onView(withId(R.id.input_lname)).perform(typeText("Lewis"));
        onView(withId(R.id.input_email)).perform(typeText("rhianatwork@gmail.com"));
        onView(withId(R.id.input_password)).perform(typeText("test1"));
        Espresso.closeSoftKeyboard();
        SystemClock.sleep(500);
        onView(withId(R.id.input_password_repeat)).perform(typeText("test1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_account_confirm)).perform(click());
        onView(withId(R.id.address1)).perform(typeText("Test house"));
        onView(withId(R.id.address2)).perform(typeText("Test street"));
        onView(withId(R.id.address_cap)).perform(typeText("12345"));
        onView(withId(R.id.city)).perform(typeText("Test city"));
        onView(withId(R.id.country)).perform(typeText("United"));
        onView(withText("United Kingdom"))
                .inRoot(isPlatformPopup())
                .perform(click());
        onView(withId(R.id.btn_address_confirm)).perform(click());
    }

}