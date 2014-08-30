package com.alejandrosoret.asmcameraminus_android.db;

import android.provider.BaseColumns;

/*************************************************************/
/*                                                           */ 
/* CameraMinusDbContract                                     */ 
/* (c)2014 Alejandro                                         */ 
/*                                                           */ 
/* Description: CameraMinusDbContract Class                  */ 
/*              ASMCameraMinus_Android Project               */ 
/*                                                           */ 
/*                                                           */ 
/*************************************************************/
public class CameraMinusDbContract
{
	/*************************************************************/
	/*                                                           */ 
	/* PhotoEntry                                                */ 
	/* (c)2014 Alejandro                                         */ 
	/*                                                           */ 
	/* Description: PhotoEntry Class                             */ 
	/*              ASMCameraMinus_Android Project               */ 
	/*                                                           */ 
	/*                                                           */ 
	/*************************************************************/
	public static abstract class PhotoEntry implements BaseColumns
	{
		public static final String TABLE_NAME = "photo";
		public static final String COLUMN_NAME_TITLE = "title";
		public static final String COLUMN_NAME_DESCRIPTION = "description";
		public static final String COLUMN_NAME_CREATION_DATE = "creationDate";
		public static final String COLUMN_NAME_MODIFIED_DATE = "modifiedDate";
		public static final String COLUMN_NAME_WIDTH = "width";
		public static final String COLUMN_NAME_HEIGHT = "height";
		public static final String COLUMN_NAME_WEIGHT = "weight";
		public static final String COLUMN_NAME_LATITUDE = "latitude";
		public static final String COLUMN_NAME_LONGITUDE = "longitude";
		public static final String COLUMN_NAME_ALTITUDE = "altitude";
		public static final String COLUMN_NAME_ADDRESS = "address";
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* CameraMinusDbContract.CameraMinusDbContract()         */ 
	/*                                                       */ 
	/*********************************************************/
	// Prevents this class from being instantiated.
	private CameraMinusDbContract() {}
}
