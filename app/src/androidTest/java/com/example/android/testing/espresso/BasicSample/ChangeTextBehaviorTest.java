/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */
//@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {

    public static final String STRING_TO_BE_TYPED = "Espresso";

    /**
     * A JUnit {@link Rule @Rule} to launch your activity under test. This is a replacement
     * for {@link ActivityInstrumentationTestCase2}.
     * <p>
     * Rules are interceptors which are executed for each test method and will run before
     * any of your setup code in the {@link Before @Before} method.
     * <p>
     * {@link ActivityTestRule} will create and launch of the activity for you and also expose
     * the activity under test. To get a reference to the activity you can use
     * the {@link ActivityTestRule#getActivity()} method.
     */
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void espressoCodeTest() {
        Log.i("NimbleDroidV1", "Scenario.profile");
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED),
            closeSoftKeyboard());
        Log.i("NimbleDroidV1", "Scenario.begin clickTest");
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)));
        Log.i("NimbleDroidV1", "Scenario.end clickTest");
    }

    @Test
    public void hybridTest() {
        Log.i("NimbleDroidV1", "Scenario.profile");
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED),
            closeSoftKeyboard());
        Log.i("NimbleDroidV1", "Scenario.begin testToAppClick");
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)));
        Log.i("NimbleDroidV1", "Scenario.end appToTestClick");
    }

    @Test
    public void appCodeTest() {
        Log.i("NimbleDroidV1", "Scenario.profile");
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED),
            closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)));
    }

    @Test
    public void nestedInterleaveTest() {
        Log.i("NimbleDroidV1", "Scenario.profile");
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED),
            closeSoftKeyboard());
        Log.i("NimbleDroidV1", "Scenario.begin interleaveClick");
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)));
    }
}
