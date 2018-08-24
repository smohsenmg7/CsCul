/**
 * if ( Tvar == "" )
 *      prevent from axcecuting operator !!!
 */

package com.example.amk.cscul;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amk.cscul.R;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    boolean key = false ;
    String Tvar = "" ;
    public static ArrayList<String> variables = new ArrayList<>();
    public static ArrayList<String> operations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        hiding status bar and action bar

        if(Build.VERSION.SDK_INT > 16)
        {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);

        final TextView editText = findViewById(R.id.edit_text);

        TextView mc = findViewById(R.id.mc_button);
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        TextView clean = findViewById(R.id.clean_button);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.clear();
                operations.clear();
                editText.setText("");
            }
        });

        TextView seven = findViewById(R.id.number7_button);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "7 ...", Toast.LENGTH_SHORT).show();
                numberAfterEqual(key, editText);
                editText.setText(editText.getText()+"7");
                Tvar += "7" ;
            }
        });

        TextView four = findViewById(R.id.number4_button);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "4 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"4");
                Tvar += "4" ;
            }
        });

        TextView one = findViewById(R.id.number1_button);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "1 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"1");
                Tvar += "1" ;
            }
        });

        TextView percent = findViewById(R.id.percent_sign);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "percent ...", Toast.LENGTH_SHORT).show();
            }
        });

        TextView mPlus = findViewById(R.id.mPlus_button);
        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "mPlus ...", Toast.LENGTH_SHORT).show();
            }
        });

        TextView division = findViewById(R.id.division_button);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "division ...", Toast.LENGTH_SHORT).show();
                operatorAfterEqual(key);
                editText.setText(editText.getText()+"÷");
                variables.add(Tvar);
                operations.add("division");
                Tvar = "" ;
            }
        });

        TextView eight = findViewById(R.id.number8_button);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "8 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"8");
                Tvar += "8" ;
            }
        });

        TextView five = findViewById(R.id.number5_button);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "5 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"5");
                Tvar += "5" ;
            }
        });

        TextView two = findViewById(R.id.number2_button);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "2 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"2");
                Tvar += "2" ;
            }
        });

        TextView zero = findViewById(R.id.zero_button);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "0 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"0");
                Tvar += "0" ;
            }
        });

        TextView mMinus = findViewById(R.id.mMinus_button);
        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "mMinus ...", Toast.LENGTH_SHORT).show();
            }
        });

        TextView multiple = findViewById(R.id.multiple_button);
        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "multiple ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"×");
                variables.add(Tvar);
                operations.add("multiple");
                Tvar = "" ;
            }
        });

        TextView nine = findViewById(R.id.number9_button);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "9 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"9");
                Tvar += "9" ;
            }
        });

        TextView six = findViewById(R.id.number6_button);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "6 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"6");
                Tvar += "6" ;
            }
        });

        TextView three = findViewById(R.id.number3_button);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "3 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"3");
                Tvar += "3" ;
            }
        });

        TextView point = findViewById(R.id.point_button);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "point ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+".");
                Tvar += "." ;
            }
        });

        TextView mr = findViewById(R.id.mr);
        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "mr ...", Toast.LENGTH_SHORT).show();
            }
        });

        TextView delete = findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "delete ...", Toast.LENGTH_SHORT).show();
//                Editable text = editText.getText();
//                String sText= editText.getText().toString();
//                //char LC = sText.charAt(sText.length()-1);
//                String LC =sText.substring(sText.length()-1);
//                boolean importent ;
//                if(Tvar != null){
//                    Tvar = Tvar.substring(0,Tvar.length()-1);
//                    editText.setText(editText.getText().subSequence(0,text.length()-1));
//                }
//                //if(LC == '+' || LC == '-' || LC == '×' || LC == '÷')
//                if(LC.equals("+") || LC.equals("-") || LC.equals("×") || LC.equals("÷"))
//                {
//                    editText.setText(editText.getText().subSequence(0,text.length()-1));
//                    importent = true ;
//                }
//                if(Tvar == null || Tvar.equals("")){
//                    String MainString = variables.get(variables.size()-1);
//                    String EditedString = MainString.substring(0,MainString.length()-1);
//                    variables.add(variables.size()-1,EditedString);
//                }
            }
        });

        TextView minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "minus ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"-");
                variables.add(Tvar);
                operations.add("minus");
                Tvar = "" ;
            }
        });

        TextView plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "plus ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText()+"+");
                variables.add(Tvar);
                operations.add("plus");
                Tvar = "" ;
            }
        });

        TextView equal = findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.add(Tvar);
                Tvar = "" ;
                Toast.makeText(view.getContext(), "equal ...", Toast.LENGTH_SHORT).show();
                for (String ops: operations){
                    if(variables.size() == 0)
                        editText.setText("");
                    if(variables.size() == 1)
                        editText.setText(variables.get(0));
                    switch (ops){
                        case "plus" :
                            Refactor(Plus());
                            break;
                        case "minus" :
                            Refactor(Minus());
                            break;
                        case "multiple" :
                            Refactor(Multiple());
                            break;
                        case "division" :
                            Refactor(Division());
                            break;
                        default:
                    }
                    key = true ;
                }
                editText.setText(variables.get(0));
            }
        });

    }

    // Operation Methods Define

    public String Plus() {
        if (variables.get(1) == null)
            return variables.get(0);
        double result = Double.parseDouble(variables.get(0)) + Double.parseDouble(variables.get(1));
        return "" + result ;
    }

    public String Minus() {
        if (variables.get(1) == null)
            return variables.get(0);
        double result = Double.parseDouble(variables.get(0)) - Double.parseDouble(variables.get(1));
        return "" + result ;
    }

    public String Multiple() {
        if (variables.get(1) == null)
            return variables.get(0);
        double result = Double.parseDouble(variables.get(0)) * Double.parseDouble(variables.get(1));
        return "" + result ;
    }

    public String Division() {
        if (variables.get(1) == null)
            return variables.get(0);
        double result = Double.parseDouble(variables.get(0)) / Double.parseDouble(variables.get(1));
        return "" + result ;
    }

    public void Refactor(String result){
        variables.set(0,result);
        variables.remove(1);
    }

    public void numberAfterEqual(boolean key, TextView editText){
        if(key){
            editText.setText("");
            variables.clear();
            operations.clear();
            this.key = false ;
        }
    }

    public void operatorAfterEqual(boolean key){
        if(key){
            operations.clear();
            this.key = false ;
        }
    }

}
