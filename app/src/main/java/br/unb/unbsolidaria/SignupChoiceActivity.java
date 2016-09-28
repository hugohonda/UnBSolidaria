package br.unb.unbsolidaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignupChoiceActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private static final int RESULT_USER_OK = 5;
    private static final int RESULT_ASS_OK = 10;

    private Button aluno;
    private Button ass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_choice);

        aluno = (Button) findViewById(R.id.alunosignup);
        aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignupUserActivity.class);
                startActivityForResult(intent,REQUEST_SIGNUP);
            }
        });

        ass = (Button) findViewById(R.id.asssignup);
        ass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignupAssActivity.class);
                startActivityForResult(intent,REQUEST_SIGNUP);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_USER_OK) {
                setResult(RESULT_USER_OK,null);
                this.finish();
            } else if(resultCode == RESULT_ASS_OK) {
                setResult(RESULT_ASS_OK,null);
                this.finish();
            }else if(resultCode == RESULT_CANCELED){
                this.finish();
            }
        }
    }
}
