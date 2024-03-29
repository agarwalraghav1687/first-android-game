package com.google.appinventor.components.runtime;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import java.util.LinkedList;
import java.util.Queue;

@SimpleObject
@DesignerComponent(category = ComponentCategory.SENSORS, description = "Non-visible component that can detect shaking and measure acceleration approximately in three dimensions using SI units (m/s<sup>2</sup>).  The components are: <ul>\n<li> <strong>xAccel</strong>: 0 when the phone is at rest on a flat      surface, positive when the phone is tilted to the right (i.e.,      its left side is raised), and negative when the phone is tilted      to the left (i.e., its right size is raised).</li>\n <li> <strong>yAccel</strong>: 0 when the phone is at rest on a flat      surface, positive when its bottom is raised, and negative when      its top is raised. </li>\n <li> <strong>zAccel</strong>: Equal to -9.8 (earth's gravity in meters per      second per second when the device is at rest parallel to the ground      with the display facing up,      0 when perpendicular to the ground, and +9.8 when facing down.       The value can also be affected by accelerating it with or against      gravity. </li></ul>", iconName = "images/accelerometersensor.png", nonVisible = true, version = 3)
public class AccelerometerSensor extends AndroidNonvisibleComponent implements OnStopListener, OnResumeListener, SensorComponent, SensorEventListener, Deleteable {
    private static final int SENSOR_CACHE_SIZE = 10;
    private static final double moderateShakeThreshold = 13.0d;
    private static final double strongShakeThreshold = 20.0d;
    private static final double weakShakeThreshold = 5.0d;
    private final Queue<Float> X_CACHE = new LinkedList();
    private final Queue<Float> Y_CACHE = new LinkedList();
    private final Queue<Float> Z_CACHE = new LinkedList();
    private Sensor accelerometerSensor;
    private int accuracy;
    private boolean enabled;
    private int minimumInterval;
    private int sensitivity;
    private final SensorManager sensorManager;
    private long timeLastShook;
    private float xAccel;
    private float yAccel;
    private float zAccel;

    public AccelerometerSensor(ComponentContainer container) {
        super(container.$form());
        this.form.registerForOnResume(this);
        this.form.registerForOnStop(this);
        this.enabled = true;
        this.sensorManager = (SensorManager) container.$context().getSystemService("sensor");
        this.accelerometerSensor = this.sensorManager.getDefaultSensor(1);
        startListening();
        MinimumInterval(400);
        Sensitivity(2);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The minimum interval, in milliseconds, between phone shakes")
    public int MinimumInterval() {
        return this.minimumInterval;
    }

    @DesignerProperty(defaultValue = "400", editorType = "non_negative_integer")
    @SimpleProperty
    public void MinimumInterval(int interval) {
        this.minimumInterval = interval;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "A number that encodes how sensitive the accelerometer is. The choices are: 1 = weak, 2 = moderate,  3 = strong.")
    public int Sensitivity() {
        return this.sensitivity;
    }

    @DesignerProperty(defaultValue = "2", editorType = "accelerometer_sensitivity")
    @SimpleProperty
    public void Sensitivity(int sensitivity2) {
        if (sensitivity2 == 1 || sensitivity2 == 2 || sensitivity2 == 3) {
            this.sensitivity = sensitivity2;
            return;
        }
        this.form.dispatchErrorOccurredEvent(this, "Sensitivity", ErrorMessages.ERROR_BAD_VALUE_FOR_ACCELEROMETER_SENSITIVITY, Integer.valueOf(sensitivity2));
    }

    @SimpleEvent
    public void AccelerationChanged(float xAccel2, float yAccel2, float zAccel2) {
        this.xAccel = xAccel2;
        this.yAccel = yAccel2;
        this.zAccel = zAccel2;
        addToSensorCache(this.X_CACHE, xAccel2);
        addToSensorCache(this.Y_CACHE, yAccel2);
        addToSensorCache(this.Z_CACHE, zAccel2);
        long currentTime = System.currentTimeMillis();
        if ((isShaking(this.X_CACHE, xAccel2) || isShaking(this.Y_CACHE, yAccel2) || isShaking(this.Z_CACHE, zAccel2)) && (this.timeLastShook == 0 || currentTime >= this.timeLastShook + ((long) this.minimumInterval))) {
            this.timeLastShook = currentTime;
            Shaking();
        }
        EventDispatcher.dispatchEvent(this, "AccelerationChanged", Float.valueOf(xAccel2), Float.valueOf(yAccel2), Float.valueOf(zAccel2));
    }

    @SimpleEvent
    public void Shaking() {
        EventDispatcher.dispatchEvent(this, "Shaking", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Available() {
        if (this.sensorManager.getSensorList(1).size() > 0) {
            return true;
        }
        return false;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Enabled() {
        return this.enabled;
    }

    private void startListening() {
        this.sensorManager.registerListener(this, this.accelerometerSensor, 1);
    }

    private void stopListening() {
        this.sensorManager.unregisterListener(this);
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void Enabled(boolean enabled2) {
        if (this.enabled != enabled2) {
            this.enabled = enabled2;
            if (enabled2) {
                startListening();
            } else {
                stopListening();
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public float XAccel() {
        return this.xAccel;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public float YAccel() {
        return this.yAccel;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public float ZAccel() {
        return this.zAccel;
    }

    private void addToSensorCache(Queue<Float> cache, float value) {
        if (cache.size() >= 10) {
            cache.remove();
        }
        cache.add(Float.valueOf(value));
    }

    private boolean isShaking(Queue<Float> cache, float currentValue) {
        float average = 0.0f;
        for (Float floatValue : cache) {
            average += floatValue.floatValue();
        }
        float average2 = average / ((float) cache.size());
        if (Sensitivity() == 1) {
            return ((double) Math.abs(average2 - currentValue)) > strongShakeThreshold;
        } else if (Sensitivity() == 2) {
            if (((double) Math.abs(average2 - currentValue)) <= moderateShakeThreshold || ((double) Math.abs(average2 - currentValue)) >= strongShakeThreshold) {
                return false;
            }
            return true;
        } else if (((double) Math.abs(average2 - currentValue)) <= weakShakeThreshold || ((double) Math.abs(average2 - currentValue)) >= moderateShakeThreshold) {
            return false;
        } else {
            return true;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.enabled) {
            float[] values = sensorEvent.values;
            this.xAccel = values[0];
            this.yAccel = values[1];
            this.zAccel = values[2];
            this.accuracy = sensorEvent.accuracy;
            AccelerationChanged(this.xAccel, this.yAccel, this.zAccel);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy2) {
    }

    public void onResume() {
        if (this.enabled) {
            startListening();
        }
    }

    public void onStop() {
        if (this.enabled) {
            stopListening();
        }
    }

    public void onDelete() {
        if (this.enabled) {
            stopListening();
        }
    }
}
