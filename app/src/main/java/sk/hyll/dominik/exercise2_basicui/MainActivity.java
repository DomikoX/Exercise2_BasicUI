package sk.hyll.dominik.exercise2_basicui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private ViewSwitcher page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page = (ViewSwitcher) findViewById(R.id.switcher);


        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.username);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                new String[]
                        {"Pasi","Dominik","Peter","Johni","Igor","Pankrac","Doxisko"});
        actv.setAdapter(aa);



    }


    public void MakeToast(View view) {
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group);

        RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

        Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
    }

    public void Login(View view){
        String name =((EditText)findViewById(R.id.username)).getText().toString();
        String pass = ((EditText)findViewById(R.id.password)).getText().toString();
        Toast.makeText(this, name + " " + pass, Toast.LENGTH_SHORT).show();
        
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        return gestureDetector.onTouchEvent(event);
    }

    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {

            float sensitvity = 50;
            if (Math.abs(e1.getX() - e2.getX()) > sensitvity) {
                page.showNext();
            }
            return true;
        }

    };
    GestureDetector gestureDetector = new GestureDetector(simpleOnGestureListener);


}