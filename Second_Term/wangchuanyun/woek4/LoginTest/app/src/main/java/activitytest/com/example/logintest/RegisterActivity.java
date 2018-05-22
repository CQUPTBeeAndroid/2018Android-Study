package activitytest.com.example.logintest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText registerAccount;
    private EditText registerPassword;
    private EditText comfirmPassword;
    private Button register2;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editor = getSharedPreferences("login",MODE_PRIVATE).edit();
        registerAccount = (EditText)findViewById(R.id.registerAccount);
        registerPassword = (EditText)findViewById(R.id.registerPassword);
        comfirmPassword = (EditText)findViewById(R.id.comfirmPassword);
        register2 = (Button)findViewById(R.id.register2);
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String account = registerAccount.getText().toString();
                String password = registerPassword.getText().toString();
                String password2 = comfirmPassword.getText().toString();
                if(account.equals("")||password.equals("")||password2.equals("")){
                    Toast.makeText(RegisterActivity.this,"It is empty!",Toast.LENGTH_SHORT).show();
                }
                else if(!password.equals(password2)){
                    Toast.makeText(RegisterActivity.this,"Please check your password!",Toast.LENGTH_SHORT).show();
                }
                else{
                editor.putString("account",account);
                editor.putString("password",password);
                editor.apply();
                    Toast.makeText(RegisterActivity.this,"Succeed!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
