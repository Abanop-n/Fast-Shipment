package com.example.android.fastshipv1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.Inflater;


public class Home_fragement extends Fragment {


    CustomAdapter adapter;
    EditText etfrom , etto;
    Button search;
    public ArrayList<Data> d = new ArrayList<>();
    ListView lv;
     @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home,container,false);

         search = (Button) view.findViewById(R.id.btsearch);
         etfrom = (EditText) view.findViewById(R.id.etfrom);
         etto = (EditText) view.findViewById(R.id.etto);


         for (int i = 0 ; i<3 ; i++){
             d.add(new Data("egy","eng","pop",4,24));

         }
         d.add(new Data("col","eng","pop",4,24));
         adapter = new CustomAdapter(getContext(),d);
         lv = (ListView) view.findViewById(R.id.lvdata);

         lv.setAdapter(adapter);
         search.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String f = etfrom.getText().toString();
                 String t = etto.getText().toString();
                 ArrayList<Data> da = new ArrayList<Data>();
                 for (int i =0 ; i< d.size() ; i++ ){
                     if(d.get(i).getFcountry().toString().equals(f) && d.get(i).getTocountry().toString().equals(t) ){
                         da.add(d.get(i));
                     }
                 }
                 CustomAdapter ad = new CustomAdapter(getContext() , d);
                 lv.setAdapter(ad);
             }
         });


         etto.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

             }

             @Override
             public void afterTextChanged(Editable s) {
                 String text = etfrom.getText().toString().toLowerCase(Locale.getDefault());
                 adapter.filter(text);

             }
         });






         return view;
    }
}
