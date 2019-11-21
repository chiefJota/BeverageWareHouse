package com.jthissel.beveragewarehouse;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Field;
import java.util.UUID;

public class newBeverageFragment extends Fragment {

    private alcoholBeverage mAlcoholBeverage;

    private EditText mName;
    private EditText mOriginInfo;
    private EditText mPriceInfo;
    private EditText mAlcContentInfo;
    private EditText mDescriptionInfo;

    private Button mSubmit;

    private Drawable drawable;
    private ImageView mAlcBottle;

    private static final String POSITION = "position_id";
    private static final String NEWDRINK = "new_beverage_image";


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID position = (UUID) getArguments().getSerializable(POSITION);
        mAlcoholBeverage = AlcoholWareHouse.get(getActivity()).getAlcoholBeverage(position);
    }

    public static newBeverageFragment newInstance(UUID position){
        Bundle args = new Bundle();
        args.putSerializable(POSITION, position);

        newBeverageFragment fragment = new newBeverageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){

        final Field field;
        int id;
        try {
            field = R.drawable.class.getField(NEWDRINK);
            id = field.getInt(null);
            drawable = getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        View view = inflater.inflate(R.layout.new_beverage, container, false);
//        mAlcBottle = view.findViewById(R.id.alcohol_image);
        mAlcoholBeverage.setFileName(NEWDRINK);

        mSubmit = view.findViewById(R.id.submit);

        mName = view.findViewById(R.id.name_info);
        mOriginInfo = view.findViewById(R.id.origin_manufacture_info);
        mPriceInfo = view.findViewById(R.id.price_info);
        mAlcContentInfo = view.findViewById(R.id.alcohol_content_info);
        mDescriptionInfo = view.findViewById(R.id.description_info);

        mName.addTextChangedListener(new beverageTextWatcher(mAlcoholBeverage, mName));
        mOriginInfo.addTextChangedListener(new beverageTextWatcher(mAlcoholBeverage, mOriginInfo));
        mPriceInfo.addTextChangedListener(new beverageTextWatcher(mAlcoholBeverage, mPriceInfo));
        mAlcContentInfo.addTextChangedListener(new beverageTextWatcher(mAlcoholBeverage, mAlcContentInfo));
        mDescriptionInfo.addTextChangedListener(new beverageTextWatcher(mAlcoholBeverage, mDescriptionInfo));

        mSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlcoholWareHouse.get(getContext()).updateBeverages(mAlcoholBeverage);
                //create intent to alcohol warehouse
                Intent intent = new Intent(getActivity(), AlcoholWareHouseActivity.class);
                // close this activity
                startActivity(intent);

            }
        });

        return view;
    }
}


