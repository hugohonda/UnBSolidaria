package br.unb.unbsolidaria;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupUserActivity extends AppCompatActivity {
    private static final int RESULT_BACK = 2;
    private static final int RESULT_USER_OK = 5;

    private EditText _nameText;
    private EditText _emailText;
    private EditText _passwordText;
    private EditText _rPasswordText;
    private Button _signupButton;
    private TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        _nameText = (EditText) findViewById(R.id.input_name_user);
        _emailText = (EditText) findViewById(R.id.input_email_user);
        _passwordText = (EditText) findViewById(R.id.input_password_user);
        _rPasswordText = (EditText) findViewById(R.id.input_retype_password_user);
        _signupButton = (Button) findViewById(R.id.btn_signup_user);
        _loginLink = (TextView) findViewById(R.id.link_login_user);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                setResult(RESULT_CANCELED,null);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        setResult(RESULT_BACK);
        return super.onKeyDown(keyCode, event);

    }

    public void signup() {
        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = ProgressDialog.show(this,null,"Criando Conta...",true,false);

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        // por enquanto, preenchendo os campos sob as devidas regras dará sempre sucesso no signup
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onSignupSuccess() {
        Toast.makeText(getApplicationContext(), "Conta criada com Sucesso!", Toast.LENGTH_LONG).show();
        _signupButton.setEnabled(true);
        setResult(RESULT_USER_OK, null);
        finish();
    }

    public void onSignupFailed() {

        _signupButton.setEnabled(true);
    }

    // faz validação das string obtidas a partir das pespectivas textBoxes
    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String rPassword = _rPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 4) {
            _nameText.setError("deve ter ao menos 4 caracteres");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("endereço inválido");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("deve ter entre 4 e 10 caracteres");
            valid = false;
        } else if(!rPassword.equals(password)){
            _passwordText.setError("senha incompatível, tente novamente");
            valid = false;
        } else{
            _passwordText.setError(null);
        }

        return valid;
    }
}
