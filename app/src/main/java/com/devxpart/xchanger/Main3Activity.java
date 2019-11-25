package com.devxpart.xchanger;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
public class Main3Activity extends AppCompatActivity {
	
	
	FrameLayout frameLayout;
	NavigationView nav;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		frameLayout=findViewById(R.id.container);
		TabLayout tabLayout=findViewById(R.id.tablayout);
		
		
		tabLayout.addTab(tabLayout.newTab().setText("Buy"));
		tabLayout.addTab(tabLayout.newTab().setText("Sell"));
		tabLayout.addTab(tabLayout.newTab().setText("Exchange"));
		tabLayout.addTab(tabLayout.newTab().setText("Rates"));
		nav = findViewById(R.id.navigation_drawer);
		nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				
				if(menuItem.getItemId()==R.id.home){
				
					startActivity(new Intent(Main3Activity.this,Home.class));
				}else if(menuItem.getItemId()==R.id.profile){
				
					startActivity(new Intent(Main3Activity.this,profile.class));
				}else if(menuItem.getItemId()==R.id.letest_transection){
					startActivity(new Intent(Main3Activity.this,History.class));
				}
				return true;
			}
		});
		
		FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
		fr.add(R.id.container,new buy());
		fr.commit();
		
		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
			
				if(tab.getPosition()==0){
					FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
					fr.add(R.id.container,new buy());
					fr.commit();
				}else if (tab.getPosition()==1) {
					FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
					fr.add(R.id.container,new sell());
					fr.commit();
				}
				else if (tab.getPosition()==2){
					FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
					fr.add(R.id.container,new Exchange());
					fr.commit();
				}
				else if (tab.getPosition()==3){
					FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
					fr.add(R.id.container,new rates());
					fr.commit();
				}
			}
			
			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
			
			}
			
			@Override
			public void onTabReselected(TabLayout.Tab tab) {
			
			}
		});
		
		
		View root = tabLayout.getChildAt(0);
		if (root instanceof LinearLayout) {
			((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
			GradientDrawable drawable = new GradientDrawable();
			drawable.setColor(getResources().getColor(R.color.white));
			drawable.setSize(2, 1);
			((LinearLayout) root).setDividerPadding(10);
			((LinearLayout) root).setDividerDrawable(drawable);
		}
		
	}
	
	
	

	
	
	
	
}
