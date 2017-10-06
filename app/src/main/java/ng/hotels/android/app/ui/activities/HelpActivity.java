package ng.hotels.android.app.ui.activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import ng.hotels.android.app.R;
import ng.hotels.android.app.ui.adapters.HelpAdapter;

public class HelpActivity extends Activity {

    ListView ArticlesListView;
    String Articles[]  = {"Save your flights", "Flight search", "Change Currency", "Ways to search", "Book a flight", "Book a hotel"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ArticlesListView = findViewById(R.id.ListView1);
       HelpAdapter helpAdapter = new HelpAdapter(getApplicationContext(),Articles);
        ArticlesListView.setAdapter(helpAdapter);

    }

}
