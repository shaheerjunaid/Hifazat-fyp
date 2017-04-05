package com.example.shaheer.hifazat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText etname = (EditText) findViewById(R.id.etname);
        final EditText etconnum = (EditText) findViewById(R.id.phonenumber);
        final EditText etpass = (EditText) findViewById(R.id.password2);
        final EditText etemail = (EditText) findViewById(R.id.emailadd);
        final EditText etadd = (EditText) findViewById(R.id.address);

        final Button btnreg = (Button) findViewById(R.id.register);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etname.getText().toString();
                final String contactnumber = etconnum.getText().toString();
                final String password = etpass.getText().toString();
                final String emailid = etemail.getText().toString();
                final String homeaddress = etadd.getText().toString();

                Response.Listener<String> resplsn = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonResp = new JSONObject(response);
                            boolean success = jsonResp.getBoolean("success");

                            if (success){
                                Intent intent=new Intent(SignUpActivity.this, LoginActivity.class);
                                SignUpActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }


                };
                RegisterRequest registerRequest = new RegisterRequest(name, contactnumber, password, emailid, homeaddress, resplsn);
                RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
                queue.add(registerRequest);

            }
        });
    }
}
