package com.jthissel.beveragewarehouse;

import androidx.fragment.app.Fragment;

public class AlcoholWareHouseActivity extends singleFragmentActivity {

    @Override
    public Fragment createFragment(){
        return new AlcoholWareHouseFragment();
    }
}
