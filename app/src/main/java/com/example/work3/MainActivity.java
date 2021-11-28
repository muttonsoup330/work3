package com.example.work3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String SharedPreferencesFileName="config";
    private final static String Key_Name="Name";
    private final static String Key_StudentNumber="StudentNumber";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences(SharedPreferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();
        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(Key_Name,"毋祥臣");
                editor.putString(Key_StudentNumber,"2018011231");
                editor.apply();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName=preferences.getString(Key_Name,null);
                String strStudentNumber=preferences.getString(Key_StudentNumber,null);
                if(strName!=null&&strStudentNumber!=null)
                    Toast.makeText(MainActivity.this,"姓名："+strName+"学号："+strStudentNumber
                    ,Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
            }
        });
    }
}