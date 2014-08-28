package com.alejandrosoret.asmcameraminus_android.model;

import java.util.Date;

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
