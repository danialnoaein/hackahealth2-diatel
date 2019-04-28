package hackahealth.diatel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.github.ybq.android.spinkit.SpinKitView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.Map;

import cz.msebera.android.httpclient.Header;
import danialnoaein_widgets.ButtonBold;
import danialnoaein_widgets.CheckBox;
import danialnoaein_widgets.EditText;
import danialnoaein_widgets.RadioButton;
import danialnoaein_widgets.TextView;
import danialnoaein_widgets.Toast;

public class ImmediateCheckupActivity extends AppCompatActivity {

    ButtonBold btn_checkup;
    LinearLayout ll_glu_guide;

    EditText et_blood_sugar;

    RadioGroup rg_checkup_time;
    RadioButton rb_checkup_time_0, rb_checkup_time_1, rb_checkup_time_2, rb_checkup_time_3, rb_checkup_time_4, rb_checkup_time_5;

    CheckBox cb_frequentUrination, cb_dryMouth, cb_excessiveThirst, cb_suddenFeeling, cb_feelingBurningHands;

    int bloodSugarTime = 7;
    int frequentUrination = 0;
    int dryMouth = 0;
    int excessiveThirst = 0;
    int suddenFeeling = 0;
    int feelingBurningHands = 0;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    SpinKitView pb_loading;

    String HAS_DIABETES_KEY = "has_diabetes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immediate_checkup);

        findViews();
        initViews();
        onClick();

        sharedPref = getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        editor = sharedPref.edit();

    }

    private void findViews() {
        btn_checkup = findViewById(R.id.btn_checkup);
        ll_glu_guide = findViewById(R.id.ll_glu_guide);
        et_blood_sugar = findViewById(R.id.et_blood_sugar);

        rg_checkup_time = findViewById(R.id.rg_checkup_time);

        rb_checkup_time_0 = findViewById(R.id.rb_checkup_time_0);
        rb_checkup_time_1 = findViewById(R.id.rb_checkup_time_1);
        rb_checkup_time_2 = findViewById(R.id.rb_checkup_time_2);
        rb_checkup_time_3 = findViewById(R.id.rb_checkup_time_3);
        rb_checkup_time_4 = findViewById(R.id.rb_checkup_time_4);
        rb_checkup_time_5 = findViewById(R.id.rb_checkup_time_5);

        cb_frequentUrination = findViewById(R.id.cb_frequentUrination);
        cb_dryMouth = findViewById(R.id.cb_dryMouth);
        cb_excessiveThirst = findViewById(R.id.cb_excessiveThirst);
        cb_suddenFeeling = findViewById(R.id.cb_suddenFeeling);
        cb_feelingBurningHands = findViewById(R.id.cb_feelingBurningHands);


        pb_loading = findViewById(R.id.pb_loading);

    }

    private void initViews() {

        rg_checkup_time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_checkup_time_0:
                        bloodSugarTime = 0;
                        break;
                    case R.id.rb_checkup_time_1:
                        bloodSugarTime = 1;
                        break;
                    case R.id.rb_checkup_time_2:
                        bloodSugarTime = 2;
                        break;
                    case R.id.rb_checkup_time_3:
                        bloodSugarTime = 3;
                        break;
                    case R.id.rb_checkup_time_4:
                        bloodSugarTime = 4;
                        break;
                    case R.id.rb_checkup_time_5:
                        bloodSugarTime = 5;
                        break;
                }
            }
        });

        if (cb_frequentUrination.isChecked()) {
            frequentUrination = 1;
        }
        if (cb_dryMouth.isChecked()) {
            dryMouth = 1;
        }
        if (cb_excessiveThirst.isChecked()) {
            excessiveThirst = 1;
        }
        if (cb_suddenFeeling.isChecked()) {
            suddenFeeling = 1;
        }
        if (cb_feelingBurningHands.isChecked()) {
            feelingBurningHands = 1;
        }

    }

    private void onClick() {
        btn_checkup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerCheckUpInServer();
                checkUp();
                pb_loading.setVisibility(View.VISIBLE);
                btn_checkup.setVisibility(View.GONE);

            }
        });

        ll_glu_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImmediateCheckupActivity.this, GlucometerGuideActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void registerCheckUpInServer() {

        RequestParams params = new RequestParams();
        params.put("bloodSuger", et_blood_sugar.getText().toString());
        params.put("checkupTime", bloodSugarTime);
        params.put("frequentUrination", frequentUrination);
        params.put("dryMouth", dryMouth);
        params.put("excessiveThirst", excessiveThirst);
        params.put("suddenFeeling", suddenFeeling);
        params.put("feelingBurningHands", feelingBurningHands);
        params.put("feelingBurningHands", feelingBurningHands);
        params.put("dangerLevel", getDangerLevel());
        params.put("userId", sharedPref.getInt("userId", 0));

        String requestUrl = "http://noaein.ir/diatel/index.php/app/registerCheckup";

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(requestUrl, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                Log.e("statusCode", statusCode + "");
                Log.e("responseString", responseString + "");
                Log.e("throwable", throwable + "");
                Toast.makeTEXT(getApplicationContext(), "خطا در ارسال اطلاعات", Toast.TOAST_TYPE_DEFAULT);
                pb_loading.setVisibility(View.GONE);
                btn_checkup.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                Log.e("statusCode", statusCode + "");
                Log.e("responseString", responseString + "");
                //startResultActivity();
            }
        });
        
    }

    private void checkUp() {

        Intent intent = new Intent(ImmediateCheckupActivity.this , CheckUpResultActivity.class);
        intent.putExtra("DANGER_LEVEL" , getDangerLevel());//Danger Level
        startActivity(intent);
        finish();

    }

    private boolean checkBloodSugarLevelDanger() {
        int bloodSugarNumber = Integer.parseInt(et_blood_sugar.getText().toString());
        int hasDiabetes = sharedPref.getInt(HAS_DIABETES_KEY,0);

        if (rb_checkup_time_0.isChecked()) {
            if (hasDiabetes == 0) {
                if (bloodSugarNumber > 70 && bloodSugarNumber < 99) {
                    return false;
                } else {
                    return true;
                }
            } else if (hasDiabetes == 1) {
                if (bloodSugarNumber > 80 && bloodSugarNumber < 130) {
                    return false;
                } else {
                    return true;
                }
            }
        } else if (rb_checkup_time_1.isChecked()) {
            if (hasDiabetes == 0) {
                if (bloodSugarNumber > 80 && bloodSugarNumber < 140) {
                    return false;
                } else {
                    return true;
                }
            } else if (hasDiabetes == 1) {
                if (bloodSugarNumber > 100 && bloodSugarNumber < 180) {
                    return false;
                } else {
                    return true;
                }
            }
        } else if (rb_checkup_time_2.isChecked()) {

            if (bloodSugarNumber > 65 && bloodSugarNumber < 95) {
                return false;
            } else {
                return true;
            }

        } else if (rb_checkup_time_3.isChecked()) {

            if (bloodSugarNumber > 65 && bloodSugarNumber < 130) {
                return false;
            } else {
                return true;
            }

        } else if (rb_checkup_time_4.isChecked()) {

            if (bloodSugarNumber > 60 && bloodSugarNumber < 99) {
                return false;
            } else {
                return true;
            }

        } else if (rb_checkup_time_5.isChecked()) {

            if (bloodSugarNumber > 100 && bloodSugarNumber < 129) {
                return false;
            } else {
                return true;
            }

        }


        return true;

    }

    private int getDangerLevel(){

        int dangerLevel;
        if ( cb_frequentUrination.isChecked() || cb_dryMouth.isChecked() || cb_excessiveThirst.isChecked() || cb_suddenFeeling.isChecked() || cb_feelingBurningHands.isChecked() ){
            dangerLevel = 2;
        }else{
            if ( checkBloodSugarLevelDanger()){
                dangerLevel = 1;
            }else{
                dangerLevel = 0;
            }
        }
        return dangerLevel;
    }


}
