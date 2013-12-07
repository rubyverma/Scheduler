package com.schedulerapp.activities;

import org.json.JSONException;
import org.json.JSONObject;

import com.schedulerapp.gcm.GcmHandler;
import com.schedulerapp.httprequests.HttpClient;
import com.schedulerapp.preferences.SessionStorage;
import com.schedulerapp.utils.UrlUtils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Author: Sonny K Raju
 */

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";
	private static final String TAG = "GCM";

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLoginTask mAuthTask = null;

	// Values for email and password at the time of the login attempt.
	private String mUsername;
	private String mPassword;

	// UI references.
	private EditText mUsernameView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;

	// GCM Handler
	GcmHandler gcmHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		// To initialize Google Cloud messaging service
		gcmHandler = new GcmHandler(this);
		Log.i(TAG, "GCM registered: " + gcmHandler);

		checkLoggedIn();
		
		// Set up the login form.
		mUsername = getIntent().getStringExtra(EXTRA_EMAIL);
		mUsernameView = (EditText) findViewById(R.id.email);
		mUsernameView.setText(mUsername);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin();
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null) {
			return;
		}

		// Reset errors.
		mUsernameView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mUsername = mUsernameView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mUsername)) {
			//mUsernameView.setError("Please enter your username");
			Toast.makeText(this, "Please enter your username", Toast.LENGTH_LONG).show();
			focusView = mUsernameView;
			cancel = true;
		} else if (TextUtils.isEmpty(mPassword)) {
			//mPasswordView.setError("Please enter your password");
			Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG).show();
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 1) {
			//mPasswordView.setError("Invalid password");
			Toast.makeText(this, "Invalid password", Toast.LENGTH_LONG).show();
			focusView = mPasswordView;
			cancel = true;
		}

		 /*
		 * else if (!mEmail.contains("@")) {
		 * mEmailView.setError(getString(R.string.error_invalid_email));
		 * focusView = mEmailView; cancel = true; }
		 */

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			mLoginStatusMessageView.setText(R.string.login_progress_signing_in);

			// create Json object for GeneralUser
			final JSONObject jsonObjectUser = new JSONObject();
			try {

				jsonObjectUser.put("username", mUsername);
				jsonObjectUser.put("password", mPassword);
				jsonObjectUser.put("gcmRegId", gcmHandler.getRegistrationId(this));

			} catch (JSONException e) {
				e.printStackTrace();
			}

			showProgress(true);
			mAuthTask = new UserLoginTask();
			mAuthTask.execute(jsonObjectUser);
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<JSONObject, Void, Boolean> {
		@Override
		protected Boolean doInBackground(JSONObject... user) {
			// authenticate against SchedulerWeb Service
			String result = "fail";
			JSONObject jObj = null;

			String response = HttpClient.SendHttpPost(UrlUtils.BASE_URL
					+ UrlUtils.USER_AUTHENTICATE, user[0]);
			try {
				if(response.equals(null)) {
					ServerUnAvailable();
				} else {
					jObj = new JSONObject(response);
					result = jObj.getString("result");
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			if (result.equals("success")) {

				SaveSession(jObj);
				return true;
			} else {
				return false;
			}
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;
			showProgress(false);

			if (success) {
				SuccessLogin();
				// finish();
			} else {
				FailedLogin();
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}

	public void SuccessLogin() {

		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);

	}

	private void FailedLogin() {

		Toast.makeText(this, "Login Failed. Please verify your credentials",
				Toast.LENGTH_LONG).show();
	}

	private void SaveSession(JSONObject jsonObject) {

		try {

			String userId = jsonObject.getString("userId");
			String username = jsonObject.getString("username");
			String fullname = jsonObject.getString("fullname");

			Log.d("SonnySP", "UserId: " + userId + ", Username: " + username);

			SessionStorage storage = new SessionStorage(this);
			storage.SavePreferences("userId", userId);
			storage.SavePreferences("username", username);
			storage.SavePreferences("fullname", fullname);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		checkLoggedIn();

	}
	
	public void checkLoggedIn() {

		// if already logged in, skip login activity
		SessionStorage storage = new SessionStorage(this);
		if (Integer.parseInt(storage.GetPreferences("userId")) > 0) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
	}
	
	private void ServerUnAvailable() {
		
		Log.d("Sonny", "Server unavailable");
		//Toast.makeText(this, "Server unavailable", Toast.LENGTH_LONG).show();
		
	}

}
