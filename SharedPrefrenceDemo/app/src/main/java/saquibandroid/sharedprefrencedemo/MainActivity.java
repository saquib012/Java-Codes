package saquibandroid.sharedprefrencedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText editText, editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText)findViewById(R.id.editText);
        editText1= (EditText)findViewById(R.id.editText2);
    }



    public void save(View view)
    {
        SharedPreferences sharedPreferences= getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("user", editText.getText().toString());
        editor.putString("pass", editText1.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

        Intent intent= new Intent(this, ActivityB.class);
        startActivity(intent);
    }
}
