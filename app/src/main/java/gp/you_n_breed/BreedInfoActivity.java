package gp.you_n_breed;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class BreedInfoActivity extends Fragment {

    public TextView breedName, lifeExp, avgWeight, history, character, healthProbs, careTips;

    public interface OnBreedSelectedListener {
        void onBreedSelected(int breedId);
    }
    private OnBreedSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_breed_info, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.breed_info_activity_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BreedAdapter adapter = new BreedAdapter();
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_info);

        breedName = findViewById(R.id.breed_name_head);
        lifeExp = findViewById(R.id.breed_life_info);
        avgWeight = findViewById(R.id.breed_weight_info);
        history = findViewById(R.id.breed_history_info);
        character = findViewById(R.id.breed_character_info);
        healthProbs = findViewById(R.id.breed_health_info);
        careTips = findViewById(R.id.breed_tips_info);*/
    }
}