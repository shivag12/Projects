package com.example.shiva.gallery500px;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class GallerySignUp extends AppCompatActivity {

    EditText editTextFirstLastName;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    EditText editTextEmail;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_sign_up);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        editTextFirstLastName = (EditText) findViewById(R.id.eTxtUserFirstLastName);
        editTextEmail = (EditText) findViewById(R.id.eTxtEmail);
        editTextPassword = (EditText) findViewById(R.id.EtxtPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.eTxtConfirmPassword);
        btnSignup = (Button) findViewById(R.id.btnSignUp);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("First&Last Name", editTextFirstLastName.getText().toString());

                ParseUser parseNewUser = new ParseUser();
                parseNewUser.put("username",editTextFirstLastName.getText().toString());
                parseNewUser.put("password",editTextPassword.getText().toString());
                parseNewUser.put("email",editTextEmail.getText().toString());

                parseNewUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            editTextConfirmPassword.getText().clear();
                            editTextEmail.getText().clear();
                            editTextPassword.getText().clear();
                            editTextFirstLastName.getText().clear();
                            Toast.makeText(GallerySignUp.this,"Inserted Successfully",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Toast.makeText(GallerySignUp.this,"Back Button is pressed",Toast.LENGTH_LONG).show();
    }
}
