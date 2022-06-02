package fcu.flashDrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class reg extends AppCompatActivity implements OnCompleteListener{
    private EditText User_Email;
    private EditText User_password;
    private EditText User_phone;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reg);

        User_Email = findViewById(R.id.Username);
        User_password = findViewById(R.id.Password_reg);
        User_phone = findViewById(R.id.Phone_reg);

        firebaseAuth = FirebaseAuth.getInstance();

    }
    public void OnRegister(View view){
        String email = User_Email.getText().toString();
        String password = User_password.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this,this);
    }
    public void onClick(View v) {
        Intent it = new Intent(this, user.class);
        startActivity(it);
    }

    @Override
    public void onComplete(@NonNull Task task) {
        if (task.isSuccessful()){
            Toast.makeText(this, "注冊成功", Toast.LENGTH_SHORT).show();
            addUser();
            finish();
        }
        else{
            Toast.makeText(this, "注冊失敗", Toast.LENGTH_SHORT).show();
        }
    }

    public void Oncancel(View view) {
        finish();
    }
    private void addUser(){
        String email = User_Email.getText().toString();
        String phone = User_phone.toString().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = firebaseDatabase.getReference("users");
        DatabaseReference phoneRef = usersRef.child(phone);
        Map<String,Object> user = new HashMap<>();
        user.put("email",email);
        user.put("phone",phone);
        phoneRef.updateChildren(user);
    }

}