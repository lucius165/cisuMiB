package com.bi.cisumib.global;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by lucius on 12/16/16.
 */

public class Show {
    public static void ToastSHORT(Context context, String content){
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void ToastLONG(Context context, String content){
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }

    public static void log(String tag, Class<?> content ){
        Log.e(tag+"", content+"");
    }
}
