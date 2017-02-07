package com.ownchan.popwindowdemo;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Author: Owen Chan
 * DATE: 2017-02-07.
 */

public class CustomPopWindow extends PopupWindow {
    private CallBack mCallBack;
    private View dropDownView;


    public CustomPopWindow(View contentView, View dropDownView) {
        this.dropDownView = dropDownView;
        setContentView(contentView);

        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new ColorDrawable(0x00000000));
        setFocusable(false);
        setAnimationStyle(R.style.anim_menu_bottom);

        final TextView allDynamic = (TextView) contentView.findViewById(R.id.all);
        final TextView releasedPost = (TextView) contentView.findViewById(R.id.mine);
        allDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onStateChanged(0);
                dismiss();
            }
        });

        releasedPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onStateChanged(1);
                dismiss();
            }
        });
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    void showPopWindow() {
        if (isShowing()) {
            return;
        }
        showAsDropDown(dropDownView, 0, 0);
        //showAsDropDown(dropDownView);
        //showAtLocation(dropDownView, Gravity.CENTER, 0, 0);
    }

    void setCallBack(CallBack callBack) {
        this.mCallBack = callBack;
    }

    interface CallBack {
        void onStateChanged(int state);
    }

}
