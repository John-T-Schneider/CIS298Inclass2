package edu.kvcc.cis298.cis298inclass1;

/**
 * Created by jschneider5667 on 9/23/2015.
 */
public class Question {

    //Class level variable to hold the question text
    //In order to get a string from strings.xml, we need
    //an integer as the reference value.
    private int mTextResId;
    //bool value for whether the question is true or false
    private boolean mAnswerTrue;

    //Constructor that accepts 2 parameters. The string id,
    // and the bool answer
    public Question(int textResId, boolean answerTrue){
        //Assign the passed in ones to the class level ones.
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    // Getter/Setter gives access to the private variables
    //Getter for mTextResId
    public int getTextResId() {
        return mTextResId;
    }

    //Setter for mTextResId
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    //Getter for mAnswerTrue
    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    //Setter for mAnswerTrue
    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
