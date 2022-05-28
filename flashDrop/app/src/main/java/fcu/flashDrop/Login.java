package fcu.flashDrop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements OnCompleteListener<AuthResult> {
    EditText username;
    EditText password;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void onLogin(View view){
        String useremail = username.getText().toString();
        String userpassword = password.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(this,this);
    }

    public void reg(View v) {
        Intent it = new Intent(this, reg.class);
        startActivity(it);
    }

    public void onClick(View v) {
        Intent it = new Intent(this, user.class);
        startActivity(it);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){
            Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show();
            MainActivity.VALID_USER = true;
            finish();
        }
        else {
            Toast.makeText(this,"登入失敗",Toast.LENGTH_SHORT).show();
        }
    }
}