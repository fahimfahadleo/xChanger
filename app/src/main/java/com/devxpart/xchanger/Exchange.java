package com.devxpart.xchanger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Exchange extends Fragment {



    Spinner choosefrom,choostto;
    Button next;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exchange,container,false);


        choosefrom = view.findViewById(R.id.choosefrom);
        choostto = view.findViewById(R.id.chooseto);

        next = (Button)view.findViewById(R.id.nextbutton);
    
    
       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
    
               FragmentTransaction fr = getFragmentManager().beginTransaction();
               fr.replace(R.id.container,new afterexchange());
               fr.commit();
           }
       });
        



        List<String> list = new ArrayList<>();
        list.add("Paypal");


        ArrayAdapter<String> choosefromadapter =
                new ArrayAdapter<String>(getActivity(), R.layout.spinner_style, list)
                {

                    public View getView(int position, View convertView, ViewGroup parent) {
                        View v = super.getView(position, convertView, parent);

                        ((TextView) v).setTextSize(16);
                        ((TextView) v).setTextColor( getResources().getColorStateList(R.color.background));
                        return v;
                    }
                    public View getDropDownView(int position, View convertView, ViewGroup parent) {
                        View v = super.getDropDownView(position, convertView, parent);
                        ((TextView) v).setTextColor(getResources().getColorStateList(R.color.background) );
                        ((TextView) v).setPadding(30,30,30,30);
                        return v;
                    }
                };
        choosefrom.setAdapter(choosefromadapter);



        List<String> list2 = new ArrayList<>();
        list2.add("bKash");


        ArrayAdapter<String> choosetoadapter =
                new ArrayAdapter<String>(getActivity(), R.layout.spinner_style, list2)
                {

                    public View getView(int position, View convertView, ViewGroup parent) {
                        View v = super.getView(position, convertView, parent);

                        ((TextView) v).setTextSize(16);
                        ((TextView) v).setTextColor( getResources().getColorStateList(R.color.background));
                        return v;
                    }
                    public View getDropDownView(int position, View convertView, ViewGroup parent) {
                        View v = super.getDropDownView(position, convertView, parent);
                        ((TextView) v).setTextColor(getResources().getColorStateList(R.color.background) );
                        ((TextView) v).setPadding(30,30,30,30);
                        return v;
                    }
                };
        choostto.setAdapter(choosetoadapter);



        return view;
    }
    
    
}
