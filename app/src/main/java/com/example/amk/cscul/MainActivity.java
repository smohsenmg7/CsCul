/**
 * issues *
 * <p>
 * 1 - if ( TempVariable == "" )
 * prevent from axcecuting operator !!!
 * <p>
 * 2 - Delete  Button
 */

package com.example.amk.cscul;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // hiding status bar and action bar
        if (Build.VERSION.SDK_INT > 16) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        numbersListener();
        operationsListener();

        TextView equal = findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.add(TempVariable);
                TempVariable = "";

                for (int i = 0; i < operations.size(); i++) {
                    if (variables.size() == 0)
                        editText.setText("");
                    if (variables.size() == 1)
                        editText.setText(variables.get(0));
                    String ops = operations.get(i);

                    switch (ops) {
                        case "multiple":
                            Refactor(operations.indexOf(ops), Multiple(operations.indexOf(ops)));
                            i--;
                            break;
                        case "division":
                            Refactor(operations.indexOf(ops), Division(operations.indexOf(ops)));
                            i--;
                            break;
                    }
                }
                for (int i = 0; i < operations.size(); i++) {
                    if (variables.size() == 0)
                        editText.setText("");
                    if (variables.size() == 1)
                        editText.setText(variables.get(0));
                    String ops = operations.get(i);

                    switch (ops) {
                        case "plus":
                            Refactor(operations.indexOf(ops), Plus(operations.indexOf(ops)));
                            i--;
                            break;
                        case "minus":
                            Refactor(operations.indexOf(ops), Minus(operations.indexOf(ops)));
                            i--;
                            break;
                    }
                }


                editText.setText(variables.get(0));
            }
        });

    }

    private void operationsListener() {
        TextView division = findViewById(R.id.division_button);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                editText.setText(editText.getText() + "×");
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
    }

    private void numbersListener() {
        /**
         *      Point   (   .   )
         */
        TextView point = findViewById(R.id.point_button);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + ".");
                TempVariable += ".";
            }
        });
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
                editText.setText(editText.getText() + "4");
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
                editText.setText(editText.getText() + "8");
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
    }


    public String Plus(int indexOfOperation) {
        double result = Double.parseDouble(variables.get(indexOfOperation)) + Double.parseDouble(variables.get(indexOfOperation + 1));
        return "" + result;
    }

    public String Minus(int indexOfOperation) {
        double result = Double.parseDouble(variables.get(indexOfOperation)) - Double.parseDouble(variables.get(indexOfOperation + 1));
        return "" + result;
    }

    public String Multiple(int indexOfOperation) {
        double result = Double.parseDouble(variables.get(indexOfOperation)) * Double.parseDouble(variables.get(indexOfOperation + 1));
        return "" + result;
    }

    public String Division(int indexOfOparation) {
        double result = Double.parseDouble(variables.get(indexOfOparation)) / Double.parseDouble(variables.get(indexOfOparation + 1));
        return "" + result;
    }

    public void Refactor(int indexOfOparation, String result) {
        variables.set(indexOfOparation, result);
        variables.remove(indexOfOparation + 1);
        operations.remove(indexOfOparation);
    }

}
