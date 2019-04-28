package fragments.firstvisit_fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import danialnoaein_widgets.ButtonBold;
import danialnoaein_widgets.EditText;
import hackahealth.diatel.MainActivity;
import hackahealth.diatel.R;

public class SlideFourFragment extends Fragment {

    EditText et_phone_number, et_nurse_phone_number;
    ButtonBold btn_register;
    SpinKitView pb_loading;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    //    Shared Pref Keys
    String NAME_KEY = "name";
    String AGE_KEY = "age";
    String GENDER_KEY = "gender";

    String WEIGHT_KEY = "weight";
    String HEIGHT_KEY = "height";

    String HAS_DIABETES_KEY = "has_diabetes";
    String FAMILY_DESEIS = "family_deseis";

    String PHONE_NUMBER_KEY = "phone_number";
    String NURSE_PHONE_NUMBER_KEY = "nurse_phone_number";

    public static SlideFourFragment newInstance() {

        Bundle args = new Bundle();
        SlideFourFragment fragment = new SlideFourFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_first_visit_slide_four, container, false);
        findViews(fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        onClick();

        sharedPref = getContext().getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        editor = sharedPref.edit();

    }

    private void onClick() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sharedPref.getString(PHONE_NUMBER_KEY, "").equals("")) {
                    showError();
                } else {
                    btn_register.setVisibility(View.GONE);
                    pb_loading.setVisibility(View.VISIBLE);
                    registerUserInServer();
                }

            }
        });
    }

    private void registerUserInServer() {

        RequestParams params = new RequestParams();
        params.put("name", sharedPref.getString(NAME_KEY, ""));
        params.put("age", sharedPref.getInt(AGE_KEY, 0));
        params.put("gender", sharedPref.getInt(GENDER_KEY, 2));
        params.put("height", sharedPref.getInt(HEIGHT_KEY, 0));
        params.put("weight", sharedPref.getInt(WEIGHT_KEY, 0));
        params.put("diseaseHistory", 0);
        params.put("familyDisease", sharedPref.getString(FAMILY_DESEIS, ""));
        params.put("diabetType", sharedPref.getInt(HAS_DIABETES_KEY, 0));
        params.put("phoneNumber", sharedPref.getString(PHONE_NUMBER_KEY, ""));
        params.put("nursePhoneNuber", sharedPref.getString(NURSE_PHONE_NUMBER_KEY, ""));
        String requestUrl = "http://noaein.ir/diatel/index.php/app/registerUser";

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(requestUrl, params, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                Log.e("statusCode", statusCode + "");
                Log.e("responseString", responseString + "");
                Log.e("throwable", throwable + "");

                if (statusCode == 0){
                    btn_register.setVisibility(View.VISIBLE);
                    pb_loading.setVisibility(View.GONE);
                    danialnoaein_widgets.Toast.makeTEXT(getContext() , "خطا در برقراری ارتباط با سرور" , danialnoaein_widgets.Toast.TOAST_TYPE_DEFAULT);
                }

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                Log.e("statusCode", statusCode + "");
                Log.e("responseString", responseString + "");
                startMainActivity();
            }
        });


    }


    private void findViews(View fragmentView) {

        btn_register = fragmentView.findViewById(R.id.btn_register);
        et_phone_number = fragmentView.findViewById(R.id.et_phone_number);
        et_nurse_phone_number = fragmentView.findViewById(R.id.et_nurse_phone_number);
        pb_loading = fragmentView.findViewById(R.id.pb_loading);

    }

    private void initViews() {

        et_phone_number.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                editor.putString(PHONE_NUMBER_KEY, s + "");
                editor.commit();


            }
        });

        et_nurse_phone_number.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (count == 11) {
                    editor.putString(NURSE_PHONE_NUMBER_KEY, s + "");
                    editor.commit();
                }
            }
        });

    }

    private void showError() {
        Toast.makeText(getActivity().getApplicationContext(), "لطفا شماره تلفن را وارد کنید", Toast.LENGTH_SHORT).show();
    }

    private void startMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();

    }
}
