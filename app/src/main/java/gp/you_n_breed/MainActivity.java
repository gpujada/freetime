package gp.you_n_breed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public Spinner breedSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breedSpinner = findViewById(R.id.breed_spinner);
        CursorAdapter adapter = new CursorAdapter() {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return null;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

            }
        }
        adapter.
    }

    public void getInfoClick(View view) {
    }
}