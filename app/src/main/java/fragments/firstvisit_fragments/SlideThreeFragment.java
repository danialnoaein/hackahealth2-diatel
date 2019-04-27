package fragments.firstvisit_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackahealth.diatel.R;

public class SlideThreeFragment extends Fragment {


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

    }

    private void onClick() {

    }


    private void findViews(View fragmentView) {



    }

    private void initViews() {

    }




}
