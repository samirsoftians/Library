package com.softianstech.library;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lenovo on 2/28/2017.
 */

public class ParseJSON {
    public static String[] i_ids;
    public static String[] i_book_ids;
    public static String[] i_book_names;
    public static String[] i_book_authers;


    public static String[] i_student_names;
    public static String[] i_issued_bys;
    public static String[] i_student_emails;
    public static String[] i_student_phones;

    public static String[] i_issued_dates;
    public static String[] i_sub_dates;
    public static String[] i_submitted_dates;
    public static String[] i_reward_points;
    public static String[] i_fines;

    public static final String JSON_ARRAY = "result";
    public static final String i_id = "i_id";
    public static final String i_book_id = "i_book_id";
    public static final String i_book_name = "i_book_name";
    public static final String i_book_auther = "i_book_auther";
    public static final String i_student_name = "i_student_name";
    public static final String i_issued_by = "i_issued_by";
    public static final String i_student_email = "i_student_email";
    public static final String i_student_phone = "i_student_phone";
    public static final String i_issued_date = "i_issued_date";
    public static final String i_sub_date = "i_sub_date";
    public static final String i_submitted_date = "i_submitted_date";
    public static final String i_reward_point = "i_reward_point";
    public static final String i_fine = "i_fine";
    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            i_ids = new String[users.length()];
            i_book_ids = new String[users.length()];
            i_book_names = new String[users.length()];
            i_book_authers = new String[users.length()];

            i_student_names = new String[users.length()];
            i_issued_bys = new String[users.length()];
            i_student_emails = new String[users.length()];
            i_student_phones = new String[users.length()];

            i_issued_dates = new String[users.length()];
            i_sub_dates = new String[users.length()];
            i_submitted_dates = new String[users.length()];
            i_reward_points = new String[users.length()];

            i_fines = new String[users.length()];


            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                i_ids[i] = jo.getString(i_id);
                i_book_ids[i] = jo.getString(i_book_id);
                i_book_names[i] = jo.getString(i_book_name);
                i_book_authers[i] = jo.getString(i_book_auther);


                i_student_names[i] = jo.getString(i_student_name);
                i_issued_bys[i] = jo.getString(i_issued_by);
                i_student_emails[i] = jo.getString(i_student_email);
                i_student_phones[i] = jo.getString(i_student_phone);

                i_issued_dates[i] = jo.getString(i_issued_date);
                i_sub_dates[i] = jo.getString(i_sub_date);
                i_submitted_dates[i] = jo.getString(i_submitted_date);
                i_reward_points[i] = jo.getString(i_reward_point);


                i_fines[i] = jo.getString(i_fine);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

//LoginRegister;
