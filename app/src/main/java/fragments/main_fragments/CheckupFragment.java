package fragments.main_fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.nineoldandroids.animation.ValueAnimator;

import java.util.ArrayList;

import danialnoaein_widgets.TextView;
import danialnoaein_widgets.TextViewBold;
import hackahealth.diatel.GlucometerGuideActivity;
import hackahealth.diatel.ImmediateCheckupActivity;
import hackahealth.diatel.R;

import static android.view.animation.Animation.RESTART;
import static android.view.animation.Animation.REVERSE;

public class CheckupFragment extends Fragment {

    RecyclerView rv_main_checkup;
    TextViewBold tvb_start_checkup_btn_title;
    TextView tv_tap_hint;
    //AnyChartView anyChartView;
    LineChart chart;
    LinearLayout ll_im_checkup , ll_diabetes_risk_test;

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
        ll_diabetes_risk_test = fragmentView.findViewById(R.id.ll_diabetes_risk_test);
        ll_im_checkup = fragmentView.findViewById(R.id.ll_im_checkup);
        chart = fragmentView.findViewById(R.id.chart);
        tvb_start_checkup_btn_title = fragmentView.findViewById(R.id.tvb_start_checkup_btn_title);
        tv_tap_hint = fragmentView.findViewById(R.id.tv_tap_hint);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClick();
        lineChart();
        zoom();
    }

    private void onClick(){
        ll_im_checkup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , GlucometerGuideActivity.class);
                startActivity(intent);
            }
        });


    }

    private void lineChart(){

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 110));
        entries.add(new Entry(1, 150));
        entries.add(new Entry(2, 105));
        entries.add(new Entry(3, 120));
        entries.add(new Entry(4, 130));

        LineDataSet dataSet = new LineDataSet(entries, "قند خون ناشتا");
        dataSet.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        dataSet.setValueTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));

        ArrayList<Entry> entriesB = new ArrayList<>();
        entriesB.add(new Entry(0, 140));
        entriesB.add(new Entry(1, 170));
        entriesB.add(new Entry(2, 135));
        entriesB.add(new Entry(3, 130));
        entriesB.add(new Entry(4, 120));

        LineDataSet dataSetB = new LineDataSet(entriesB, "قند خون دو ساعت قبل از غذا");
        dataSetB.setColor(ContextCompat.getColor(getContext(), R.color.colorPink));
        dataSetB.setValueTextColor(ContextCompat.getColor(getContext(), R.color.colorPinkDark));

        //****
        // Controlling X axis
        XAxis xAxis = chart.getXAxis();
        // Set the xAxis position to bottom. Default is top
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //Customizing x axis value
        final String[] months = new String[]{"10 اردیبهشت","20 اردیبهشت", "30 اردیبهشت", "10 خرداد", "20 خرداد"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return months[(int) value];
            }
        };
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter( formatter);

        //***
        // Controlling right side of y axis
        YAxis yAxisRight = chart.getAxisRight();
        yAxisRight.setEnabled(false);

        //***
        // Controlling left side of y axis
        YAxis yAxisLeft = chart.getAxisLeft();
        yAxisLeft.setGranularity(1f);

        // Setting Data
        LineData data = new LineData(dataSet , dataSetB);
        chart.setData(data);
        chart.animateX(1000);

        //refresh
        chart.invalidate();
        chart.setScaleEnabled(false);

    }

    public void zoom(){

//        Animation animation = AnimationUtils.loadAnimation(getContext(),
//                R.anim.animation_zoom);
//        tvb_start_checkup_btn_title.startAnimation(animation);
//        animation.setRepeatMode(Animation.INFINITE);

        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(tv_tap_hint, "scaleX", 1.0f, 1.1f , 1.0f);
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim.setRepeatMode(ValueAnimator.REVERSE/RESTART);
        scaleAnim.start();




    }
}

