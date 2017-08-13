package com.codingblocks.leadtracker.activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.codingblocks.leadtracker.utils.CONSTANTS;

import android.webkit.WebViewClient;
import android.widget.Button;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.sharedPref.SuperPrefs;

public class LoginActivity extends AppCompatActivity implements CONSTANTS{
    private Button login;
    private SuperPrefs prefs;
    private Dialog auth_dialog;

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(auth_dialog != null && auth_dialog.isShowing())
            auth_dialog.dismiss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialisePref();
        if(checkIfAlreadySignedIn())
            moveToOtherActivity();

        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogForSignIn();
            }
        });
    }

    private void openDialogForSignIn() {
        WebView web;

        auth_dialog = new Dialog(LoginActivity.this);
        auth_dialog.setContentView(R.layout.auth_dialog);
        web = (WebView) auth_dialog.findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(CONSTANTS.OAUTH_URL + "?redirect_uri=" + REDIRECT_URI + "&response_type=token&client_id=" + CLIENT_ID);

        web.setWebViewClient(new WebViewClient() {
            boolean authComplete = false;
            String authToken;
            
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                
                if(url.contains(ACCESS_TOKEN+"=") && !authComplete){
                    authToken = getAccessToken(url);
                    authComplete = true;
                    prefs.setString(ACCESS_TOKEN, authToken);
                    moveToOtherActivity();
                }
            }
        });
        auth_dialog.show();
        auth_dialog.setTitle("");
        auth_dialog.setCancelable(true);
    }

    private String getAccessToken(String url) {

        // Look for access token parameter
        int accessTokenIndex = url.indexOf("access_token");

        // url would be like www.example.com/access_token=abcd&otherparameters
        int loopStartIndex = accessTokenIndex + "access_token".length() + 1;
        int andIndex = url.indexOf("&");
        StringBuilder sb = new StringBuilder("");
        for (int i = loopStartIndex; i < andIndex; i++) {
            sb.append(url.charAt(i));
        }
        return sb.toString();
    }

    private void initialisePref() {
        prefs = new SuperPrefs(LoginActivity.this);
    }

    private boolean checkIfAlreadySignedIn() {
        if(prefs.stringExists(ACCESS_TOKEN))
        {
            showDetails();
            return true;
        }
        return false;
    }

    private void showDetails() {
    }

    private void moveToOtherActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class ));
        finish();
    }
}
