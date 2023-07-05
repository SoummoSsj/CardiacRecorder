package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.init;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class log_in_or_SignUITest {
    @Rule
    public ActivityScenarioRule<log_in_or_Sign> activityRule =
            new ActivityScenarioRule<>(log_in_or_Sign.class);

    @Test
    public void testLog_in_or_Sign(){
        onView(withId(R.id.loginSignUpActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.signup_button)).check(matches(isDisplayed()));
        onView(withId(R.id.login_button)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));

    }
    @Test
    public void navigateToLoginActivity() {
        Intents.init();
        // Perform an action to navigate to the second activity, for example, clicking a button
        onView(withId(R.id.login_button)).perform(click());

        // Verify that the second activity is launched
        Intents.intended(IntentMatchers.hasComponent(LogInPage.class.getName()));
        onView(withId(R.id.loginActivity)).check(matches(isDisplayed()));
        Intents.release();


    }
    @Test
    public void navigateToSignupActivity() {
        Intents.init();
        onView(withId(R.id.signup_button)).perform(click());

        // Verify that the second activity is launched
        Intents.intended(IntentMatchers.hasComponent(SignUpAct.class.getName()));
        onView(withId(R.id.SignupActivity)).check(matches(isDisplayed()));
        Intents.release();

    }
}

