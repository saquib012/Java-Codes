package com.test.loginsampledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;

import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity
{

    private CallbackManager callbackManager;
    private LoginButton fbLoginButton;
    private TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        // Initialize the SDK before executing any other operations,
        // especially, if you're using Facebook UI elements.

        callbackManager = CallbackManager.Factory.create();
        //You need this method to be used only once to configure
        //your key hash in your App Console at
        // developers.facebook.com/apps

        setContentView(R.layout.activity_main);

        fbLoginButton = (LoginButton)findViewById(R.id.login_button);
        fbLoginButton.setReadPermissions("user_friends");

        details= (TextView) findViewById(R.id.text_details);






        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                AccessToken accessToken= loginResult.getAccessToken();
                Profile profile=Profile.getCurrentProfile();
                if(profile != null)
                {
                    details.setText(
                            "User ID: "
                                    + loginResult.getAccessToken().getUserId()
                                    + "\n" +
                                    "Auth Token: "
                                    + loginResult.getAccessToken().getToken()
                    );
                }

               /* System.out.println("Facebook Login Successful!");
                System.out.println("Logged in user Details : ");
                System.out.println("--------------------------");
                System.out.println("User ID  : " + loginResult.getAccessToken().getUserId());
                System.out.println("Authentication Token : " + loginResult.getAccessToken().getToken());*/
                Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Login cancelled by user!", Toast.LENGTH_LONG).show();
                System.out.println("Facebook Login failed!!");
                details.setText("Login attempt canceled.");

            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(MainActivity.this, "Login unsuccessful!", Toast.LENGTH_LONG).show();
                System.out.println("Facebook Login failed!!");
            }
        });
    }







    protected void onActivityResult(int reqCode, int resCode, Intent i)
    {
        super.onActivityResult(reqCode, resCode, i);
        callbackManager.onActivityResult(reqCode, resCode, i);
    }

    }


