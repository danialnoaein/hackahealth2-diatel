package fragments.main_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackahealth.diatel.R;

public class ReminderFragment extends Fragment {


    public static ReminderFragment newInstance() {
        Bundle args = new Bundle();
        ReminderFragment fragment = new ReminderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main_reminder, container, false);
        findViews(fragmentView);
        return fragmentView;
    }

    private void findViews(View fragmentView) {
        //rv_educational_category = fragmentView.findViewById(R.id.rv_educational_category);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }




}

