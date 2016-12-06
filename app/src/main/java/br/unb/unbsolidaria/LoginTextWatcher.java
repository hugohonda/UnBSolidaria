package br.unb.unbsolidaria;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import br.unb.unbsolidaria.entities.RegisterValidation;

/**
 * Created by criss on 06/12/2016.
 */

//Declaration
public class LoginTextWatcher implements TextWatcher {

    private View view;
    public LoginTextWatcher(View view) {
        this.view = view;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    public void afterTextChanged(Editable editable) {
        String text = editable.toString();
        EditText model = (EditText) view;

        switch(view.getId()){
            case R.id.input_cpf:
                if (text.length() >= 11 && !RegisterValidation.isValidCPF(text)) {
                    model.setTextColor(Color.RED);
                    model.setError("insira um CPF válido");
                } else {
                    model.setTextColor(Color.BLACK);
                }
                break;
            case R.id.input_cep:
                if (text.length() >= 8 && !RegisterValidation.isValidCEP(text)) {
                    model.setTextColor(Color.RED);
                    model.setError("insira um CEP válido");
                } else {
                    model.setTextColor(Color.BLACK);
                }
                break;
        }
    }
}