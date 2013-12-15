package com.qustom.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QustomDialogBuilder extends AlertDialog.Builder{

	/** The custom_body layout */
	private View mDialogView;
    private AlertDialog mDialog;
	
	/** optional dialog title layout */
	private TextView mTitle;
	/** optional alert dialog image */
	private ImageView mIcon;
	/** optional message displayed below title if title exists*/
	private TextView mMessage;
	/** The colored holo divider. You can set its color with the setDividerColor method */
	private View mDivider;
	
    public QustomDialogBuilder(Context context) {
        super(context);

        mDialogView = View.inflate(context, R.layout.qustom_dialog_layout, null);
        setView(mDialogView);

        mTitle = (TextView) mDialogView.findViewById(R.id.alertTitle);
        mMessage = (TextView) mDialogView.findViewById(R.id.message);
        mIcon = (ImageView) mDialogView.findViewById(R.id.icon);
        mDivider = mDialogView.findViewById(R.id.titleDivider);
	}

    /** 
     * Use this method to color the divider between the title and content.
     * Will not display if no title is set.
     * 
     * @param colorString for passing "#ffffff"
     */
    public QustomDialogBuilder setDividerColor(String colorString) {
    	mDivider.setBackgroundColor(Color.parseColor(colorString));
    	return this;
    }
 
    @Override
    public QustomDialogBuilder setTitle(CharSequence text) {
        mTitle.setText(text);
        return this;
    }

    public QustomDialogBuilder setTitleColor(String colorString) {
    	mTitle.setTextColor(Color.parseColor(colorString));
    	return this;
    }

    @Override
    public QustomDialogBuilder setMessage(int textResId) {
        mMessage.setText(textResId);
        return this;
    }

    @Override
    public QustomDialogBuilder setMessage(CharSequence text) {
        mMessage.setText(text);
        return this;
    }

    @Override
    public QustomDialogBuilder setIcon(int drawableResId) {
        mIcon.setImageResource(drawableResId);
        return this;
    }

    @Override
    public QustomDialogBuilder setIcon(Drawable icon) {
        mIcon.setImageDrawable(icon);
        return this;
    }
    
    /**
     * This allows you to specify a custom layout for the area below the title divider bar
     * in the dialog. As an example you can look at example_ip_address_layout.xml and how
     * I added it in TestDialogActivity.java
     * 
     * @param resId  of the layout you would like to add
     * @param context
     */
    public QustomDialogBuilder setCustomView(int resId, Context context) {
    	View customView = View.inflate(context, resId, null);
    	((FrameLayout)mDialogView.findViewById(R.id.customPanel)).addView(customView);
    	return this;
    }

    /**
     * Set a list of items to be displayed in the dialog as the content, you will be notified of the
     * selected item via the supplied listener. This should be an array type i.e. R.array.foo
     *
     * @return This Builder object to allow for chaining of calls to set methods
     */
    @Override
    public QustomDialogBuilder setItems(int itemsId, final DialogInterface.OnClickListener listener) {
        return setItems(getContext().getResources().getTextArray(itemsId), listener);
    }

    /**
     * Set a list of items to be displayed in the dialog as the content, you will be notified of the
     * selected item via the supplied listener.
     *
     * @return This Builder object to allow for chaining of calls to set methods
     */
    @Override
    public QustomDialogBuilder setItems(CharSequence[] items, final DialogInterface.OnClickListener listener) {
        LinearLayout itemList = (LinearLayout) mDialogView.findViewById(R.id.items_list);

        for (int i = 0; i < items.length; i++) {
            final int currentItem = i;
            View listItem = inflateItem(items[i].toString());
            itemList.addView(listItem);
            if (listener != null) {
                itemList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onClick(mDialog, currentItem);
                    }
                });
            }
        }

        return this;
    }

    private View inflateItem(String itemText) {
        View listItem = View.inflate(getContext(), R.layout.qustom_dialog_item_layout, null);
        TextView bestFriendNameTextView = (TextView) listItem.findViewById(R.id.item_text);
        bestFriendNameTextView.setText(itemText);
        return listItem;
    }

    private View inflateDivider(String itemText) {
        View listItem = View.inflate(getContext(), R.layout.qustom_dialog_item_layout, null);
        TextView bestFriendNameTextView = (TextView) listItem.findViewById(R.id.item_text);
        bestFriendNameTextView.setText(itemText);
        return listItem;
    }
    
    @Override
    public AlertDialog show() {
    	if (mTitle.getText().equals("")) mDialogView.findViewById(R.id.topPanel).setVisibility(View.GONE);
    	mDialog = super.show();
        return mDialog;
    }

}
