package com.example.alertdialogradio;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.alertdialogradio.AlertDialogRadio.AlertPositiveListener;

public class MainActivity extends Activity implements AlertPositiveListener
{
	int position = 0; 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		OnClickListener listener = new OnClickListener()
		{
			@Override
			public void onClick ( View view )
			{
				FragmentManager manager = getFragmentManager();
				AlertDialogRadio radio = new AlertDialogRadio();
				Bundle b = new Bundle(); 
				b.putInt( "position", position );
				radio.setArguments(b);
				radio.show( manager, "alert_dialog_radio" );
			}
		};
		
		Button btn =  (Button) findViewById( R.id.cmdChoose );
		btn.setOnClickListener(listener);
	}

	@Override
	public void onPositiveClick(int position) 
	{
		this.position = position;
		TextView tv = (TextView) findViewById( R.id.android );
		tv.setText( "Your Choice : " + Android.code[this.position] );
	}
}