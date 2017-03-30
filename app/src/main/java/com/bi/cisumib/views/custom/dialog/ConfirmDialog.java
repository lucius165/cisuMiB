package com.bi.cisumib.views.custom.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bi.cisumib.R;

/**
 * Created by lucius on 12/16/16.
 */

public class ConfirmDialog extends BaseDialog {
    private Context context;
    private OnDialogConfirm onDialogConfirm;
    private Dialog dialog;

    public ConfirmDialog(Context context) {
        this(context, context.getResources().getString(R.string.default_confirm));
    }

    public ConfirmDialog(Context context, String content) {
        this(context, content, null);

    }

    public ConfirmDialog(Context context, String content, OnDialogConfirm onDialogConfirm) {
        super(context, BaseDialog.NO_TITLE);
        this.context = context;
        this.dialog = this;
        setContentView(R.layout.view_confirm_dialog);
        setContentText(content);
        setOnDialogConfirm(onDialogConfirm);
        setWidth(0.9f);
        setPadding(10);
    }


    public void setContentText(String content) {
        ((TextView) findViewById(R.id.content)).setText(content);
    }

    public void setOnDialogConfirm(OnDialogConfirm event) {
        if (event == null) return;
        this.onDialogConfirm = event;
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDialogConfirm.onCancelClicked(dialog, view);
                cancel();
            }
        });

        findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDialogConfirm.onYesClicked(dialog, view);
                cancel();
            }
        });
    }

    public interface OnDialogConfirm {
        void onCancelClicked(Dialog dialog, View view);

        void onYesClicked(Dialog dialog, View view);
    }
}
