package youpp.wftda.wftdarulebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;



public class SectionActivity extends ActionBarActivity {

    int[] subsectionCount = {11, 9, 3, 2, 16, 4, 2, 4, 4, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Get section number from intent
        Intent intent = getIntent();
        String section_num = intent.getStringExtra(MainActivity.SECTION_NUMBER);

        // Get the section name
        String section_name_id = "section_" + section_num + "_title";
        String section_name = (String) getResources().getText(getResources().getIdentifier(section_name_id, "string", "youpp.wftda.wftdarulebook"));
        
        // Get the section number
        String section_number_id = "section_" + section_num;
        String section_number = (String) getResources().getText(getResources().getIdentifier(section_number_id, "string", "youpp.wftda.wftdarulebook"));

        // Set the title
        setTitle(section_number + ": " + section_name);
        
        setContentView(R.layout.fragment_section);
        for (int i = 1; i <= subsectionCount[Integer.parseInt(section_num)-1]; i++) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.section_fragment);
            Button button = new Button(this);
            String section_id = "section_" + section_num + "." + Integer.toString(i);
            String section_string = (String) getResources().getText(getResources().getIdentifier(section_id, "string", "youpp.wftda.wftdarulebook"));
            button.setText(section_string);
            button.setGravity(4);
            linearLayout.addView(button);
        }
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
