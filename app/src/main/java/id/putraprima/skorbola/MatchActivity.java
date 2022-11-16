package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MatchActivity extends AppCompatActivity {
    TextView textHome,textAway,scrHome,scrAway;
    ImageView image;
    Button home,away,result;
    int count = 0;
    int count2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        textHome=findViewById(R.id.txt_home);
        textAway=findViewById(R.id.txt_away);
        image=findViewById(R.id.home_logo);
        home=findViewById(R.id.btn_add_home);
        away=findViewById(R.id.btn_add_away);
        result=findViewById(R.id.btn_result);
        scrHome=findViewById(R.id.score_home);
        scrAway=findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        textHome.setText(extras.getString("HOME_TEAM"));
        textAway.setText(extras.getString("AWAY_TEAM"));
        image.setImageURI(Uri.parse(extras.getString("KEY_IMAGE")));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                scrHome.setText(String.valueOf(count));


            }
        });
        away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2+=2;
                scrAway.setText(String.valueOf(count2));


            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hasil_home = Integer.parseInt(scrHome.getText().toString());
                int hasil_away = Integer.parseInt(scrAway.getText().toString());

                if(hasil_home>hasil_away){
                    Toast.makeText(getApplicationContext(),"Home menang",Toast.LENGTH_LONG).show();
                }else if(hasil_home==hasil_away){
                    Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Away menang",Toast.LENGTH_LONG).show();
                }

//                Intent move = new Intent(MatchActivity.this, ResultActivity.class);
//
//                move.putExtra("RESULT_HOME", hasil_home);
//                move.putExtra("RESULT_AWAY", hasil_away);
//                startActivity(move);


            }
        });



        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
