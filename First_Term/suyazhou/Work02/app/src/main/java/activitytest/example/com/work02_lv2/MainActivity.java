package activitytest.example.com.work02_lv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView QQ;
    private TextView account;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        QQ = (ImageView) findViewById(R.id.QQ);
        account = (TextView) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        Button landing = (Button) findViewById(R.id.landing);
            landing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String string = password.getText().toString();
                    switch (string) {
                        case "123456789":
                            String data = "登陆成功";
                            Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
                            intent1.putExtra("landing", data);
                            startActivity(intent1);
                            break;
                        default:
                            Toast.makeText(MainActivity.this , "密码错误，请输入正确密码" , Toast.LENGTH_SHORT).show();
                                break;
                    }
                }
            });
        }

}
