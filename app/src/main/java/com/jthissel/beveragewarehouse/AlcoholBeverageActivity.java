package com.jthissel.beveragewarehouse;

import androidx.fragment.app.Fragment;

public class AlcoholBeverageActivity extends singleFragmentActivity {

    @Override
    public Fragment createFragment(){
        return new AlcoholBeverageFragment();
    }
}
