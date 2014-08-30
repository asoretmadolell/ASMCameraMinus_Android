package com.alejandrosoret.asmcameraminus_android;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alejandrosoret.asmcameraminus_android.adapters.PhotoAdapter;
import com.alejandrosoret.asmcameraminus_android.db.PhotoDAO;
import com.alejandrosoret.asmcameraminus_android.model.Photo;

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
	private ListView mList;
	private PhotoAdapter mAdapter;
	
	private ProgressBar mProgress;
	
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
		
		generateDummyPhoto();
		
		mProgress = (ProgressBar) findViewById( R.id.IDV_PROGRESSBAR );
		
		mList = (ListView) findViewById( R.id.IDV_PHOTO_LISTVIEW );
		mList.setOnItemClickListener( this );
				
		PhotoDAO dao = new PhotoDAO( MainActivity.this );
		Cursor photoCursor = dao.selectAllPhotos();
		
		mList.setAdapter( new PhotoAdapter( this, photoCursor ) );
	}

	private void generateDummyPhoto()
     {
		PhotoDAO dao = new PhotoDAO( this );
//		dao.deleteAll();
		Photo photo = new Photo( 0, "Titulo :D", null, null, 1024, 768, 20, 1.00, 1.00, 1.00, "" );
		dao.insert( photo );
     }

	/*********************************************************/
	/*                                                       */ 
	/* MainActivity.onItemClick()                            */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public void onItemClick( AdapterView< ? > parent, View view, int position, long id )
     {
		if( (ListView)parent == mList )
          {
	          Intent intent = new Intent( MainActivity.this, PhotoActivity.class );
	          intent.putExtra( ASMApplication.IDRC_PHOTO_ID, id );
	          startActivity( intent );
          }
     }
}	
