package com.ttshrk.cp_sample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CPSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		buttonClick1();
        	}
        });
        
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		buttonClick2();
        	}
        });
        
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		buttonClick3();
        	}
        });
        
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		buttonClick4();
        	}
        });
    }

	/**
	 * gmailにContentProvider経由でassets内のイメージファイルを添付
	 */
    private void buttonClick1() {
    	Intent intent = new Intent(Intent.ACTION_SEND);
    	
    	// 起動するアプリを設定
    	intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
    	// subject
    	intent.putExtra(Intent.EXTRA_SUBJECT, "イメージファイルの添付");
    	// text
    	intent.putExtra(Intent.EXTRA_TEXT, "assets内のイメージファイルの添付");
    	
    	// attachment
    	// intent.setType("image/gif"); // 指定しなくても問題ないらしい
    	Uri uri = Uri.parse("content://com.ttshrk.provider.AssetFile/sample_01.gif");
    	intent.putExtra(Intent.EXTRA_STREAM, uri);
    	
    	Log.d("BUG", "a");
    	startActivity(intent);
    	Log.d("BUG", "b");
    }
    
	/**
	 * gmailにContentProvider経由でassets内のexcelファイルを添付
	 * 添付に失敗します。
	 */
	private void buttonClick2() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		
		// 起動するアプリを設定
		intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
		// subject
		intent.putExtra(Intent.EXTRA_SUBJECT, "excelファイルの添付");
		// text
		intent.putExtra(Intent.EXTRA_TEXT, "assets内のexcelファイルの添付");
		
		// attachment
		// intent.setType("application/vnd.ms-excel");
		Uri uri = Uri.parse("content://com.ttshrk.provider.AssetFile/sample_excel_01.xls");
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		
		startActivity(intent);
	}
	
	/**
	 * gmailにContentProvider経由でsdcardのexcelファイルを添付
	 */
	private void buttonClick3() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		
		// 起動するアプリを設定
		intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
		// subject
		intent.putExtra(Intent.EXTRA_SUBJECT, "excelファイルの添付");
		// text
		intent.putExtra(Intent.EXTRA_TEXT, "sdcardのexcelファイルの添付");
		
		// attachment
		// intent.setType("application/vnd.ms-excel"); // 指定しなくても問題ないらしい
		Uri uri = Uri.parse("content://com.ttshrk.provider.File/sample_excel_01.xls");
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		
		startActivity(intent);
	}
	
	/**
	 * ContentProviderを使わずに、sdcardのexcelファイルを添付
	 */
	private void buttonClick4() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		
		// 起動するアプリを設定
		intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGMail");
		// subject
		intent.putExtra(Intent.EXTRA_SUBJECT, "excelファイルの添付");
		
		// attachment
		//intent.setType("application/vnd.ms-excel");
		Uri uri = Uri.parse("file:///sdcard/sample_01.gif");
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		
		startActivity(intent);
	}
}