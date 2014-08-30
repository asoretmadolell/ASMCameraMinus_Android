package com.alejandrosoret.asmcameraminus_android;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.alejandrosoret.asmcameraminus_android.db.PhotoDAO;
import com.alejandrosoret.asmcameraminus_android.model.Photo;

public class PhotoActivity extends ActionBarActivity
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
	     super.onCreate( savedInstanceState );
	     setContentView( R.layout.activity_photo );
	     
	     TextView photoName = (TextView)findViewById( R.id.IDV_PHOTO_NAME );
	     TextView photoDescription = (TextView)findViewById( R.id.IDV_PHOTO_DESCRIPTION );
	     
	     long photoId = getIntent().getLongExtra( ASMApplication.IDRC_PHOTO_ID, -1 );
	     
	     if( photoId != -1 )
          {
	          PhotoDAO dao = new PhotoDAO( this );
	          Photo photo = dao.selectPhoto( photoId );
	          if( photo != null ) { photoName.setText( photo.getTitle() ); }
          }
	}
}
