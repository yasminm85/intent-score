package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView hasil,hasil2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        hasil=findViewById(R.id.textView3);
        hasil2=findViewById(R.id.textView4);
        Bundle extras = getIntent().getExtras();
        hasil.setText(extras.getString("HOME_WIN"));
        hasil2.setText(extras.getString("AWAY_WIN"));
    }
}
