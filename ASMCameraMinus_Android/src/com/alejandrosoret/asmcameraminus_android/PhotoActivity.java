package com.alejandrosoret.asmcameraminus_android;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class PhotoActivity extends ActionBarActivity
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
	     super.onCreate( savedInstanceState );
	     setContentView( R.layout.activity_photo );
	     
	     TextView photoName = (TextView)findViewById( R.id.IDV_PHOTO_NAME );
	     TextView photoDescription = (TextView)findViewById( R.id.IDV_PHOTO_DESCRIPTION );
	     
	     Bundle extras = getIntent().getExtras();
	     photoName.setText( extras.getString( "IDRC_PHOTO_NAME" ) );
	     photoDescription.setText( extras.getString( "IDRC_PHOTO_DESCRIPTION" ) );
	}
}
