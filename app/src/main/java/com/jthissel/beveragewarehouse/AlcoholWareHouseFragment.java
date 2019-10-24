package com.jthissel.beveragewarehouse;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.List;

public class AlcoholWareHouseFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private beverageAdapter mBeverageAdapter;
    private Drawable drawable;
    //privat DividerItemDecoration mDividerItemDecoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.alcohol_warehouse_list, container, false);
        mRecyclerView = view.findViewById(R.id.alcohol_warehouse_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        AlcoholWareHouse wareHouse = AlcoholWareHouse.get(getActivity());
        List<alcoholBeverage> beverageList = wareHouse.getAlcBeverages();
        mBeverageAdapter = new beverageAdapter(beverageList);
        mRecyclerView.setAdapter(mBeverageAdapter);
    }

    private class beverageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mBeverageImage;
        private alcoholBeverage mBeverage;
        private TextView mName;
        private beverageHolder(View itemView) {
            super(itemView);
            mBeverageImage = itemView.findViewById(R.id.alcohol_image);
            mName = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        private void bindBeverage(alcoholBeverage beverage) {
            mBeverage = beverage;
            mName.setText(beverage.getName());
            String drawableImage = mBeverage.getFileName();

            final Field field;
            int id;
            try {
                field = R.drawable.class.getField(drawableImage);
                id = field.getInt(null);
                drawable = getResources().getDrawable(id);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            mBeverageImage.setImageDrawable(drawable);
        }

        @Override
        public void onClick(View v){
            Toast.makeText(getActivity(), mBeverage.getName() + " selected!", Toast.LENGTH_SHORT).show();
            Intent intent = AlcoholBeverageActivity.newIntent(getActivity(),mBeverage.getId());
            startActivity(intent);
        }
    }

    private class beverageAdapter extends RecyclerView.Adapter<beverageHolder>{
        private List<alcoholBeverage> mBeverages;
        private beverageAdapter(List<alcoholBeverage> beverages){
            mBeverages = beverages;
        }

        @Override
        public beverageHolder onCreateViewHolder(ViewGroup viewGroup, int pos){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_alcohol, viewGroup, false);
            return new beverageHolder(view);
        }


        @Override
        public void onBindViewHolder(beverageHolder beverageHolder, int position){
            beverageHolder.bindBeverage(mBeverages.get(position));
        }

        @Override
        public int getItemCount(){
            return mBeverages.size();
        }
    }

}



