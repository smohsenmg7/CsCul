/**
 * issues *
 *
 *      1 - if ( TempVariable == "" )
 *          prevent from axcecuting operator !!!
 *
 *      2 - Delete  Button 
 */

package com.example.amk.cscul;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // when an variable get completed will save in this ArrayList
    public static ArrayList<String> variables = new ArrayList<>();
    // operator commands will save in this ArrayList ( usage : Equal method )
    public static ArrayList<String> operations = new ArrayList<>();
    // button effect on reaction of buttons when tapping them
    boolean EqEffect = false;
    // this variable get updated till user input an operator
    String TempVariable = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // hiding status bar and action bar
        if(Build.VERSION.SDK_INT > 16)
        {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);

        /**
         *      EditText
         */
        final TextView editText = findViewById(R.id.edit_text);

        /**
         *      Button 0
         */
        TextView zero = findViewById(R.id.zero_button);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
                TempVariable += "0";
            }
        });

        /**
         *      Button 1
         */
        TextView one = findViewById(R.id.number1_button);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
                TempVariable += "1";
            }
        });

        /**
         *      Button 2
         */
        TextView two = findViewById(R.id.number2_button);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
                TempVariable += "2";
            }
        });

        /**
         *      Button 3
         */
        TextView three = findViewById(R.id.number3_button);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
                TempVariable += "3";
            }
        });

        /**
         *      Button 4
         */
        TextView four = findViewById(R.id.number4_button);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"4");
                TempVariable += "4";
            }
        });

        /**
         *      Button 5
         */
        TextView five = findViewById(R.id.number5_button);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
                TempVariable += "5";
            }
        });

        /**
         *      Button 6
         */
        TextView six = findViewById(R.id.number6_button);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
                TempVariable += "6";
            }
        });

        /**
         *      Button 7
         */
        TextView seven = findViewById(R.id.number7_button);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberAfterEqual(EqEffect, editText);
                editText.setText(editText.getText() + "7");
                TempVariable += "7";
            }
        });

        /**
         *      Button 8
         */
        TextView eight = findViewById(R.id.number8_button);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"8");
                TempVariable += "8";
            }
        });

        /**
         *      Button 9
         */
        TextView nine = findViewById(R.id.number9_button);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "9 ...", Toast.LENGTH_SHORT).show();
                editText.setText(editText.getText() + "9");
                TempVariable += "9";
            }
        });

        /**
         *      Division    (   ÷   )
         */
        TextView division = findViewById(R.id.division_button);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorAfterEqual(EqEffect);
                editText.setText(editText.getText() + "÷");
                variables.add(TempVariable);
                operations.add("division");
                TempVariable = "";
            }
        });

        /**
         *      Multiple    (   ×   )
         */
        TextView multiple = findViewById(R.id.multiple_button);
        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"×");
                variables.add(TempVariable);
                operations.add("multiple");
                TempVariable = "";
            }
        });

        /**
         *      Minus   (   -   )
         */
        TextView minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "-");
                variables.add(TempVariable);
                operations.add("minus");
                TempVariable = "";
            }
        });

        /**
         *      Plus    (   +   )
         */
        TextView plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "+");
                variables.add(TempVariable);
                operations.add("plus");
                TempVariable = "";
            }
        });

        /**
         *      Point   (   .   )
         */
        TextView point = findViewById(R.id.point_button);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+".");
                TempVariable += ".";
            }
        });

        /**
         *      Button Clean
         */
        TextView clean = findViewById(R.id.clean_button);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.clear();
                operations.clear();
                editText.setText("");
            }
        });

        /**
         *      Button mc
         */
        TextView mc = findViewById(R.id.mc_button);
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        /**
         *      percent (   %   )
         */
        TextView percent = findViewById(R.id.percent_sign);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "percent ...", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         *      mPlus   (   m+  )
         */
        TextView mPlus = findViewById(R.id.mPlus_button);
        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "mPlus ...", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         *      mMinus   (   m-  )
         */
        TextView mMinus = findViewById(R.id.mMinus_button);
        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "mMinus ...", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         *      mr  (   mr  )
         */
        TextView mr = findViewById(R.id.mr);
        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        /**
         *      Delete  (   Warning : Under Construction  :)  )
         */
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
//                if(TempVariable != null){
//                    TempVariable = TempVariable.substring(0,TempVariable.length()-1);
//                    editText.setText(editText.getText().subSequence(0,text.length()-1));
//                }
//                //if(LC == '+' || LC == '-' || LC == '×' || LC == '÷')
//                if(LC.equals("+") || LC.equals("-") || LC.equals("×") || LC.equals("÷"))
//                {
//                    editText.setText(editText.getText().subSequence(0,text.length()-1));
//                    importent = true ;
//                }
//                if(TempVariable == null || TempVariable.equals("")){
//                    String MainString = variables.get(variables.size()-1);
//                    String EditedString = MainString.substring(0,MainString.length()-1);
//                    variables.add(variables.size()-1,EditedString);
//                }
            }
        });

        /**
         *      Equal   (   =   )
         */
        TextView equal = findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.add(TempVariable);
                TempVariable = "";
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
                    EqEffect = true;
                }
                editText.setText(variables.get(0));
            }
        });

    }

    // Operation Methods Declaration    plus    minus   multiple    division

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

    //  After Excecuting each operation Refactor method will place Result in index 0 of Variables ArrayList
    // and
    // will delete Second variable in Variables ArrayList
    public void Refactor(String result){
        variables.set(0,result);
        variables.remove(1);
    }

    // reaction for number button after Equal operation
    public void numberAfterEqual(boolean key, TextView editText){
        if(key){
            editText.setText("");
            variables.clear();
            operations.clear();
            this.EqEffect = false;
        }
    }

    //  reaction for operation button after Equal operation
    public void operatorAfterEqual(boolean key){
        if(key){
            operations.clear();
            this.EqEffect = false;
        }
    }

}
