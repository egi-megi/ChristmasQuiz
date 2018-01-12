package com.example.android.christmasquiz1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int maxHerePoints = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int onRadioButtonClickedAdwent(View view) {
        // Is the button now checked?

        RadioGroup adventRadioGroup = (RadioGroup) findViewById(R.id.rgAdvent);

        int checkedId = adventRadioGroup.getCheckedRadioButtonId();
        if (checkedId == -1) {
            return 0;
        }
        boolean checked = ((RadioButton) findViewById(checkedId)).isChecked();
        int sum = 0;
        // Check which radio button was clicked
        if (checkedId == R.id.ans3Advent) {
            if (checked) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public int onRadioButtonClickedTree(View view) {
        // Is the button now checked?

        RadioGroup treeRadioGroup = (RadioGroup) findViewById(R.id.rgTree);

        int checkedIdTree = treeRadioGroup.getCheckedRadioButtonId();
        if (checkedIdTree == -1) {
            return 0;
        }
        boolean checkedTree = ((RadioButton) findViewById(checkedIdTree)).isChecked();
        int sumTree = 0;
        // Check which radio button was clicked
        if (checkedIdTree == R.id.ans1Tree) {
            if (checkedTree) {
                sumTree = sumTree + 1;
            }
        }
        return sumTree;
    }

    public int onRadioButtonClickedSaintNicolas(View view) {
        // Is the button now checked?

        RadioGroup saintNicolasRadioGroup = (RadioGroup) findViewById(R.id.rgSaintNicolas);

        int checkedIdSaintNicolas = saintNicolasRadioGroup.getCheckedRadioButtonId();
        if (checkedIdSaintNicolas == -1) {
            return 0;
        }
        boolean checkedSaintNicolas = ((RadioButton) findViewById(checkedIdSaintNicolas)).isChecked();
        int sumSaintNicolas = 0;
        // Check which radio button was clicked
        if (checkedIdSaintNicolas == R.id.ans3saintNicolas) {
            if (checkedSaintNicolas) {
                sumSaintNicolas = sumSaintNicolas + 1;
            }
        }
        return sumSaintNicolas;
    }

    public int countButtonResult(View view) {
        int sumPoints = 0;
        CheckBox ans1WaferCheckBox = (CheckBox) findViewById(R.id.ans1_wafer_checkBox);
        CheckBox ans2WaferCheckBox = (CheckBox) findViewById(R.id.ans2_wafer_checkBox);
        CheckBox ans3WaferCheckBox = (CheckBox) findViewById(R.id.ans3_wafer_checkBox);
        CheckBox ans4WaferCheckBox = (CheckBox) findViewById(R.id.ans4_wafer_checkBox);
        boolean checkedAns1WaferCheckBox = ans1WaferCheckBox.isChecked();
        boolean checkedAns2WaferCheckBox = ans2WaferCheckBox.isChecked();
        boolean checkedAns3WaferCheckBox = ans3WaferCheckBox.isChecked();
        boolean checkedAns4WaferCheckBox = ans4WaferCheckBox.isChecked();

        // Check which CheckBox was clicked and sum points
        if (ans1WaferCheckBox.isChecked()) {
            sumPoints = sumPoints + 0;
        }
        // Sum points only if CheckBox 2 and CheckBox 3 is checked
        if (ans2WaferCheckBox.isChecked() && ans3WaferCheckBox.isChecked()) {
            sumPoints = sumPoints + 1;
        }

        if (ans4WaferCheckBox.isChecked()) {
            sumPoints = sumPoints + 0;
        } else
            sumPoints = sumPoints + 0;


        CheckBox ans1CripCheckBox = (CheckBox) findViewById(R.id.ans1_crib_checkBox);
        CheckBox ans2CripCheckBox = (CheckBox) findViewById(R.id.ans2_crib_checkBox);
        CheckBox ans3CripCheckBox = (CheckBox) findViewById(R.id.ans3_crib_checkBox);
        CheckBox ans4CripCheckBox = (CheckBox) findViewById(R.id.ans4_crib_checkBox);
        boolean checkedAns1CripCheckBox = ans1CripCheckBox.isChecked();
        boolean checkedAns2CripCheckBox = ans2CripCheckBox.isChecked();
        boolean checkedAns3CripCheckBox = ans3CripCheckBox.isChecked();
        boolean checkedAns4WCripCheckBox = ans4CripCheckBox.isChecked();

        // Check which CheckBox was clicked and sum points
        // Sum points only if CheckBox 1 and CheckBox 2 and CheckBox 3 is checked
        if (ans1CripCheckBox.isChecked() && ans2CripCheckBox.isChecked() && ans3CripCheckBox.isChecked()) {
            sumPoints = sumPoints + 1;
        }

        if (ans4CripCheckBox.isChecked()) {
            sumPoints = sumPoints + 0;
        } else
            sumPoints = sumPoints + 0;

        //Question where someone have to write the answer
        EditText writeLaplandEditText = (EditText) findViewById(R.id.editText_SCLapland);
        String answerLapland = writeLaplandEditText.getText().toString();
        if (answerLapland.matches("Lapland")) {
            sumPoints = sumPoints + 1;
        }

        //Question where someone have to write the answer
        EditText writeWhoHelpEditText = (EditText) findViewById(R.id.editText_SChelp);
        String answerElfsReindeer = writeWhoHelpEditText.getText().toString();
        if (answerElfsReindeer.matches("elf")) {
            sumPoints = sumPoints + 1;
        }
        if (answerElfsReindeer.matches("elves")) {
            sumPoints = sumPoints + 1;
        }
        if (answerElfsReindeer.matches("reindeer")) {
            sumPoints = sumPoints + 1;
        }
        if (answerElfsReindeer.matches("reindeers")) {
            sumPoints = sumPoints + 1;
        }
        return sumPoints;
    }

    //Here is write what is the the range of points for different texts displayed when the button of "Show the results" is clicked
    public void buttonResult(View view) {
        int allPoints = 0;
        allPoints = allPoints + countButtonResult(view) + onRadioButtonClickedSaintNicolas(view) + onRadioButtonClickedTree(view) + onRadioButtonClickedAdwent(view);

        if (allPoints < 4) {
            displayPointsLittle(countPointsLittle(allPoints, maxHerePoints));
        } else {

            if (allPoints < 6) {
                displayPointsNormal(countPointsNormal(allPoints, maxHerePoints));
            } else {
                displayPointsMuch(countPointsMuch(allPoints, maxHerePoints));
            }
        }
    }
    //It is method for getting the String for the smallest number of points
    private String countPointsLittle(int firstInt, int secondInt) {
        String pointsLittle = getString(R.string.littlePoints, firstInt, secondInt);
        return pointsLittle;
    }

    //It is method for displaying first Toast for the smallest number of points
    private void displayPointsLittle(String poi) {
        Toast.makeText(MainActivity.this,
                poi, Toast.LENGTH_LONG).show();
    }

    //It is method for getting the String for the verage number of points
    private String countPointsNormal(int firstInt, int secondInt) {
        String pointsNormal = getString(R.string.normalPoints, firstInt, secondInt);
        return pointsNormal;
    }

    //It is method for displaying first Toast for the  average  number of points
    private void displayPointsNormal(String poiN) {
        Toast.makeText(MainActivity.this,
                poiN, Toast.LENGTH_LONG).show();
    }

    //It is method for getting the String for the biggest number of points
    private String countPointsMuch(int gottenPoints, int totalPoints) {
        String pointsMuch = getString(R.string.muchPoints, gottenPoints, totalPoints);
        return pointsMuch;
    }

    //It is method for displaying first Toast for the biggest number of points
    private void displayPointsMuch(String poiM) {
        Toast.makeText(MainActivity.this,
                poiM, Toast.LENGTH_LONG).show();
    }

    //Here is method to reset all selections after clicked on button "Try again"
    public void buttonTryAgain(View view) {

        int[] checkboxes = {R.id.ans1_wafer_checkBox, R.id.ans2_wafer_checkBox, R.id.ans3_wafer_checkBox, R.id.ans4_wafer_checkBox, R.id.ans1_crib_checkBox, R.id.ans2_crib_checkBox, R.id.ans3_crib_checkBox, R.id.ans4_crib_checkBox};
        for (int checkBoxId : checkboxes) {
            CheckBox checkBox = (CheckBox) findViewById(checkBoxId);
            checkBox.setChecked(false);
        }

        RadioGroup adventRadioGroup = (RadioGroup) findViewById(R.id.rgAdvent);
        adventRadioGroup.clearCheck();

        RadioGroup treeRadioGroup = (RadioGroup) findViewById(R.id.rgTree);
        treeRadioGroup.clearCheck();

        RadioGroup saintNicolasRadioGroup = (RadioGroup) findViewById(R.id.rgSaintNicolas);
        saintNicolasRadioGroup.clearCheck();

        EditText writeLaplandEditText = (EditText) findViewById(R.id.editText_SCLapland);
        writeLaplandEditText.setText("");

        EditText writeWhoHelpEditText = (EditText) findViewById(R.id.editText_SChelp);
        writeWhoHelpEditText.setText("");


    }

}
