package com.ihs.appli.portfolio.domain;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import com.ihs.appli.portfolio.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Created by tchipi on 3/19/18.
 */


@Entity
public class Site  implements Serializable {

    //site informations
    @PrimaryKey
    @NonNull
    public  String ihsId;
    public String region;
    public String cluster;
    public String operatorId;
    public String name;
    public String topology;
    public String configuration;
    public String type;

    //site management
    public String sbc;
    public String supervisor;
    public String supervisorContact1;
    public String supervisorContact2;
    public String teamLeader;
    public String teamLeaderContact1;
    public String teamLeaderContact2;
    public String securityCompany;
    public String securityCompanyContact;
    //grid information
    public Boolean transformerAvailable;
    public String typeConnexion;
    public String panelNumber;
    public String avrSize;
    //power cabinet
    public String rectifierType;
    public String powerCabinetType;
    public String batteryType;
    public Integer numberOfRack;
    public Integer rackCapacity;
    public Float currentDCLoad;
    public Integer numberOfRectifierModule;
    public Integer numberOfSlotAvailable;
    //generator
    public Integer numberOfGenerator;
    public Float   generatorSize1;
    public Float   generatorSize2;
    public String  generatorBrand;
    public String  generatorEngineBrand;
    public String  generatorEngineType;
    public String  generatorMainAlternatorBrand;
    public String  generatorMainAlternatorType;

    //fuel tank
    public String fuelTankForme;
    public String fuelTankSize;
    public String fuelTankCapacity;

    //solar system
    public String solarSystemTechnology;
    public String solarSystemTypeRegulateur;
    public Integer solarSystemQuantityOfModules;
    public Integer solarSystemQuantityOfPanels1;
    public Integer solarSystemQuantityOfPanels2;
    public String solarSystemCaracteristic1;
    public String solarSystemCaracteristic2;



    public static Site[] readData(Context context) {
        List<Site> sites = new ArrayList<>();
        InputStream is = context.getResources().openRawResource(R.raw.ihs);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";

        try {
            while ((line = reader.readLine()) != null) {
                // Split the line into different tokens (using the comma as a separator).
                String[] tokens = line.split(",",47);

                // Read the data and store it in the WellData POJO.
                Site site = new Site();

                site.region = tokens[0];
                site.cluster = tokens[1];
                site.ihsId = tokens[2];
                site.operatorId = tokens[3];
                site.name = tokens[4].toUpperCase().replace('"', ' ');
                site.topology = tokens[5];
                site.configuration = tokens[6];
                site.type = tokens[7];


                site.sbc= tokens[8];
                site.supervisor= tokens[9];
                site.supervisorContact1= tokens[10];
                site.supervisorContact2= tokens[11];
                site.teamLeader= tokens[12];
                site.teamLeaderContact1= tokens[13];
                site.teamLeaderContact2= tokens[14];
                site.securityCompany= tokens[15];
                site.securityCompanyContact= tokens[16];


                site.transformerAvailable= parseBoolean(tokens[17]);
                site.typeConnexion       = tokens[18];
                site.panelNumber         = tokens[19];
                site.avrSize             = tokens[20];


                site.rectifierType= tokens[21];
                site.powerCabinetType= tokens[22];
                site.batteryType= tokens[23];
                site.numberOfRack= parseInt(tokens[24]);
                site.rackCapacity= parseInt(tokens[25]);
                site.currentDCLoad= parseFloat(tokens[26]);
                site.numberOfRectifierModule= parseInt(tokens[27]);
                site.numberOfSlotAvailable= parseInt(tokens[28]);



                site.numberOfGenerator= parseInt(tokens[29]);;
                site.generatorSize1= parseFloat(tokens[30]);
                site.generatorSize2= parseFloat(tokens[31]);
                site.generatorBrand= tokens[32];
                site.generatorEngineBrand= tokens[33];
                site.generatorEngineType= tokens[34];
                site.generatorMainAlternatorBrand= tokens[35];
                site.generatorMainAlternatorType= tokens[36];


                site.fuelTankForme= tokens[37];
                site.fuelTankSize= tokens[38];
                site.fuelTankCapacity= tokens[39];


                site.solarSystemTechnology= tokens[40];
                site.solarSystemTypeRegulateur= tokens[41];
                site.solarSystemQuantityOfModules= parseInt(tokens[42]);
                site.solarSystemQuantityOfPanels1=parseInt( tokens[43]);
                site.solarSystemQuantityOfPanels2= parseInt(tokens[44]);
                site.solarSystemCaracteristic1= tokens[45];
                site.solarSystemCaracteristic2= tokens[46];


                sites.add(site);

                Log.d("MainActivity", "Just Created " + site);
            }
        } catch (IOException e1) {
            Log.e("MainActivity", "Error " + line, e1);
            e1.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e1) {
            Log.e("MainActivity", "Error " + line, e1);
            e1.printStackTrace();
        }
        return sites.toArray(new Site[0]);
    }

    private static Integer parseInt(String text){
        try {
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    private static Float parseFloat(String text){
        try {
            return Float.parseFloat(text);
        }catch (NumberFormatException e){
            return 0F;
        }
    }


    private static Boolean parseBoolean(String text){
        if(text==null) return Boolean.FALSE;
        if("YES".equalsIgnoreCase(text)
        || "OUI".equalsIgnoreCase(text))return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
