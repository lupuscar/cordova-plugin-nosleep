package com.z2informatica.nosleep;

import android.content.Context;
import android.os.PowerManager;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

public class NoSleepPlugin extends CordovaPlugin {

    private PowerManager.WakeLock wakeLock;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("activate")) {
            this.activateNoSleep(callbackContext);
            return true;
        } else if (action.equals("deactivate")) {
            this.deactivateNoSleep(callbackContext);
            return true;
        }
        return false;
    }

    private void activateNoSleep(CallbackContext callbackContext) {
        if (wakeLock == null || !wakeLock.isHeld()) {
            PowerManager powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);
            wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "NoSleepPlugin:WakeLock");
            wakeLock.acquire();
            callbackContext.success("WakeLock activado");
        } else {
            callbackContext.success("WakeLock ya estaba activado");
        }
    }

    private void deactivateNoSleep(CallbackContext callbackContext) {
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
            wakeLock = null;
            callbackContext.success("WakeLock desactivado");
        } else {
            callbackContext.error("No había ningún WakeLock activo");
        }
    }
}
