package com.jthissel.beveragewarehouse;

import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.List;

public class AlcoholWareHouseFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private beverageAdapter mBeverageAdapter;
    private Drawable drawable;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.alcohol_warehouse_list, container, false);
        mRecyclerView = view.findViewById(R.id.alcohol_warehouse_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.fragment_alcohol_warehouse_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
        if(mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        }
        else{
            subtitleItem.setTitle(R.string.show_subtitle);
        }
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.new_alcohol_beverage:
                alcoholBeverage alcoholBeverage = new alcoholBeverage();
                AlcoholWareHouse.get(getActivity()).addAlcoholBeverage(alcoholBeverage);
                //create intent to new beverage activity
                //TODO: Don't add a beverage if the back button is clicked only on submit
                Intent intent = newBeverageActivity.newIntent(getActivity(), alcoholBeverage.getId());
                startActivity(intent);
                return true;

            case R.id.show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void updateSubtitle(){
        AlcoholWareHouse wareHouse = AlcoholWareHouse.get(getActivity());
        int beverageStock = wareHouse.getAlcBeverages().size();
        String subtitle = getString(R.string.subtitle_format, beverageStock);

        if(!mSubtitleVisible){
            subtitle = null;
        }

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private void updateUI(){
        AlcoholWareHouse wareHouse = AlcoholWareHouse.get(getActivity());
        List<alcoholBeverage> beverageList = wareHouse.getAlcBeverages();

        if(mBeverageAdapter == null){
            mBeverageAdapter = new beverageAdapter(beverageList);
            mRecyclerView.setAdapter(mBeverageAdapter);
        }
        else{
            mBeverageAdapter.setBeverages(beverageList);
            mBeverageAdapter.notifyDataSetChanged();
        }

        updateSubtitle();

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

            int pos = getAdapterPosition();
            Intent intent = AlcoholBeverageActivity.newIntent(getActivity(),mBeverage.getId());
            startActivity(intent);
            notifyItemChanged(pos);
        }

        private void notifyItemChanged(int pos){
            mBeverageAdapter.notifyItemChanged(pos);
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

        public void setBeverages(List<alcoholBeverage> beverageList){
            mBeverages = beverageList;
        }
    }



}



