package com.alejandrosoret.asmcameraminus_android.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alejandrosoret.asmcameraminus_android.R;
import com.alejandrosoret.asmcameraminus_android.model.Photo;

/*************************************************************/
/*                                                           */ 
/* PhotoAdapter                                              */ 
/* (c)2014 Alejandro                                         */ 
/*                                                           */ 
/* Description: PhotoAdapter Class                           */ 
/*              ASMCameraMinus_Android Project               */ 
/*                                                           */ 
/*                                                           */ 
/*************************************************************/
public class PhotoAdapter extends CursorAdapter
{
	private Context context;

	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.PhotoAdapter()                           */ 
	/*                                                       */ 
	/*********************************************************/
	public PhotoAdapter( Context context, Cursor cursor )
	{
		super( context, cursor, false );
		this.context = context;
	}

	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.newView()                                */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public View newView( Context context, Cursor cursor, ViewGroup parent )
     {
		View itemLayout = null;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		itemLayout = inflater.inflate( R.layout.listview_photo_item, null );
		
	     return itemLayout;
     }

	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.bindView()                               */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public void bindView( View itemLayout, Context context, Cursor cursor )
     {
		final Photo photo = new Photo( cursor );
		
		TextView photoName = (TextView) itemLayout.findViewById( R.id.IDV_PHOTO_NAME );
		TextView photoDescription = (TextView) itemLayout.findViewById( R.id.IDV_PHOTO_DESCRIPTION );
		
		photoName.setText( photo.getTitle() );
		photoDescription.setText( "esto es una prueba" );
     }
}