package com.kazemieh.www.zekrshommarr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar tb=findViewById(R.id.tb_MainActivity_toolbar);
        setSupportActionBar(tb);
        // setActionBar(tb);

        final TextView t_plus = findViewById(R.id.tv_MainActivity_plus);
        final TextView tv_counter = findViewById(R.id.tv_MainActivity_counter);

        final SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("tt",0);
        final int i=sharedPreferences.getInt("number",0);
        c=sharedPreferences.getInt("number",0);
        t_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c++;
                tv_counter.setText(c+"");
            }
        });



        Button b_reset = findViewById(R.id.b_MainActivity_reset);
        b_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = 0;
                tv_counter.setText(c + "");
            }
        });



        tv_counter.setText(i+"");


        Button b_save=findViewById(R.id.b_MainActivity_save);
        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("tt",0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("number",c);
                editor.apply();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.info) {
            Intent intent = new Intent(MainActivity.this, Info.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.nazar) {
            // Toast.makeText(this, "ارتباط با ما کلیک شد", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
    //  new line with comment
    public void test(){
// comments are test for github
    }
}
