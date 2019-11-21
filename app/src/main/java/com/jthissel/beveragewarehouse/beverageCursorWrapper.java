package com.jthissel.beveragewarehouse;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.jthissel.beveragewarehouse.alcBevDbSchema.alcBeverageTable;

import java.util.UUID;

public class beverageCursorWrapper extends CursorWrapper {
    public beverageCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public alcoholBeverage getBeverage(){
        String uuidString = getString(getColumnIndex(alcBeverageTable.Cols.UUID));
        String name = getString(getColumnIndex(alcBeverageTable.Cols.NAME));
        String fileName = getString(getColumnIndex(alcBeverageTable.Cols.FILENAME));
        String manufacturer = getString(getColumnIndex(alcBeverageTable.Cols.MANUFACTURERORIGIN));
        String price = getString(getColumnIndex(alcBeverageTable.Cols.PRICE));
        String alcContent = getString(getColumnIndex(alcBeverageTable.Cols.ALCCONTENT));
        String description = getString(getColumnIndex(alcBeverageTable.Cols.DESCRIPTION));

        alcoholBeverage alcoholBeverage = new alcoholBeverage(UUID.fromString(uuidString));
        alcoholBeverage.setName(name);
        alcoholBeverage.setFileName(fileName);
        alcoholBeverage.setManufacturerOrigin(manufacturer);
        alcoholBeverage.setAlcPrice(price);
        alcoholBeverage.setAlcContent(alcContent);
        alcoholBeverage.setDescription(description);

        return alcoholBeverage;
    }

}
