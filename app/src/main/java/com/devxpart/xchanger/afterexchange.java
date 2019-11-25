package com.devxpart.xchanger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class afterexchange extends Fragment {
    
    Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.afterexchange,container,false);

        btn=(Button)view.findViewById(R.id.afterorder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.container,new tracking());
                fr.commit();
            }
        });
        return view;
    }
    
    
    
}
