package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class MainActivity extends AppCompatActivity {

    private PinView pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog2, null);

        //((PinView) dialogView.findViewById(R.id.pinView)).setAnimationEnable(true);
        //((PinView) dialogView.findViewById(R.id.pinView)).setPasswordHidden(true);

        final TextView main_label = (TextView) findViewById(R.id.main_label) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(MainActivity.this);
                customDialog.callFunction(main_label);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog2 customDialog = new CustomDialog2(MainActivity.this);
                customDialog.setDialogListener(new CustomDialog2.CustomDialogListener() {
                    @Override
                    public void onPositiveClicked(String pinNum) {

                        if (pinNum.equals("1234")) {

                            Intent intent = new Intent(MainActivity.this, authenticationDone.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "인증 완료", Toast.LENGTH_LONG).show();
                            customDialog.dismiss();

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "핀 번호를 확인해주세요", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onNegativeClicked() {

                    }
                });
                customDialog.show();

            }
        });


    }
}

