package activitytest.example.com.work02_lv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
        String data = intent.getStringExtra("landing");
        Log.d("SecondActivity" , data);
        Toast.makeText(SecondActivity.this , data , Toast.LENGTH_SHORT).show();
        search = (EditText) findViewById(R.id.search);
        Button Go = (Button) findViewById(R.id.go);
        Button Jim = (Button) findViewById(R.id.friend_1);
        final Button Tom = (Button) findViewById(R.id.friend_2);
        final Button Bill = (Button) findViewById(R.id.friend_3);

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String person = search.getText().toString();
                switch (person){
                    case "Jim":
                        Intent intent3 = new Intent("android.intent.action.Jim");
                        startActivity(intent3);
                        break;
                    case "Tom":
                        Intent intent4 = new Intent("android.intent.action.Tom");
                        startActivity(intent4);
                        break;
                    case "Bill":
                        Intent intent5 = new Intent("android.intent.action.Bil");
                        startActivity(intent5);
                        break;
                }
            }
        });
        Jim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jim = new Intent("android.intent.action.Jim");
                startActivity(jim);
            }
        });

        Tom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tom = new Intent("android.intent.action.Tom");
                startActivity(tom);
            }
        });

        Bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bill = new Intent("android.intent.action.Bill");
                startActivity(bill);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main , menu);
            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()){
                case R.id.add:
                    Intent intent6 = new Intent("android.intent.action.Add");
                    startActivity(intent6);
                    break;
                case R.id.creat:
                    Intent intent7 = new Intent("android.intent.action.CREAT");
                    startActivity(intent7);
                    break;
                case R.id.exit:
                    finish();
                    break;
            }
            return true;
    }
}

