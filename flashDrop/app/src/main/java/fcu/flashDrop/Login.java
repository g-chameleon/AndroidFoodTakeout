package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
    }

    public void Check(View v) {

        String ausername = "D0870757";
        String apassword = "123";
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (user.equals(ausername) && pass.equals(apassword)) {
            Toast.makeText(this,"Welcome!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Sorry,please try agin!",Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View v) {
        Intent it = new Intent(this, user.class);
        startActivity(it);
    }

}