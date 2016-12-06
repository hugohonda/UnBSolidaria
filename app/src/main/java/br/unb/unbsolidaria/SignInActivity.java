package br.unb.unbsolidaria;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import br.unb.unbsolidaria.entities.User;
import br.unb.unbsolidaria.entities.Voluntary;
import br.unb.unbsolidaria.organization.OrganizationScreen;
import br.unb.unbsolidaria.voluntary.VoluntaryScreen;


public class SignInActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private EditText _emailText;
    private EditText _passwordText;
    private Button _loginButton;
    private TextView _signupLink;

    public static final String LOGIN_MESSAGE = "br.unb.unbsolidaria.LOADUSER";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());

        _emailText = (EditText) findViewById(R.id.input_email);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _loginButton = (Button) findViewById(R.id.btn_login);
        _signupLink = (TextView) findViewById(R.id.link_signup);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = ProgressDialog.show(this, null, "Autenticando...", true, false);

        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO: Implement REST OATH here
                // local user account DB (see .persistency.Database)
                User user = User.getUserFromCredentials(email, password);
                if ( user != null ){
                    onLoginSuccess(user);
                } else {
                    onLoginFailed();
                }
                progressDialog.dismiss();
            }
        }, 3000);

    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess(User user) {
        Intent nextIntent;

        switch (user.getType()){
            case organization:
                nextIntent = new Intent(this, OrganizationScreen.class);
                break;
            case voluntary:
                nextIntent = new Intent(this, VoluntaryScreen.class);
                break;
            default:
                throw new RuntimeException("User type " + user.getType() + "  login handler does not exist");
        }
        nextIntent.putExtra(LOGIN_MESSAGE, user);
        startActivity(nextIntent);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getApplicationContext(), getString(R.string.error_login_auth), Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError(getString(R.string.error_field_required));
            valid = false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError(getString(R.string.error_invalid_email));
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty()) {
            _passwordText.setError(getString(R.string.error_field_required));
            valid = false;
        }
        if (password.length() < 4 || password.length() > 10) {
            _passwordText.setError(getString(R.string.error_incorrect_password));
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


}

