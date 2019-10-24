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

        //TODO: set all fields for alcohol beverage in here
        alcoholBeverage alcBeverage = new alcoholBeverage();
        alcBeverage.setName("Heady Topper");
        alcBeverage.setManufacturerOrigin("Alchemist Brewery");
        alcBeverage.setAlcContent("8.0");
        alcBeverage.setAlcPrice("13.29");
        alcBeverage.setDescription("Most sought after craft IPA");
        alcBeverage.setFileName("heady_topper");
        mAlcBeverages.add(alcBeverage);

        alcoholBeverage alc1Beverage = new alcoholBeverage();
        alc1Beverage.setName("Vermont Double IPA");
        alc1Beverage.setManufacturerOrigin("Long Trail");
        alc1Beverage.setAlcContent("8.0");
        alc1Beverage.setAlcPrice("10.59");
        alc1Beverage.setDescription("Is full of fruity, juicy\n" +
                " and dank hop flavors with a light, soft mouthfeel and\n" +
                " slight alcohol presence. The recipe features green\n" +
                " mountains of Amarillo, Citra and Simcoe hops.\n");
        alc1Beverage.setFileName("long_trail_green_mtn_haze");
        mAlcBeverages.add(alc1Beverage);


        alcoholBeverage alc2Beverage = new alcoholBeverage();
        alc2Beverage.setName("Official Hazy IPA");
        alc2Beverage.setManufacturerOrigin("Bells");
        alc2Beverage.setAlcContent("6.4");
        alc2Beverage.setAlcPrice("11.99");
        alc2Beverage.setFileName("bells_official_ipa");
        alc2Beverage.setDescription("Two of our favorite ingredients come together in the brewhouse;\n" +
                " pungent American hops and delicious wheat malt. This Hazy IPA is double dry-hopped\n" +
                " (a combination of Mosaic, Citra, Azacca, Amarillo and El Dorado hops) resulting in\n" +
                " complex peach, stone fruit and tropical notes with a dry finish and balanced bitterness.\n" +
                " A refined beer for those who love hops and for those who prefer wheat beers.\n" +
                " Go ahead and make it Official.");
        mAlcBeverages.add(alc2Beverage);


        alcoholBeverage alc3Beverage = new alcoholBeverage();
        alc3Beverage.setName("WhistlePig Whiskey: 10 Years");
        alc3Beverage.setManufacturerOrigin("WhistlePig Farm");
        alc3Beverage.setAlcContent("50.00");
        alc3Beverage.setAlcPrice("80.00");
        alc3Beverage.setFileName("whistle_pig_10_years");
        alc3Beverage.setDescription("Fortune, superb taste, and hustle lead us to the\n" +
                " discovery of an aged Rye Whiskey stock in Alberta, Canada.\n" +
                " We rescued the stock from misuse as a blending whiskey, aged it in new American Oak,\n" +
                " then hand-bottled this rye on its own. We’re honored to\n" +
                " present the most awarded Rye Whiskey in the world.");
        mAlcBeverages.add(alc3Beverage);

        alcoholBeverage alc4Beverage = new alcoholBeverage();
        alc4Beverage.setName("Hendricks Gin");
        alc4Beverage.setManufacturerOrigin("Girvan distillery, Scotland");
        alc4Beverage.setAlcContent("44.00");
        alc4Beverage.setAlcPrice("35.00");
        alc4Beverage.setFileName("hendricks_gin");
        alc4Beverage.setDescription("Its an unusual gin created from eleven fine botanicals.\n" +
                " The curious, yet marvellous, infusions of rose & cucumber imbue our spirit with its\n" +
                " uniquely balanced flavour resulting in an unimpeachably smooth and distinct gin.");
        mAlcBeverages.add(alc4Beverage);

        alcoholBeverage alc5Beverage = new alcoholBeverage();
        alc5Beverage.setName("Farmers Daughter");
        alc5Beverage.setManufacturerOrigin("Alchemist Brewery");
        alc5Beverage.setAlcContent("7.0");
        alc5Beverage.setAlcPrice("13.00");
        alc5Beverage.setFileName("farmers_daughter");
        alc5Beverage.setDescription("This Belgian-inspired ale is loosely based on a Saison. A blend\n " +
                " of Hallertau Mittlefrue and Amarillo hops lend a\n " +
                " beautiful and delicate bitterness to a dry and\n " +
                " malty background. No spices added.");
        mAlcBeverages.add(alc5Beverage);

        alcoholBeverage alc6Beverage = new alcoholBeverage();
        alc6Beverage.setName("Unified Press");
        alc6Beverage.setManufacturerOrigin("Citizen Cider");
        alc6Beverage.setAlcContent("6.80");
        alc6Beverage.setAlcPrice("9.00");
        alc6Beverage.setFileName("citizen_cider_unified");
        alc6Beverage.setDescription("Off-Dry, clean and crisp drink for the people; our flagship cider.\n" +
                " The Unified Press is easy drinking for any occasion. Blend of 10 or so varieties of apples grown in Vermont at Happy Valley Orchards,\n" +
                " Kent Ridge Orchards, and Allenholm Farm.");
        mAlcBeverages.add(alc6Beverage);


        alcoholBeverage alc7Beverage = new alcoholBeverage();
        alc7Beverage.setName("Von Trapp Helles Lager");
        alc7Beverage.setManufacturerOrigin("Von Trapp");
        alc7Beverage.setAlcContent("4.9");
        alc7Beverage.setAlcPrice("13.00");
        alc7Beverage.setFileName("von_trapp_helles_lager");
        alc7Beverage.setDescription("Our lightest offering, “Helles” is German for “bright.”  It is golden in color,\n" +
                " and is a crisp, easy drinking beer for all occasions, a true session lager.\n " +
                " The spicy hop characters are a bit more subdued and in balance with hops.\n " +
                " It is our only lager that is filtered.");
        mAlcBeverages.add(alc7Beverage);

        alcoholBeverage alc8Beverage = new alcoholBeverage();
        alc8Beverage.setName("14th Star Tribute Double IPA");
        alc8Beverage.setManufacturerOrigin("Tribute");
        alc8Beverage.setAlcContent("4.9");
        alc8Beverage.setAlcPrice("11.00");
        alc8Beverage.setFileName("tribute_ipa");
        alc8Beverage.setDescription("Our Tribute Double IPA is a celebration of hops, pure and simple.\n" +
                " A simple and smooth malt base serves as the stage for the hops to perform.\n" +
                " Tribute has a beautiful golden color, an aroma brimming with citrusy hops, and a deliciously smooth hop flavor and dry finish.");
        mAlcBeverages.add(alc8Beverage);
    }


    public List<alcoholBeverage> getAlcBeverages(){
        return mAlcBeverages;
    }

    public alcoholBeverage getAlcoholBeverage(UUID id){
        for(alcoholBeverage alcoholBeverage: mAlcBeverages){
            if(alcoholBeverage.getId().equals(id)){
                return alcoholBeverage;
            }
        }
        return null;
    }
}


