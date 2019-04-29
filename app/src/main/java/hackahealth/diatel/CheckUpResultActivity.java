package hackahealth.diatel;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import danialnoaein_widgets.Button;
import danialnoaein_widgets.ButtonBold;
import danialnoaein_widgets.TextView;
import danialnoaein_widgets.Toast;

public class CheckUpResultActivity extends AppCompatActivity {

    ButtonBold btn_go_to_main_activity,btn_get_regime_program;
    TextView tv_result_message;

    LinearLayout ll_container_bg,ll_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up_result);

        findViews();
        onClick();

        Intent intent = getIntent();
        int dangerLevel = intent.getIntExtra("DANGER_LEVEL" ,0);
        changeBackgroundColor(dangerLevel);
        showResultMessage(dangerLevel);

    }

    private void showResultMessage(int dangerLevel) {

        switch (dangerLevel){
            case 0:
                tv_result_message.setText(R.string.danger_level_0);
                break;
            case 1:
                tv_result_message.setText(R.string.danger_level_1);
                break;
            case 2:
                tv_result_message.setText(R.string.danger_level_2);
                break;

        }
    }

    private void onClick() {
        btn_go_to_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( CheckUpResultActivity.this , MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        btn_get_regime_program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeTEXT(getApplicationContext() , "برنامه تغذیه افزوده شد" , Toast.TOAST_TYPE_DEFAULT);
            }
        });
    }

    private void findViews() {

        btn_go_to_main_activity = findViewById(R.id.btn_go_to_main_activity);
        btn_get_regime_program = findViewById(R.id.btn_get_regime_program);
        tv_result_message = findViewById(R.id.tv_result_message);
        ll_container_bg = findViewById(R.id.ll_container_bg);
        ll_toolbar = findViewById(R.id.ll_toolbar);
    }

    private void changeBackgroundColor( int dangerLevel ) {

        int color = R.color.firstVisitSlideBackground;
        switch (dangerLevel){
            case 0:
                color = R.color.firstVisitSlideBackground;
                break;
            case 1:
                color = R.color.colorAccent;
                break;
            case 2:
                color = R.color.colorError;
                break;
        }
        ll_container_bg.setBackgroundColor(getResources().getColor(color));
        ll_toolbar.setBackgroundColor(getResources().getColor(color));
        Window window = CheckUpResultActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(CheckUpResultActivity.this.getResources().getColor(color));
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent( CheckUpResultActivity.this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
