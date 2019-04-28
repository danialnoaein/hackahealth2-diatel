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
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import danialnoaein_widgets.EditText;
import danialnoaein_widgets.RadioButton;
import hackahealth.diatel.R;

public class SlideThreeFragment extends Fragment {

    RadioGroup rg_have_diabet;
    RadioButton rb_yes,rb_no;

    LinearLayout ll_diabet_type;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String HAVE_DIABET_KEY = "have_diabet";
    String FAMILY_DESEIS = "family_deseis";

    EditText et_family_deseis;

    public static SlideThreeFragment newInstance() {

        Bundle args = new Bundle();
        SlideThreeFragment fragment = new SlideThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_first_visit_slide_three, container , false);
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

        rg_have_diabet = fragmentView.findViewById(R.id.rg_have_diabet);
        rb_yes = fragmentView.findViewById(R.id.rb_yes);
        rb_no = fragmentView.findViewById(R.id.rb_no);

        et_family_deseis = fragmentView.findViewById(R.id.et_family_deseis);

        ll_diabet_type = fragmentView.findViewById(R.id.ll_diabet_type);

    }

    private void initViews() {

        rg_have_diabet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_yes:
                        editor.putInt(HAVE_DIABET_KEY , 1);
                        ll_diabet_type.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_no:
                        editor.putInt(HAVE_DIABET_KEY , 0);
                        ll_diabet_type.setVisibility(View.GONE);
                        break;
                }
                editor.commit();
            }
        });

        et_family_deseis.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                editor.putString(FAMILY_DESEIS, s + "");
                editor.commit();


            }
        });

    }

}
