package com.wahyukn92.kasirsuperresto;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingHarga extends AppCompatActivity {
    EditText edit1, edit2, edit3, edit4, edit5, edit6, edit7;
    Button simpan;

    public static final String MyPreferences = "MyPrefs";
    public static final String menu1 = "menu1";
    public static final String menu2 = "menu2";
    public static final String menu3 = "menu3";
    public static final String menu4 = "menu4";
    public static final String menu5 = "menu5";
    public static final String menu6 = "menu6";
    public static final String menu7 = "menu7";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_harga);

        edit1 = (EditText) findViewById(R.id.hrg1);
        edit2 = (EditText) findViewById(R.id.hrg2);
        edit3 = (EditText) findViewById(R.id.hrg3);
        edit4 = (EditText) findViewById(R.id.hrg4);
        edit5 = (EditText) findViewById(R.id.hrg5);
        edit6 = (EditText) findViewById(R.id.hrg6);
        edit7 = (EditText) findViewById(R.id.hrg7);

        simpan = (Button) findViewById(R.id.btnSimpan);

        sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
        DisplayText();

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f1 = edit1.getText().toString();
                String f2 = edit2.getText().toString();
                String f3 = edit3.getText().toString();
                String f4 = edit4.getText().toString();
                String f5 = edit5.getText().toString();
                String f6 = edit6.getText().toString();
                String f7 = edit7.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(menu1,f1);
                editor.putString(menu2,f2);
                editor.putString(menu3,f3);
                editor.putString(menu4,f4);
                editor.putString(menu5,f5);
                editor.putString(menu6,f6);
                editor.putString(menu7,f7);
                editor.commit();
                Toast.makeText(SettingHarga.this, "Tersimpan!", Toast.LENGTH_SHORT).show();

                DisplayText();
            }
        });
    }

    private void DisplayText() {
        edit1.setText(sharedPreferences.getString(menu1,menu1));
        edit2.setText(sharedPreferences.getString(menu2,menu2));
        edit3.setText(sharedPreferences.getString(menu3,menu3));
        edit4.setText(sharedPreferences.getString(menu4,menu4));
        edit5.setText(sharedPreferences.getString(menu5,menu5));
        edit6.setText(sharedPreferences.getString(menu6,menu6));
        edit7.setText(sharedPreferences.getString(menu7,menu7));
    }
}
