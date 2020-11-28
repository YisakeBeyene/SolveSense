package com.codepath.solvesense;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.luciferx86.doodlecanvaslibrary.DoodleCanvas;

public class WhiteboardFragment extends AppCompatActivity {

    public static final String TAG = "WhiteboardFragment";
    private DoodleCanvas canvas;

    View view; //setup when fragment
    Button whiteBtn;
    Button redBtn;
    Button yellowBtn;
    Button greenBtn;
    Button blueBtn;
    Button purpleBtn;
    Button erase;
    Button undo;
    Button clear;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiteboard_fragment);

        canvas = findViewById(R.id.canvas);

        final Animation bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);

        whiteBtn = findViewById(R.id.whiteBtn);
        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        greenBtn = findViewById(R.id.greenBtn);
        blueBtn = findViewById(R.id.blueBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        erase = findViewById(R.id.erase);
        undo = findViewById(R.id.undo);
        clear = findViewById(R.id.clear);
        save = findViewById(R.id.save);

        canvas.setStrokeColor(Color.WHITE);

        whiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whiteBtn.startAnimation(bounce);
                canvas.setStrokeColor(Color.WHITE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        whiteBtn.clearAnimation();
                    }
                }, 500);
            }
        });

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redBtn.startAnimation(bounce);
                canvas.setStrokeColor(Color.parseColor("#FF4444"));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        redBtn.clearAnimation();
                    }
                }, 500);
            }
        });

        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yellowBtn.startAnimation(bounce);
                canvas.setStrokeColor(Color.parseColor("#FFFF00"));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        yellowBtn.clearAnimation();
                    }
                }, 500);
            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenBtn.startAnimation(bounce);
                canvas.setStrokeColor(Color.parseColor("#03DAC5"));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        greenBtn.clearAnimation();
                    }
                }, 500);
            }
        });

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueBtn.startAnimation(bounce);
                canvas.setStrokeColor(Color.parseColor("#00DDFF"));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blueBtn.clearAnimation();
                    }
                }, 500);
            }
        });

        purpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purpleBtn.startAnimation(bounce);
                canvas.setStrokeColor(Color.parseColor("#AA66CC"));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        purpleBtn.clearAnimation();
                    }
                }, 500);
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                erase.startAnimation(bounce);
                canvas.setStrokeColor(Color.BLACK);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        erase.clearAnimation();
                    }
                }, 500);
            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undo.startAnimation(bounce);
                canvas.undoMove();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        undo.clearAnimation();
                    }
                }, 500);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear.startAnimation(bounce);
                canvas.clearCanvas();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clear.clearAnimation();
                    }
                }, 500);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.startAnimation(bounce);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        save.clearAnimation();
                    }
                }, 500);
            }
        });
    }
}