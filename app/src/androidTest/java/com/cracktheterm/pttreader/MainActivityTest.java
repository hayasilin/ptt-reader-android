package com.cracktheterm.pttreader;

import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.anything;

/**
 * Created by kuan-weilin on 3/18/18.
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class MainActivityTest {

    MainPage mainPage;

    private IdlingResource mIdlingResource;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void setup() {
        IdlingPolicies.setMasterPolicyTimeout(30, TimeUnit.SECONDS);
        IdlingPolicies.setIdlingResourceTimeout(30, TimeUnit.SECONDS);

        mIdlingResource = mActivityRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(mIdlingResource);

        mainPage = new MainPage();
    }

    @Test
    public void testHowArticleWebViewExists() {
        // Given
        mainPage.listLive.check(matches(isDisplayed()));

        // When
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        // Then
        checkWebViewIsDisplayed(mainPage.webView);

        // When
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(1).perform(click());
        // Then
        checkWebViewIsDisplayed(mainPage.webView);
    }

    @Test
    public void testHotArticleListHasData() {
        // Given
        mainPage.listLive.check(matches(isDisplayed()));

        int count =  mActivityRule.getActivity().hotArticles.size();
        ListView listView = mActivityRule.getActivity().findViewById(R.id.listView);

        // Then
        assertEquals(count, listView.getAdapter().getCount());
    }

    public void checkWebViewIsDisplayed(ViewInteraction webView) {
        webView.check(matches(isDisplayed()));
        pressBack();
    }

    @After
    public void teardown() {
        IdlingRegistry.getInstance().unregister(mIdlingResource); // Clean up
    }
}