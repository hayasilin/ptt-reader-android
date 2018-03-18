package com.cracktheterm.pttreader;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import junit.framework.AssertionFailedError;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by kuan-weilin on 3/18/18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest // 代表這個 Test 會跑比較久
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void setup() throws Exception {
        //do something…
    }

    @Test
    public void demoTest() throws InterruptedException {

        ViewInteraction webView = onView(withId(R.id.webView));

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        checkWebViewIsDisplayed(webView);

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(1).perform(click());
        checkWebViewIsDisplayed(webView);

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(2).perform(click());
        checkWebViewIsDisplayed(webView);

        try {
            onView(withId(R.id.listView)).check(ViewAssertions.matches(Matchers.withListSize(30)));
            Log.w("pass","list has correct number");
        }catch (AssertionFailedError e){
            Log.e("error", "AssertionFailedError", e);
        }

    }

    public void checkWebViewIsDisplayed(ViewInteraction webView) {

        try {
            webView.check(matches(isDisplayed()));
            pressBack();
        }catch (AssertionFailedError e) {
            Log.e("error", "AssertionFailedError" ,e);
        }
    }

    @After
    public void teardown() throws Exception {
        // do something
    }
}

class Matchers {
    public static Matcher<View> withListSize (final int size) {
        return new TypeSafeMatcher<View>() {
            @Override public boolean matchesSafely (final View view) {
                return ((ListView) view).getCount () == size;
            }

            @Override public void describeTo (final Description description) {
                description.appendText ("ListView should have " + size + " items");
            }
        };
    }
}

