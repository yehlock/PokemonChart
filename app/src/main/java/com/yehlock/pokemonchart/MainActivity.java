package com.yehlock.pokemonchart;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity<bundle> extends AppCompatActivity implements View.OnClickListener {
    int numberOfType = 0;
    double[] emptyList = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    TextView typeI,typeII;
    String firstType;
    Button btnNormal,btnFire,btnWater,btnElectric,btnGrass,btnIce,btnFighting,btnPoison;
    Button btnGround,btnFlying,btnPsychic,btnBug,btnRock,btnGhost,btnDragon,btnDark,btnSteel,btnFairy;
    Button toSearch;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chart chart = ((Chart) getApplicationContext());

        typeI = (TextView)findViewById(R.id.typeI);
        typeII = (TextView)findViewById(R.id.typeII);

        btnNormal = (Button)findViewById(R.id.btnNormal);
        btnNormal.setOnClickListener(this);
        btnFire = (Button)findViewById(R.id.btnFire);
        btnFire.setOnClickListener(this);
        btnWater = (Button)findViewById(R.id.btnWater);
        btnWater.setOnClickListener(this);
        btnElectric = (Button)findViewById(R.id.btnElectric);
        btnElectric.setOnClickListener(this);
        btnGrass = (Button)findViewById(R.id.btnGrass);
        btnGrass.setOnClickListener(this);
        btnIce = (Button)findViewById(R.id.btnIce);
        btnIce.setOnClickListener(this);
        btnFighting = (Button)findViewById(R.id.btnFighting);
        btnFighting.setOnClickListener(this);
        btnPoison = (Button)findViewById(R.id.btnPoison);
        btnPoison.setOnClickListener(this);
        btnGround = (Button)findViewById(R.id.btnGround);
        btnGround.setOnClickListener(this);
        btnFlying = (Button)findViewById(R.id.btnFlying);
        btnFlying.setOnClickListener(this);
        btnPsychic = (Button)findViewById(R.id.btnPsychic);
        btnPsychic.setOnClickListener(this);
        btnBug = (Button)findViewById(R.id.btnBug);
        btnBug.setOnClickListener(this);
        btnRock = (Button)findViewById(R.id.btnRock);
        btnRock.setOnClickListener(this);
        btnGhost = (Button)findViewById(R.id.btnGhost);
        btnGhost.setOnClickListener(this);
        btnDragon = (Button)findViewById(R.id.btnDragon);
        btnDragon.setOnClickListener(this);
        btnDark = (Button)findViewById(R.id.btnDark);
        btnDark.setOnClickListener(this);
        btnSteel = (Button)findViewById(R.id.btnSteel);
        btnSteel.setOnClickListener(this);
        btnFairy = (Button)findViewById(R.id.btnFairy);
        btnFairy.setOnClickListener(this);
        toSearch = (Button) findViewById(R.id.toSearch);
        toSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("msg","Click Search");
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        setTypeValue(emptyList);

        String pokemonName;
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String[][] pokedexData;
            pokedexData = Pokedex.pokemonsAll();
            pokemonName = bundle.getString("pokemon");
            //Log.v("msg","MA Pokemon 1 = "+pokemonName+" length = "+pokedexData.length);
            for(int i=0;i<pokedexData.length;i++){
                if(pokedexData[i][4].equals(pokemonName)){
                    Log.v("msg","MA Pokemon 2 = "+pokemonName+" length = "+pokedexData.length);
                    String typeI = pokedexData[i][5];
                    String typeII = pokedexData[i][6];
                    Log.v("msg",pokemonName + " typeI is "+typeI);
                    setTextForTitle(typeI);

                    if (!typeII.equals("None")) {
                        setTextForTitle(typeII);
                    }
                    break;
                }
            }

        }
    }

    @SuppressLint("NonConstantResourceId")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnNormal:
                setTextForTitle("Normal");
                Log.v("msg","Normal");
                break;
            case R.id.btnFire:
                setTextForTitle("Fire");
                Log.v("msg","Fire");
                break;
            case R.id.btnWater:
                setTextForTitle("Water");
                Log.v("msg","Water");
                break;
            case R.id.btnElectric:
                setTextForTitle("Electric");
                Log.v("msg","Electric");
                break;
            case R.id.btnGrass:
                setTextForTitle("Grass");
                Log.v("msg","Grass");
                break;
            case R.id.btnIce:
                setTextForTitle("Ice");
                Log.v("msg","Ice");
                break;
            case R.id.btnFighting:
                setTextForTitle("Fighting");
                Log.v("msg","Fighting");
                break;
            case R.id.btnPoison:
                setTextForTitle("Poison");
                Log.v("msg","Poison");
                break;
            case R.id.btnGround:
                setTextForTitle("Ground");
                Log.v("msg","Ground");
                break;
            case R.id.btnFlying:
                setTextForTitle("Flying");
                Log.v("msg","Flying");
                break;
            case R.id.btnPsychic:
                setTextForTitle("Psychic");
                Log.v("msg","Psychic");
                break;
            case R.id.btnBug:
                setTextForTitle("Bug");
                Log.v("msg","Bug");
                break;
            case R.id.btnRock:
                setTextForTitle("Rock");
                Log.v("msg","Rock");
                break;
            case R.id.btnGhost:
                setTextForTitle("Ghost");
                Log.v("msg","Ghost");
                break;
            case R.id.btnDragon:
                setTextForTitle("Dragon");
                Log.v("msg","Dragon");
                break;
            case R.id.btnDark:
                setTextForTitle("Dark");
                Log.v("msg","Dark");
                break;
            case R.id.btnSteel:
                setTextForTitle("Steel");
                Log.v("msg","Steel");
                break;
            case R.id.btnFairy:
                setTextForTitle("Fairy");
                Log.v("msg","Fairy");
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setTextForTitle(String type){
        type = type.toLowerCase(Locale.ROOT);
        Log.v("msg",type);
        if(numberOfType==0){
            typeI.setText(translator(type));
            double[] forAttack = Chart.whichType(type);
            Log.v("msg", "for Attack is "+String.valueOf(forAttack));
            firstType = type;
            setTypeValue(forAttack);
            numberOfType++;
        }else if(firstType.equals(type) && numberOfType==1){
            //Toast.makeText(this, "你選擇了同一個屬性，請選另一個屬性", Toast.LENGTH_LONG).show();
        } else if(numberOfType==1){
            typeII.setText(translator(type));
            double[] forAttack = Chart.typeCalculate(firstType,type);
            setTypeValue(forAttack);
            numberOfType++;
        }else{
            typeI.setText(translator(type));
            typeII.setText("");
            double[] forAttack = Chart.whichType(type);
            firstType = type;
            setTypeValue(forAttack);
            numberOfType--;
        }
    }

    public void setTypeValue(double[] list){
        List<String> stringList = new ArrayList<String>();
        for (double v : list) {
            if (v == 4) {
                stringList.add("4");
            }
            if (v == 2) {
                stringList.add("2");
            }
            if (v == 1) {
                stringList.add("1");
            }
            if (v == 0.5) {
                stringList.add("½");
            }
            if (v == 0.25) {
                stringList.add("¼");
            }
            if (v == 0) {
                stringList.add("0");
            }
        }
        btnNormal.setText(stringList.get(0));
        btnFire.setText(stringList.get(1));
        btnWater.setText(stringList.get(2));
        btnElectric.setText(stringList.get(3));
        btnGrass.setText(stringList.get(4));
        btnIce.setText(stringList.get(5));
        btnFighting.setText(stringList.get(6));
        btnPoison.setText(stringList.get(7));
        btnGround.setText(stringList.get(8));
        btnFlying.setText(stringList.get(9));
        btnPsychic.setText(stringList.get(10));
        btnBug.setText(stringList.get(11));
        btnRock.setText(stringList.get(12));
        btnGhost.setText(stringList.get(13));
        btnDragon.setText(stringList.get(14));
        btnDark.setText(stringList.get(15));
        btnSteel.setText(stringList.get(16));
        btnFairy.setText(stringList.get(17));
    }

    public String translator(String type){
        switch (type){
            case "normal":
                return "一般";
            case "fire":
                return "火";
            case "water":
                return "水";
            case "electric":
                return "電";
            case "grass":
                return "草";
            case "ice":
                return "冰";
            case "fighting":
                return "格鬥";
            case "poison":
                return "毒";
            case "ground":
                return "地面";
            case "flying":
                return "飛行";
            case "psychic":
                return "超能力";
            case "bug":
                return "蟲";
            case "rock":
                return "岩石";
            case "ghost":
                return "幽靈";
            case "dragon":
                return "龍";
            case "dark":
                return "惡";
            case "steel":
                return "鋼";
            case "fairy":
                return "妖精";
        }
        return "錯誤";
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}