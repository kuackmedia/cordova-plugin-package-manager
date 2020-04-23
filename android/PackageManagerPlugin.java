package com.kuack.plugins;

import java.lang.Integer;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;

import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;

public class PackageManagerPlugin extends CordovaPlugin {

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = cordova.getActivity().getApplicationContext();
        PackageManager pm = cordova.getActivity().getPackageManager();

        if ("hasSystemFeature".equals(action)) {
            String feature = parseFeatureArgument(args.getString(0));
            if (!feature.isEmpty()) {
                boolean hasFeature = pm.hasSystemFeature(feature);
                PluginResult result = new PluginResult(PluginResult.Status.OK, hasFeature);
                callbackContext.sendPluginResult(result);
            } else {
                PluginResult result = new PluginResult(PluginResult.Status.ERROR, "Feature '" + args.getString(0) + "' is not supported");
                callbackContext.sendPluginResult(result);
            }
        }

        else if ("isPackageInstalled".equals(action)) {
            boolean isInstalled = false;
            try {
                String packageName = args.getString(0);
                pm.getPackageInfo(packageName, 0);
                isInstalled = true;
            } catch (PackageManager.NameNotFoundException e) {
                // noop
            }
            PluginResult result = new PluginResult(PluginResult.Status.OK, isInstalled);
            callbackContext.sendPluginResult(result);
        }

        return false;
    }

    private String parseFeatureArgument(String feature) {
        switch (feature) {
            case "FEATURE_ACTIVITIES_ON_SECONDARY_DISPLAYS":
                return PackageManager.FEATURE_ACTIVITIES_ON_SECONDARY_DISPLAYS;
            case "FEATURE_APP_WIDGETS":
                return PackageManager.FEATURE_APP_WIDGETS;
            case "FEATURE_AUDIO_LOW_LATENCY":
                return PackageManager.FEATURE_AUDIO_LOW_LATENCY;
            case "FEATURE_AUDIO_OUTPUT":
                return PackageManager.FEATURE_AUDIO_OUTPUT;
            case "FEATURE_AUDIO_PRO":
                return PackageManager.FEATURE_AUDIO_PRO;
            case "FEATURE_AUTOFILL":
                return PackageManager.FEATURE_AUTOFILL;
            case "FEATURE_AUTOMOTIVE":
                return PackageManager.FEATURE_AUTOMOTIVE;
            case "FEATURE_BACKUP":
                return PackageManager.FEATURE_BACKUP;
            case "FEATURE_BLUETOOTH":
                return PackageManager.FEATURE_BLUETOOTH;
            case "FEATURE_BLUETOOTH_LE":
                return PackageManager.FEATURE_BLUETOOTH_LE;
            case "FEATURE_CAMERA":
                return PackageManager.FEATURE_CAMERA;
            case "FEATURE_CAMERA_ANY":
                return PackageManager.FEATURE_CAMERA_ANY;
            case "FEATURE_CAMERA_AR":
                return PackageManager.FEATURE_CAMERA_AR;
            case "FEATURE_CAMERA_AUTOFOCUS":
                return PackageManager.FEATURE_CAMERA_AUTOFOCUS;
            case "FEATURE_CAMERA_CAPABILITY_MANUAL_POST_PROCESSING":
                return PackageManager.FEATURE_CAMERA_CAPABILITY_MANUAL_POST_PROCESSING;
            case "FEATURE_CAMERA_CAPABILITY_MANUAL_SENSOR":
                return PackageManager.FEATURE_CAMERA_CAPABILITY_MANUAL_SENSOR;
            case "FEATURE_CAMERA_CAPABILITY_RAW":
                return PackageManager.FEATURE_CAMERA_CAPABILITY_RAW;
            case "FEATURE_CAMERA_EXTERNAL":
                return PackageManager.FEATURE_CAMERA_EXTERNAL;
            case "FEATURE_CAMERA_FLASH":
                return PackageManager.FEATURE_CAMERA_FLASH;
            case "FEATURE_CAMERA_FRONT":
                return PackageManager.FEATURE_CAMERA_FRONT;
            case "FEATURE_CAMERA_LEVEL_FULL":
                return PackageManager.FEATURE_CAMERA_LEVEL_FULL;
            case "FEATURE_CANT_SAVE_STATE":
                return PackageManager.FEATURE_CANT_SAVE_STATE;
            case "FEATURE_COMPANION_DEVICE_SETUP":
                return PackageManager.FEATURE_COMPANION_DEVICE_SETUP;
            case "FEATURE_CONNECTION_SERVICE":
                return PackageManager.FEATURE_CONNECTION_SERVICE;
            case "FEATURE_CONSUMER_IR":
                return PackageManager.FEATURE_CONSUMER_IR;
            case "FEATURE_DEVICE_ADMIN":
                return PackageManager.FEATURE_DEVICE_ADMIN;
            case "FEATURE_EMBEDDED":
                return PackageManager.FEATURE_EMBEDDED;
            case "FEATURE_ETHERNET":
                return PackageManager.FEATURE_ETHERNET;
            case "FEATURE_FAKETOUCH":
                return PackageManager.FEATURE_FAKETOUCH;
            case "FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT":
                return PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT;
            case "FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND":
                return PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND;
            case "FEATURE_FINGERPRINT":
                return PackageManager.FEATURE_FINGERPRINT;
            case "FEATURE_FREEFORM_WINDOW_MANAGEMENT":
                return PackageManager.FEATURE_FREEFORM_WINDOW_MANAGEMENT;
            case "FEATURE_GAMEPAD":
                return PackageManager.FEATURE_GAMEPAD;
            case "FEATURE_HIFI_SENSORS":
                return PackageManager.FEATURE_HIFI_SENSORS;
            case "FEATURE_HOME_SCREEN":
                return PackageManager.FEATURE_HOME_SCREEN;
            case "FEATURE_INPUT_METHODS":
                return PackageManager.FEATURE_INPUT_METHODS;
            case "FEATURE_LEANBACK":
                return PackageManager.FEATURE_LEANBACK;
            case "FEATURE_LEANBACK_ONLY":
                return PackageManager.FEATURE_LEANBACK_ONLY;
            case "FEATURE_LIVE_TV":
                return PackageManager.FEATURE_LIVE_TV;
            case "FEATURE_LIVE_WALLPAPER":
                return PackageManager.FEATURE_LIVE_WALLPAPER;
            case "FEATURE_LOCATION":
                return PackageManager.FEATURE_LOCATION;
            case "FEATURE_LOCATION_GPS":
                return PackageManager.FEATURE_LOCATION_GPS;
            case "FEATURE_LOCATION_NETWORK":
                return PackageManager.FEATURE_LOCATION_NETWORK;
            case "FEATURE_MANAGED_USERS":
                return PackageManager.FEATURE_MANAGED_USERS;
            case "FEATURE_MICROPHONE":
                return PackageManager.FEATURE_MICROPHONE;
            case "FEATURE_MIDI":
                return PackageManager.FEATURE_MIDI;
            case "FEATURE_NFC":
                return PackageManager.FEATURE_NFC;
            case "FEATURE_NFC_HOST_CARD_EMULATION":
                return PackageManager.FEATURE_NFC_HOST_CARD_EMULATION;
            case "FEATURE_NFC_HOST_CARD_EMULATION_NFCF":
                return PackageManager.FEATURE_NFC_HOST_CARD_EMULATION_NFCF;
            case "FEATURE_OPENGLES_EXTENSION_PACK":
                return PackageManager.FEATURE_OPENGLES_EXTENSION_PACK;
            case "FEATURE_PC":
                return PackageManager.FEATURE_PC;
            case "FEATURE_PICTURE_IN_PICTURE":
                return PackageManager.FEATURE_PICTURE_IN_PICTURE;
            case "FEATURE_PRINTING":
                return PackageManager.FEATURE_PRINTING;
            case "FEATURE_RAM_LOW":
                return PackageManager.FEATURE_RAM_LOW;
            case "FEATURE_RAM_NORMAL":
                return PackageManager.FEATURE_RAM_NORMAL;
            case "FEATURE_SCREEN_LANDSCAPE":
                return PackageManager.FEATURE_SCREEN_LANDSCAPE;
            case "FEATURE_SCREEN_PORTRAIT":
                return PackageManager.FEATURE_SCREEN_PORTRAIT;
            case "FEATURE_SECURELY_REMOVES_USERS":
                return PackageManager.FEATURE_SECURELY_REMOVES_USERS;
            case "FEATURE_SENSOR_ACCELEROMETER":
                return PackageManager.FEATURE_SENSOR_ACCELEROMETER;
            case "FEATURE_SENSOR_AMBIENT_TEMPERATURE":
                return PackageManager.FEATURE_SENSOR_AMBIENT_TEMPERATURE;
            case "FEATURE_SENSOR_BAROMETER":
                return PackageManager.FEATURE_SENSOR_BAROMETER;
            case "FEATURE_SENSOR_COMPASS":
                return PackageManager.FEATURE_SENSOR_COMPASS;
            case "FEATURE_SENSOR_GYROSCOPE":
                return PackageManager.FEATURE_SENSOR_GYROSCOPE;
            case "FEATURE_SENSOR_HEART_RATE":
                return PackageManager.FEATURE_SENSOR_HEART_RATE;
            case "FEATURE_SENSOR_HEART_RATE_ECG":
                return PackageManager.FEATURE_SENSOR_HEART_RATE_ECG;
            case "FEATURE_SENSOR_LIGHT":
                return PackageManager.FEATURE_SENSOR_LIGHT;
            case "FEATURE_SENSOR_PROXIMITY":
                return PackageManager.FEATURE_SENSOR_PROXIMITY;
            case "FEATURE_SENSOR_RELATIVE_HUMIDITY":
                return PackageManager.FEATURE_SENSOR_RELATIVE_HUMIDITY;
            case "FEATURE_SENSOR_STEP_COUNTER":
                return PackageManager.FEATURE_SENSOR_STEP_COUNTER;
            case "FEATURE_SENSOR_STEP_DETECTOR":
                return PackageManager.FEATURE_SENSOR_STEP_DETECTOR;
            case "FEATURE_SIP":
                return PackageManager.FEATURE_SIP;
            case "FEATURE_SIP_VOIP":
                return PackageManager.FEATURE_SIP_VOIP;
            case "FEATURE_STRONGBOX_KEYSTORE":
                return PackageManager.FEATURE_STRONGBOX_KEYSTORE;
            case "FEATURE_TELEPHONY":
                return PackageManager.FEATURE_TELEPHONY;
            case "FEATURE_TELEPHONY_CDMA":
                return PackageManager.FEATURE_TELEPHONY_CDMA;
            case "FEATURE_TELEPHONY_EUICC":
                return PackageManager.FEATURE_TELEPHONY_EUICC;
            case "FEATURE_TELEPHONY_GSM":
                return PackageManager.FEATURE_TELEPHONY_GSM;
            case "FEATURE_TELEPHONY_MBMS":
                return PackageManager.FEATURE_TELEPHONY_MBMS;
            case "FEATURE_TELEVISION":
                return PackageManager.FEATURE_TELEVISION;
            case "FEATURE_TOUCHSCREEN":
                return PackageManager.FEATURE_TOUCHSCREEN;
            case "FEATURE_TOUCHSCREEN_MULTITOUCH":
                return PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH;
            case "FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT":
                return PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT;
            case "FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND":
                return PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND;
            case "FEATURE_USB_ACCESSORY":
                return PackageManager.FEATURE_USB_ACCESSORY;
            case "FEATURE_USB_HOST":
                return PackageManager.FEATURE_USB_HOST;
            case "FEATURE_VERIFIED_BOOT":
                return PackageManager.FEATURE_VERIFIED_BOOT;
            case "FEATURE_VR_HEADTRACKING":
                return PackageManager.FEATURE_VR_HEADTRACKING;
            case "FEATURE_VR_MODE":
                return PackageManager.FEATURE_VR_MODE;
            case "FEATURE_VR_MODE_HIGH_PERFORMANCE":
                return PackageManager.FEATURE_VR_MODE_HIGH_PERFORMANCE;
            case "FEATURE_VULKAN_HARDWARE_COMPUTE":
                return PackageManager.FEATURE_VULKAN_HARDWARE_COMPUTE;
            case "FEATURE_VULKAN_HARDWARE_LEVEL":
                return PackageManager.FEATURE_VULKAN_HARDWARE_LEVEL;
            case "FEATURE_VULKAN_HARDWARE_VERSION":
                return PackageManager.FEATURE_VULKAN_HARDWARE_VERSION;
            case "FEATURE_WATCH":
                return PackageManager.FEATURE_WATCH;
            case "FEATURE_WEBVIEW":
                return PackageManager.FEATURE_WEBVIEW;
            case "FEATURE_WIFI":
                return PackageManager.FEATURE_WIFI;
            case "FEATURE_WIFI_AWARE":
                return PackageManager.FEATURE_WIFI_AWARE;
            case "FEATURE_WIFI_DIRECT":
                return PackageManager.FEATURE_WIFI_DIRECT;
            case "FEATURE_WIFI_PASSPOINT":
                return PackageManager.FEATURE_WIFI_PASSPOINT;
            case "FEATURE_WIFI_RTT":
                return PackageManager.FEATURE_WIFI_RTT;
            default:
                return feature;
        }
    }
}
