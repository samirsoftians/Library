package com.softianstech.library;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Lenovo on 2/28/2017.
 */

public class CustomList extends ArrayAdapter<String> {
//    private String[] ids;
//    private String[] names;
//    private String[] emails;
//    private String[] ratings;



    public  String[] i_ids;
    public  String[] i_book_ids;
    public  String[] i_book_names;
    public  String[] i_book_authers;


    public  String[] i_student_names;
    public  String[] i_issued_bys;
    public  String[] i_student_emails;
    public  String[] i_student_phones;

    public  String[] i_issued_dates;
    public  String[] i_sub_dates;
    public  String[] i_submitted_dates;
    public  String[] i_reward_points;
    public  String[] i_fines;








    private Activity context;

    public CustomList(
            Activity context, String[] i_ids, String[] i_book_ids, String[] i_book_names, String[] i_book_authers,
                       String[] i_student_names, String[] i_issued_bys, String[] i_student_emails, String[] i_student_phones,
    String[] i_issued_dates, String[] i_sub_dates, String[] i_submitted_dates, String[] i_reward_points, String[] i_fines) {
        super(context, R.layout.first_page, i_ids);
        this.context = context;
        this.i_ids = i_ids;
        this.i_book_ids = i_book_ids;
        this.i_book_names = i_book_names;
        this.i_book_authers = i_book_authers;

        this.i_student_names = i_student_names;
        this.i_issued_bys = i_issued_bys;
        this.i_student_emails = i_student_emails;
        this.i_student_phones = i_student_phones;

        this.i_issued_dates = i_issued_dates;
        this.i_sub_dates = i_sub_dates;
        this.i_submitted_dates = i_submitted_dates;
        this.i_reward_points = i_reward_points;

        this.i_fines = i_fines;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.first_page, null, true);




        TextView book_name = (TextView) listViewItem.findViewById(R.id.book_name);
        TextView author = (TextView) listViewItem.findViewById(R.id.author);
        TextView student_name = (TextView) listViewItem.findViewById(R.id.student_name);

        TextView issued_date = (TextView) listViewItem.findViewById(R.id.issued_date);
        TextView phone = (TextView) listViewItem.findViewById(R.id.phone);
        TextView sub_date = (TextView) listViewItem.findViewById(R.id.sub_date);


       // TextView book_submitted_date = (TextView) listViewItem.findViewById(R.id.book_submitted_date);



        book_name.setText(i_book_names[position]);
        author.setText(i_book_authers[position]);
        student_name.setText(i_student_names[position]);
        issued_date.setText(i_issued_dates[position]);
        phone.setText(i_student_phones[position]);
        sub_date.setText(i_sub_dates[position]);
      //  book_submitted_date.setText(i_submitted_dates[position]);


        return listViewItem;
    }
}
