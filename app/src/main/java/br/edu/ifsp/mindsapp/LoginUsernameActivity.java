package br.edu.ifsp.mindsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import java.sql.Time;
import java.sql.Timestamp;

import br.edu.ifsp.mindsapp.model.UserModel;
import br.edu.ifsp.mindsapp.utils.AndroidUtil;
import br.edu.ifsp.mindsapp.utils.FirebaseUtil;

public class LoginUsernameActivity extends AppCompatActivity {

    EditText usernameInput;
    Button letMeInBtn;
    ProgressBar progressBar;
    String phoneNumber;

    UserModel usermodel;

    Timestamp timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_username);

        usernameInput = findViewById(R.id.login_username);
        letMeInBtn = findViewById(R.id.login_entrar_btn);
        progressBar = findViewById(R.id.login_progress_bar);


        phoneNumber = getIntent().getExtras().getString("phone");
        getUsername();

        letMeInBtn.setOnClickListener((view -> {
            setUsername();
        }));

    }

    private void setUsername(){
        setInProgress(true);
        String username = usernameInput.getText().toString();

        if(username.isEmpty() || username.length()<=3){
            usernameInput.setError("Por favor digite um nome com mais de 3 caracteres");
            return;
        }if(usermodel!=null){
            usermodel.setUsername(username);
        }else{
            usermodel = new UserModel(phoneNumber, username, timestamp.getTime());
        }

    FirebaseUtil.currentUserDetails().set(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            setInProgress(false);
            if (task.isSuccessful()){
                Intent intent = new Intent(LoginUsernameActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }
    });

    }

    private void getUsername() {
        setInProgress(true);
        FirebaseUtil.currentUserDetails().get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                setInProgress(false);
                if(task.isSuccessful()){
                    UserModel userModel = task.getResult().toObject(UserModel.class);
                    if (userModel != null){
                        usernameInput.setText(userModel.getUsername());
                    }
                }
            }
        });
    }

    private void setInProgress(boolean inProgress){
        if(inProgress){
            progressBar.setVisibility(View.VISIBLE);
            letMeInBtn.setVisibility(View.GONE);
        }
        else{
            progressBar.setVisibility(View.GONE);
            letMeInBtn.setVisibility(View.VISIBLE);
        }
    }

}