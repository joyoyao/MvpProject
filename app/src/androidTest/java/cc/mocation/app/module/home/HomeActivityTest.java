/*
 * Copyright 2016, The Android Open Source Project
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

package cc.mocation.app.module.home;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import cc.mocation.app.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Tests for the tasks screen, the main screen which contains a list of all tasks.
 */
@RunWith(AndroidJUnit4.class)
public class HomeActivityTest extends ActivityInstrumentationTestCase2<HomeActivity> {

    private HomeActivity mActivity;
    private TextView mContentView;

    public HomeActivityTest() {
        // 所有的ActivityInstrumentationTestCase2子类都需要调用该父类的super(String)构造方法
        super(HomeActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        // @Before注解表示在执行所有的testCase之前要做的事情
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

        // getActivity()方法会在开始所有的testCase之前启动相应的Activity
        mActivity = getActivity();
        // findViewById()很熟悉吧？找到我要测试的控件
        mContentView = (TextView) mActivity.findViewById(R.id.txt_address);
    }

    @Test
    public void testPreconditions() {
        // @Test注解表示一个测试用例方法
        assertNotNull("AppStartActivity is null", mActivity);
    }

    @Test
    public void testContentDisplayed() {
        // 这里就是我们测试的目标，判断目标控件的text不为空
        String content = mContentView.getText().toString();
        assertNotNull("AppStartActivity Content is Null", content);
    }
}

