package com.softianstech.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 12/10/2017.
 */

public class Registration extends AppCompatActivity {

    int validate=0;

public String url,name ,email,phone,address,user,password;

EditText Name,Email,Phone,Address,User,Password,Confirm;
Spinner Spinner;
Button Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        Name=(EditText)findViewById(R.id.Name);
        Email=(EditText)findViewById(R.id.Email);
        Phone=(EditText)findViewById(R.id.Phone);
        Address=(EditText)findViewById(R.id.Address);
        User=(EditText)findViewById(R.id.User);
        Password=(EditText)findViewById(R.id.Password);
        Confirm=(EditText)findViewById(R.id.Confirm);
        Spinner=(Spinner)findViewById(R.id.Spinner);

        Register=(Button)findViewById(R.id.Register);



        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate=0;
                String designation=Spinner.getSelectedItem().toString();

                validation();

                if(validate>0)
                {
                    Toast.makeText(Registration.this, "Please Check the fields", Toast.LENGTH_SHORT).show();
                }

               else {


                    if (designation.equals("Librarian")) {

                        name = "l_name";
                        email = "l_email";
                        phone = "l_phone";
                        address = "l_phone";
                        user = "l_user_name";
                        password = "l_password";
                        url = Links.librarian_registration;

                        register();
                    }
                    else {

                        name = "s_name";
                        email = "s_email";
                        phone = "s_phone";
                        address = "s_phone";
                        user = "s_user_name";
                        password = "s_password";
                        url = Links.student_registration;

                        register();
                    }

                }


            }
        });

    }





    public void register()
    {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {








            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                                myPd_ring.dismiss();
                if (error instanceof NetworkError) {
                    Toast.makeText(Registration.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(Registration.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(Registration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(Registration.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(Registration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(Registration.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                }
                // counter++;
            }

            {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put(name, Name.getText().toString());
                parameters.put(email, Email.getText().toString());
                parameters.put(phone, Phone.getText().toString());
                parameters.put(address, Address.getText().toString());
                parameters.put(user, User.getText().toString());
                parameters.put(password, Password.getText().toString());




                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }



    public void validation()
    {
        if(Name.getText().toString().trim().equals(""))
        {
            Name.setError("please enter name");
            validate++;
        }

        if(Email.getText().toString().trim().equals(""))
        {
            Email.setError("please enter Email");
            validate++;
        }

        if(Phone.getText().toString().trim().equals(""))
        {
            Phone.setError("please enter Phone");
            validate++;
        }

        if(Address.getText().toString().trim().equals(""))
        {
            Address.setError("please enter Address");
            validate++;
        }

        if(User.getText().toString().trim().equals(""))
        {
            User.setError("please enter User Name");
            validate++;
        }

        if(Password.getText().toString().trim().equals(""))
        {
            Password.setError("please enter Password");
            validate++;
        }

        if(!Confirm.getText().toString().equals(Password.getText().toString()))
        {

            Confirm.setError("Password did not matched");
            validate++;
        }
    }

}
