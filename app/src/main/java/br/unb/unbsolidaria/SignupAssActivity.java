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

import br.unb.unbsolidaria.entidades.ValidaCadastro;

public class SignupAssActivity extends AppCompatActivity {
    private static final int RESULT_BACK = 2;
    private static final int RESULT_ASS_OK = 10;

    private EditText _nameText;         //Nome comercial
    private EditText _emailText;
    private EditText _passwordText;
    private EditText _rPasswordText;
    private Button _signupButton;
    private TextView _loginLink;
    private EditText _cnpjText;
    private EditText _websiteText;
    private EditText _addrText;
    private EditText _cepText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_ass);

        _nameText = (EditText) findViewById(R.id.input_name_ass);
        _emailText = (EditText) findViewById(R.id.input_email_ass);
        _passwordText = (EditText) findViewById(R.id.input_password_ass);
        _rPasswordText = (EditText) findViewById(R.id.input_retype_password_ass) ;
        _signupButton = (Button) findViewById(R.id.btn_signup_ass);
        _loginLink = (TextView) findViewById(R.id.link_login_ass);
        _cnpjText = (EditText) findViewById(R.id.input_cnpj_ass);
        _websiteText = (EditText) findViewById(R.id.input_site_ass);
        _addrText = (EditText) findViewById(R.id.input_address_ass);
        _cepText = (EditText) findViewById(R.id.input_cep_ass);

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

        final ProgressDialog progressDialog = ProgressDialog.show(this,null,"Entrando em contato com os moderadores...",true,false);

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        Toast.makeText(
                getApplicationContext(),
                "Pedido de Criação feito com suscesso. Em breve entraremos em contato",
                Toast.LENGTH_LONG).show();
        _signupButton.setEnabled(true);
        setResult(RESULT_ASS_OK, null);
        finish();
    }

    public void onSignupFailed() {

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String rPassword = _rPasswordText.getText().toString();
        String cnpj = _cnpjText.getText().toString();
        String cep = _cepText.getText().toString();
        String site = _websiteText.getText().toString();

        if (name.isEmpty() || name.length() > 20) {
            _nameText.setError("deve ter menos de 20 caracteres");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (!ValidaCadastro.isValidCNPJ(cnpj)) {
            _cnpjText.setError("insira um CNPJ válido");
            valid = false;
        } else {
            _cnpjText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("endereço de email inválido");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (!ValidaCadastro.isValidCEP(cep)) {
            _cepText.setError("insira um CEP válido");
            valid = false;
        } else {
            _cepText.setError(null);
        }

        if (android.util.Patterns.WEB_URL.matcher(site).matches() || site.isEmpty()) {
            _websiteText.setError(null);
        } else {
            _websiteText.setError("insira um website válido");
            valid = false;
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

        if (!valid) {
            Toast erro = new Toast(getApplicationContext()).makeText(getApplicationContext(),"Erro no cadastro, verifique se todos os campos estão corretos", Toast.LENGTH_SHORT);
            erro.show();
        }

        return valid;
    }
}
