package com.qustom.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.qustom.dialog.R;

public class TestDialogActivity extends Activity {

	private static final String HALLOWEEN_ORANGE = "#FF7F27";

	private OnClickListener mShowDialogClickListener =new OnClickListener(){
		public void onClick(View v){
			QustomDialogBuilder qustomDialogBuilder = new QustomDialogBuilder(v.getContext()).
					setTitle("Set IP Address").
					setTitleColor(HALLOWEEN_ORANGE).
					setDividerColor(HALLOWEEN_ORANGE).
					setMessage("You are now entering the 10th dimension.").
					setCustomView(R.layout.example_ip_address_layout, v.getContext()).
					setIcon(getResources().getDrawable(R.drawable.ic_launcher));
			
			qustomDialogBuilder.show();
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt = (Button)findViewById(R.id.button1);
		bt.setOnClickListener(mShowDialogClickListener);
	}


}
