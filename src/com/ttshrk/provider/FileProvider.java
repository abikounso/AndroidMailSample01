package com.ttshrk.provider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;

public class FileProvider extends ContentProvider {
	
	public static final String AUTHORITY = "com.ttshrk.provider.File";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
	public static final String TAG = "FileProvider";
	
	@Override
    public boolean onCreate() {
    	return false;
    }

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	@Override
	public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
		String filepath = uri.getPath().substring(1);
		Log.i(TAG, "open file:" + filepath);
		URI path = URI.create("file:///sdcard/" + filepath);
		
		ParcelFileDescriptor parcel = ParcelFileDescriptor.open(new File(path), ParcelFileDescriptor.MODE_READ_ONLY);
		return parcel;
	}
	
}