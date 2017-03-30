package com.bi.cisumib.views.custom.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.bi.cisumib.R;

/**
 * Created by lucius on 12/16/16.
 */

public class BaseDialog extends Dialog {
    public static int NO_TITLE = 0;
    public static int NORMAL_DIALOG = 1;

    private ViewGroup root;
    private Context context;

    public BaseDialog(Context context, int dialogMode) {
        super(context);
        this.context = context;
        if(dialogMode == 0){
            setNoTitle();
        }
        super.setContentView(R.layout.view_root_dialog);
        root = (ViewGroup) findViewById(R.id.root);
    }

    public void setContentView(int layout) {
        View view = getLayoutInflater().inflate(layout, root, false);
        root.addView(view);
    }

    public View getView(){
        return root.getChildAt(0);
    }

    public void setSize(int height, int width) {
        setHeight(height);
        setWidth(width);
    }

    public void setSize(float height, float width) {
        setHeight(height);
        setWidth(width);
    }

    public void setHeight(int height) {
        findViewById(R.id.root).getLayoutParams().height = height;
    }

    public void setWidth(int width) {
        findViewById(R.id.root).getLayoutParams().width = width;
    }

    public void setHeight(float height) {
        setHeight((int) (getScreenHeight() * height));
    }

    public void setWidth(float width) {
        setWidth((int) (getScreenWidth() * width));
    }

    public void setPadding(int padding) {
        setPadding(padding, padding, padding, padding);
    }

    public void setPadding(int left, int top, int right, int bottom) {
        root.setPadding(left, top, right, bottom);
    }

    private int getScreenWidth() {
        Point size = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }

    private int getScreenHeight() {
        Point size = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
        return size.y;
    }

    public void setNoTitle(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
