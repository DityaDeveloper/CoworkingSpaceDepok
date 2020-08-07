package aiproject.tama.cspacedepok;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static aiproject.tama.cspacedepok.R.drawable.coworking;


public class DbHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "db_puskesmas";
    public DbHelper(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS puskesmas(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, alamat TEXT, no_tlpn NUMERIC, descripsi TEXT,latitude Double,longtitude Double, img BLOB)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();
        //copy puskesmas disini
        values.put("_id", "120");
        values.put("nama", "Coworking Space GDR 117 ");
        values.put("alamat", "Cherry 1, Grand Depok Residence, Jl. KH.Dehir Kel, RT.09/RW.12, Tanah Baru, Kec.Beji, Depok City, 16426");
        values.put("no_tlpn", "(021) 7757033");
        values.put("descripsi","Coworking Space GDR 117");
        values.put("latitude","-6.378142");
        values.put("longtitude","106.797030");
        values.put("img",coworking);

        db.insert("puskesmas","_id", values);

        values.put("_id", "121");
        values.put("nama", "Bale Rombeng Adventure ");
        values.put("alamat", "Jl. Kp. Mampang No.16, RT.2/RW.9, Mampang, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16433");
        values.put("no_tlpn", "Tidak Ada");
        values.put("descripsi","Bale Rombeng Adventure");
        values.put("latitude","-6.391383");
        values.put("longtitude","106.800116");
        values.put("img",coworking);

        db.insert("puskesmas","_id", values);

        values.put("_id", "123");
        values.put("nama", "Depok Coworking ");
        values.put("alamat", "Jl. Raya Sawangan No.81, Pancoran MAS, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16436");
        values.put("no_tlpn", "(021) 29436785");
        values.put("descripsi","Depok Coworking");
        values.put("latitude","-6.394839");
        values.put("longtitude","106.803250");
        values.put("img",coworking);

        db.insert("puskesmas","_id", values);

        values.put("_id", "124");
        values.put("nama", "Cahaya Cake,S ");
        values.put("alamat", "Jl. Utama Puri Bsi Permai, Rangkapan Jaya, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16435");
        values.put("no_tlpn", "083893212296");
        values.put("descripsi","Cahaya Cake,S ");
        values.put("latitude","-6.386549");
        values.put("longtitude","106.784566");
        values.put("img",coworking);

        db.insert("puskesmas","_id", values);

        values.put("_id", "125");
        values.put("nama", "Digital Innovation Lounge ");
        values.put("alamat", "Jl. Ridwan Rais No.65, Beji Tim., Kecamatan Beji, Kota Depok, Jawa Barat 16422");
        values.put("no_tlpn", "+622177801655");
        values.put("descripsi","Digital Innovation Lounge ");
        values.put("latitude","-6.379347");
        values.put("longtitude","106.823965");
        values.put("img",coworking);

        db.insert("puskesmas","_id", values);

        values.put("_id", "126");
        values.put("nama", "Juanda Coworking Space ");
        values.put("alamat", "Jl. Jelutung 4 No.191B, RT.03/RW.016, Bakti Jaya, Kec. Sukmajaya, Kota Depok, Jawa Barat 16418");
        values.put("no_tlpn", "+622127612703");
        values.put("descripsi","Juanda Coworking Space ");
        values.put("latitude","-6.379246");
        values.put("longtitude","106.849585");
        values.put("img",coworking);

        db.insert("puskesmas","_id", values);

        values.put("_id", "124");
        values.put("nama", "Code Margonda ");
        values.put("alamat", "Depok Town Square, paling atas (Lantai 2, Level Mezanin) Area Foodcourt, Jl. Margonda Raya No.1, Kemiri Muka, Kecamatan Beji, Kota Depok, Jawa Barat 16424");
        values.put("no_tlpn", "+622122711457");
        values.put("descripsi","https://codemargonda.com/ ");
        values.put("latitude","-6.373058");
        values.put("longtitude","106.833152");
        values.put("img",coworking);

        db.insert("puskesmas","_id", values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS puskesmas");
        onCreate(db);

    }
}
