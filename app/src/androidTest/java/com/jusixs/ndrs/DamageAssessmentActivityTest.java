package com.jusixs.ndrs;

import android.util.Log; // Add this import for logging
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.jusixs.ndrs.ui.view.DamageAssessmentActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class DamageAssessmentActivityTest {

    private static final String TAG = "DamageAssessmentTest"; // Define a tag for logging

    @Rule
    public ActivityScenarioRule<DamageAssessmentActivity> activityRule =
            new ActivityScenarioRule<>(DamageAssessmentActivity.class);

    @Test
    public void testGenerateReport_withValidInput_displaysReportDetails() {
        Log.d(TAG, "Entering location input");
        onView(withId(R.id.inputLocation)).perform(replaceText("LocationA"));

        Log.d(TAG, "Entering disaster type input");
        onView(withId(R.id.inputDisasterType)).perform(replaceText("Flood"));

        Log.d(TAG, "Entering severity input");
        onView(withId(R.id.inputSeverity)).perform(replaceText("Severe"));

        Log.d(TAG, "Clicking generate report button");
        onView(withId(R.id.buttonGenerateReport)).perform(click());

        Log.d(TAG, "Checking report details");
        onView(withId(R.id.textViewReportDetails))
                .check(matches(withText("Location: LocationA\nDisaster Type: Flood\nSeverity: Severe")));
    }

    @Test
    public void testSubmitReport_whenOffline_showsRetryMessage() {
        Log.d(TAG, "Entering location input");
        onView(withId(R.id.inputLocation)).perform(replaceText("LocationA"));

        Log.d(TAG, "Entering disaster type input");
        onView(withId(R.id.inputDisasterType)).perform(replaceText("Flood"));

        Log.d(TAG, "Entering severity input");
        onView(withId(R.id.inputSeverity)).perform(replaceText("Severe"));

        Log.d(TAG, "Clicking generate report button");
        onView(withId(R.id.buttonGenerateReport)).perform(click());

        Log.d(TAG, "Clicking submit report button");
        onView(withId(R.id.buttonSubmitReport)).perform(click());

        Log.d(TAG, "Checking toast message for submission failure");
        onView(withText("Submission failed. Will retry when online."))
                .inRoot(new ToastMatcher()) // Assuming you have a ToastMatcher implemented
                .check(matches(isDisplayed()));
    }
}
