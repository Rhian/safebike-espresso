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
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.safebike.ui.login.LoginActivity;
import io.safebike.ui.main.MainActivity;

/**
 * Created by Rhian on 18/09/16.
 */
public class PasswordValidationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void invalidPassword() {
        onView(withId(R.id.sign_in_btn)).perform(click());
        onView(withId(R.id.input_password)).perform(typeText("test"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());

        //check unable to log in
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    public void avatarNotVisibleWhenLoggedOut() {
        onView(withId(R.id.user_avatar)).check(matches(not(isDisplayed())));
    }

}