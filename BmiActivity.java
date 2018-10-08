package com.example.lokie.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BmiActivity extends AppCompatActivity {
    @BindView(R.id.editText)
    EditText edt_height;
    @BindView(R.id.editText2)
    EditText edt_weight;

    @BindView(R.id.textView)
    TextView txv_result;
    @BindView(R.id.textView1)
    TextView txv_idwm;
    //  @BindView(R.id.editText) EditText edt_height;
    DecimalFormat d2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        ButterKnife.bind(this);
//        Button btn_calc;
//        final EditText edt_height, edt_weight;
//        final TextView txv_result, txv_idwm;
//        btn_calc = findViewById(R.id.button1);
//         edt_height = findViewById(R.id.editText);
//        edt_weight = findViewById(R.id.editText2);
//        txv_result = findViewById(R.id.textView);
//        txv_idwm = findViewById(R.id.textView1);
//@BindView(R.id.editText) EditText edt_height;
        edt_weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double ht, wt, rst, ht2;
                String ht0, wt0, res;
                ht0 = edt_height.getText().toString();
                wt0 = edt_weight.getText().toString();
                if (ht0.equals("")) {
                    ht2 = 0.0;
                } else ht2 = Integer.parseInt(ht0);
                if (wt0.equals("")) {
                    wt = 0.0;
                } else wt = Integer.parseInt(wt0);
                rst = bmiCalc(ht2, wt);
                res = Double.toString(rst);
                txv_result.setText(res);
            }
        });
        edt_height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double ht5, idealWeight;
                String ht4 = edt_height.getText().toString();
                if (ht4.equals("")) {
                    ht5 = 0.0;
                } else ht5 = Integer.parseInt(ht4);
                idealWeight = idealWeightDef(ht5);
                DecimalFormat d2 = new DecimalFormat(".#");
                double d1 = Double.parseDouble(d2.format(idealWeight));
                String idwdisp = Double.toString(d1);
                txv_idwm.setText(idwdisp);
            }
        });

//        btn_calc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                double ht, wt, rst,ht2;
//                String ht0, wt0, res;
//                ht0 = edt_height.getText().toString();
//                wt0 = edt_weight.getText().toString();
//                ht2 = Integer.parseInt(ht0);
//                wt = Integer.parseInt(wt0);
//                rst = bmiCalc(ht2, wt);
//                res = Double.toString(rst);
//                txv_result.setText(res);
//            }
//        });
    }

    public double bmiCalc(double height, double weight) {
//        if(height==NULL || weight==NULL)
////        {
////            if(height==NULL)
////            {
////                height=0;
////            }else if(weight==NULL)
////            {
////                weight=0;
////            }
////        }
        double result, ht;
        ht = height / 100;
        result = weight / (ht * ht);

        return Double.parseDouble(d2.format(result));
    }

    public double cmToinch(double cm) {
        double oneCm = 0.393701;
        double inch = cm * oneCm;
        return inch;
    }
    public double cmToMeter(double cm)
    {
        double meter=cm/100;
        return meter;
    }

    public double kgTopound(double kg) {
        double onePound = 0.453592;
        double pound = onePound * kg;
        return pound;
    }
public double idealWeightDef(double height)
{
    double htIninch = cmToinch(height);
    double tempidw = htIninch - 60;
        double tempidw1 = tempidw * 2.26796;
        double idwm = tempidw1 + 49.8952;
        return idwm;
}
public double idealWeightRob(double height,int gen)
{
    double htIninch = cmToinch(height);
    if(gen==0)
    {
        double tempidw = htIninch - 60;
            double tempidw1 = tempidw * 1.9;
            double idwm = tempidw1 + 52;
            return idwm;
    }
    else
    {
        double tempidw = htIninch - 60;
                double tempidw1 = tempidw * 1.7;
                double idwm = tempidw1 + 49;
                return idwm;
    }

}
public double idealWeightMill(double height,int gen)
{
    double htIninch = cmToinch(height);
    if (gen==0)
    {
        double tempidw = htIninch - 60;
            double tempidw1 = tempidw * 1.41;
            double idwm = tempidw1 + 56.2;
            return idwm;
    }else
    {
        double tempidw = htIninch - 60;
                double tempidw1 = tempidw * 1.36;
                double idwm = tempidw1 + 53.1;
                return idwm;
    }
}
public double idealWeightHan(double height,int gen)
{
    double htIninch = cmToinch(height);
    if(gen==0)
    {
        double tempidw = htIninch - 60;
            double tempidw1 = tempidw * 2.7;
            double idwm = tempidw1 + 48;
            return idwm;
    }else
    {
        double tempidw = htIninch - 60;
                double tempidw1 = tempidw * 2.2;
                double idwm = tempidw1 + 45.5;
                return idwm;
    }

}
public double idealWeightlem(double height)
{
    double htInMet=cmToMeter(height);
    double idw=22*htInMet;
    return idw;
}
//    public double idealWeight(double height) {
//        int id=0;
//        int gen=0;
//        double htIninch = cmToinch(height);
//        if(gen==0){
//        if (id==1){
//        double tempidw = htIninch - 60;
//        double tempidw1 = tempidw * 2.26796;
//        double idwm = tempidw1 + 49.8952;
//        return idwm;
//        }else if(id==2)
//        {
//            double tempidw = htIninch - 60;
//            double tempidw1 = tempidw * 1.9;
//            double idwm = tempidw1 + 52;
//            return idwm;
//        }else if(id==3)
//        {
//            double tempidw = htIninch - 60;
//            double tempidw1 = tempidw * 1.41;
//            double idwm = tempidw1 + 56.2;
//            return idwm;
//        }else if(id==4)
//        {
//            double tempidw = htIninch - 60;
//            double tempidw1 = tempidw * 2.7;
//            double idwm = tempidw1 + 48;
//            return idwm;
//        }else if(id==5)
//        {
//           //lem
//        }
//        else
//            Toast.makeText(this, "OopsMen", Toast.LENGTH_SHORT).show();
//        }else if(gen==1)
//        {
//            if (id==1){
//                double tempidw = htIninch - 60;
//                double tempidw1 = tempidw * 2.26796;
//                double idwm = tempidw1 + 49.8952;
//                return idwm;
//            }else if(id==2)
//            {
//                double tempidw = htIninch - 60;
//                double tempidw1 = tempidw * 1.7;
//                double idwm = tempidw1 + 49;
//                return idwm;
//            }else if(id==3)
//            {
//                double tempidw = htIninch - 60;
//                double tempidw1 = tempidw * 1.36;
//                double idwm = tempidw1 + 53.1;
//                return idwm;
//            }else if(id==4)
//            {
//                double tempidw = htIninch - 60;
//                double tempidw1 = tempidw * 2.2;
//                double idwm = tempidw1 + 45.5;
//                return idwm;
//            }else if(id==5)
//            {
//                //lem
//            }
//            else
//                Toast.makeText(this, "OopsWoMen", Toast.LENGTH_SHORT).show();
//        }
//return 0;
//    }


}
