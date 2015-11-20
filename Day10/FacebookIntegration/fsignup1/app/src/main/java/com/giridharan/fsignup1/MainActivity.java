package com.giridharan.fsignup1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    LoginManager mLoginManager;
    CallbackManager callbackManager;
    TextView info;
    LoginButton loginButton;
    Button nxtpg,logout;
    String name,link,pic,text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this,"oncreate",Toast.LENGTH_LONG).show();
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        info=(TextView)findViewById(R.id.textview1);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        nxtpg=(Button)findViewById(R.id.button);
        logout=(Button)findViewById(R.id.button2);
        loginButton.setReadPermissions(Arrays.asList("email"));
        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        AccessToken accessToken = loginResult.getAccessToken();
                        Profile profile = Profile.getCurrentProfile();
                        info.setText(profile.getName() + " LINK:  " + profile.getLinkUri().toString());
                        name = profile.getName();
                        link = profile.getLinkUri().toString();
                        pic = "https://graph.facebook.com/" + profile.getId() + "/picture?type=large";
                        if (AccessToken.getCurrentAccessToken() != null) {
                            RequestData();
                        }
                    }

                    @Override
                    public void onCancel() {
                        // App code
                        info.setText("Login attempt canceled.");
                        System.out.println("Login attempt canceled.");
                        Toast.makeText(MainActivity.this, "Login attempt canceled.", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Toast.makeText(MainActivity.this, "Login attempt failed.", Toast.LENGTH_LONG).show();
                        info.setText("Login attempt failed.");
                        System.out.println("Login attempt failed.");
                    }
                });
        nxtpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent io=new Intent(MainActivity.this,Main2Activity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("ONE", name);
                bundle1.putString("TWO", link);
                bundle1.putString("Three", pic);
                bundle1.putString("Four", text);
                io.putExtras(bundle1);
                startActivity(io);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FacebookSdk.sdkInitialize(getApplicationContext());
                LoginManager.getInstance().logOut();
                info.setText("");
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(MainActivity.this,"ResultActivity",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
        Toast.makeText(MainActivity.this,"resume",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,"pause",Toast.LENGTH_LONG).show();
        // Logs 'app deactivate' App Event.
       AppEventsLogger.deactivateApp(this);
    }
    public void RequestData(){
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object,GraphResponse response) {
                JSONObject json = response.getJSONObject();
                try {
                    if(response != null){
                        System.out.println(json);
                       text = "Name : "+json.getString("name")+"ID : "+json.getString("id")+"Profile link : "+json.getString("link")+"Name : "+json.getString("name")+json.getString("email");
                        }
                    } catch (JSONException e) {
                    e.printStackTrace();
                    }
                }
            });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email,picture");
        request.setParameters(parameters);
        request.executeAsync();
        }
}
