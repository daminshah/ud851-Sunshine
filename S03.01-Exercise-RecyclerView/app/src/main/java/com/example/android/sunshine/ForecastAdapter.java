package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by daminshah on 6/29/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>  {


    private String[] mWeatherData;

    public ForecastAdapter(){

    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context=viewGroup.getContext();
        int layoutIdforItem=R.layout.forecast_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttach=false;

        View view=inflater.inflate(layoutIdforItem,viewGroup,shouldAttach);
        ForecastAdapterViewHolder viewHolder=new ForecastAdapterViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weatherforday=mWeatherData[position];
        holder.mWeatherTextView.setText(weatherforday);
    }

    @Override
    public int getItemCount() {

        if (mWeatherData == null) {
            return 0;
        }
        else return mWeatherData.length;
    }


    public void setWeatherData(String[] weatherData)
    {
        mWeatherData=weatherData;
            notifyDataSetChanged();
    }


    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{

        public final TextView mWeatherTextView;


        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView=(TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

}

