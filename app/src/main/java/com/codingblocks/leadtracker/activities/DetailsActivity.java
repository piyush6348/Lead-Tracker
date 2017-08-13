package com.codingblocks.leadtracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.leadtracker.R;
import com.codingblocks.leadtracker.model.User;
import com.codingblocks.leadtracker.model.UserApi;
import com.codingblocks.leadtracker.sharedPref.SuperPrefs;
import com.codingblocks.leadtracker.utils.CONSTANTS;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity implements CONSTANTS{

    private SuperPrefs prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        prefs = new SuperPrefs(this);
        String access_token = prefs.getString(ACCESS_TOKEN);

        String url = "https://account.codingblocks.com/api/users/";
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(url).build();
        UserApi userApi = retrofit.create(UserApi.class);
        userApi.getMe("Bearer " + access_token).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                setViews(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void setViews(User user) {
        TextView tvId = (TextView) findViewById(R.id.tvId);
        TextView tvUsername = (TextView) findViewById(R.id.tvUsername);
        TextView tvFirstname = (TextView) findViewById(R.id.tvFirstname);
        TextView tvLastName = (TextView) findViewById(R.id.tvLastName);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvCreatedAt = (TextView) findViewById(R.id.tvCreatedAt);
        TextView tvUpdatedAt = (TextView) findViewById(R.id.tvUpdatedAt);
        ImageView ivPhoto = (ImageView) findViewById(R.id.ivImageView);
        Button btnLogout = (Button) findViewById(R.id.btnLogout);


        tvId.setText(String.valueOf(user.getId()));
        tvUsername.setText(user.getUsername());
        tvFirstname.setText(user.getFirstname());
        tvLastName.setText(user.getLastname());
        tvEmail.setText(user.getEmail());
        tvCreatedAt.setText(user.getCreatedAt());
        tvUpdatedAt.setText(user.getUpdatedAt());
        Picasso.with(this).load(user.getPhoto()).into(ivPhoto);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sharedPreferences.edit().clear().apply();

                Intent i = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
