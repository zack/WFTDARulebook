package youpp.wftda.wftdarulebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    public final static String SECTION_NUMBER = "youpp.wftda.wftdarulebook.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        String text = "";
        switch (item.getItemId()) {
            case R.id.action_search:
                text = (String) getResources().getText(getResources().getIdentifier("search_toast", "string", "youpp.wftda.wftdarulebook"));
                break;
            case R.id.action_settings:
                text = (String) getResources().getText(getResources().getIdentifier("settings_toast", "string", "youpp.wftda.wftdarulebook"));
                break;
            case R.id.action_about:
                text = (String) getResources().getText(getResources().getIdentifier("about_toast", "string", "youpp.wftda.wftdarulebook"));
                break;
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            return rootView;
        }
    }
    
    /**
     * Called when the user clicks section1 button 
     */
    public void goToSection(View view) {
        Intent intent = new Intent(this, SectionActivity.class);
        String section_number= (String) view.getTag();
        intent.putExtra(SECTION_NUMBER, section_number);
        startActivity(intent);
    }
     
}
