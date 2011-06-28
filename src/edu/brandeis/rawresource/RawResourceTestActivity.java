package edu.brandeis.rawresource;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class RawResourceTestActivity extends Activity {
	private static String TAG="pito";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView textview = (TextView) findViewById(R.id.textone);
        InputStream xmlfs = getResources().openRawResource(R.raw.hello);
        try {
        	int len = xmlfs.available();
			byte[] buffer = new byte[len];
			xmlfs.read(buffer);
			String s = new String(buffer);

			Log.v(TAG, Integer.toString(len));
        	Log.v(TAG, s);
			textview.setText(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}