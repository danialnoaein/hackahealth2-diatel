package hackahealth.diatel;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import danialnoaein_widgets.Button;

public class DiabetesTypeTwoTestActivity extends AppCompatActivity {

    ImageView iv_table;
    Context context;

    Button btn_show_table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_type_two_test);
        findViews();
        onClick();
    }

    private void findViews() {
        btn_show_table = findViewById(R.id.btn_show_table);
        iv_table = findViewById(R.id.iv_table);
    }
    private void onClick(){
        btn_show_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( DiabetesTypeTwoTestActivity.this );

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_diabetes_type_two_test, null);
                builder.setView(dialogView);

                final AlertDialog dialog = builder.create();
                dialog.show();

                ImageButton iv_close = dialogView.findViewById(R.id.iv_close);
                iv_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });



            }
        });
    }
    public Context getContext() {
        return context;
    }

}
