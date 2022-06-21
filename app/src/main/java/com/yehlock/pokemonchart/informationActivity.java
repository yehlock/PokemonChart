package com.yehlock.pokemonchart;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class informationActivity extends AppCompatActivity {

    TextView tvNameZh,tvNameEn,tvNameJp,tvDexNational,tvDexSinnoh,tvDexHisui,tvHeight,tvWeight;
    ImageView typesIconI,typesIconII,pokePic;
    //TextView tvNormal,tvFire,tvWater,tvElectric,tvGrass,tvIce,tvFighting,tvPoison;
    //TextView tvGround,tvFlying,tvPsychic,tvBug,tvRock,tvGhost,tvDragon,tvDark,tvSteel,tvFairy;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        tvNameZh = (TextView) findViewById(R.id.infoNameZh);
        tvNameEn = (TextView) findViewById(R.id.infoNameEn);
        tvNameJp = (TextView) findViewById(R.id.infoNameJp);
        tvDexNational = (TextView) findViewById(R.id.infoDexNational);
        tvDexSinnoh = (TextView) findViewById(R.id.infoDexSinnoh);
        tvDexHisui = (TextView) findViewById(R.id.infoDexHisui);
        tvHeight = (TextView) findViewById(R.id.infoHeight);
        tvWeight = (TextView) findViewById(R.id.infoWeight);
        typesIconI = (ImageView) findViewById(R.id.infoIconI);
        typesIconII = (ImageView) findViewById(R.id.infoIconII);
        pokePic = (ImageView) findViewById(R.id.infoPokePic);
/*
        tvNormal = (TextView)findViewById(R.id.infoNormal);
        tvFire = (TextView)findViewById(R.id.infoFire);
        tvWater = (TextView)findViewById(R.id.infoWater);
        tvElectric = (TextView)findViewById(R.id.infoElectric);
        tvGrass = (TextView)findViewById(R.id.infoGrass);
        tvIce = (TextView)findViewById(R.id.infoIce);
        tvFighting = (TextView)findViewById(R.id.infoFighting);
        tvPoison = (TextView)findViewById(R.id.infoPoison);
        tvGround = (TextView)findViewById(R.id.infoGround);
        tvFlying = (TextView)findViewById(R.id.infoFlying);
        tvPsychic = (TextView)findViewById(R.id.infoPsychic);
        tvBug = (TextView)findViewById(R.id.infoBug);
        tvRock = (TextView)findViewById(R.id.infoRock);
        tvGhost = (TextView)findViewById(R.id.infoGhost);
        tvDragon = (TextView)findViewById(R.id.infoDragon);
        tvDark = (TextView)findViewById(R.id.infoDark);
        tvSteel = (TextView)findViewById(R.id.infoSteel);
        tvFairy = (TextView) findViewById(R.id.infoFairy);
*/
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String[][] pokeDexData;
            String pokemonName;
            pokeDexData = Pokedex.pokemonsAll();
            pokemonName = bundle.getString("pokemon");
            for(int i=0;i<pokeDexData.length;i++){
                if(pokeDexData[i][4].equals(pokemonName)){
                    Log.v("msg","MA Pokemon 2 = "+pokemonName+" length = "+pokeDexData.length);
                    String dexNational = pokeDexData[i][0],dexSinnoh=pokeDexData[i][1];//,dexHisui=pokeDexData[i][10];
                    String nameZh = pokeDexData[i][4],nameEn=pokeDexData[i][2],nameJp=pokeDexData[i][3];
                    String typeI = pokeDexData[i][5];
                    String typeII = pokeDexData[i][6];
                    String height = pokeDexData[i][7],weight=pokeDexData[i][8];
                    String pokeUrl = pokeDexData[i][9];
                    //Log.v("msg",pokemonName + " typeI is "+typeI);
                    tvNameZh.setText(nameZh);
                    tvNameEn.setText(nameEn.substring(0,1).toUpperCase()+nameEn.substring(1));
                    tvNameJp.setText(nameJp);
                    tvDexNational.setText("全國\n#"+dexNational);
                    if(dexSinnoh.equals("-1")){tvDexSinnoh.setText("無神奧編號");}
                    else{tvDexSinnoh.setText("神奧 #"+dexSinnoh);}
                    //if(dexHisui.equals("-1")){tvDexHisui.setText("無洗翠編號");}
                    //else{tvDexHisui.setText("洗翠 #"+dexHisui);}
                    tvHeight.setText(height+" cm");tvWeight.setText(weight+" kg");
                    typesIconI.setImageResource(setIcon(typeI));
                    typesIconII.setImageResource(setIcon(typeII));

                    //setChart(typeI,typeII);

                    //String pokeUrl = "https://media.52poke.com/wiki/2/21/001Bulbasaur.png";
                    if (pokeUrl.equals("no url")){pokeUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQREJH9KAgLYCQOcfuFYMsCtXybs4laSW80CHhy9tGs6ifnQHWAEykSGXuE91LcAkUYRJs&usqp=CAU";}
                    LoadImg loadImg = (LoadImg) new LoadImg(pokePic).execute(pokeUrl);
                    Log.v("msg", String.valueOf(loadImg));
                    if(loadImg!=null){
                        Log.v("msg","1111111");
                    }
                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                    break;
                }
            }
        }
    }
    
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setChart(String typeI, String typeII){
        if(typeII.equals("None")){
            double[] typeChart;
            typeChart = Chart.whichType(typeI);
            setTypeValue(typeChart);
        }else {
            double[] typeChart;
            typeChart = Chart.typeCalculate(typeI,typeII);
            setTypeValue(typeChart);
        }
    }

    public void setTypeValue(double[] list){
        List<String> stringList = new ArrayList<String>();
        for(int i=0;i<list.length;i++){
            if(list[i]==4){stringList.add(" x4");}
            if(list[i]==2){stringList.add(" x2");}
            if(list[i]==1){stringList.add(" x1");}
            if(list[i]==0.5){stringList.add(" x½");}
            if(list[i]==0.25){stringList.add(" x¼");}
            if(list[i]==0){stringList.add(" x0");}
        }/*
        tvNormal.setText(stringList.get(0));
        tvFire.setText(stringList.get(1));
        tvWater.setText(stringList.get(2));
        tvElectric.setText(stringList.get(3));
        tvGrass.setText(stringList.get(4));
        tvIce.setText(stringList.get(5));
        tvFighting.setText(stringList.get(6));
        tvPoison.setText(stringList.get(7));
        tvGround.setText(stringList.get(8));
        tvFlying.setText(stringList.get(9));
        tvPsychic.setText(stringList.get(10));
        tvBug.setText(stringList.get(11));
        tvRock.setText(stringList.get(12));
        tvGhost.setText(stringList.get(13));
        tvDragon.setText(stringList.get(14));
        tvDark.setText(stringList.get(15));
        tvSteel.setText(stringList.get(16));
        tvFairy.setText(stringList.get(17));*/
    }

    private int setIcon(String type) {
        switch (type){
            case "normal":
                return R.drawable.normal_with_txt;
            case "fire":
                return R.drawable.fire_with_txt;
            case "water":
                return R.drawable.water_with_txt;
            case "electric":
                return R.drawable.electric_with_txt;
            case "grass":
                return R.drawable.grass_with_txt;
            case "ice":
                return R.drawable.ice_with_txt;
            case "fighting":
                return R.drawable.fighting_with_txt;
            case "poison":
                return R.drawable.poison_with_txt;
            case "ground":
                return R.drawable.ground_with_txt;
            case "flying":
                return R.drawable.flying_with_txt;
            case "psychic":
                return R.drawable.psychic_with_txt;
            case "bug":
                return R.drawable.bug_with_txt;
            case "rock":
                return R.drawable.rock_with_txt;
            case "ghost":
                return R.drawable.ghost_with_txt;
            case "dragon":
                return R.drawable.dragon_with_txt;
            case "dark":
                return R.drawable.dark_with_txt;
            case "steel":
                return R.drawable.steel_with_txt;
            case "fairy":
                return R.drawable.fairy_with_txt;
        }
        return 0;
    }
}