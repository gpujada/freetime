package gp.you_n_breed;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DogDatabaseHelper extends SQLiteOpenHelper {

    String dbPath;
    private static String dbName = "dog_breeds";
    private SQLiteDatabase mDatabase;
    private final Context mContext;

    public DogDatabaseHelper(Context context) {
        super(context, dbName, null, 1);
        this.mContext = context;
        this.dbPath = context.getFilesDir().getPath() + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", dbPath);
    }

    public void createDatabase() {
        boolean dbExist = checkDatabase();
        if(dbExist) {
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDatabase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = dbPath + dbName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException ignored) { }
        if(checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDatabase() throws IOException {
        InputStream inputStream = mContext.getAssets().open(dbName);
        String outFileName = dbPath + dbName;
        OutputStream outputStream = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public void openDatabase() throws SQLException {
        String myPath = dbPath + dbName;
        mDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if(mDatabase != null) {
            mDatabase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(newVersion > oldVersion) {
            try {
                copyDatabase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectArgs, String groupBy, String having, String orderBy) {
        return mDatabase.query("DOG BREED", null, null, null, null, null, null);
    }
}
