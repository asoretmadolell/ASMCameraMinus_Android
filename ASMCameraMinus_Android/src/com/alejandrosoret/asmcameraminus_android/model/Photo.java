package com.alejandrosoret.asmcameraminus_android.model;

import java.util.Date;

import com.alejandrosoret.asmcameraminus_android.db.CameraMinusDbContract;

import android.database.Cursor;

/*************************************************************/
/*                                                           */ 
/* Photo                                                     */ 
/* (c)2014 Alejandro                                         */ 
/*                                                           */ 
/* Description: Photo Class                                  */ 
/*              ASMCameraMinus_Android Project               */ 
/*                                                           */ 
/*                                                           */ 
/*************************************************************/
public class Photo
{
	private long id;
	private String title;
	private Date creationDate;
	private Date modifiedDate;
	private long width;
	private long height;
	private double weight;
	private double latitude;
	private double longitude;
	private double altitude;
	private String address;
	
	/*********************************************************/
	/*                                                       */ 
	/* Photo.Photo()                                         */ 
	/*                                                       */ 
	/*********************************************************/
	public Photo( long id, String title, Date creationDate, Date modifiedDate, long width, long height, double weight, double latitude, double longitude, double altitude, String address )
	{
		this.id = id;
		this.title = title;
		this.creationDate = creationDate;
		this.modifiedDate = modifiedDate;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.address = address;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* Photo.Photo()                                         */ 
	/*                                                       */ 
	/*********************************************************/
	public Photo( Cursor cursor )
	{
		this( 0, null, null, null, 0, 0, 0, 0, 0, 0, null );
		
		this.id = cursor.getLong( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry._ID ) );
		this.title = cursor.getString( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_TITLE ) );
		
		if ( !cursor.isNull( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_CREATION_DATE ) ) )
		{
			this.creationDate = new Date( cursor.getLong( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_CREATION_DATE ) ) );
		}
		
		if ( !cursor.isNull( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_MODIFIED_DATE ) ) )
		{
			this.modifiedDate = new Date( cursor.getLong( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_MODIFIED_DATE ) ) );
		}
		
		this.width = cursor.getLong( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WIDTH ) );
		this.height = cursor.getLong( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_HEIGHT ) );
		this.weight = cursor.getDouble( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WEIGHT ) );
		this.latitude = cursor.getDouble( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LATITUDE) );
		this.longitude = cursor.getDouble( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LONGITUDE ) );
		this.altitude = cursor.getDouble( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ALTITUDE ) );
		this.address = cursor .getString( cursor.getColumnIndex( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ADDRESS ) );
	}

	/*********************************************************/
	/*                                                       */ 
	/* Photo.getters                                         */ 
	/*                                                       */ 
	/*********************************************************/
	public long getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public Date getCreationDate()
	{
		return creationDate;
	}

	public Date getModifiedDate()
	{
		return modifiedDate;
	}

	public long getWidth()
	{
		return width;
	}

	public long getHeight()
	{
		return height;
	}

	public double getWeight()
	{
		return weight;
	}

	public double getLatitude()
	{
		return latitude;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public double getAltitude()
	{
		return altitude;
	}

	public String getAddress()
	{
		return address;
	}
}
