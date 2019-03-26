package cz.gopas.gopaskalkulacka;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.buttonCalculate) Button buttonCalculate;


    TextView textViewResult = null;
    RadioGroup rgCalc = null;
    TextInputEditText inputA = null;
    TextInputEditText inputB = null;


    double dResult = 0;

//    @Override
//    protected void onSaveInstanceState (@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("result", textViewResult.getText().toString() );
//    }
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState){
//        super.onRestoreInstanceState(savedInstanceState);
//        textViewResult.setText(savedInstanceState.get("result").toString());
//    }

    protected void onRest(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result", textViewResult.getText().toString() );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Created");

        Toast.makeText(this, "Ahoj", Toast.LENGTH_LONG).show();

        textViewResult = findViewById(R.id.textViewResult);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        rgCalc = findViewById(R.id.op);
        inputA = findViewById(R.id.a);
        inputB = findViewById(R.id.b);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iRadioButtonSelected = rgCalc.getCheckedRadioButtonId();
                Log.d(TAG, "iRadioButtonSelected:" + iRadioButtonSelected);
                Log.d(TAG, "TextA"+inputA.getText());
                Log.d(TAG, "TextB"+inputB.getText());
               // dResult = calc(iRadioButtonSelected);
                switch (iRadioButtonSelected){
                    case R.id.radioButtonPlus: dResult = Double.parseDouble(inputA.getText().toString()) +Double.parseDouble(inputB.getText().toString());  Log.d(TAG ,"Plus"); break;
                    case R.id.radioButtonMinus: dResult = Double.parseDouble(inputA.getText().toString()) -Double.parseDouble(inputB.getText().toString());  Log.d(TAG ,"Minus"); break;
                    case R.id.radioButtonMultiply: dResult = Double.parseDouble(inputA.getText().toString()) *Double.parseDouble(inputB.getText().toString());  Log.d(TAG ,"Multiply"); break;
                    case R.id.radioButtonDivide: dResult = Double.parseDouble(inputA.getText().toString()) /Double.parseDouble(inputB.getText().toString());  Log.d(TAG ,"Divide"); break;
                }

                Log.d(TAG, "Result:=" + dResult);
                textViewResult.setText(String.valueOf(dResult));
            }
        });


    }

    private float calc(int aCalcType) {
        {
            float fResult = 0;
            switch (aCalcType) {
                case R.id.radioButtonPlus:
                    dResult = Double.parseDouble(inputA.getText().toString()) + Double.parseDouble(inputB.getText().toString());
                    Log.d(TAG, "Plus");
                    break;
                case R.id.radioButtonMinus:
                    dResult = Double.parseDouble(inputA.getText().toString()) - Double.parseDouble(inputB.getText().toString());
                    Log.d(TAG, "Minus");
                    break;
                case R.id.radioButtonMultiply:
                    dResult = Double.parseDouble(inputA.getText().toString()) * Double.parseDouble(inputB.getText().toString());
                    Log.d(TAG, "Multiply");
                    break;
                case R.id.radioButtonDivide:
                    dResult = Double.parseDouble(inputA.getText().toString()) / Double.parseDouble(inputB.getText().toString());
                    Log.d(TAG, "Divide");
                    break;
            }
            return fResult;
        }

//        protected void onResume () {
//            super.onResume();
//            Log.d(TAG, "Resumed");
//            Toast.makeText(this, "Resumed", Toast.LENGTH_LONG).show();
//        }
//        @Override
//        protected void onStart () {
//
//            Toast.makeText(this, "Started", Toast.LENGTH_LONG).show();
//            Log.d(TAG, "Started");
//            super.onStart();
//
//        }
//        @Override
//        protected void onPause () {
//            Toast.makeText(this, "Pause", Toast.LENGTH_LONG).show();
//            Log.d(TAG, "Paused");
//            super.onPause();
//
//        }

//        @Override
//        protected void onSaveInstanceState (Bundle outState){
//            super.onSaveInstanceState(outState);
//            //outState
//
//        }


    }


}
