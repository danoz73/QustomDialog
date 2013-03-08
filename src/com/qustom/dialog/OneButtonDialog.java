package com.qustom.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;


/**
 * An abstract class which subclasses AlertDialog. It displays a message
 * and an "Okay" button. doActionOkay() is an abstract method 
 * which is called when the "Okay" button is pressed.
 */
public abstract class OneButtonDialog extends AlertDialog {
	
	private String mMessage;
	
	/**
	 * EditTextDialog constructor.
	 * @param context
	 * @param message this Dialog's message
	 */
	protected OneButtonDialog(Context context, String message) {
		super(context);
		mMessage = message;
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setMessage(mMessage);
		setCancelable(true); // Sets whether this dialog is cancelable with the BACK key.
		
		setButton(DialogInterface.BUTTON_POSITIVE, "Okay", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
				doOkayAction();
			}
		});

		super.onCreate(savedInstanceState);
	}
	
	/**
	 * Action to be performed when the "Okay" button on the dialog is clicked.
	 */
	protected abstract void doOkayAction();
}
