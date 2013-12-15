package com.qustom.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestDialogActivity extends Activity {

	private static final String HALLOWEEN_ORANGE = "#FF7F27";

	private OnClickListener mShowDialogClickListener =new OnClickListener(){
		public void onClick(View v){
			String[] sa = {"dog","cat"};
			QustomDialogBuilder qustomDialogBuilder = (QustomDialogBuilder) new QustomDialogBuilder(v.getContext())
					.setTitle("Set IP Address")
					.setTitleColor(HALLOWEEN_ORANGE)
					.setDividerColor(HALLOWEEN_ORANGE)
					.setMessage("You are now entering the 10th dimension.")
					.setCustomView(android.R.layout.example_ip_address_layout, v.getContext())
					.setIcon(getResources().getDrawable(android.R.drawable.ic_launcher))
                    .setItems(sa, null);
			
			qustomDialogBuilder.show();
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(android.R.layout.activity_main);
		Button bt = (Button)findViewById(android.R.id.button1);
		bt.setOnClickListener(mShowDialogClickListener);
	}


}
