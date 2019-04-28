package fragments.main_fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.VideoView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;

import danialnoaein_widgets.Button;
import danialnoaein_widgets.TextView;
import hackahealth.diatel.GlucometerGuideActivity;
import hackahealth.diatel.ImmediateCheckupActivity;
import hackahealth.diatel.R;

public class RegimeFragment extends Fragment {

    Button btn_change_week_day;
    public static RegimeFragment newInstance() {
        Bundle args = new Bundle();
        RegimeFragment fragment = new RegimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main_regime, container, false);
        findViews(fragmentView);

        return fragmentView;
    }

    private void findViews(View fragmentView) {
        btn_change_week_day = fragmentView.findViewById(R.id.btn_change_week_day);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClick();
    }

    private void onClick(){
        btn_change_week_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = requireActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_days_of_week, null);
                builder.setView(dialogView);
                final AlertDialog dialog = builder.create();
                dialog.show();

                RadioGroup rg_days_of_week = dialogView.findViewById(R.id.rg_days_of_week);
                rg_days_of_week.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        dialog.dismiss();
                    }
                });




            }
        });
    }

}

