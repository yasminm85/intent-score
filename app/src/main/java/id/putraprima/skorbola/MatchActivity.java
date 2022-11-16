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
    ImageView image,image2;
    Button home1,home2,home3,away1,away2,away3,result,resetHome,resetAway;
    int count = 0;
    int count2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        textHome=findViewById(R.id.txt_home);
        textAway=findViewById(R.id.txt_away);

        image=findViewById(R.id.home_logo);
        image2=findViewById(R.id.away_logo);

        home1=findViewById(R.id.btn_add_home_1);
        home2=findViewById(R.id.btn_add_home_2);
        home3=findViewById(R.id.btn_add_home_3);

        away1=findViewById(R.id.btn_add_away_1);
        away2=findViewById(R.id.btn_add_away_2);
        away3=findViewById(R.id.btn_add_away_3);

        resetHome=findViewById(R.id.btn_reset_home);
        resetAway=findViewById(R.id.btn_reset_away);

        result=findViewById(R.id.btn_result);

        scrHome=findViewById(R.id.score_home);
        scrAway=findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        textHome.setText(extras.getString("HOME_TEAM"));
        textAway.setText(extras.getString("AWAY_TEAM"));
        image.setImageURI(Uri.parse(extras.getString("KEY_IMAGE")));
        image2.setImageURI(Uri.parse(extras.getString("KEY_IMAGE2")));

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                scrHome.setText(String.valueOf(count));


            }
        });
        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count+=2;
                scrHome.setText(String.valueOf(count));


            }
        });
        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count+=3;
                scrHome.setText(String.valueOf(count));


            }
        });
        away1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2++;
                scrAway.setText(String.valueOf(count2));


            }
        });
        away2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2+=2;
                scrAway.setText(String.valueOf(count2));


            }
        });
        away3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2+=3;
                scrAway.setText(String.valueOf(count2));


            }
        });

        resetHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrHome.setText("0");
            }
        });
        resetAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrAway.setText("0");
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hasil_home = Integer.parseInt(scrHome.getText().toString());
                int hasil_away = Integer.parseInt(scrAway.getText().toString());
                String home_win = textHome.getText().toString();
                String away_win = textAway.getText().toString();
                if(hasil_home>hasil_away){
                    Intent move = new Intent(MatchActivity.this, ResultActivity.class);

                move.putExtra("HOME_WIN", home_win);
                startActivity(move);
                }else if(hasil_home==hasil_away){
                    Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_LONG).show();
                }else{
                    Intent move = new Intent(MatchActivity.this, ResultActivity.class);
                    move.putExtra("AWAY_WIN", away_win);
                    startActivity(move);
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
