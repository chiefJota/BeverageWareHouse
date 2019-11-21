package com.jthissel.beveragewarehouse;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Field;
import java.util.UUID;


public class AlcoholBeverageFragment extends Fragment {

     private alcoholBeverage mAcoholBeverage;

     private ImageView mAlcBottle;

     private TextView mOriginInfo;
     private TextView mPriceInfo;
     private TextView mAlcContentInfo;
     private TextView mDescriptionInfo;

     private Drawable drawable;

     private Button delete;

    private alcoholBaseHelper mDatabaseHelper;


     private static final String POSITION = "position_id";


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID position = (UUID) getArguments().getSerializable(POSITION);
        mAcoholBeverage = AlcoholWareHouse.get(getActivity()).getAlcoholBeverage(position);
    }

    @Override
    public void onPause(){
        super.onPause();
        AlcoholWareHouse.get(getActivity()).updateBeverages(mAcoholBeverage) ;
    }

    public static AlcoholBeverageFragment newInstance(UUID position){
        Bundle args = new Bundle();
        args.putSerializable(POSITION, position);

        AlcoholBeverageFragment fragment = new AlcoholBeverageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        String drawableImage = mAcoholBeverage.getFileName();

        final Field field;
        int id;
        try {
            field = R.drawable.class.getField(drawableImage);
            id = field.getInt(null);
            drawable = getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        View view = inflater.inflate(R.layout.fragment_alcoholbeverage, container, false);
        mAlcBottle = view.findViewById(R.id.alcohol_image);
        mAlcBottle.setImageDrawable(drawable);
        delete = view.findViewById(R.id.Delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //create function in database file to remove the selected beverage from database
                //TODO: REMOVE Beverage from database

                AlcoholWareHouse.get(getContext()).removeBeverage(mAcoholBeverage);

                //then create an intent to go back to the recycler view
                //create intent to alcohol warehouse
                Intent intent = new Intent(getActivity(), AlcoholWareHouseActivity.class);
                // close this activity
                startActivity(intent);

            }

        });

        mOriginInfo = view.findViewById(R.id.origin_manufacture_info);
        mOriginInfo.setText(mAcoholBeverage.getManufacturerOrigin());
        mPriceInfo = view.findViewById(R.id.price_info);
        mPriceInfo.setText(mAcoholBeverage.getAlcPrice());
        mAlcContentInfo = view.findViewById(R.id.alcohol_content_info);
        mAlcContentInfo.setText(mAcoholBeverage.getAlcContent());
        mDescriptionInfo = view.findViewById(R.id.description_info);
        mDescriptionInfo.setText(mAcoholBeverage.getDescription());

        return view;
    }


}
