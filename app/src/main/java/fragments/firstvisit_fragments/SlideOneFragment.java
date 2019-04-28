package fragments.firstvisit_fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import danialnoaein_widgets.EditText;
import danialnoaein_widgets.RadioButton;
import danialnoaein_widgets.Toast;
import hackahealth.diatel.R;

import static danialnoaein_widgets.Toast.TOAST_TYPE_DEFAULT;

public class SlideOneFragment  extends Fragment {

    RadioGroup rg_gender;
    RadioButton rb_man,rb_woman;
    EditText et_name, et_age;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String NAME_KEY = "name";
    String AGE_KEY = "age";
    String GENDER_KEY = "gender";

    public static SlideOneFragment newInstance() {

        Bundle args = new Bundle();
        SlideOneFragment fragment = new SlideOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_first_visit_slide_one, container , false);
        findViews( fragmentView );
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        onClick();

        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    private void onClick() {

    }

    private void findViews(View fragmentView) {

        et_name = fragmentView.findViewById(R.id.et_name);
        et_age = fragmentView.findViewById(R.id.et_age);
        rg_gender = fragmentView.findViewById(R.id.rg_gender);
        rb_man = fragmentView.findViewById(R.id.rb_man);
        rb_woman = fragmentView.findViewById(R.id.rb_woman);

    }

    private void initViews() {

        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_man:
                        editor.putInt(GENDER_KEY , 1);
                        break;
                    case R.id.rb_woman:
                        editor.putInt(GENDER_KEY , 0);
                        break;
                }
                editor.commit();
            }
        });

        et_name.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                editor.putString(NAME_KEY , s + "");
                editor.commit();
            }
        });

        et_age.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                editor.putInt(AGE_KEY , Integer.parseInt(s.toString()) );
                editor.commit();
            }
        });

    }



}
