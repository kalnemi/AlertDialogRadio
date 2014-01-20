package com.example.alertdialogradio;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class AlertDialogRadio extends DialogFragment
{
	AlertPositiveListener alertPositiveListener;

	interface AlertPositiveListener 
	{
		public void onPositiveClick ( int position );
	}

	public void onAttach ( android.app.Activity activity )
	{
		super.onAttach(activity);
		try
		{
			alertPositiveListener = ( AlertPositiveListener ) activity;
		}
		catch ( Exception e ){ System.out.println ( "onAttaych : " + e.toString() ); }
	}

	OnClickListener positiveListener = new OnClickListener()
	{
		@Override
		public void onClick ( DialogInterface dialog, int which )
		{
			AlertDialog alert = (AlertDialog)dialog;
			int position = alert.getListView().getCheckedItemPosition();
			alertPositiveListener.onPositiveClick(position);
		}
	};

	@Override
	public Dialog onCreateDialog ( Bundle savedInstanceState )
	{
		Bundle bundle = getArguments();
		int position = bundle.getInt( "position" );
		
		AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
		b.setTitle( "Choose your version" );
		b.setSingleChoiceItems( Android.code, position, null );
		b.setPositiveButton( "OK", positiveListener );
		b.setNegativeButton( "Cancel", null );
		AlertDialog d = b.create();
		return d;
	}
}