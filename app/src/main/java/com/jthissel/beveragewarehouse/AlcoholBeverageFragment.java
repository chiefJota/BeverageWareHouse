package com.jthissel.beveragewarehouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AlcoholBeverageFragment extends Fragment {

    private alcoholBeverage mAcoholBeverage;

   // private TextView mTitleField;
   // private Button mAlcButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mAcoholBeverage = new alcoholBeverage();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_alcoholbeverage, container, false);

        return view;
    }
}
