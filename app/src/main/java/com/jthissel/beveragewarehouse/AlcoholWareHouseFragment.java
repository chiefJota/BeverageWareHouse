package com.jthissel.beveragewarehouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlcoholWareHouseFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private beverageAdapter mBeverageAdapter;

    @Nullable
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

        private alcoholBeverage mBeverage;

        public beverageHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
        }

        public void bindBeverage(alcoholBeverage beverage){
            mBeverage = beverage;
        }


        @Override
        public void onClick(View v){
            Toast.makeText(getActivity(), mBeverage.getName() + " selected!", Toast.LENGTH_SHORT).show();
        }
    }

    private class beverageAdapter extends RecyclerView.Adapter<beverageHolder>{

        private List<alcoholBeverage> mBeverages;

        public beverageAdapter(List<alcoholBeverage> beverages){
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



