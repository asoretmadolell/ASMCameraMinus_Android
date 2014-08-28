package com.alejandrosoret.asmcameraminus_android.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/*************************************************************/
/*                                                           */ 
/* CamereaMinusDbHelper                                      */ 
/* (c)2014 Alejandro                                         */ 
/*                                                           */ 
/* Description: CamereaMinusDbHelper Class                   */ 
/*              ASMCameraMinus_Android Project               */ 
/*                                                           */ 
/*                                                           */ 
/*************************************************************/
public class CameraMinusDbHelper extends SQLiteOpenHelper
{
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "CameraMinus.db";
	
	private static final String SQL_CREATE_TABLE_PHOTO =
			"CREATE TABLE " + CameraMinusDbContract.PhotoEntry.TABLE_NAME + " (" +
					CameraMinusDbContract.PhotoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_TITLE + " TEXT, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_CREATION_DATE + " DATE, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_MODIFIED_DATE + " DATE, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WIDTH + " INTEGER, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_HEIGHT + " INTEGER, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WEIGHT + " REAL, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LATITUDE + " REAL, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LONGITUDE + " REAL, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ALTITUDE + " REAL, " +
					CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ADDRESS + " TEXT" +
			" );";
	
	private static final String SQL_DROP_TABLE_PHOTO =
			"DROP TABLE IF EXISTS " + CameraMinusDbContract.PhotoEntry.TABLE_NAME + ";";

	/*********************************************************/
	/*                                                       */ 
	/* CamereaMinusDbHelper.CamereaMinusDbHelper()           */ 
	/*                                                       */ 
	/*********************************************************/
	public CameraMinusDbHelper( Context context, String name, CursorFactory factory, int version, DatabaseErrorHandler errorHandler )
     {
	     super( context, name, factory, version, errorHandler );
     }

	/*********************************************************/
	/*                                                       */ 
	/* CamereaMinusDbHelper.onCreate()                       */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
	public void onCreate( SQLiteDatabase db )
	{
		db.execSQL( SQL_CREATE_TABLE_PHOTO );
	}

	/*********************************************************/
	/*                                                       */ 
	/* CamereaMinusDbHelper.onUpgrade()                      */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
	public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
	{
		// Warning: This DB is erased when updating the app!
		db.execSQL( SQL_DROP_TABLE_PHOTO );
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* CamereaMinusDbHelper.onDowngrade()                    */ 
	/*                                                       */ 
	/*********************************************************/
	@Override
	public void onDowngrade( SQLiteDatabase db, int oldVersion, int newVersion )
	{
	     super.onDowngrade( db, oldVersion, newVersion );
	}
}
