package com.yehlock.pokemonchart;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetPokeData extends AsyncTask<String, Void, String>{

    String name;
    String url,title;
    @SuppressLint("StaticFieldLeak")
    TextView tvAbility1,tvAbility2;

    public GetPokeData(TextView... textView) {
        this.tvAbility1 = textView[0];
        this.tvAbility2 = textView[1];

    }

    @Override
    protected String doInBackground(String... urls) {
        String url = urls[0];
        Map<String,String> data = new HashMap<>();
        try{
            Document document = Jsoup.connect(url).get();

            title = document.title();
            Log.v("msg",title);

            Element abilities = document.select("table[class=roundy bgwhite fulltable]").get(3);
            String abilitiesS = abilities.text();
            Log.v("msg", String.valueOf(abilities));
            Log.v("msg",abilitiesS);

            return abilitiesS;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String abilitiesS){
        tvAbility1.setText(abilitiesS);
        tvAbility2.setText(abilitiesS);
    }
}
