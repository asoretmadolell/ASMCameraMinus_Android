package com.alejandrosoret.asmcameraminus_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alejandrosoret.asmcameraminus_android.R;

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
public class PhotoAdapter extends BaseAdapter
{
	private Context context;
	String[] photos = new String[] { "foto1", "foto2", "foto3", "foto4", "foto5", "foto6", "foto7", "foto8", "foto9" };
	String[] photoDescriptions = new String[] { "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9" };

	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.PhotoAdapter()                           */ 
	/*                                                       */ 
	/*********************************************************/
	public PhotoAdapter( Context context )
	{
		this.context = context;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.getCount()                               */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public int getCount()
     {
	     return photos.length;
     }

	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.getItem()                                */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public Object getItem( int position )
     {
	     return null;
     }

	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.getItemId()                              */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public long getItemId( int position )
     {
	     return position;
     }

	/*********************************************************/
	/*                                                       */ 
	/* PhotoAdapter.getView()                                */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
     public View getView( int position, View convertView, ViewGroup parent )
     {
		View itemView = null;
		if( convertView == null)
		{
			LayoutInflater inflater = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
			itemView = inflater.inflate( R.layout.listview_photo_item, null );
		}
		else itemView = convertView;
		
		TextView photoName = (TextView) itemView.findViewById( R.id.IDV_PHOTO_NAME );
		photoName.setText( photos[ position] );
		
		TextView photoDescription = (TextView) itemView.findViewById( R.id.IDV_PHOTO_DESCRIPTION );
		photoDescription.setText( photoDescriptions[ position ] );
		
	     return itemView;
     }
}