package com.curso.android.app.projectofinalticmas

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.curso.android.app.projectofinalticmas.view.MainActivity
import com.curso.android.app.projectofinalticmas.viewModel.MainViewModel
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainViewModelTest {

    @Test
    fun testTextComparison() {
        val viewModel = MainViewModel()

        viewModel.compareTexts("Hello", "Hello")
        val result = viewModel.comparisonResult.value

        assertTrue(result == true)
    }
}


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Test
    fun testActivityLaunch() {

        val scenario = ActivityScenario.launch(MainActivity::class.java)

        scenario.onActivity { activity ->
            assertNotNull(activity.findViewById(R.id.editText1))
            assertNotNull(activity.findViewById(R.id.editText2))
            assertNotNull(activity.findViewById(R.id.compareButton))
            assertNotNull(activity.findViewById(R.id.resultTextView))
        }
    }

}
