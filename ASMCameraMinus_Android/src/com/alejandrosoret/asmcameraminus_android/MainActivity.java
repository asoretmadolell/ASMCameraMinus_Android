package com.alejandrosoret.asmcameraminus_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

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
	          TextView photoName = (TextView)view.findViewById( R.id.IDV_PHOTO_NAME );
	          TextView photoDescription = (TextView)view.findViewById( R.id.IDV_PHOTO_DESCRIPTION);
	          
	          Intent intent = new Intent( MainActivity.this, PhotoActivity.class );
	          Bundle extras = new Bundle();
	          extras.putString( ASMApplication.IDRC_PHOTO_NAME, (String) photoName.getText() );
	          extras.putString( ASMApplication.IDRC_PHOTO_DESCRIPTION, (String) photoDescription.getText() );
	          intent.putExtras( extras );
	          startActivity( intent );
          }
     }
}	
