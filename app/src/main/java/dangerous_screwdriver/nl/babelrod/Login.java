package dangerous_screwdriver.nl.babelrod;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import com.microsoft.windowsazure.mobileservices.*;

import java.net.MalformedURLException;

public class Login extends Activity {

    private MobileServiceClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner spinner = (Spinner) findViewById(R.id.language_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
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

    public void login(View view) {
        EditText editText = (EditText)findViewById(R.id.username);
        Log.d(this.getClass().toString(), editText.getText().toString());

        Spinner spinner = (Spinner)findViewById(R.id.language_spinner);
        Log.d(this.getClass().toString(), spinner.getSelectedItem().toString());

        try {
            client = new MobileServiceClient( "https://babel.azure-mobile.net/", "jwoqtSgFYXpShIajosnaqgdoukfNfG70", this );
        } catch (MalformedURLException e) {
            Log.d(this.getClass().toString(), e.getMessage());
        }

    }
}
