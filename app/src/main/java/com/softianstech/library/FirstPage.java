package com.softianstech.library;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Lenovo on 12/8/2017.
 */

public class FirstPage extends AppCompatActivity {
    private ListView listView;
    String url2;
    String myString4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
       listView = (ListView) findViewById(R.id.list_item);
        Bundle bundle = null;
        bundle = this.getIntent().getExtras();
//        myString4 = bundle.getString("cemail3");
        url2 = "http://ranjana.000webhostapp.com/library/book_info.php";

        final ProgressDialog myPd_ring= ProgressDialog.show(FirstPage.this, "", "Please wait......", true);
        myPd_ring.setCancelable(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try
                {
                    Thread.sleep(10000);
                }catch(Exception e){

                }

            }
        }).start();

        //**************************************

        StringRequest stringRequest = new StringRequest(url2,new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                showJSON(response);
                myPd_ring.dismiss();
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        myPd_ring.dismiss();
                        if (error instanceof NetworkError)
                        {
                            Toast.makeText(FirstPage.this,"Cannot connect to Internet...Please check your connection!",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ServerError)
                        {
                            Toast.makeText(FirstPage.this,"The server could not be found. Please try again after some time!!",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof AuthFailureError)
                        {
                            Toast.makeText(FirstPage.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof ParseError)
                        {
                            Toast.makeText(FirstPage.this,"Parsing error! Please try again after some time !!",Toast.LENGTH_LONG ).show();

                        }
                        else if (error instanceof NoConnectionError)
                        {
                            Toast.makeText(FirstPage.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }
                        else if (error instanceof TimeoutError)
                        {
                            Toast.makeText(FirstPage.this,"Cannot connect to Internet...Please check your connection !",Toast.LENGTH_LONG ).show();
                        }




                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        //**************************************
    }
    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();//
        //Toast.makeText(this, ParseJSON.names, Toast.LENGTH_SHORT).show();
        CustomList cl = new CustomList(this, ParseJSON.i_ids,ParseJSON.i_book_ids,ParseJSON.i_book_names,ParseJSON.i_book_authers

                , ParseJSON.i_student_names,ParseJSON.i_issued_bys,ParseJSON.i_student_emails,ParseJSON.i_student_phones

                , ParseJSON.i_issued_dates,ParseJSON.i_sub_dates,ParseJSON.i_submitted_dates,ParseJSON.i_reward_points ,ParseJSON.i_fines );
        listView.setAdapter(cl);


    }
}
