package me.micrusa.amaztimer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import me.micrusa.amaztimer.defValues;
import me.micrusa.amaztimer.utils.file;
import me.micrusa.amaztimer.utils.utils;
import me.micrusa.app.amazwidgets.R;

public class EditPresetActivity extends AppCompatActivity {

    private Button plus, plus2, plus3, minus, minus2, minus3, edit;
    private TextView sets,rest,work,settingstext,setsText,workText,restText;
    private ConstraintLayout L1, L2;
    private OnClickListener plusMinusBtn;
    private OnClickListener editBtn;
    private file file;
    private me.micrusa.amaztimer.defValues defValues = new defValues();
    private me.micrusa.amaztimer.utils.utils utils = new utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amaztimer);
        final int PresetID = getIntent().getIntExtra("ID", 0);
        this.init();
        this.createOnClickListeners(PresetID);
        this.setOnClickListeners();
        this.startActivity();
    }

    private void createOnClickListeners(final int PresetID){
        file file = null;
        switch(PresetID){
            case 1:
                file = new file("preset1", this);
                break;
            case 2:
                file = new file("preset2", this);
                break;
        }
        final me.micrusa.amaztimer.utils.file finalFile = file;
        plusMinusBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                int Btn;
                int sets = finalFile.get(defValues.sSets, defValues.defSets);
                int work = finalFile.get(defValues.sWork, defValues.defWorkTime);
                int rest = finalFile.get(defValues.sRest, defValues.defRestTime);
                switch(v.getId()){
                    case R.id.plus:
                        sets = sets++;
                        break;
                    case R.id.plus2:
                        work = work++;
                        break;
                    case R.id.plus3:
                        rest = rest++;
                        break;
                    case R.id.minus:
                        sets = sets--;
                        break;
                    case R.id.minus2:
                        work = work--;
                        break;
                    case R.id.minus3:
                        rest = rest--;
                        break;
                }
                utils.pushToFile(finalFile, sets, work, rest);
                setTimeTexts(sets, work, rest);
            }
        };
        editBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                v.getContext().startActivity(intent);
            }
        };
    }

    private void setOnClickListeners(){
        plus.setOnClickListener(plusMinusBtn);
        plus2.setOnClickListener(plusMinusBtn);
        plus3.setOnClickListener(plusMinusBtn);
        minus.setOnClickListener(plusMinusBtn);
        minus2.setOnClickListener(plusMinusBtn);
        minus3.setOnClickListener(plusMinusBtn);
        edit.setOnClickListener(editBtn);
    }

    private void init(){
        //Buttons
        plus = this.findViewById(R.id.plus);
        plus2 = this.findViewById(R.id.plus2);
        plus3 = this.findViewById(R.id.plus3);
        minus = this.findViewById(R.id.minus2);
        minus2 = this.findViewById(R.id.minus);
        minus3 = this.findViewById(R.id.minus3);
        edit = this.findViewById(R.id.start);
        //TextViews
        sets = this.findViewById(R.id.sets);
        rest = this.findViewById(R.id.rest);
        work = this.findViewById(R.id.work);
        settingstext = this.findViewById(R.id.textView);
        setsText = this.findViewById(R.id.textView4);
        workText = this.findViewById(R.id.textView5);
        restText = this.findViewById(R.id.textView6);
        //Layouts
        L1 = this.findViewById(R.id.startScreen);
        L2 = this.findViewById(R.id.timerScreen);
    }

    private void startActivity(){
        //Set lang
        utils.setLang(this, new file(defValues.settingsFile, this).get(defValues.sLang, defValues.LangDefault));
        //Make settings text invisible
        settingstext.setVisibility(View.GONE);
        //Set all texts again
        Resources res = this.getResources();
        setsText.setText(res.getString(R.string.sets));
        workText.setText(res.getString(R.string.work));
        restText.setText(res.getString(R.string.rest));
        edit.setText(res.getString(R.string.edit));
    }

    private void setTimeTexts(int intSets, int intWork, int intRest){
        sets.setText(String.valueOf(intSets));
        work.setText(utils.formatTime(intWork));
        rest.setText(utils.formatTime(intRest));
    }
}
