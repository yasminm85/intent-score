package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int HOME_REQUEST_CODE = 1;
    private static final int AWAY_REQUEST_CODE = 2;
    ImageView avatarImage,avatarImage2;
    EditText home,away;
    Button btnTeam;
    private Uri imageUri_1 = null;
    private Uri imageUri_2 = null;

    public void handleChangeAvatar(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, HOME_REQUEST_CODE);
    }
    public void handleChangeAvatar2(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, AWAY_REQUEST_CODE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avatarImage=findViewById(R.id.home_logo);
        avatarImage2=findViewById(R.id.away_logo);
        home=findViewById(R.id.home_team);
        away=findViewById(R.id.away_team);
        btnTeam=findViewById(R.id.btn_team);

        btnTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_home = home.getText().toString();
                String text_away = away.getText().toString();
                String image = imageUri_1.toString();
                String image2 = imageUri_2.toString();

                Intent move = new Intent(MainActivity.this, MatchActivity.class);

                move.putExtra("HOME_TEAM", text_home);
                move.putExtra("AWAY_TEAM", text_away);
                move.putExtra("KEY_IMAGE", image);
                move.putExtra("KEY_IMAGE2", image2);
                startActivity(move);
            }
        });

        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == HOME_REQUEST_CODE) {
            if (data != null) {
                try {
                    imageUri_1 = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri_1);
                    avatarImage.setImageBitmap(bitmap);

                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }

        if (requestCode == AWAY_REQUEST_CODE) {
            if (data != null) {
                try {
                    imageUri_2 = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri_2);
                    avatarImage2.setImageBitmap(bitmap);

                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }


    }
}
