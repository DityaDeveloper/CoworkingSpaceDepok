package aiproject.tama.cspacedepok;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean isKonek = false;
    Pendeteksi_koneksi pk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pk = new Pendeteksi_koneksi(getApplicationContext());
        isKonek = pk.isConnectingToInternet();
        if (isKonek){
            Toast.makeText(this, "anda terhubung ke internet", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "anda tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
            //this.finish();
        }
    }
    public void klikTombolMenu(View v){
        Intent intent;
        switch (v.getId()) {
            case R.id.tombolmaps:
                intent = new Intent (this, MapsActifity.class);
                startActivity(intent);

                break;
            case R.id.tombolhome:
                intent = new Intent(this,HomeItem.class);
                startActivity(intent);
                break;
            case R.id.tombolabout:
                intent = new Intent(this,AboutActivitfty.class);
                startActivity(intent);

                break;
            case R.id.tombolversi:
                intent = new Intent(this, VersiFragment.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("apakah anda yakin ingin keluar")
                .setCancelable(false);
        dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                MainActivity.this.finish();
            }
        });
        dialog.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.cancel();

                    }
                });
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}

