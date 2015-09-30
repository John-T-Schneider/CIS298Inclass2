package edu.kvcc.cis298.cis298inclass1;

/**
 * Created by jschneider5667 on 9/23/2015.
 */
public class Question {

    //Class level variable to hold the question text
    //In order to get a string from strings.xml, we need
    //an integer as the reference value.
    private int mTextResId;
    //integer to represent the integer id of the correct resource
    private int mCorrectAnswerResId;
    //integer array used to hold the resource ids of the choices for the question
    private int[] mChoiceResIds;

    //Constructor that accepts 3 parameters. The string id,
    // and the int correct answer
    public Question(int textResId, int correctAnswerResId, int[] choiceResIds){
        //Assign the passed in ones to the class level ones.
        mTextResId = textResId;
        mCorrectAnswerResId = correctAnswerResId;
        mChoiceResIds = choiceResIds;
    }


    public int[] getChoiceResIds() {
        return mChoiceResIds;
    }

    public void setChoiceResIds(int[] choiceResIds) {
        mChoiceResIds = choiceResIds;
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

    //getters and setters for ALL
    public int getCorrectAnswerResId() {
        return mCorrectAnswerResId;
    }

    public void setCorrectAnswerResId(int correctAnswerResId) {
        mCorrectAnswerResId = correctAnswerResId;
    }
}
