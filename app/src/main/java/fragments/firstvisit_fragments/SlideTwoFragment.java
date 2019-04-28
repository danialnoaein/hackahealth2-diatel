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

import danialnoaein_widgets.EditText;
import hackahealth.diatel.R;

public class SlideTwoFragment extends Fragment {

    EditText et_height, et_weight;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String WEIGHT_KEY = "weight";
    String HEIGHT_KEY = "height";

    public static SlideTwoFragment newInstance() {

        Bundle args = new Bundle();
        SlideTwoFragment fragment = new SlideTwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_first_visit_slide_two, container , false);
        findViews( fragmentView );
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

    }

    private void findViews(View fragmentView) {

        et_height = fragmentView.findViewById(R.id.et_height);
        et_weight = fragmentView.findViewById(R.id.et_weight);

    }

    private void initViews() {

        et_height.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                editor.putInt(WEIGHT_KEY , Integer.parseInt(s.toString()) );
                editor.commit();
            }
        });

        et_weight.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                editor.putInt(HEIGHT_KEY , Integer.parseInt(s.toString()) );
                editor.commit();
            }
        });

    }




}
