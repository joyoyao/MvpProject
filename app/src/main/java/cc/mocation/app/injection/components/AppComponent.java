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
package cc.mocation.app.injection.components;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import cc.mocation.app.MocationApplication;
import cc.mocation.app.data.DataManager;
import cc.mocation.app.injection.ApplicationContext;
import cc.mocation.app.injection.modules.AppModule;
import cc.mocation.app.navigation.Navigator;
import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = AppModule.class)
public interface AppComponent {
    @ApplicationContext
    Context context();
    Application application();
    Navigator navigator();
    DataManager dataManager();

    MocationApplication inject(MocationApplication application);
}
