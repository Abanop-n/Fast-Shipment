package com.example.android.fastshipv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    public static ArrayList<userdata> users;
    Button register;
    EditText name, email, pass, conpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        register = (Button) findViewById(R.id.btreg);
        email = (EditText) findViewById(R.id.etregemail);
        name = (EditText) findViewById(R.id.etregname);
        pass = (EditText) findViewById(R.id.etregpass);
        conpass = (EditText) findViewById(R.id.etregcon);


        users = new ArrayList<userdata>();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if (pass.getText().toString().equals(conpass.getText().toString())
//                        && !email.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()){
//
//                    users.add(new userdata (email.getText().toString(),name.getText().toString(),pass.getText().toString()));
//                }
//                Toast.makeText(getApplicationContext(), "succesful",
//                        Toast.LENGTH_LONG).show();
//                Intent i = new Intent(Register.this , Log_in.class);
//                startActivity(i);
                callsignupApi();


            }
        });


    }

    private void callsignupApi() {

        APIManager.getInstance().getAPI().register(email.getText().toString(), name.getText().toString(), name.getText().toString(), pass.getText().toString())
                .enqueue(new Callback<RegisterResponseModel>() {
                    @Override
                    public void onResponse(Call<RegisterResponseModel> call, Response<RegisterResponseModel> response) {


                        if (response.isSuccessful()) {


                            RegisterResponseModel msg = response.body();
                            Toast.makeText(getApplicationContext(), msg.getMessage(), Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Register.this, home1.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponseModel> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), "This is my Toast message!",
                                Toast.LENGTH_LONG).show();


                    }
                });
    }
}
/*if (pass.getText().toString().equals(conpass.getText().toString())){

                    users.add(new userdata(email.getText().toString(),name.getText().toString(),pass.getText().toString()));
                }
                Toast.makeText(getApplicationContext(), "succesful",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent(Register.this , home1.class);
                startActivity(i);*/