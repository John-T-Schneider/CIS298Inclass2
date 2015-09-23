package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    //Create a class level Widget variables so that we will
    //have access to stuff from the view.
    //No value yet. Just declared the variable
    private Button mTrueButton;
    private Button mFalseButton;

    //I did not write this method, it was given to me by google.
    //It is the 'setup' method for the app
    //It will be called when the app launches.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Begin code i write ***************************************

        //Fetch the widget control from the view, and then
        //cast and assign it to the class variable we setup
        mTrueButton = (Button) findViewById(R.id.true_button);

        //Now that i have a 'handle' to the view widget, i can
        //Setup an OnClickListener for the widget
        //This OnClickListener uses an anonymous inner class.
        //We are passing what we want to have happen OnClick.
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Use the Toast class to print a message to the
                //Screen that will fade out after the duration
                //listed as LENGTH_SHORT
                //This method requires 3 parameters.
                //The Context, which will usually be Activity.this
                //The Message, which will usually be a string from strings.xml
                //The Length, which will be on of the predefined constants.
                Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //End code i write********************************************************
    }

    //These are methods that we did not write, but Google provided.
    //If we get to using menus, we will need them. They can be ignored for now.

    //Begin unneeded google methods************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
