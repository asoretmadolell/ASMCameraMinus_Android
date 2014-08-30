package com.alejandrosoret.asmcameraminus_android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alejandrosoret.asmcameraminus_android.model.Photo;

/*************************************************************/
/*                                                           */ 
/* PhotoDAO                                                  */ 
/* (c)2014 Alejandro                                         */ 
/*                                                           */ 
/* Description: PhotoDAO Class                               */ 
/*              ASMCameraMinus_Android Project               */ 
/*                                                           */ 
/*                                                           */ 
/*************************************************************/
public class PhotoDAO
{
	private CameraMinusDbHelper mDbHelper;
	private SQLiteDatabase mDb;
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.PhotoDAO()                                   */ 
	/*                                                       */ 
	/*********************************************************/
     // The constructor initializes an SQLiteOpenHelper object
	public PhotoDAO( Context context )
	{
		mDbHelper = new CameraMinusDbHelper( context );
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.insert()                                     */ 
	/*                                                       */ 
	/*********************************************************/
	// Inserts a new photo
	public long insert( Photo photo )
	{
		if( mDb == null || mDb.isReadOnly() )
          {
	          this.close();
	          mDb = mDbHelper.getWritableDatabase();
          }
		
		// Values to be inserted
		ContentValues values = new ContentValues();
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_TITLE, photo.getTitle() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_CREATION_DATE, photo.getCreationDate() == null ? null : photo.getCreationDate().getTime() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_MODIFIED_DATE, photo.getModifiedDate() == null ? null : photo.getModifiedDate().getTime() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WIDTH, photo.getWidth() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_HEIGHT, photo.getHeight() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WEIGHT, photo.getWeight() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LATITUDE, photo.getLatitude() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LONGITUDE, photo.getLongitude() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ALTITUDE, photo.getAltitude() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ADDRESS, photo.getAddress() );
		
		long newId = mDb.insert(
				CameraMinusDbContract.PhotoEntry.TABLE_NAME,
				null,
				values );
		
		return newId;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.selectAllPhotos                              */ 
	/*                                                       */ 
	/*********************************************************/
	// Returns all of the entries in the Photo table
	public Cursor selectAllPhotos()
	{
		if( mDb == null ) { mDb = mDbHelper.getReadableDatabase(); }
		
		// Defines the table to compile the query against
		String table = CameraMinusDbContract.PhotoEntry.TABLE_NAME;
		
		// Defines the columns that our query will return. Passing "null" will return all columns, which is discouraged to prevent reading data from storage that isn't going to be used.
		String[] columns = {
				CameraMinusDbContract.PhotoEntry._ID,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_TITLE,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_CREATION_DATE,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_MODIFIED_DATE,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WIDTH,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_HEIGHT,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WEIGHT,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LATITUDE,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LONGITUDE,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ALTITUDE,
				CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ADDRESS
		};
		
		// Defines a filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing "null" will return all rows for the given table.
		String selection = null;
		
		// Defines the values for the WHERE clause. We may include ?s in "selection", which will be replaced by the values from "selectionArgs", in order that they appear in the selection. The values will be bound as Strings.
		String[] selectionArgs = null;
		
		// Defines a filter declaring how to group rows, formatted as an SQL GROUP BY clause (excluding the GROUP BY itself). Passing "null" will cause the rows to not be grouped.
		String groupBy = null;
		
		// Defines a filter declaring which row groups to include in the cursor, if row grouping is being used, formatted as an SQL HAVING clause (excluding the HAVING itself). Passing "null" will cause all row groups to be included, and is required when row grouping is not being used.
		String having = null;
		
		// Defines the order in which our results will be returned, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing "null" will use the default sort order, which may be unordered.
		String orderBy = CameraMinusDbContract.PhotoEntry.COLUMN_NAME_CREATION_DATE + " DESC";
		
		// Queries the given table, returning a "Cursor" over the result set. "http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#query(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String)"
		Cursor cursor = mDb.query( table, columns, selection, selectionArgs, groupBy, having, orderBy );
		
		// A "Cursor" object, which is positioned before the first entry. Note that Cursors are not synchronized!
		return cursor;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.selectPhoto()                                */ 
	/*                                                       */ 
	/*********************************************************/
	// Returns a Photo matching the given ID
	public Photo selectPhoto( long photoId )
	{
		if( mDb == null ) { mDb = mDbHelper.getReadableDatabase(); }
		String table = CameraMinusDbContract.PhotoEntry.TABLE_NAME;
		String[] columns = { "*" }; // This is basically the same thing we did in selectAllPhotos(). "*" means "ALL". Obviously.
		String selection = CameraMinusDbContract.PhotoEntry._ID + " = ?" ;
		String[] selectionArgs = { "" + photoId }; // The way of the Samuel - Converting numbers to strings.
		String groupBy = null;
		String having = null;
		String orderBy = null;
		
		Cursor photoCursor = mDb.query( table, columns, selection, selectionArgs, groupBy, having, orderBy );
		
		Photo photo = null;
		if( photoCursor.moveToFirst() ) { photo = new Photo( photoCursor ); }
		
		return photo;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.delete()                                     */ 
	/*                                                       */ 
	/*********************************************************/
	// Deletes a database entry by ID (primary key).
	public int delete( long rowId )
	{
		if( mDb == null || mDb.isReadOnly() )
          {
	          this.close();
	          mDb = mDbHelper.getWritableDatabase();
          }
		
		// Defines the table to delete from.
		String table = CameraMinusDbContract.PhotoEntry.TABLE_NAME;
		
		// Defines the optional WHERE clause to apply when deleting. Passing "null" will delete all rows.
		String whereClause = CameraMinusDbContract.PhotoEntry._ID + " = ?";
		
		// Defines the values for the WHERE clause. You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings.
		String[] whereArgs = new String[] { "" + rowId };
		
		// Convenience method for deleting rows in the database. "http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#delete(java.lang.String, java.lang.String, java.lang.String[])"
		int count = mDb.delete( table, whereClause, whereArgs );
		
		// Returns the number of rows affected if a "whereClause" is passed in, 0 otherwise. To remove all rows and get a count pass "1" as the whereClause.
		return count;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.deleteAll()                                  */ 
	/*                                                       */ 
	/*********************************************************/
	// Deletes all the entries of a table.
	public int deleteAll()
	{
		if( mDb == null || mDb.isReadOnly() )
          {
	          this.close();
	          mDb = mDbHelper.getWritableDatabase();
          }
		
		// Same as before, only with "null" arguments.
		int count = mDb.delete( CameraMinusDbContract.PhotoEntry.TABLE_NAME, null, null );
		
		return count;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.update()                                     */ 
	/*                                                       */ 
	/*********************************************************/
	// Updates a Photo in the database.
	public int update( Photo photo )
	{
		if( mDb == null || mDb.isReadOnly() )
          {
	          this.close();
	          mDb = mDbHelper.getWritableDatabase();
          }
		
		// Defines the table to update in.
		String table = CameraMinusDbContract.PhotoEntry.TABLE_NAME;;
		
		// Defines a map from column names to new column values. "null" is a valid value that will be translated to NULL.
		ContentValues values = new ContentValues();
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_TITLE, photo.getTitle() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_CREATION_DATE, photo.getCreationDate() == null ? null : photo.getCreationDate().getTime() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_MODIFIED_DATE, photo.getModifiedDate() == null ? null : photo.getModifiedDate().getTime() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WIDTH, photo.getWidth() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_HEIGHT, photo.getHeight() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_WEIGHT, photo.getWeight() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LATITUDE, photo.getLatitude() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_LONGITUDE, photo.getLongitude() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ALTITUDE, photo.getAltitude() );
		values.put( CameraMinusDbContract.PhotoEntry.COLUMN_NAME_ADDRESS, photo.getAddress() );
		
		// Defines the optional WHERE clause to apply when updating. Passing null will update all rows.
		String whereClause = CameraMinusDbContract.PhotoEntry._ID + " = ?";
		
		// Defines the values for the WHERE clause. You may include ?s in the where clause, which will be replaced by the values from whereArgs. The values will be bound as Strings.
		String[] whereArgs = new String[] { "" + photo.getId() };
		
		// Convenience method for updating rows in the database. "http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#update(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[])"
		int count = mDb.update( table, values, whereClause, whereArgs );
		
		return count;
	}
	
	/*********************************************************/
	/*                                                       */ 
	/* PhotoDAO.close()                                      */ 
	/*                                                       */ 
	/*********************************************************/
	// Closes the connection to the database.
	public void close()
	{
		if( mDb != null )
          {
	          mDb.close();
	          mDb = null;
          }
	}
}
