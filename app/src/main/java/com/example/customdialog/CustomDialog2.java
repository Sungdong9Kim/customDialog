package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.AppCompatEditText;

import com.chaos.view.PinView;

public class CustomDialog2 extends AppCompatEditText{

    private Context context;

    public CustomDialog2(Context context) {
        super(context);
        this.context = context;
    }

    public void callFunction(final TextView main_label) {
        final Dialog dlg = new Dialog(context);

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dlg.setContentView(R.layout.custom_dialog2);

        dlg.show();

        final EditText message = (EditText) dlg.findViewById(R.id.mesgase);
        final Button okButton = (Button) dlg.findViewById(R.id.okButton);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton);
        final PinView pinView = (PinView) dlg.findViewById(R.id.pinView);

        //((PinView) findViewById(R.id.pinView)).setAnimationEnable(true);
        //((PinView) findViewById(R.id.pinView)).setPasswordHidden(true);

        pinView.setFocusable(true);
        pinView.setFocusableInTouchMode(true);

        pinView.setAnimationEnable(true);
        pinView.setPasswordHidden(true);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dlg.dismiss();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
            }
        });
    }
}

