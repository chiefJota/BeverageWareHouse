package com.jthissel.beveragewarehouse;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;


public class AlcoholBeverageActivity extends singleFragmentActivity {
    private final static String EXTRA_BEVERAGE_ID = "com.jthissel.beveragewarehouse.position_id";

    public static Intent newIntent(Context context, UUID id){
        Intent intent = new Intent(context, AlcoholBeverageActivity.class);
        intent.putExtra(EXTRA_BEVERAGE_ID, id);
        return intent;

    }


    @Override
    public Fragment createFragment(){
        UUID position = (UUID) getIntent().getSerializableExtra(EXTRA_BEVERAGE_ID);
        return AlcoholBeverageFragment.newInstance(position);
    }
}
