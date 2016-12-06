package br.unb.unbsolidaria;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.unb.unbsolidaria.entities.RegisterValidation;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private static final int RESULT_BACK = 2;
    private static final int RESULT_ASS_OK = 10;

    private EditText _nameText;
    private EditText _emailText;
    private EditText _passwordText;
    private EditText _rPasswordText;
    private Button _signupButton;
    private TextView _loginLink;
    private EditText _addrText;
    private EditText _cepText;

    private LinearLayout base_layout;
    private Spinner _AccountTypeChooser;
    private int lastSelectedItem = -1;
    private View orgForm;
    private View volForm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_base);

        base_layout = (LinearLayout) findViewById(R.id.su_baselayout);
        LayoutInflater inflater_service = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        orgForm = inflater_service.inflate(R.layout.activity_signup_ass, null);
        volForm = inflater_service.inflate(R.layout.activity_signup_vol, null);

        base_layout.addView(volForm, 1);
        // Warning: if base_layout is not set to volForm View first than cpfText will be null.
        EditText cpfText = (EditText) findViewById(R.id.input_cpf);
        cpfText.addTextChangedListener(new LoginTextWatcher(cpfText));

        _AccountTypeChooser = (Spinner) findViewById(R.id.su_sAccountType);
        _AccountTypeChooser.setOnItemSelectedListener(this);

        _nameText = (EditText) findViewById(R.id.input_name);
        _emailText = (EditText) findViewById(R.id.input_email);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _rPasswordText = (EditText) findViewById(R.id.input_retype_password);
        _addrText = (EditText) findViewById(R.id.input_address);
        _cepText = (EditText) findViewById(R.id.input_cep);

        _signupButton = (Button) findViewById(R.id.btn_signup);
        _loginLink = (TextView) findViewById(R.id.link_login);

        _cepText.addTextChangedListener(new LoginTextWatcher(_cepText));
    }

    public void signup() {
        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = ProgressDialog.show(this, null, "Requisição em andamento...", true, false);

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
        String sucessText = "";

        if (lastSelectedItem == 0)
            sucessText = "Conta criada com Sucesso!";
        else if (lastSelectedItem == 1)
            sucessText = "Pedido de Criação feito com suscesso. Em breve entraremos em contato";

        Toast.makeText(getApplicationContext(),  sucessText, Toast.LENGTH_LONG).show();
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
        String cep = _cepText.getText().toString();

        if (name.isEmpty() || name.length() > 20) {
            _nameText.setError("deve ter menos de 20 caracteres");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("endereço de email inválido");
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

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("deve ter entre 4 e 10 caracteres");
            valid = false;
        } else if (!rPassword.equals(password)) {
            _passwordText.setError("senha incompatível, tente novamente");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (lastSelectedItem == 0)
            valid = validate_ass();
        else if (lastSelectedItem == 1)
            valid = validate_vol();

        if (!valid) {
            Toast erro = new Toast(getApplicationContext()).makeText(getApplicationContext(), "Erro no cadastro, verifique se todos os campos estão corretos", Toast.LENGTH_SHORT);
            erro.show();
        }

        return valid;
    }

    public boolean validate_ass(){
        boolean valid = true;

        EditText cpfcpnjText = (EditText) findViewById(R.id.input_cpf_cnpj);
        EditText websiteText = (EditText) findViewById(R.id.input_site);

        String cnpj = cpfcpnjText.getText().toString();
        String site = websiteText.getText().toString();


        if (!RegisterValidation.isValidCNPJ(cnpj)) {
            cpfcpnjText.setError("insira um CNPJ válido");
            valid = false;
        } else {
            cpfcpnjText.setError(null);
        }

        if (android.util.Patterns.WEB_URL.matcher(site).matches() || site.isEmpty()) {
            websiteText.setError(null);
        } else {
            websiteText.setError("insira um website válido");
            valid = false;
        }

        return valid;
    }

    public boolean validate_vol(){
        boolean valid = true;

        EditText cpfcpnjText = (EditText) findViewById(R.id.input_cpf_cnpj);
        EditText matriculaText = (EditText) findViewById(R.id.input_matricula);

        String cpf = cpfcpnjText.getText().toString();
        String matricula = matriculaText.getText().toString();

        if (!RegisterValidation.isValidCPF(cpf)) {
            cpfcpnjText.setError("insira um CPF válido");
            valid = false;
        } else {
            cpfcpnjText.setError(null);
        }

        if (!RegisterValidation.isValidMatricula(matricula)) {
            matriculaText.setError("matricula da UnB inválida");
            valid = false;
        } else {
            matriculaText.setError(null);
        }

        return valid;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (view.getId()){
            case R.id.su_sAccountType:
                if (lastSelectedItem == position)
                    return;

                base_layout.removeViewAt(1);

                switch (position){
                    case 0:
                        base_layout.addView(volForm, 1); break;
                    case 1:
                        base_layout.addView(orgForm, 1); break;
                }

                lastSelectedItem = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signup:
                signup();
                break;
            case R.id.link_login:
                finish();
                break;
        }
    }
}
