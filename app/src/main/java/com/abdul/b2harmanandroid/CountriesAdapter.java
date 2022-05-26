package com.abdul.b2harmanandroid;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {
    public static String TAG = CountriesAdapter.class.getSimpleName();
    String[] mCountries;

    public CountriesAdapter(String[] countries) {
        mCountries = countries;
    }

    @NonNull
    @Override // atanu -- has to buy the row planks from the market
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "atanu -- has to buy the row planks from the market");
        //inflate a baloon -- read the layout xml file and create its memory variables
        View rowPlank = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_recycler_item_1, parent, false);
        return new CountriesViewHolder(rowPlank);
    }

    @Override //abishek -- write the data on the planks
    public void onBindViewHolder(@NonNull CountriesViewHolder shwetaHolder, int position) {
        Log.i(TAG, "abishek -- write the data on the planks--"+mCountries[position]);
        shwetaHolder.tvRecyclerItem.setText(mCountries[position]);

    }

    @Override //bipin -- count the remaining items in the array
    public int getItemCount() {
        Log.i(TAG, "bipin -- count the remaining items in the array--"+ mCountries.length);

        return mCountries.length;
    }

    //shweta -- owns box  to hold the reserve planks
    public  class CountriesViewHolder extends RecyclerView.ViewHolder {
        TextView tvRecyclerItem;
        public CountriesViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG, "shweta -- owns box  to hold the reserve planks");

            tvRecyclerItem = itemView.findViewById(R.id.tvRecyclerItem);
        }
    }
}
