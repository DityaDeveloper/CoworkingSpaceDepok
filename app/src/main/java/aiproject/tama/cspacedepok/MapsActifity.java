package aiproject.tama.cspacedepok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActifity extends AppCompatActivity {
    static final LatLng Depok= new LatLng(-6.390028,106.809052);
    final int RQS_GooglePlayServices = 1;
    private GoogleMap myMap;
    private String provider = null;
    private Marker mCurrenPosition = null;
    LatLng cwd_gdr117 = new LatLng(-6.378152, 106.797052);
    LatLng cwd_bale = new LatLng(-6.391383, 106.800116);
    LatLng cwd_depok = new LatLng(-6.394839, 106.803250);
    LatLng cwd_cahaya = new LatLng(-6.386549, 106.784566);
    LatLng cwd_dd = new LatLng(-6.379347, 106.823965);
    LatLng cwd_jd = new LatLng(-6.379246, 106.849585);
    LatLng cwd_cm = new LatLng(-6.373058, 106.833152);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Lokasi Coworking Space");
        }

        FragmentManager myFragmentManager = getSupportFragmentManager();
        SupportMapFragment mySupportMapFragment = (SupportMapFragment) myFragmentManager.findFragmentById(R.id.map);
        myMap = mySupportMapFragment.getMap();

        myMap.addMarker(new MarkerOptions().position(cwd_gdr117).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Coworking Space GDR 117").snippet("Cherry 1, Grand Depok Residence, Jl. KH.Dehir Kel, RT.09/RW.12, Tanah Baru, Kec.Beji, Depok City, 16426"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_gdr117, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_bale).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Bale Rombeng Adventure").snippet("Jl. Kp. Mampang No.16, RT.2/RW.9, Mampang, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16433"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_bale, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_depok).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Depok Coworking").snippet("Jl. Raya Sawangan No.81, Pancoran MAS, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16436"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_depok, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_cahaya).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Cahaya Cake,S").snippet("Jl. Utama Puri Bsi Permai, Rangkapan Jaya, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_cahaya, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_dd).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Digital Innovation Lounge").snippet("Jl. Ridwan Rais No.65, Beji Tim., Kecamatan Beji, Kota Depok, Jawa Barat 16422"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_dd, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_jd).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("DJuanda Coworking Space").snippet("Jl. Jelutung 4 No.191B, RT.03/RW.016, Bakti Jaya, Kec. Sukmajaya, Kota Depok, Jawa Barat 16418"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_jd, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_cm).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Code Margonda").snippet("Depok Town Square, paling atas (Lantai 2, Level Mezanin) Area Foodcourt, Jl. Margonda Raya No.1, Kemiri Muka, Kecamatan Beji, Kota Depok, Jawa Barat 16424"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_cm, 10));


        myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        myMap.getUiSettings().setCompassEnabled(true);

        myMap.getUiSettings().setZoomControlsEnabled(true);

        myMap.getUiSettings().setMyLocationButtonEnabled(true);
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Depok, 12));

        myMap.setMyLocationEnabled(true);

        myMap.setOnMarkerClickListener(new OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {
                // TODO Auto-generated method stub

                try {
                    StringBuilder urlString = new StringBuilder();
                    String daddr = (String.valueOf(arg0.getPosition().latitude) + "," + String.valueOf(arg0.getPosition().longitude));
                    urlString.append("http://maps.google.com/maps?f=d&hl=en");
                    urlString.append("&saddr=" + String.valueOf(myMap.getMyLocation().getLatitude()) + "," + String.valueOf(myMap.getMyLocation().getLongitude()));
                    urlString.append("&daddr=" + daddr);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString.toString()));
                    startActivity(i);
                } catch (Exception ee) {
                    Toast.makeText(getApplicationContext(), "Lokasi Saat Ini Belum Didapatkan, Izinkan GPS secara manual. lalu masuk kembali", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });


        myMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker arg0) {
                // TODO Auto-generated method stub
                //JIKA KLIKNYA INGIN DI INFO WINDOW
            }
        });

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
