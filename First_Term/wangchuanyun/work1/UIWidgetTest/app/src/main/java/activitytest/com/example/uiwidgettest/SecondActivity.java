package activitytest.com.example.uiwidgettest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);
        Button button = (Button)findViewById(R.id.button2);
        editText = (EditText)findViewById(R.id.edit_text);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button2:
                String inputText = editText.getText().toString();
                Toast.makeText(SecondActivity.this,inputText,Toast.LENGTH_SHORT).show();
                Toast.makeText(SecondActivity.this,"创建完毕",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.thirdactivity.ACTION_START");
                intent.addCategory("com.thirdactivity.CATEGORY_START");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back_item:
                finish();
                break;
            case R.id.click_item:
                Toast.makeText(this,"你抖了一下",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
