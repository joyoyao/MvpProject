/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cc.mocation.app.navigation;

import android.app.Activity;
import android.content.Context;


import javax.inject.Inject;
import javax.inject.Singleton;

import cc.mocation.app.module.home.HomeActivity;


/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    /**
     * 跳转到mainActivity
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToHome(Context context) {
        if (context != null) {
            HomeActivity.start((Activity) context);
        }
    }

    /**
     */
    public void navigateToUserDetails(Context context, int userId) {
        if (context != null) {
//      Intent intentToLaunch = UserDetailsActivity.getCallingIntent(context, userId);
//      context.startActivity(intentToLaunch);
        }
    }
}
