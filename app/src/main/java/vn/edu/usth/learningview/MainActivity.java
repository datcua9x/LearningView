package vn.edu.usth.learningview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText txtA,txtB;

    Button btnSubtraction;

    Button btnMultiplication,btnDivision;

    Button btnHide;

    Button btnExit;

    View.OnClickListener sharedEvent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtraction();
            }
        });
        sharedEvent = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnMultiplication){
                    multiplication();
                }
                else if (v.getId() == R.id.btnDivision){
                    division();
                }
            }
        };
        btnMultiplication.setOnClickListener(sharedEvent);
        btnDivision.setOnClickListener(sharedEvent);
        btnHide.setOnLongClickListener(this);
        btnExit.setOnClickListener(new MyEvent());

    }

    private void multiplication() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a*b;

        Toast.makeText(MainActivity.this,"Subtraction is "+c,Toast.LENGTH_LONG).show();
    }
    private void division() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a/b;

        Toast.makeText(MainActivity.this,"Subtraction is "+c,Toast.LENGTH_LONG).show();
    }

    private void subtraction() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a-b;

        Toast.makeText(MainActivity.this,"Subtraction is "+c,Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtA =  findViewById(R.id.txtA);
        txtB =  findViewById(R.id.txtB);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnHide = findViewById(R.id.btnHide);
        btnExit = findViewById(R.id.btnExit);
    }

    public void addition(View v)
    {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a+b;

        Toast.makeText(MainActivity.this,"Addition is "+c,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btnHide){
            btnHide.setVisibility(View.INVISIBLE);
        }
        return false;
    }
    public class MyEvent implements View.OnClickListener, View.OnLongClickListener{

        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.btnExit){
                finish();//close the program
            }
        }

        @Override
        public boolean onLongClick(View v) {

            return false;
        }
    }
    public void SwapApp(View v){
        // create new button and override it
        Button btnNew = new Button(MainActivity.this){
            @Override
            public boolean performClick() {

                setContentView(R.layout.activity_main);

                addControls();
                addEvents();

                return super.performClick();
            }
        };
        btnNew.setText("Return");
        btnNew.setWidth(200);
        btnNew.setHeight(200);

        setContentView(btnNew);
    }
}
