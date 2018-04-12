package se.lth.sartry.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;


public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView x;
    TextView y;
    TextView z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        x = findViewById(R.id.textViewX);
        y = findViewById(R.id.textViewY);
        z = findViewById(R.id.textViewZ);

    }


        protected void onResume() {
            super.onResume();
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        protected void onPause() {
            super.onPause();
            mSensorManager.unregisterListener(this);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
//    protected float[] lowPass( float[] input, float[] output ) {
//        if ( output == null ) return input;
//        for ( int i=0; i<input.length; i++ ) {
//            output[i] = output[i] + ALPHA * (input[i] - output[i]);
//        }
//        return output;
//    }
        @Override
        public void onSensorChanged(SensorEvent event) {

        DecimalFormat decimalf = new DecimalFormat("0.0000");

          x.setText("X: " + decimalf.format(event.values[0]));
          y.setText("Y: " + decimalf.format(event.values[1]));
          z.setText("Z: " + decimalf.format(event.values[2]));


        }


    }
