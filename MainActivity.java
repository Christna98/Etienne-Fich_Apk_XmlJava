package com.example.calculatricescientifique;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    TextView input, signBox;
    String value1, value2, sign;
    double num1, num2, result;
    Button btnFactorial;
    Button btnSin;
    Button btnCos;
    Button btnTan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        signBox = findViewById(R.id.sign);
        btnFactorial = findViewById(R.id.btnFactorial);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        input = findViewById(R.id.input);


    }


    @SuppressLint("SetTextI18n")
    public void btnClick_percentage(View view) {
        if (!input.getText().toString().isEmpty()) {
            double currentValue = Double.parseDouble(input.getText().toString());
            double percentage = currentValue * 0.01;
            input.setText(String.valueOf(percentage));
        }
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_parentheses(View view) {
        String currentText = input.getText().toString();

        // Ajoutez la logique de calcul ici (utilisation de WebView pour évaluer l'expression mathématique)
        WebView webView = new WebView(this);
        double result = evaluateExpression("(" + currentText + ")");

        // Affichez le résultat dans l'input
        input.setText(String.valueOf(result));
    }

    private double evaluateExpression(String expression) {
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new CalculatorJSInterface(), "calculator");
        webView.evaluateJavascript("javascript:calculator.setResult(eval('" + expression + "'))", null);

        // Attendez que l'évaluation JavaScript soit terminée
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CalculatorJSInterface.getResult();
    }

    public static class CalculatorJSInterface {
        private static double result;

        @JavascriptInterface
        public void setResult(double value) {
            result = value;
        }

        public static double getResult() {
            return result;
        }
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_0(View view) {
        input.setText(input.getText() + "0");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_1(View view) {
        input.setText(input.getText() + "1");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_2(View view) {
        input.setText(input.getText() + "2");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_3(View view) {
        input.setText(input.getText() + "3");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_4(View view) {
        input.setText(input.getText() + "4");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_5(View view) {
        input.setText(input.getText() + "5");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_6(View view) {
        input.setText(input.getText() + "6");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_7(View view) {
        input.setText(input.getText() + "7");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_8(View view) {
        input.setText(input.getText() + "8");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_9(View view) {
        input.setText(input.getText() + "9");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_p(View view) {
        input.setText(input.getText() + ".");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_add(View view) {
        sign = "+";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("+");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_subtract(View view) {
        sign = "-";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("-");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_multiply(View view) {
        sign = "*";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("*");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_divide(View view) {
        sign = "/";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("÷");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_clear(View view) {
        input.setText("");
        signBox.setText("");
        value1 = null;
        value2 = null;
        sign = null;
        num1 = 0;
        num2 = 0;
        result = 0;
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_sin(View view) {
        Log.d(TAG, "Button sin Clicked");

        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else {
            value1 = input.getText().toString();
            num1 = Double.parseDouble(value1);

            // Calcul du sinus
            double sinResult = Math.sin(Math.toRadians(num1));

            input.setText(String.valueOf(sinResult));
            sign = null;
            signBox.setText(null);
        }
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_cos(View view) {
        Log.d(TAG, "Button cos Clicked");

        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else {
            value1 = input.getText().toString();
            num1 = Double.parseDouble(value1);

            // Calcul du cosinus
            double cosResult = Math.cos(Math.toRadians(num1));

            input.setText(String.valueOf(cosResult));
            sign = null;
            signBox.setText(null);
        }
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_tan(View view) {
        Log.d(TAG, "Button tan Clicked");

        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else {
            value1 = input.getText().toString();
            num1 = Double.parseDouble(value1);

            // Calcul de la tangente
            double tanResult = Math.tan(Math.toRadians(num1));

            input.setText(String.valueOf(tanResult));
            sign = null;
            signBox.setText(null);
        }
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_log(View view) {
        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else {
            value1 = input.getText().toString();
            num1 = Double.parseDouble(value1);
            result = Math.log10(num1);
            input.setText(result + "");
            sign = null;
            signBox.setText(null);
        }
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_ln(View view) {
        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else {
            value1 = input.getText().toString();
            num1 = Double.parseDouble(value1);
            result = Math.log(num1);
            input.setText(result + "");
            sign = null;
            signBox.setText(null);
        }
    }




    @SuppressLint("SetTextI18n")
    public void btnClick_squareRoot(View view) {
        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else {
            sign = "√";
            value1 = input.getText().toString();
            input.setText(null);
            signBox.setText("√");
            performOperation();
        }
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_factorial(View view) {
        Log.d(TAG, "Button ! Clicked");

        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else {
            value1 = input.getText().toString();
            num1 = Double.parseDouble(value1);

            // Calcul de la factorielle
            long factorial = calculateFactorial((int) num1);

            input.setText(String.valueOf(factorial));
            sign = null;
            signBox.setText(null);
        }
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
    @SuppressLint("SetTextI18n")
    public void btnClick_equal(View view) {
        if (input.getText().equals("")) {
            signBox.setText("Error!");
        } else if (sign != null) {
            value2 = input.getText().toString();
            num1 = Double.parseDouble(value1);
            num2 = Double.parseDouble(value2);
            input.setText(null);

            switch (sign) {
                default:
                    break;
                case "+":
                    result = num1 + num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "-":
                    result = num1 - num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "*":
                    result = num1 * num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                        input.setText(result + "");
                    } else {
                        input.setText("Error!");
                    }
                    sign = null;
                    signBox.setText(null);
                    break;
            }
        } else {
            input.setText("Error!");
        }
    }

    public void btnClick_backspace(View view) {
        CharSequence currentText = input.getText();
        if (currentText.length() > 0) {
            input.setText(currentText.subSequence(0, currentText.length() - 1));
        }
    }

    @SuppressLint("SetTextI18n")
    private void performOperation() {
        if (value1 != null && sign != null) {
            num1 = Double.parseDouble(value1);
            input.setText(null);

            switch (sign) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        input.setText("Error!");
                        return;
                    }
                    break;
                case "√":
                    result = Math.sqrt(num1);
                    break;
            }

            input.setText(result + "");
            sign = null;
            signBox.setText(null);
        }
    }

   
}
