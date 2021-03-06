package com.example.shramona.uihackathon;
        import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity implements View.OnClickListener {

    public static final String REGISTER_URL = "https://transolver.000webhostapp.com/apis/register.php//:authKey/:empid/:name/:desig/:password";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PHONENUM = "phoneno";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";

    private EditText editTextUsername;
    private EditText editTextEmpid;
    private EditText editTextPassword;
    private EditText editTextDesig;

    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmpid = (EditText) findViewById(R.id.editTextEmpid);
        editTextDesig = (EditText) findViewById(R.id.editTextDesig);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
    }

    private void registerUser() {
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String empid = editTextEmpid.getText().toString().trim();
        final String desig = editTextDesig.getText().toString().trim();

        final String url = "https://transolver.000webhostapp.com/apis/register.php/" + empid + "/" + username + "/" + desig + "/" + password;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(registration.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(registration.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            /*
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                params.put(KEY_PHONENUM,phoneno);
                return params;
            }
            */
            public Map<String, String> getHeaders() throws Exception {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "Application");
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }




    @Override
    public void onClick(View v) {
        if (v == buttonRegister) {
            registerUser();
        }
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, empadd.class);

        startActivity(intent);}
}
