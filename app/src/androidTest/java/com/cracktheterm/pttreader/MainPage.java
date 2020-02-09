package com.cracktheterm.pttreader;

import android.support.test.espresso.ViewInteraction;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainPage {
    ViewInteraction listLive = onView(withId(R.id.listView));
    ViewInteraction webView = onView(withId(R.id.webView));
}