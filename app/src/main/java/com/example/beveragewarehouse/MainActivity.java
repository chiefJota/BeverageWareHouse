package com.example.beveragewarehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**initial implementation of a RecyclerView showing detail amd master views,
using fragments master-detail interface, with fragments
it's OK to initialize the app with hardcoded, initial data**/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
