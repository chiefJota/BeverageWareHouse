package com.jthissel.beveragewarehouse;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AlcoholWareHouse {

    private static AlcoholWareHouse sAlcoholWareHouse;

    private List<alcoholBeverage> mAlcBeverages;

    public static AlcoholWareHouse get(Context context){
        if(sAlcoholWareHouse == null){
            sAlcoholWareHouse = new AlcoholWareHouse(context);
        }
        return sAlcoholWareHouse;
    }

    private AlcoholWareHouse(Context context){
        mAlcBeverages = new ArrayList<>();

        for(int i = 0; i < 25; i++){
            alcoholBeverage alcBeverage = new alcoholBeverage();
            alcBeverage.setName("Heady Topper");
            mAlcBeverages.add(alcBeverage);
        }
    }

    public List<alcoholBeverage> getAlcBeverages(){
        return mAlcBeverages;
    }

    public alcoholBeverage getAlcoholBeverage(UUID id){
        for(alcoholBeverage beverage: mAlcBeverages){
            if(beverage.getId().equals(id)){
                return beverage;
            }
        }
        return null;
    }


}
