package fragments.firstvisit_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import danialnoaein_widgets.ButtonBold;
import hackahealth.diatel.MainActivity;
import hackahealth.diatel.R;

public class SlideFourFragment extends Fragment {

    ButtonBold btn_register;
    public static SlideFourFragment newInstance() {

        Bundle args = new Bundle();
        SlideFourFragment fragment = new SlideFourFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_first_visit_slide_four, container , false);
        findViews( fragmentView );
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        onClick();

    }

    private void onClick() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext() , MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }


    private void findViews(View fragmentView) {

        btn_register = fragmentView.findViewById(R.id.btn_register);

    }

    private void initViews() {

    }

}
