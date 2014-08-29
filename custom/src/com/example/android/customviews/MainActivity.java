/* Copyright (C) 2012 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.example.android.customviews;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.android.customviews.charting.Rectangle;

public class MainActivity extends Activity {
	Rectangle rect1, rect2, rect3, rect4;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Resources res = getResources();
        // Para hacer la pantalla fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main2);
        rect1 = (Rectangle) findViewById(R.id.Rectangle1);
        rect2 = (Rectangle) findViewById(R.id.Rectangle2);
        rect3 = (Rectangle) findViewById(R.id.Rectangle3);
        rect4 = (Rectangle) findViewById(R.id.Rectangle4);
        
        rect1.setWord("Arbol");
        rect2.setWord("Banana");
        rect3.setWord("Casa");
        rect4.setWord("Dado");
        


    }
}

