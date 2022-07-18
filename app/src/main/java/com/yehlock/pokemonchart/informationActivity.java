package com.yehlock.pokemonchart;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class informationActivity extends AppCompatActivity {

    TextView tvNameZh,tvNameEn,tvNameJp,tvDexNational,tvDexSinnoh,tvDexHisui,tvDexGalar,tvHeight,tvWeight;
    TextView tvAbility1, tvAbility2;
    ImageView typesIconI,typesIconII,pokePic;
    GridLayout gWeakAgainst,gResistantAgainst,gNormalDamage;
    //TextView tvNormal,tvFire,tvWater,tvElectric,tvGrass,tvIce,tvFighting,tvPoison;
    //TextView tvGround,tvFlying,tvPsychic,tvBug,tvRock,tvGhost,tvDragon,tvDark,tvSteel,tvFairy;
    private static String[] typeList = {"normal","fire","water","electric","grass","ice","fighting","poison","ground","flying",
            "psychic","bug","rock","ghost","dragon","dark","steel","fairy"};
    String[] typeListZh = {"一般","火","水","電","草","冰","格鬥","毒","地面","飛行",
            "超能力","蟲","岩石","幽靈","龍","惡","鋼","仙子"};
    String[] typeColour = {"9099a1","ff9c54","4d90d5","f3d23b","63bb5b","74cec0","ce4069","ab6ac8","d97746","8fa8dd",
            "f97176","90c12c","c7b78b","5269ac","0a6dc4","5a5366","5a8ea1","ec8fe6"};

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //Textview
        tvNameZh = (TextView) findViewById(R.id.infoNameZh);
        tvNameEn = (TextView) findViewById(R.id.infoNameEn);
        tvNameJp = (TextView) findViewById(R.id.infoNameJp);
        tvDexNational = (TextView) findViewById(R.id.infoDexNational);
        tvDexSinnoh = (TextView) findViewById(R.id.infoDexSinnoh);
        tvDexHisui = (TextView) findViewById(R.id.infoDexHisui);
        tvHeight = (TextView) findViewById(R.id.infoHeight);
        tvWeight = (TextView) findViewById(R.id.infoWeight);
        tvAbility1 = (TextView) findViewById(R.id.infoAbility1);
        tvAbility2 = (TextView) findViewById(R.id.infoAbility2);
        tvDexGalar = (TextView) findViewById(R.id.infoDexGalar);

        //ImageView
        typesIconI = (ImageView) findViewById(R.id.infoIconI);
        typesIconII = (ImageView) findViewById(R.id.infoIconII);
        pokePic = (ImageView) findViewById(R.id.infoPokePic);

        //GridLayout
        gWeakAgainst = (GridLayout) findViewById(R.id.infoWeekAgainst);
        gResistantAgainst = (GridLayout) findViewById(R.id.infoResistantAgainst);
        gNormalDamage = (GridLayout) findViewById(R.id.infoNormalDamage);

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
                    String dexNational = pokeDexData[i][0],dexSinnoh=pokeDexData[i][1];
                    //,dexHisui=pokeDexData[i][10];
                    String dexGalar = "999"; //need to update
                    String nameZh = pokeDexData[i][4],nameEn=pokeDexData[i][2],nameJp=pokeDexData[i][3];
                    String typeI = pokeDexData[i][5];
                    String typeII = pokeDexData[i][6];
                    String height = pokeDexData[i][7],weight=pokeDexData[i][8];
                    String pokeImgUrl = pokeDexData[i][9];
                    String pokeUrl = "https://wiki.52poke.com/zh-hant/"+nameZh;

                    //Log.v("msg",pokemonName + " typeI is "+typeI);
                    tvNameZh.setText(nameZh);
                    tvNameEn.setText(nameEn.substring(0,1).toUpperCase()+nameEn.substring(1));
                    tvNameJp.setText(nameJp);
                    tvDexNational.setText("全國\n#"+dexNational);

                    if(dexSinnoh.equals("-1")){tvDexSinnoh.setText("無神奧編號");}
                    else{tvDexSinnoh.setText("神奧 #"+dexSinnoh);}
                    //if(dexHisui.equals("-1")){tvDexHisui.setText("無洗翠編號");}
                    //else{tvDexHisui.setText("洗翠 #"+dexHisui);}
                    if(dexGalar.equals("-1")){tvDexGalar.setText("無加勒爾編號");}
                    else{tvDexGalar.setText("加勒爾 #"+dexGalar);}
                    tvHeight.setText(height);tvWeight.setText(weight);
                    typesIconI.setImageResource(setIcon(typeI));
                    typesIconII.setImageResource(setIcon(typeII));

                    Map<String,Double> setTypeEff = new HashMap<>();
                    setTypeEff = setEffectiveness(typeI,typeII);
                    setEff(setTypeEff);

                    //String pokeUrl = "https://media.52poke.com/wiki/2/21/001Bulbasaur.png";
                    if (pokeImgUrl.equals("no url")){pokeImgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQREJH9KAgLYCQOcfuFYMsCtXybs4laSW80CHhy9tGs6ifnQHWAEykSGXuE91LcAkUYRJs&usqp=CAU";}

                    GetPokeData getPokeData = (GetPokeData) new GetPokeData(tvAbility1,tvAbility2).execute(pokeUrl);
                    LoadImg loadImg = (LoadImg) new LoadImg(pokePic).execute(pokeImgUrl);

                    //tvAbilities.setText((CharSequence) getPokeData);

                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                    break;
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static Map<String, Double> setEffectiveness(String typeI, String typeII){
        double[] typeChart;
        if(typeII.equals("None")){
            typeChart = Chart.whichType(typeI);
        }else {
            typeChart = Chart.typeCalculate(typeI,typeII);
        }
        Map<String,Double> typeEffMap = new HashMap<>();
        for(int i=0;i<typeList.length;i++){
            typeEffMap.put(typeList[i],typeChart[i]);
        }
        Map<String, Double> sortedTypeChart = sortByValue(typeEffMap);
        //Log.v("msg", String.valueOf(sortedTypeChart));

        return sortedTypeChart;

    }

    private static Map<String, Double> sortByValue(Map<String, Double> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Double>> list =
                new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/
        return sortedMap;
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
        }
        /*
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

    private void setEff(Map<String, Double> typeEffMap){
        Map<String,Double> weakAgainst = new HashMap<>();
        Map<String,Double> resistantAgainst = new HashMap<>();
        Map<String,Double> normalDamage = new HashMap<>();

        for (Map.Entry<String, Double> eff : typeEffMap.entrySet()){
            if(eff.getValue() < 1){
                resistantAgainst.put(eff.getKey(), eff.getValue());
            }else if(eff.getValue() == 1){
                normalDamage.put(eff.getKey(), eff.getValue());
            }else{
                weakAgainst.put(eff.getKey(), eff.getValue());
            }
        }
        setGridLayout(gWeakAgainst,weakAgainst);
        setGridLayout(gNormalDamage,normalDamage);
        setGridLayout(gResistantAgainst,resistantAgainst);
    }

    @SuppressLint("ResourceType")
    private void setGridLayout(GridLayout gridLayout, Map<String, Double> typeEffMap){
        gridLayout.removeAllViews();
        int total = typeEffMap.size();
        int column = 3;
        int row = total/column;
        if(total%column!=0){row+=1;}

        ArrayList<String> keyList = new ArrayList<String>(typeEffMap.keySet());
        ArrayList<Double> valueList = new ArrayList<Double>(typeEffMap.values());
        ArrayList<String> margeList = new ArrayList<>();
        for(int i=0;i<keyList.size();i++){
            margeList.add(keyList.get(i) +":"+ valueList.get(i));
        }

        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row);

        for (int i = 0, c = 0, r = 0; i < total; i++, c++) {
            if (c == column) {
                c = 0;
                r++;
            }
            int color = setChartBackgroundColor(keyList.get(i));

            TextView textView = new TextView(this);
            textView.setBackgroundResource(color);
            textView.setText(keyList.get(i));

            GridLayout.Spec rowSpan = GridLayout.spec(GridLayout.UNDEFINED,  1f);
            GridLayout.Spec colspan = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL, 1f);
            GridLayout.LayoutParams param = new GridLayout.LayoutParams();
            param.columnSpec = colspan;
            param.rowSpec = rowSpan;
            param.setGravity(Gravity.CENTER);
            gridLayout.addView(textView, param);
        }
    }

    private int setChartBackgroundColor(String type){
        switch (type){
            case "normal":
                return R.color.normal;
            case "fire":
                return R.color.fire;
            case "water":
                return R.color.water;
            case "electric":
                return R.color.electric;
            case "grass":
                return R.color.grass;
            case "ice":
                return R.color.ice;
            case "fighting":
                return R.color.fighting;
            case "poison":
                return R.color.poison;
            case "ground":
                return R.color.ground;
            case "flying":
                return R.color.flying;
            case "psychic":
                return R.color.psychic;
            case "bug":
                return R.color.bug;
            case "rock":
                return R.color.rock;
            case "ghost":
                return R.color.ghost;
            case "dragon":
                return R.color.dragon;
            case "dark":
                return R.color.dark;
            case "steel":
                return R.color.steel;
            case "fairy":
                return R.color.fairy;
        }
        return 0;
    }

}