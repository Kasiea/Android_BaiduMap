package com.example.yeqinglu.map;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by yeqing.lu on 2016/9/5.
 */
class MyOrientationListener implements SensorEventListener {
    private SensorManager mSensorManager;
    private Context mContext;
    private Sensor mSensor;

    private float lastX;

    //构造函数
    public MyOrientationListener(Context context)
    {
        this.mContext = context;
    }

    public void start()
    {
        mSensorManager = (SensorManager)mContext.
                getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager  != null)
        {
            //获得方向传感器
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        }
        if (mSensor != null)
        {
            mSensorManager.registerListener(this,mSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }
    }

    public void stop()
    {
        mSensorManager.unregisterListener(this);

    }
    @Override
    //精度发生改变
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ORIENTATION)
        {
            float x = event.values[mSensorManager.DATA_X];

            if (Math.abs(x-lastX)>1.0)
            {
                if (mOnOritentionListener!= null)
                {
                    mOnOritentionListener.onOrientationChanged(x);
                }

            }
            lastX = x;
        }
    }

    public void setOnOrientationListener(OnOrientationListener mOnOrientionListener)
    {
        this.mOnOritentionListener = mOnOrientionListener;
    }
    private OnOrientationListener mOnOritentionListener;

    public interface OnOrientationListener
    {
        void onOrientationChanged(float x);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
