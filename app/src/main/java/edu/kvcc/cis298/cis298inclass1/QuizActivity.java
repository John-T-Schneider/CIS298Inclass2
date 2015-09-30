package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    //Create a class level Widget variables so that we will
    //have access to stuff from the view.
    //No value yet. Just declared the variable
    private RadioGroup mQuestionGroup;

    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;
    private RadioButton mChoice4;

    private Button mSubmitButton;

    //Variable for the next button
    private Button mNextButton;
    //Variable for the question string
    private TextView mQuestionTextView;

    //The questions that will be used. It is an array of type
    //Question, that contains 5 Questions. It is a hard coded
    //array. In most apps, you would want your data to come from
    //somewhere else(database, internet). Not be hard coded
    private Question[] mQuestionBank = new Question[]{

            new Question(R.string.question_1_multiple,R.id.multiple_choice_3,
                    new int[] {R.string.question_1_choice_1, R.string.question_1_choice_2,
                            R.string.question_1_choice_3, R.string.question_1_choice_4}),


            new Question(R.string.question_2_multiple, R.id.multiple_choice_2,
                    new int[] {R.string.question_2_choice_1, R.string.question_2_choice_2,
                            R.string.question_2_choice_3, R.string.question_2_choice_4})
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

        //Fetch the question choice strings from the question object
        int[] choices = mQuestionBank[mCurrentIndex].getChoiceResIds();

        //Assign each question choice text to the text property of the radio button.


        mChoice1.setText(choices[0]);
        mChoice2.setText(choices[1]);
        mChoice3.setText(choices[2]);
        mChoice4.setText(choices[3]);

    }

    private void checkAnswer (int selectedRadioButtonId){
        //Create a integer to represent the actual answer of
        //the current question
        int correctAnswer = mQuestionBank[mCurrentIndex].getCorrectAnswerResId();

        //declare an integer that will be a pointer to the string
        //resource that will be used for the toast message
        int messageResId = 0;

        //Does the radio button id of the answer they submitted match the radio button
        // id of the correct answer. If so it is right, else it is wrong
        if (selectedRadioButtonId == correctAnswer) {
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

        mQuestionGroup = (RadioGroup) findViewById(R.id.multiple_group);

        mChoice1 = (RadioButton) findViewById(R.id.multiple_choice_1);
        mChoice2 = (RadioButton) findViewById(R.id.multiple_choice_2);
        mChoice3 = (RadioButton) findViewById(R.id.multiple_choice_3);
        mChoice4 = (RadioButton) findViewById(R.id.multiple_choice_4);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Query the radio button group to find out which radio button was selected.
                 //Store the id of the selected one in the variable selectedAnswerId.
                 int selectedAnswerId = mQuestionGroup.getCheckedRadioButtonId();

                 //Pass the id of the selected radio button into the checkAnswer method.
                 //The checkAnswer handles toasting whether it is correct or not.
                 checkAnswer(selectedAnswerId);
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
        //This is declared about. it does the work of changing
        //to the next question in the array
        updateQuestion();
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
