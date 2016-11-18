package com.giousa.eventdistribution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 *  注意：当ImageView不执行onClick方法并且clickable=false的时候，此时onTouch仅仅执行down方法。
    若是ImageView执行onClick或者clickable=true时，down-》move-》up，逐步执行。
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private Button mBtnTouch;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnTouch = (Button) findViewById(R.id.btn_touch);
        mImage = (ImageView) findViewById(R.id.iv_imageView);

        mBtnTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Button onclick");
            }
        });

        mBtnTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG,"Button action_down");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG,"Button action_move");
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.d(TAG,"Button action_up");
                        break;
                }
                return true;
            }

        });

//        mImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG,"ImageView onclick");
//            }
//        });

        mImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG,"ImageView action_down");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG,"ImageView action_move");
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.d(TAG,"ImageView action_up");
                        break;
                }
                return false;
            }
        });
    }
}
