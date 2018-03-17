package com.sheyla.labcalificado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class formularioActivity extends AppCompatActivity {
    private Spinner spinner1;
    private RadioGroup radioGroup;
    private TextView displayText;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        radioGroup =  (RadioGroup) findViewById(R.id.radioGroup);


        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg) {

            }

        });
    }
    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // This check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    //Do something when radio button is clicked
                    Toast.makeText(getApplicationContext(), "Seleccionado correctamente.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton2:
                //Do something when radio button is clicked
                Toast.makeText(getApplicationContext(), "Seleccionado correctamente", Toast.LENGTH_SHORT).show();
                break;
        }
    }
        public void showvalue(View view){
        String item = (String)spinner1.getSelectedItem();
        Toast.makeText(this, "Item seleccionado : " + item, Toast.LENGTH_SHORT).show();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        if (radioButtonId == -1){
            Toast.makeText(this, "This field is required!", Toast.LENGTH_LONG).show();
        }
        else{
            // Individual selected
            if (radioButtonId == R.id.radioButton1){
                Toast.makeText(this, "Seleccionado correctamente", Toast.LENGTH_SHORT).show();
            }else if (radioButtonId == R.id.radioButton2){
                Toast.makeText(this, "Seleccionado correctamente", Toast.LENGTH_SHORT).show();
            }//...

            // Dinamic selected
            RadioButton radioButton = (RadioButton) findViewById(radioButtonId);
            Toast.makeText(this, "This text is " + radioButton.getText(), Toast.LENGTH_SHORT).show();
        }
    }

}

