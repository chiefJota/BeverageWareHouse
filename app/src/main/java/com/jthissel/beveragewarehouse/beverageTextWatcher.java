package com.jthissel.beveragewarehouse;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

public class beverageTextWatcher implements TextWatcher {

    private View view;
    private alcoholBeverage mBeverage;
    protected beverageTextWatcher(alcoholBeverage Beverage, View view) {

        this.mBeverage = Beverage;

        this.view = view;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String text = charSequence.toString();
        switch(view.getId()){
            case R.id.name_info:
                mBeverage.setName(text);
                break;
            case R.id.origin_manufacture_info:
                mBeverage.setManufacturerOrigin(text);
                break;
            case R.id.price_info:
                mBeverage.setAlcPrice(text);
                break;
            case R.id.alcohol_content_info:
                mBeverage.setAlcContent(text);
                break;
            case R.id.description_info:
                mBeverage.setDescription(text);
        }
    }

    public void afterTextChanged(Editable editable) {


    }
}

