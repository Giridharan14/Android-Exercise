package com.giridharan.gplussignin;
import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

public class MainActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {
    String locatoion;    String name;
    String currentAccount;
    Person currentPerson;
        private static final String TAG = "MainActivity";
        private static final int RC_SIGN_IN = 1;
        private static final int RC_PERM_GET_ACCOUNTS = 2;
        private static final String KEY_IS_RESOLVING = "is_resolving";
        private static final String KEY_SHOULD_RESOLVE = "should_resolve";
        private GoogleApiClient mGoogleApiClient;
        private TextView mStatus;
        private boolean mIsResolving = false;
        private boolean mShouldResolve = false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            if (savedInstanceState != null) {
                mIsResolving = savedInstanceState.getBoolean(KEY_IS_RESOLVING);
                mShouldResolve = savedInstanceState.getBoolean(KEY_SHOULD_RESOLVE);
            }
            findViewById(R.id.sign_in_button).setOnClickListener(this);
            findViewById(R.id.sign_out_button).setOnClickListener(this);
            findViewById(R.id.disconnect_button).setOnClickListener(this);
            ((SignInButton) findViewById(R.id.sign_in_button)).setSize(SignInButton.SIZE_WIDE);
            findViewById(R.id.sign_in_button).setEnabled(false);
            mStatus = (TextView) findViewById(R.id.status);
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(Plus.API)
                    .addScope(new Scope(Scopes.PROFILE))
                    .addScope(new Scope(Scopes.EMAIL))
                    .build();
        }
        private void updateUI(boolean isSignedIn) {
            if (isSignedIn) {
                currentPerson = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
                locatoion = currentPerson.getCurrentLocation();
                if (currentPerson != null) {
                    name = currentPerson.getDisplayName();
                    mStatus.setText(getString(R.string.signed_in_fmt, name));
                    if (checkAccountsPermission()) {
                        currentAccount = Plus.AccountApi.getAccountName(mGoogleApiClient);
                        ((TextView) findViewById(R.id.email)).setText(currentAccount);
                    }
                } else {
                    Log.w(TAG, getString(R.string.error_null_person));
                    mStatus.setText(getString(R.string.signed_in_err));
                }
                findViewById(R.id.sign_in_button).setVisibility(View.GONE);
                findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
            } else {
                mStatus.setText(R.string.signed_out);
                ((TextView) findViewById(R.id.email)).setText("");
                findViewById(R.id.sign_in_button).setEnabled(true);
                findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
                findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
            }
        }
        private boolean checkAccountsPermission() {
            final String perm = Manifest.permission.GET_ACCOUNTS;
            int permissionCheck;
            permissionCheck = ContextCompat.checkSelfPermission(this, perm);
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, perm)) {
                return false;
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{perm},
                        RC_PERM_GET_ACCOUNTS);
                return false;
            }
        }
        private void showSignedInUI() {
            updateUI(true);
        }
        private void showSignedOutUI() {
            updateUI(false);
        }
        @Override
        protected void onStart() {
            super.onStart();
            mGoogleApiClient.connect();
        }
        @Override
        protected void onStop() {
            super.onStop();
            mGoogleApiClient.disconnect();
        }
        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putBoolean(KEY_IS_RESOLVING, mIsResolving);
            outState.putBoolean(KEY_SHOULD_RESOLVE, mShouldResolve);
        }
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Log.d(TAG, "onActivityResult:" + requestCode + ":" + resultCode + ":" + data);
            if (requestCode == RC_SIGN_IN) {
                if (resultCode != RESULT_OK) {
                    mShouldResolve = false;
                }
                mIsResolving = false;
                mGoogleApiClient.connect();
            }
        }
        @Override
        public void onRequestPermissionsResult(int requestCode,
                                               @NonNull String permissions[],
                                               @NonNull int[] grantResults) {
            Log.d(TAG, "onRequestPermissionsResult:" + requestCode);
            if (requestCode == RC_PERM_GET_ACCOUNTS) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showSignedInUI();
                } else {
                    Log.d(TAG, "GET_ACCOUNTS Permission Denied.");
                }
            }
        }
        @Override
        public void onConnected(Bundle bundle) {
            Log.d(TAG, "onConnected:" + bundle);
            mShouldResolve = false;

            showSignedInUI();
        }
        @Override
        public void onConnectionSuspended(int i) {
            Log.w(TAG, "onConnectionSuspended:" + i);
        }
        @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {
            Log.d(TAG, "onConnectionFailed:" + connectionResult);
            if (!mIsResolving && mShouldResolve) {
                if (connectionResult.hasResolution()) {
                    try {
                        connectionResult.startResolutionForResult(this, RC_SIGN_IN);
                        mIsResolving = true;
                    } catch (IntentSender.SendIntentException e) {
                        Log.e(TAG, "Could not resolve ConnectionResult.", e);
                        mIsResolving = false;
                        mGoogleApiClient.connect();
                    }
                } else {
                    showErrorDialog(connectionResult);
                }
            } else {
                showSignedOutUI();
            }
        }
        private void showErrorDialog(ConnectionResult connectionResult) {
            GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
            int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
            if (resultCode != ConnectionResult.SUCCESS) {
                if (apiAvailability.isUserResolvableError(resultCode)) {
                    apiAvailability.getErrorDialog(this, resultCode, RC_SIGN_IN,
                            new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialog) {
                                    mShouldResolve = false;
                                    showSignedOutUI();
                                }
                            }).show();
                } else {
                    Log.w(TAG, "Google Play Services Error:" + connectionResult);
                    String errorString = apiAvailability.getErrorString(resultCode);
                    Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show();

                    mShouldResolve = false;
                    showSignedOutUI();
                }
            }
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sign_in_button:
                    onSignInClicked();
                    break;
                case R.id.sign_out_button:
                    onSignOutClicked();
                    break;
                case R.id.disconnect_button:
                    onDisconnectClicked();
                    break;
            }
        }
        private void onSignInClicked() {
            mShouldResolve = true;
            mGoogleApiClient.connect();
            mStatus.setText(R.string.signing_in);
        }
        private void onSignOutClicked() {
            if (mGoogleApiClient.isConnected()) {
                Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                mGoogleApiClient.disconnect();
            }
            showSignedOutUI();
        }
        private void onDisconnectClicked() {
            Intent io=new Intent(MainActivity.this,Main2Activity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putString("ONE", name);
            bundle1.putString("TWO", currentAccount);
            bundle1.putString("Three", locatoion);
            bundle1.putString("Four", currentPerson.getImage().getUrl());
            io.putExtras(bundle1);
            startActivity(io);
        }
}
