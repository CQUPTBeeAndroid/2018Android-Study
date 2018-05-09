package activitytest.example.com.work02_lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddFriendActivity extends AppCompatActivity {
    private EditText Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend_factivity);
        Add = (EditText) findViewById(R.id.add_friend);
        Button button = (Button) findViewById(R.id.search);
    }
}
