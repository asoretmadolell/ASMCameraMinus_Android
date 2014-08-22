package com.alejandrosoret.asmcameraminus_android;

import java.util.ArrayList;
import java.util.Arrays;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*************************************************************/
/*                                                           */ 
/* MainActivity                                              */ 
/* (c)2014 Alejandro                                         */ 
/*                                                           */ 
/* Description: MainActivity Class                           */ 
/*              ASMCameraMinus_Android Project               */ 
/*                                                           */ 
/*                                                           */ 
/*************************************************************/
public class MainActivity extends ActionBarActivity
{
	
	private ListView mainListView;
	private ArrayAdapter< String > listAdapter;
	
	/*********************************************************/
	/*                                                       */ 
	/* MainActivity.onCreate()                               */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );
		
		mainListView = (ListView) findViewById( R.id.mainListView );
		
		// Create and populate a List of names. 
		String[] names = new String[] { "Alejandro", "Jorge", "Yvon", "Julian", "David", "Pablo", "Jose", "Jon", "Kofi" };
		ArrayList< String > nameList = new ArrayList<String>();
		nameList.addAll( Arrays.asList( names ) );
		
		// Create ArrayAdapter using the names list.
		listAdapter = new ArrayAdapter<String>( this, R.layout.listview_main_item, nameList );
		
		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter( listAdapter );
	}	
}
