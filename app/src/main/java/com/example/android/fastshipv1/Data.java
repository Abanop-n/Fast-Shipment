package com.example.android.fastshipv1;

import java.util.Date;

/**
 * Created by h on 03/02/2020.
 */

public class Data {

    public Data(){}
    public Data(String Fcountry,String Tocountry,
            String Name,
            float Rate,
            float weight){
        this.Fcountry = Fcountry;
        this.Tocountry = Tocountry;
        this.Name = Name;
        this.Rate = Rate;
        this.weight = weight;

    }

    String Fcountry;
    String Tocountry;
    String Name;
    float Rate;
    float weight;

    public String getFcountry() {
        return Fcountry;
    }

    public void setFcountry(String fcountry) {
        Fcountry = fcountry;
    }

    public String getTocountry() {
        return Tocountry;
    }

    public void setTocountry(String tocountry) {
        Tocountry = tocountry;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
