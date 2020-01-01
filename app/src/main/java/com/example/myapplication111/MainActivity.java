package com.example.myapplication111;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public TextInputEditText input_name, input_password;
    public TextInputLayout name_layout, password_layout;
    public Spinner spinner_names, spinner_products;
    public RadioButton male, female;
    public String checked_value =null;
    public RadioGroup radioGroup;
    public CheckBox checkBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.group);

        //String radiovalue = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();


        checkBox = findViewById(R.id.check_updates);

        male  = findViewById(R.id.male);
        female = findViewById(R.id.female);

        input_name = findViewById(R.id.name_et);

        input_name.addTextChangedListener(new mytextwatcher(input_name));



        input_password = findViewById(R.id.passwor_et);

        input_password.addTextChangedListener(new mytextwatcher(input_password));

        password_layout = findViewById(R.id.password_layout);
        name_layout = findViewById(R.id.name_layout);

        spinner_names = findViewById(R.id.spinner_names);
        spinner_products = findViewById(R.id.spinner_products);

        ArrayList<String> names_array = new ArrayList<String>();
        ArrayList<String> products_array  = new ArrayList<String>();

        names_array.add("mohammed");
        names_array.add("saleh");
        names_array.add("khaled");
        names_array.add("ameen");


        products_array.add("shampoo");
        products_array.add("laptop");
        products_array.add("mouse");




        ArrayAdapter<String> names_adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner, names_array);
        ArrayAdapter<String> products_adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner, products_array);

        names_adapter.setDropDownViewResource(R.layout.spinner);
        products_adapter.setDropDownViewResource(R.layout.spinner);

        spinner_names.setAdapter(names_adapter);
        spinner_products.setAdapter(products_adapter);



        spinner_names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){

                    case 1:
                        input_name.setBackgroundColor(Color.BLUE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });














    }

    public boolean isvalidname(){

        if (input_name.getText().toString().trim().isEmpty()){
            name_layout.setError("name cannot be empty");
            return false;

        }
        else{
            name_layout.setErrorEnabled(false);

        }
        return true;
    }

    public boolean isvalidpassword(){

        if (input_password.getText().toString().trim().isEmpty()){
            password_layout.setError("password cannot be empty");
            return false;

        }
        else{
            password_layout.setErrorEnabled(false);

        }
        return true;
    }




    public void go(View view) {


//        if (!male.isChecked() && !female.isChecked()){
//
//            Toast.makeText(getApplicationContext(), "you must choose your gender", Toast.LENGTH_LONG).show();
//        }

//        if (male.isChecked()){
//
//            checked_value = male.toString();
//
//        }


//        else if (female.isChecked()){
//            checked_value = female.toString();
//        }

        //String radiovalue = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();


        //Toast.makeText(getApplicationContext(), radiovalue, Toast.LENGTH_LONG).show();


        if (!checkBox.isChecked()) {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Warning")
                    .setMessage("Are you sure you don't want to get updates")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           Toast.makeText(getApplicationContext(), "okay", Toast.LENGTH_LONG).show();
                           }                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"Go check the updates",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
            // Create the AlertDialog object and return it

        }

        }




    public  class mytextwatcher implements TextWatcher{

       private View view;

       public mytextwatcher(View view){

           this.view = view;
       }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

           switch (view.getId()){

               case R.id.name_et:
                   isvalidname();
                   break;

               case R.id.passwor_et:
                   isvalidpassword();
                   break;
           }

        }
    }
}
