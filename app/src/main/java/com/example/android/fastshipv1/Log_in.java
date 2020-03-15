package com.example.android.fastshipv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Log_in extends AppCompatActivity {

    Button login;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        login = (Button) findViewById(R.id.btlog);
        email = (EditText) findViewById(R.id.etlogemail);
        pass = (EditText) findViewById(R.id.etlogpass);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String e = email.getText().toString();
//                String p = pass.getText().toString();
//                userdata u ;
//
//                for (int i =0 ; i < Register.users.size() ; i++){
//                    u = Register.users.get(i);
//                    if (u.getEmail().toString().equals(e) && u.getPass().toString().equals(p) && !p.isEmpty() && !e.isEmpty() ){
//                        Toast.makeText(getApplicationContext(), "Welcome",
//                                Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(Log_in.this , home1.class);
//                        startActivity(intent);
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(), "Failed",
//                                Toast.LENGTH_LONG).show();
//                    }
//
//                }
                calloginApi();

            }
        });
    }

    private void calloginApi() {
        APIManager.getInstance().getAPI().login(email.getText().toString(), pass.getText().toString())
                .enqueue(new Callback<userdata>() {
                    @Override
                    public void onResponse(Call<userdata> call, Response<userdata> response) {


                        if (response.isSuccessful()) {
                            userdata apiobject = response.body();
                            Intent i = new Intent(Log_in.this, home1.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onFailure(Call<userdata> call, Throwable t) {


                    }
                });
    }
}
