package com.alejandrosoret.asmcameraminus_android;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alejandrosoret.asmcameraminus_android.adapters.PhotoAdapter;

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
public class MainActivity extends ActionBarActivity implements OnItemClickListener
{
	
	private ListView photoListView;
	
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
		
		photoListView = (ListView) findViewById( R.id.IDV_PHOTO_LISTVIEW );
		photoListView.setAdapter( new PhotoAdapter( this ) );
		photoListView.setOnItemClickListener( this );
	}

	/*********************************************************/
	/*                                                       */ 
	/* MainActivity.onItemClick()                            */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public void onItemClick( AdapterView< ? > parent, View view, int position, long id )
     {
		if( (ListView)parent == photoListView )
          {
	          TextView name = (TextView)view.findViewById( R.id.IDV_PHOTO_NAME );
	          Toast.makeText( this, name.getText(), Toast.LENGTH_LONG ).show();
          }
     }
}	
