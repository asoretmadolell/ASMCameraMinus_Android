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
	     
	     TextView photoTitle = (TextView) findViewById( R.id.IDV_PHOTO_NAME );
	     TextView photoDescription = (TextView) findViewById( R.id.IDV_PHOTO_DESCRIPTION );
	     TextView photoCreationDate = (TextView) findViewById( R.id.IDV_PHOTO_CREATIONDATE );
	     TextView photoModifiedDate = (TextView) findViewById( R.id.IDV_PHOTO_MODIFIEDDATE );
	     TextView photoWidth = (TextView) findViewById( R.id.IDV_PHOTO_WIDTH );
	     TextView photoHeight= (TextView) findViewById( R.id.IDV_PHOTO_HEIGHT);
	     TextView photoWeight = (TextView) findViewById( R.id.IDV_PHOTO_WEIGHT);
	     TextView photoLatitude = (TextView) findViewById( R.id.IDV_PHOTO_LATITUDE );
	     TextView photoLongitude = (TextView) findViewById( R.id.IDV_PHOTO_LONGITUDE );
	     TextView photoAltitude = (TextView) findViewById( R.id.IDV_PHOTO_ALTITUDE );
	     TextView photoAddress = (TextView) findViewById( R.id.IDV_PHOTO_ADDRESS );
	     
	     long photoId = getIntent().getLongExtra( ASMApplication.IDRC_PHOTO_ID, -1 );
	     
	     if( photoId != -1 )
          {
	          PhotoDAO dao = new PhotoDAO( this );
	          Photo photo = dao.selectPhoto( photoId );
	          if( photo != null ) {
	          	photoTitle.setText( photo.getTitle() );
	          	photoDescription.setText( photo.getDescription() );
	          	photoCreationDate.setText( photo.getCreationDate().toString() );
	          	photoModifiedDate.setText( photo.getModifiedDate().toString() );
	          	photoWidth.setText( "" + photo.getWidth() );
	          	photoHeight.setText( "" + photo.getHeight() );
	          	photoWeight.setText( "" + photo.getWeight() );
	          	photoLatitude.setText( "" + photo.getLatitude() );
	          	photoLongitude.setText( "" + photo.getLongitude() );
	          	photoAltitude.setText( "" + photo.getAltitude() );
	          	photoAddress.setText( photo.getAddress() );
	          }
          }
	}
}
