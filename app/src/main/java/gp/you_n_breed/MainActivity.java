package gp.you_n_breed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner breedSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breedSpinner = findViewById(R.id.breed_spinner);

    }
}