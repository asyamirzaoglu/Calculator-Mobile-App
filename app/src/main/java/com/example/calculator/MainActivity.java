package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    EditTextSelectable ekran;
    Button sifir, bir, iki, uc, dort, bes, alti, yedi, sekiz, dokuz, esittir, eksi, arti, carpi, bolu, nokta;
    Float deger1, deger2, sonuc;
    String islemtur;
    Boolean kokMu=false;
   String TAG="main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ekran = findViewById(R.id.tekran);
        ekran.setShowSoftInputOnFocus(false);
        sifir = findViewById(R.id.buttonsifir);
        bir = findViewById(R.id.buttonbir);
        iki = findViewById(R.id.buttoniki);
        uc = findViewById(R.id.buttonuc);
        dort = findViewById(R.id.buttondort);
        bes = findViewById(R.id.buttonbes);
        alti = findViewById(R.id.buttonalti);
        yedi = findViewById(R.id.buttonyedi);
        sekiz = findViewById(R.id.buttonsekiz);
        dokuz = findViewById(R.id.buttondokuz);
        esittir = findViewById(R.id.buttonesittir);
        eksi = findViewById(R.id.buttoneksi);
        arti = findViewById(R.id.buttonarti);
        carpi = findViewById(R.id.buttoncarpi);
        bolu = findViewById(R.id.buttonbolu);
        nokta = findViewById(R.id.buttonnokta);
        ekran.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                imlecKonumu = ekran.getSelectionStart(); // imlec konumunu güncelle
            }
        });

        esittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (kokMu) {
                    if (sonuc == null) {
                        deger1 = kokAlma(view);
                        ekran.setText(String.valueOf(deger1));
                        if (islemtur != null) {
                            hesapla();
                        }

                    } else {
                        deger2 = kokAlma(view);
                        ekran.setText(String.valueOf(deger2));
                        if (islemtur != null) {
                            deger1 = sonuc;
                            hesapla();
                        }
                    }
                } else {
                    hesapla();
                }
            }
        });
    }
    public void sifir(View view) { insertDigit("0");}

    public void bir(View view) { insertDigit("1");}

    public void iki(View view) {
        insertDigit("2");
    }

    public void uc(View view) {
        insertDigit("3");
    }

    public void dort(View view) {
        insertDigit("4");
    }

    public void bes(View view) {
        insertDigit("5");
    }

    public void alti(View view) { insertDigit("6");}

    public void yedi(View view) {
        insertDigit("7");
    }

    public void sekiz(View view) {
        insertDigit("8");
    }

    public void dokuz(View view) { insertDigit("9");}

    public void nokta(View view) {
        insertDigit(".");
    }
    int imlecKonumu;

    public void insertDigit(String digit){
        if(ekran==null){
            imlecKonumu=ekran.getSelectionStart();
            Log.i(TAG,"imleckonumu "+imlecKonumu);
            ekran.setText(digit);
            imlecKonumu=imlecKonumu+1;
        }
        else{
            String ekranText=ekran.getText().toString();
            Log.i(TAG,"elseimlec "+imlecKonumu);
            String yeniDeger = ekranText.substring(0,imlecKonumu)+digit+ekranText.substring(imlecKonumu);
            ekran.setText(yeniDeger);
            Log.i(TAG,"yenideger "+yeniDeger);
            imlecKonumu=imlecKonumu+1;
            Log.i(TAG,"imleck+1 "+imlecKonumu);
        }
    }

    public void temizle(View view) {
        ekran.setText("");
        sonuc = null;
        deger2=null;
        deger1=null;
        islemtur=null;
        kokMu=false;
        imlecKonumu=0;
    }

    public void gerial(View view) {
        if (imlecKonumu > 0) {
            imlecKonumu=imlecKonumu-1;
            String eskiDeger = ekran.getText().toString();
            String yeniDeger = eskiDeger.substring(0, imlecKonumu) + eskiDeger.substring(imlecKonumu+1);
            ekran.setText(yeniDeger);
        }
    }
    public void hesapla() {
        if (islemtur.equals("topla")) {
            if (sonuc == null) {
                if(kokMu){
                    deger1 = kokAlma(ekran);
                    sonuc=deger1;
                    kokMu=false;
                }
                else{
                    sonuc = deger1;
                }
            }
            else {
                if(kokMu){
                    sonuc=sonuc+deger2;
                    kokMu=false;
                }
                else{
                    deger2 = Float.parseFloat(ekran.getText() + "");
                    sonuc = sonuc+deger2;
                }
            }
            ekran.setText(String.valueOf(sonuc));
        }
        else if (islemtur.equals("cikarma")) {
            if (sonuc == null) {
                if(kokMu){
                    deger1 = kokAlma(ekran);
                    sonuc=deger1;
                    kokMu=false;
                }
                else{
                    sonuc = deger1;
                }
            }
            else {
                if(kokMu){
                    sonuc=sonuc-deger2;
                    kokMu=false;
                }
                else{
                    deger2 = Float.parseFloat(ekran.getText() + "");
                    sonuc = sonuc-deger2;
                }
            }
            ekran.setText(String.valueOf(sonuc));
        }
        else if (islemtur.equals("carpma")) {
            if (sonuc == null) {
                if(kokMu){
                    deger1 = kokAlma(ekran);
                    sonuc=deger1;
                    kokMu=false;
                }
                else{
                    sonuc = deger1;
                    Log.i(TAG,"sonuc1 "+sonuc);
                }
            }
            else {
                if(kokMu){
                    sonuc=sonuc*deger2;
                    kokMu=false;
                }
                else{
                    deger2 = Float.parseFloat(ekran.getText() + "");
                    Log.i(TAG,"deger2 "+deger2);
                    Log.i(TAG,"sonuc2 "+sonuc);
                    sonuc = sonuc*deger2;
                    Log.i(TAG,"sonuc3 "+sonuc);
                }
            }
            ekran.setText(String.valueOf(sonuc));
        }
        else if (islemtur.equals("bolme")) {
            if (sonuc == null) {
                if(kokMu){
                    deger1 = kokAlma(ekran);
                    sonuc=deger1;
                    kokMu=false;
                }
                else{
                    sonuc = deger1;
                    Log.i(TAG,"sonuc1 "+sonuc);
                }
            }
            else {
                    if(kokMu){
                        if(deger2==0) {
                            ekran.setText("Undefined");
                        }
                        else {
                            sonuc = sonuc / deger2;
                            kokMu = false;
                            ekran.setText(String.valueOf(sonuc));
                        }
                    }
                    else{
                        deger2 = Float.parseFloat(ekran.getText() + "");
                        Log.i(TAG,"deger2 "+deger2);
                        Log.i(TAG,"sonuc2 "+sonuc);
                        sonuc = sonuc/deger2;
                        Log.i(TAG,"sonuc3 "+sonuc);
                        ekran.setText(String.valueOf(sonuc));
                    }
            }

        }
    }
    public float kokAlma (View view){
        String ekranText = ekran.getText() + "";
        Float koksuz = Float.parseFloat(ekranText.substring(1));
        if (koksuz!= null && koksuz>=0) {
                deger2 = (float) Math.sqrt((double) koksuz);
                return deger2.floatValue();
        }
        else{
            ekran.setText("Error");
            return 0f;
        }
}


    public void toplama(View view) {
        String ekranText = ekran.getText().toString();
        if (ekranText.isEmpty()) {
            ekran.setText("0");
            deger1=0f;
        } else {
            if (kokMu==true){
                deger1 = Float.parseFloat(ekranText.substring(1));
            }
            else{
                deger1 = Float.parseFloat(ekranText);
            }
        }
        islemtur = "topla";
        hesapla();
        ekran.setText("");
        imlecKonumu=0;
    }
    public void cikarma(View view) {
        String ekranText = ekran.getText().toString();
        if (ekranText.isEmpty()) {
            ekran.setText("0");
            deger1 = 0f;
        } else {
            if (kokMu==true){
                deger1 = Float.parseFloat(ekranText.substring(1));
            }
            else{
                deger1 = Float.parseFloat(ekranText);
            }
        }
        islemtur="cikarma";
        hesapla();
        ekran.setText("");
        imlecKonumu=0;
    }
    public void carpma(View view) {
        String ekranText = ekran.getText().toString();
        if (ekranText.isEmpty()) {
            ekran.setText("0");
            deger1=0f;
            islemtur = "carpma";
        }
        else {
            if (kokMu==true){
                deger1 = Float.parseFloat(ekranText.substring(1));
            }
            else{
                Log.i(TAG,"deger1 "+deger1);
                deger1 = Float.parseFloat(ekranText);
                Log.i(TAG,"deger1 "+deger1);
            }
        }
        islemtur="carpma";
        hesapla();
        ekran.setText("");
        imlecKonumu=0;
    }
    public void bolme(View view) {
        String ekranText = ekran.getText().toString();
        if (ekranText.isEmpty()) {
            ekran.setText("0");
            deger1=0f;
            islemtur = "bolme";
        } else {
            if (kokMu==true){
                deger1 = Float.parseFloat(ekranText.substring(1));
            }
            else{
                deger1 = Float.parseFloat(ekranText);
            }
        }
        islemtur="bolme";
        hesapla();
        ekran.setText("");
        imlecKonumu=0;
    }
        public void koklu(View view){
            String ekranText = ekran.getText().toString();
            if (ekranText.isEmpty()) {
                    ekran.setText("√");
                    kokMu=true;
                }
            else{
                ekran.setText("");
                ekran.setText("√");
                kokMu=true;
            }
            imlecKonumu++;
        }
    }
