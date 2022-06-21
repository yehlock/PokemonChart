package com.yehlock.pokemonchart;

import android.app.Application;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;

/*
 * 一般	Normal
 * 火	Fire
 * 水	Water
 * 電	Electric
 * 草	Grass
 * 冰	Ice
 * 格鬥	Fighting
 * 毒	Poison
 * 地面	Ground
 * 飛行	Flying
 * 超能力Psychic
 * 蟲	Bug
 * 岩石	Rock
 * 幽靈	Ghost
 * 龍	Dragon
 * 惡	Dark
 * 鋼	Steel
 * 妖精	Fairy
 */
public class Chart extends Application {
    public static double[] whichType(String type) {
        // TODO Auto-generated method stub
        double[] result = null;
        //效果絕佳 = 2, 效果普通=1 , 效果不佳 = .5, 沒有效果 = 0
                            // 般,火,水, 電,草,冰, 鬥,毒,地, 飛,超, 蟲,岩,幽,龍, 惡,鋼,妖
                            // No,Fr,Wa,El,Gr,Ic,Ft,Po,Gd,Fy,Ps,Bu,Ro,Gh,Dr,Dk,St,Fa
        double[] normal 	= { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        double[] fire		= { 1,.5, 2, 1,.5,.5, 1, 1, 2, 1, 1,.5, 2, 1, 1, 1,.5,.5};
        double[] water		= { 1,.5,.5, 2, 2,.5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,.5, 1};
        double[] electric	= { 1, 1, 1,.5, 1, 1, 1, 1, 2,.5, 1, 1, 1, 1, 1, 1,.5, 1};
        double[] grass 		= { 1, 2,.5,.5,.5, 2, 1, 2,.5, 2, 1, 2, 1, 1, 1, 1, 1, 1};
        double[] ice	 	= { 1, 2, 1, 1, 1,.5, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1};
        double[] fighting	= { 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,.5,.5, 1, 1,.5, 1, 2};
        double[] poison 	= { 1, 1, 1, 1,.5, 1,.5,.5, 2, 1, 2,.5, 1, 1, 1, 1, 1,.5};
        double[] ground 	= { 1, 1, 2, 0, 2, 2, 1,.5, 1, 1, 1, 1,.5, 1, 1, 1, 1, 1};
        double[] flying 	= { 1, 1, 1, 2,.5, 2,.5, 1, 0, 1, 1,.5, 2, 1, 1, 1, 1, 1};
        double[] psychic 	= { 1, 1, 1, 1, 1, 1,.5, 1, 1, 1,.5, 2, 1, 2, 1, 2, 1, 1};
        double[] bug	 	= { 1, 2, 1, 1,.5, 1,.5, 1,.5, 2, 1, 1, 2, 1, 1, 1, 1, 1};
        double[] rock		= {.5,.5, 2, 1, 2, 1, 2,.5, 2,.5, 1, 1, 1, 1, 1, 1, 2, 1};
        double[] ghost 		= { 0, 1, 1, 1, 1, 1, 0,.5, 1, 1, 1,.5, 1, 2, 1, 2, 1, 1};
        double[] dragon 	= { 1,.5,.5,.5,.5, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2};
        double[] dark		= { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0, 2, 1,.5, 1,.5, 1, 2};
        double[] steel 		= {.5, 2, 1, 1,.5,.5, 2, 0, 2,.5,.5,.5,.5, 1,.5, 1,.5,.5};
        double[] fairy 		= { 1, 1, 1, 1, 1, 1,.5, 2, 1, 1, 1,.5, 1, 1, 0,.5, 2, 1};

        switch (type) {
            case "normal":
                result = normal;
                break;
            case "fire":
                result = fire;
                break;
            case "water":
                result = water;
                break;
            case "electric":
                result = electric;
                break;
            case "grass":
                result = grass;
                break;
            case "ice":
                result = ice;
                break;
            case "fighting":
                result = fighting;
                break;
            case "poison":
                result = poison;
                break;
            case "ground":
                result = ground;
                break;
            case "flying":
                result = flying;
                break;
            case "psychic":
                result = psychic;
                break;
            case "bug":
                result = bug;
                break;
            case "rock":
                result = rock;
                break;
            case "ghost":
                result = ghost;
                break;
            case "dragon":
                result = dragon;
                break;
            case "dark":
                result = dark;
                break;
            case "steel":
                result = steel;
                break;
            case "fairy":
                result = fairy;
                break;
        }
        return result;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static double[] typeCalculate(String typeI, String typeII) {
        List<Double> resultList = new ArrayList<Double>();
        double[] dTypeI = whichType(typeI);
        double[] dTypeII = whichType(typeII);
        for(int i = 0;i<dTypeI.length;i++) {
            double n = dTypeI[i] * dTypeII[i];
            resultList.add(n);
        }
        double[] resultArray = resultList.stream().mapToDouble(Double::doubleValue).toArray();
        return resultArray;
    }
}
