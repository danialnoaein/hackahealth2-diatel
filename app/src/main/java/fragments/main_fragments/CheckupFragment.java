package fragments.main_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import danialnoaein_widgets.TextView;
import hackahealth.diatel.ImmediateCheckupActivity;
import hackahealth.diatel.R;

public class CheckupFragment extends Fragment {

    RecyclerView rv_main_checkup;
    TextView tv_no_checkup;
    LinearLayout ll_im_checkup;

    public static CheckupFragment newInstance() {
        Bundle args = new Bundle();
        CheckupFragment fragment = new CheckupFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main_checkup, container, false);
        findViews(fragmentView);
        return fragmentView;
    }

    private void findViews(View fragmentView) {
        rv_main_checkup = fragmentView.findViewById(R.id.rv_main_checkups);
        tv_no_checkup = fragmentView.findViewById(R.id.tv_no_checkup);
        ll_im_checkup = fragmentView.findViewById(R.id.ll_im_checkup);
        initRecyclerView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClick();
    }


    private void initRecyclerView() {
        rv_main_checkup.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

    }

    private void onClick(){
        ll_im_checkup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , ImmediateCheckupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void noCheckup(){
        tv_no_checkup.setVisibility(View.VISIBLE);
    }

}

