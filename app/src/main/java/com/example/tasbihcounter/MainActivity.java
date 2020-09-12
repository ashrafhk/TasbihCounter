package com.example.tasbihcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Vibrator mVibrator;
    boolean isTrueVibrator = true;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mytextview = findViewById(R.id.txtAdd);
        ImageButton btnCount = findViewById(R.id.count_btn);
        ImageButton reset = findViewById(R.id.reset_btn);
        final ImageButton TrueVibrator = findViewById(R.id.vib_btn);

        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTrueVibrator){
                    mVibrator.vibrate(100);
                }
                count++;
                mytextview.setText(""+count);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTrueVibrator){
                    mVibrator.vibrate(100);
                }
                count = 0;
                mytextview.setText(""+count);
            }
        });

        TrueVibrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVibrator.vibrate(100);
                if (isTrueVibrator){
                    isTrueVibrator = false;
                    TrueVibrator.setImageResource(R.drawable.ic_smartphone);
                }else {
                    isTrueVibrator = true;
                    TrueVibrator.setImageResource(R.drawable.ic_vibration);
                }
            }
        });
    }
}
