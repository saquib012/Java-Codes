package saquibandroid.sharedprefrencedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Saquib on 1/13/2016.
 */
public class ActivityB extends AppCompatActivity
{
    TextView textView;
    public static final String DEFAULT="N/A";

    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        editText1=(EditText)findViewById(R.id.editText3);
        editText2=(EditText)findViewById(R.id.editText4);
    }

    public void load(View view)
    {
        SharedPreferences sharedPreferences= getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("user", DEFAULT);
        String pass=sharedPreferences.getString("pass", DEFAULT);

        if(name.equals(DEFAULT)|| pass.equals(DEFAULT))
        {
            Toast.makeText(this, "Wrong Entries", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Data Loaded Success", Toast.LENGTH_SHORT).show();
            editText1.setText(name);
            editText2.setText(pass);
        }





    }
    public void back(View view)
    {
        Toast.makeText(this, "You have come back", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);

    }






}
