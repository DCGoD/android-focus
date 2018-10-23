package android.com.edibu.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.content.Context;
import android.app.Activity;


public class AndroidFocus extends CordovaPlugin {
    private CallbackContext callbackContext;
    private JSONObject data = new JSONObject();
    private boolean focus = false;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) 
    {
        this.focus = hasFocus;
    }


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("getFocus".equals(action)) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, this.focus);
            callbackContext.sendPluginResult(result);
            return true;
        }

        return false;  // Returning false results in a "MethodNotFound" error.
    }
}