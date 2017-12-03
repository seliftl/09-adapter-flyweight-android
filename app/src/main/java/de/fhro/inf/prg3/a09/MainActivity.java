package de.fhro.inf.prg3.a09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Locale;

import de.fhro.inf.prg3.a09.model.FighterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String LOGGING_TAG = MainActivity.class.getName();
    private FighterFactory fighterFactory;
    private ArrayAdapter<CharSequence> pageSizeAdapter;
    private Switch partySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fighterFactory = new FighterFactory(this);

        pageSizeAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.page_sizes,
                R.layout.support_simple_spinner_dropdown_item
        );

        final Spinner pageSizeSpinner = findViewById(R.id.page_size_spinner);
        pageSizeSpinner.setAdapter(pageSizeAdapter);
        pageSizeSpinner.setOnItemSelectedListener(this);

        partySwitch = findViewById(R.id.party_switch);

        final ListView fighterListView = findViewById(R.id.fighter_list_view);
        /* TODO set the adapter of the list view to an instance of your own adapter
         * remember to keep a reference to the adapter to be able to interact with it later */
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        boolean createEmpireFighter = partySwitch.isChecked();
        int pageSize = Integer.parseInt(pageSizeAdapter.getItem(position).toString());
        Log.d(LOGGING_TAG, String.format(Locale.getDefault(), "Selected page size: %d", pageSize));
        /* TODO generate as many new fighters as the selected page size
         * add them to your own adapter implementation to display them
         * remember to clear the adapter previously! */
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(
                this,
                R.string.no_item_selected_toast,
                Toast.LENGTH_LONG
        ).show();
        Log.d(LOGGING_TAG, "No item selected");
    }
}
