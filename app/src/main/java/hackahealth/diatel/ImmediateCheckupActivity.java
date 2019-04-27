package hackahealth.diatel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import danialnoaein_widgets.ButtonBold;

public class ImmediateCheckupActivity extends AppCompatActivity {

    ButtonBold btn_checkup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immediate_checkup);

        findViews();
        initViews();
        onClick();

    }

    private void findViews() {
        btn_checkup = findViewById(R.id.btn_checkup);
    }

    private void initViews() {

    }

    private void onClick() {
        btn_checkup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ImmediateCheckupActivity.this, CheckUpResultActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
