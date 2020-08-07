package aiproject.tama.cspacedepok;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WSpaceDetailActifity extends AppCompatActivity {
    ImageView Im;
    TextView tv_nama, tv_alamat,tv_tlpn,tv_deskripsi ,id,lalitude,longtitude;
    Gallery gallery;
    ImageSwitcher imageSwitcher;
    Integer[] imageIDs = new Integer[3];
    int msg_im;
    public static final String NAME= "name";
    public static final String LOKASI= "lokasi";
    public static final String LAT ="lat";
    public static final String LONG = "long";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cspace_detail
        );

        Intent iIdentifikasi = getIntent();
        msg_im = iIdentifikasi.getIntExtra("dataIM", 0);
        String msg_nama = iIdentifikasi.getStringExtra("dataNama");
        String msg_alamat = iIdentifikasi.getStringExtra("dataAlamat");
        String msg_no_tlpn = iIdentifikasi.getStringExtra("dataNoTlpn");
        String msg_deskripsi = iIdentifikasi.getStringExtra("dataDeskripsi");
        String lat = iIdentifikasi.getStringExtra("latitude");
        String lng = iIdentifikasi.getStringExtra("longtitude");
        Im = (ImageView) findViewById(R.id.iv_detail);
        tv_nama = (TextView) findViewById(R.id.tvNama);
        tv_alamat = (TextView) findViewById(R.id.tvalamat);
        tv_tlpn = (TextView) findViewById(R.id.tvtlpn);
        tv_deskripsi = (TextView) findViewById(R.id.tvdeskripsi);
        lalitude = (TextView) findViewById(R.id.latitude);
        longtitude = (TextView) findViewById(R.id.longitude);
        Im.setImageResource(msg_im);
        tv_nama.setText(msg_nama);
        tv_alamat.setText(msg_alamat);
        tv_tlpn.setText(msg_no_tlpn);
        tv_deskripsi.setText(msg_deskripsi);
        lalitude.setText(lat);
        longtitude.setText(lng);

        Button btn = (Button) findViewById(R.id.btnlihat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WSpaceDetailActifity.this, MapsInfowindows.class);
                intent.putExtra(LAT, lalitude.getText().toString());
                intent.putExtra(LONG, longtitude.getText().toString());
                intent.putExtra(NAME, tv_nama.getText().toString());
                intent.putExtra(LOKASI, tv_alamat.getText().toString());
                startActivity(intent);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Coworking Space Depok");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    }
