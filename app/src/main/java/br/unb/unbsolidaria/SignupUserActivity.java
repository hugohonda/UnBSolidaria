package br.unb.unbsolidaria;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.unb.unbsolidaria.communication.RestCommunication;
import br.unb.unbsolidaria.communication.VoluntaryService;
import br.unb.unbsolidaria.entities.RegisterValidation;
import br.unb.unbsolidaria.entities.Voluntary;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupUserActivity extends AppCompatActivity implements Callback<Voluntary> {
    private static final int RESULT_BACK = 2;
    private static final int RESULT_USER_OK = 5;

    private EditText _nameText;
    private EditText _emailText;
    private EditText _passwordText;
    private EditText _rPasswordText;
    private Button _signupButton;
    private TextView _loginLink;
    private EditText _cpfText;
    private EditText _cepText;
    private EditText _matriculaText;

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        _nameText = (EditText) findViewById(R.id.input_name_user);
        _cpfText = (EditText) findViewById(R.id.input_cpf_user);
        _matriculaText = (EditText) findViewById(R.id.input_matricula_user);
        _emailText = (EditText) findViewById(R.id.input_email_user);
        _passwordText = (EditText) findViewById(R.id.input_password_user);
        _rPasswordText = (EditText) findViewById(R.id.input_retype_password_user);
        _cepText = (EditText) findViewById(R.id.input_cep_user);
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
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });

        _cpfText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (_cpfText.getText().length() >= 11 && !RegisterValidation.isValidCPF(_cpfText.getText().toString())) {
                    _cpfText.setTextColor(Color.RED);
                    _cpfText.setError("insira um CPF válido");
                } else {
                    _cpfText.setTextColor(Color.BLACK);
                }
            }
        });

        _cepText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (_cepText.getText().length() >= 8 && !RegisterValidation.isValidCEP(_cepText.getText().toString())) {
                    _cepText.setTextColor(Color.RED);
                    _cepText.setError("insira um CEP válido");
                } else {
                    _cepText.setTextColor(Color.BLACK);
                }
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
        progressDialog = ProgressDialog.show(this, null, "Entrando em contato com os moderadores...", true, false);

        String name = _nameText.getText().toString();
        String cpf = _cpfText.getText().toString();
        String matricula = _matriculaText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        //Criar o servico do voluntario para fazer requests com essa entidade
        VoluntaryService voluntaryService = RestCommunication.createService(VoluntaryService.class);
        Call<Voluntary> call = voluntaryService.postVoluntary(
                new Voluntary("id", cpf, name, name, "", email, "", "", matricula, "", "", false));
        //Faz a chamada do request assincronamente
        call.enqueue(this);
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
        String cpf = _cpfText.getText().toString();
        String cep = _cepText.getText().toString();
        String matricula = _matriculaText.getText().toString();

        if (name.isEmpty() || name.length() > 20) {
            _nameText.setError("deve ter menos de 20 caracteres");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (!RegisterValidation.isValidCPF(cpf)) {
            _cpfText.setError("insira um CPF válido");
            valid = false;
        } else {
            _cpfText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("endereço inválido");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (!RegisterValidation.isValidCEP(cep)) {
            _cepText.setError("insira um CEP válido");
            valid = false;
        } else {
            _cepText.setError(null);
        }

        if (!RegisterValidation.isValidMatricula(matricula)) {
            _matriculaText.setError("insira sua matricula da UnB");
            valid = false;
        } else {
            _matriculaText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("deve ter entre 4 e 10 caracteres");
            valid = false;
        } else if (!rPassword.equals(password)) {
            _passwordText.setError("senha incompatível, tente novamente");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (valid == false) {
            Toast error = new Toast(getApplicationContext()).makeText(getApplicationContext(), "Erro no cadastro, verifique se todos os campos estão corretos", Toast.LENGTH_SHORT);
            error.show();
        }

        return valid;
    }

    @Override
    public void onResponse(Call<Voluntary> call, Response<Voluntary> response) {
        //Trata o caso que o request teve reply bem sucedido
        onSignupSuccess();
        progressDialog.dismiss();
    }

    @Override
    public void onFailure(Call<Voluntary> call, Throwable t) {
        //Trata o caso de falha no request
        onSignupSuccess();
        progressDialog.dismiss();
    }
}
