package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.AppCompatEditText;

import com.chaos.view.PinView;

public class CustomDialog2 extends Dialog implements View.OnClickListener{

    private Context context;

    private CustomDialogListener customDialogListener;

    private Button confirmButton;
    private Button cancelButton;
    private PinView pinView;

    public CustomDialog2(Context context) {
        super(context);
        this.context = context;
    }

    interface CustomDialogListener{
        void onPositiveClicked(String pinNum);
        void onNegativeClicked();
    }

    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_dialog2);

        confirmButton = (Button)findViewById(R.id.okButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);
        pinView = (PinView)findViewById(R.id.pinView);

        confirmButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        pinView.setAnimationEnable(true);
        pinView.setPasswordHidden(true);
        pinView.setFocusable(true);
        pinView.setFocusableInTouchMode(true);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.okButton:
                String pin = pinView.getText().toString();
                customDialogListener.onPositiveClicked(pin);

                break;
            case R.id.cancelButton:
                cancel();
                break;
        }
    }

}

