package com.schedulerapp.gcm;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.schedulerapp.activities.MainActivity;

/*
 * Author - Sonny
 * Purpose - To initialize Google Cloud Messaging
 * IMPORTANT - Please refer the to the Google Play Services.docx file in the documentation folder to resolve any error
 */
public class GcmHandler {
	
	public static final String EXTRA_MESSAGE = "message";
    public static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    
    /**
     * Project number from the API Console.
     */
    String SENDER_ID = "653650036063";

    /**
     * Tag used on log messages.
     */
    static final String TAG = "GCMDemo";
    
    // Please refer the to the Google Play Services.docx file in the documentation folder to resolve this error
    GoogleCloudMessaging gcm;
    AtomicInteger msgId = new AtomicInteger();
    SharedPreferences prefs;
    Context context;
    
    String regid;
    
    public GcmHandler(Context context) {
    	
    	this.context = context;
    	
    	if(checkPlayServices()) {
			gcm = GoogleCloudMessaging.getInstance(context);
			regid = getRegistrationId(context);
			
			if(regid.isEmpty())
			{
				registerInBackground();
			}
		} else {
            Log.i(TAG, "No valid Google Play Services APK found.");
        }
    	
    }
    
    public String getRegistrationId(Context context) {
	    final SharedPreferences prefs = getGCMPreferences(context);
	    String registrationId = prefs.getString(PROPERTY_REG_ID, "");
	    if (registrationId.isEmpty()) {
	        Log.i(TAG, "Registration not found.");
	        return "";
	    }
	    
	    int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
	    int currentVersion = getAppVersion(context);
	    if (registeredVersion != currentVersion) {
	        Log.i(TAG, "App version changed.");
	        return "";
	    }
	   
	    return registrationId;
	}
    
    private SharedPreferences getGCMPreferences(Context context) {
    	
	    return context.getSharedPreferences(MainActivity.class.getSimpleName(),
	            Context.MODE_PRIVATE);
	}
    
    private boolean checkPlayServices() {
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
		
		if (resultCode != ConnectionResult.SUCCESS) {
			if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
				//GooglePlayServicesUtil.getErrorDialog(resultCode, context,
						//PLAY_SERVICES_RESOLUTION_REQUEST).show();
			} else {
				Log.i(TAG, "No valid Google Play Services APK found.");
			}
			return false;
		}
		return true;
	}
    
    private static int getAppVersion(Context context) {
	    try {
	        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
	        return packageInfo.versionCode;
	    } catch (NameNotFoundException e) {
	        // should never happen
	        throw new RuntimeException("Could not get package name: " + e);
	    }
	}
    
    private void registerInBackground() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
                    regid = gcm.register(SENDER_ID);
                    msg = "Device registered, registration ID=" + regid;

   
                    sendRegistrationIdToBackend();

                    storeRegistrationId(context, regid);
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                }
                return msg;
            }

            private void sendRegistrationIdToBackend() {
				// TODO Auto-generated method stub
				
			}

			@Override
            protected void onPostExecute(String msg) {
                // Registration Id is received here
            }
        }.execute(null, null, null);
    }
    
    private void storeRegistrationId(Context context, String regId) {
	    final SharedPreferences prefs = getGCMPreferences(context);
	    int appVersion = getAppVersion(context);
	    Log.i(TAG, "Saving regId on app version " + appVersion);
	    SharedPreferences.Editor editor = prefs.edit();
	    editor.putString(PROPERTY_REG_ID, regId);
	    editor.putInt(PROPERTY_APP_VERSION, appVersion);
	    editor.commit();
	}

}
