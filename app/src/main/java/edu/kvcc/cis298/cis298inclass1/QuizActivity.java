package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    //Create a class level Widget variables so that we will
    //have access to stuff from the view.
    //No value yet. Just declared the variable
    private Button mTrueButton;
    private Button mFalseButton;
    //Variable for the next button
    private Button mNextButton;
    //Variable for the question string
    private TextView mQuestionTextView;

    //The questions that will be used. It is an array of type
    //Question, that contains 5 Questions. It is a hard coded
    //array. In most apps, you would want your data to come from
    //somewhere else(database, internet). Not be hard coded
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;

    //Private methods that will be used inside the OnCreate
    //I wrote these, not Google
    private void updateQuestion(){

        //questionbank, using current intdes, gets a question using its ResId
        //Get the Question instance stored at the mCurrentIndex of the
        //QuestionBank array. Then call the getTextResId method (property)
        //resource in strings.xml that we want to use.
        int question = mQuestionBank[mCurrentIndex].getTextResId();

        //Assign the integer for the string resource to the
        //textview so that the question text will display.
        mQuestionTextView.setText(question);
    }

    private void checkAnswer (boolean userPressedTrue){
        //Create a boolean to represent the actual answer of
        //the current question
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        //declare an integer that will be a pointer to the string
        //resource that will be used for the toast message
        int messageResId = 0;

        //Compare the actual answer to the answer that was passed
        //into this method. If they match, the message is correct.
        //else it is incorrect. Assign the R in value to the messageResId
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        //Use the Toast class to print a message to the
        //Screen that will fade out after the duration
        //listed as LENGTH_SHORT
        //This method requires 3 parameters.
        //The Context, which will usually be Activity.this
        //The Message, which will usually be a string from strings.xml
        //The Length, which will be on of the predefined constants.

        //Make a toast, and use the messageResId for the message
        //to show.
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
    //I did not write this method, it was given to me by google.
    //It is the 'setup' method for the app
    //It will be called when the app launches.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Begin code i write ***************************************


        //Get a 'handle' to the textview in the layout
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);




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
                //Call the checkAnswer method that is declared up top
                //of the class. It will take in the bool value that they
                //selected, and do the work of determining if it is correct.
                //Either way it will Toast the message to the screen.
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Call the checkAnswer method that is declared up top
                //of the class. It will take in the bool value that they
                //selected, and do the work of determining if it is correct.
                //Either way it will Toast the message to the screen.
                checkAnswer(false);
            }
        });


        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                //This method is declared at the top of the class, it
                //handles updating the question text.
                updateQuestion();
            }
        });

        //Check to see if there is a bundle and that it has a value that is not null.
        // If so, fetch out the KEY_INDEX, which will be the index of the question that
        // we were on before we did a rotate
        if (savedInstanceState !=null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }


        //This is declared about. it does the work of changing
        //to the next question in the array
        updateQuestion();
        //End code i write********************************************************
    }
    // Static string to use for the override methods
    private static final String TAG = "QuizActivity";

    //Static string to be used as the key in the key / value Bundle for onSaveInstanceState
    private static final String KEY_INDEX = "index";
    @Override
    //Overridden method to save any information about our activity that we
    // will need to restore from either a rotate or a change in activity
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //Log that onSaveInstanceState was called
            Log.i(TAG, "onSaveInstanceState");
        //Put the index of the question that we are on into the bundle, using
        // a key defined above as the variable KEY_INDEX and the value "index"
            savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }


    //static string to use for the override methods


    //Below are the main activity methods that can be
    // overwritten to do 'work' with our application
    //the app will call all of these in sequence as it
    // loads, and as it is closed.
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
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
