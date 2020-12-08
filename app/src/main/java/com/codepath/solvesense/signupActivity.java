package com.codepath.solvesense;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class signupActivity extends AppCompatActivity {

    EditText edEmail, edPassword, edName, edConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edName = findViewById(R.id.edName);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
    }

    // Method used to display error messages if the field is left empty
    public void signup(View view) {
        if (TextUtils.isEmpty(edName.getText())){
            edName.setError( "Name is required!" );
        }else if (TextUtils.isEmpty(edEmail.getText())){
            edEmail.setError( "Email is required!" );
        } else if (TextUtils.isEmpty(edPassword.getText())){
            edPassword.setError( "Password is required!");
            // Error shown if the password don't match the confirm password
        } else if (TextUtils.isEmpty(edConfirmPassword.getText())){
            edConfirmPassword.setError( "Confirm password is required!");
        }else if (!edPassword.getText().toString().equals(edConfirmPassword.getText().toString())){
            Toast.makeText(signupActivity.this, "Password are not the same!", Toast.LENGTH_LONG).show();
        }else {
            final ProgressDialog progress = new ProgressDialog(this);
            // Displaying a loading screen after the user clicks on sign up button
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser user = new ParseUser();
            user.setUsername(edName.getText().toString().trim());
            user.setEmail(edEmail.getText().toString().trim());
            user.setPassword(edPassword.getText().toString());
            user.put("name", edName.getText().toString().trim());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    progress.dismiss();
                    if (e == null) {
                        Toast.makeText(signupActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(signupActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(signupActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}