package me.micrusa.amaztimer;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class defValues {
    //Format for times
    public final String timeFormat = "mm:ss";
    //Default sets and times
    public final int DEF_SETS = 8;
    public final int DEF_WORKTIME = 20;
    public final int DEF_RESTTIME = 10;
    //Vibration times
    public final int SHORT_VIBRATION = 100; //0.1s
    public final int LONG_VIBRATION = 700; //0.5s
    //Preparation times
    public final int SHORT_PREPARETIME = 5 * 1000;
    public final int LONG_PREPARETIME = 60 * 1000;
    //Sensor value and sensor delay
    public final int HRSENSOR_DELAY = SensorManager.SENSOR_DELAY_FASTEST;
    public final int HRSENSOR = Sensor.TYPE_HEART_RATE;
    public final int[] ACCURACY_RANGE = {1, 3};
    //Max and min values
    public final int MIN_SETS = 1;
    public final int MAX_SETS = 99;
    public final int MIN_TIME = 1; //1s
    public final int MAX_TIME = 900; //15m
    //Default values
    public final String DEFAULT_LANG = "en";
    public final Boolean DEFAULT_LONGPREPARE = false;
    public final boolean DEFAULT_BATTERYSAVING = false;
    public final boolean DEFAULT_HRSWITCH = true;
    public final boolean DEFAULT_REPSMODE = false;
    public final int DEFAULT_WEIGHT = 70;
    public final int DEFAULT_AGE = 20;
    public final boolean DEFAULT_MALE = true;
    public final int DEFAULT_HR_VALUES = 0;
    public final int DEFAULT_KCAL_VALUES = 0;
    //Files name
    //They're in different files bc sometimes they have conflicts if they're all in the same file
    public final String TIMER_FILE = "amaztimer";
    public final String SETTINGS_FILE = "settings";
    public final String LATEST_TRAIN_FILE = "latesttrain";
    public final String BODY_FILE = "bodysettings";
    //Settings names
    public final String SETTINGS_SETS = "sets";
    public final String SETTINGS_WORK = "work";
    public final String SETTINGS_REST = "rest";
    public final String SETTINGS_BATTERYSAVING = "batterySaving";
    public final String SETTINGS_HRSWITCH = "hrEnabled";
    public final String SETTINGS_LANG = "lang";
    public final String SETTINGS_WEIGHT = "weight";
    public final String SETTINGS_AGE = "age";
    public final String SETTINGS_MALE = "gender";
    public final String SETTINGS_AVGHR = "avghr";
    public final String SETTINGS_MINHR = "minhr";
    public final String SETTINGS_MAXHR = "maxhr";
    public final String SETTINGS_KCAL = "kcal";
    public final String SETTINGS_LONGPREPARE = "longprep";
    public final String SETTINGS_REPSMODE = "repsmode";
    //Settings keys
    public final String KEY_BATTERYSAVING = "batterySaving";
    public final String KEY_HRTOGGLE = "hrOn";
    public final String KEY_LANG = "lang";
    public final String KEY_GENDER = "gender";
    public final String KEY_AGE = "age";
    public final String KEY_WEIGHT = "weight";
    public final String KEY_LONGPREPARE = "huamiactivity";
    public final String KEY_REPSMODE = "repsmode";
    public final String KEY_SAVED = "saved";
    public final String KEY_LATESTTRAIN = "latesttrain";
    public final String KEY_APPINFO = "appinfo";
    //Some useful stuff
    public final String VERSION_NAME = "v" + BuildConfig.VERSION_NAME;
    public final int VERSION_CODE = BuildConfig.VERSION_CODE;
    @SuppressLint("SimpleDateFormat")
    public final int CURRENT_YEAR = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
}
