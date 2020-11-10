package gp.you_n_breed;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DogDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME = "dog_breeds.db";
    public static final int DB_VERSION = 1;
    private static String DB_LOC = "/data/data/gp.you_n_breed/databases/";
    private SQLiteDatabase db;
    private Context mContext;


    public DogDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DB_NAME).getPath();
        if(db != null && db.isOpen()) {
            return;
        }
        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(db!=null) {
            db.close();
        }
    }

    public List<Dog> getBreed() {
        Dog breed = null;
        List<Dog> breedList = new ArrayList<>();
        openDatabase();
        Cursor c = db.rawQuery("SELECT * FROM 'DOG BREED'", null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            breed = new Dog(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4),
                    c.getString(5), c.getString(6), c.getString(7));
            breedList.add(breed);
            c.moveToNext();
        }
        c.close();
        closeDatabase();
        return breedList;
    }
}
