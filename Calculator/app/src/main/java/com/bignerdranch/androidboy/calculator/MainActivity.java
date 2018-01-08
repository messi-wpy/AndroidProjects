package com.bignerdranch.androidboy.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;
    private Button mButtonPlus;
    private Button mButtonMinus;
    private Button mButtonMultiply;
    private Button mButtonDivide;
    private Button mButtonEqual;
    private Button mAllclear;
    private Button mPoint;
    private TextView mTextView;
    private EditText mEditText;
    private String str1 = "0", str2 = "0";
    private double result = 0;
    List<Numbers> mNumbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview);
        mButton1 = findViewById(R.id.one_button);
        mButton0 = findViewById(R.id.zero_button);
        mButton2 = findViewById(R.id.two_button);
        mButton3 = findViewById(R.id.three_button);
        mButton4 = findViewById(R.id.four_button);
        mButton5 = findViewById(R.id.five_button);
        mButton6 = findViewById(R.id.six_button);
        mButton7 = findViewById(R.id.seven_button);
        mButton8 = findViewById(R.id.eight_button);
        mButton9 = findViewById(R.id.night_button);
        mButtonPlus = findViewById(R.id.plus_button);
        mButtonEqual = findViewById(R.id.equal_button);
        mEditText = findViewById(R.id.output_view);
        mButtonMultiply = findViewById(R.id.multiply_button);
        mButtonMinus = findViewById(R.id.minus_button);
        mButtonDivide = findViewById(R.id.divide_button);
        mAllclear = findViewById(R.id.clear_button);
        mPoint=findViewById(R.id.point_button);


        //监听数字按钮
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("0");
                str1 += "0";
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("1");
                str1 += "1";
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("2");
                str1 += "2";
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("3");
                str1 += "3";
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("4");
                str1 += "4";
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("5");
                str1 += "5";
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("6");
                str1 += "6";
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("7");
                str1 += "7";
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("8");
                str1 += "8";
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append("9");
                str1 += "9";
            }
        });
//     setPoint();
        mPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.append(".");
                str1+=".";
            }
        });

        mAllclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allClear();
            }
        });


        //监听加号
        mButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exception();
                Numbers numbers = new Numbers();        //创建一个局部Numbers对象
                double a=Double.parseDouble(str1);      //获取加号前的字符串并转换成double
                numbers.setNumber(a);                   //把该数值存入Numbers对象中
                mNumbers.add(numbers);                  //把该局部变量转移到mNumbers集合中
                str1 = str2;                            //初始化该字符串，以便读取下一次输入的数值
                mEditText.append("＋");
            }
        });

        //监听等号
        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exception();
                Numbers numbers = new Numbers();
                double a = Double.parseDouble(str1);
                numbers.setNumber(a);
                mNumbers.add(numbers);
                str1 = str2;
                //计算顺序
                Minus();//给数据添加负号
                Multiply();//计算乘法
                Divide();//计算除法
                Plus();//计算加法

            }
        });

        //监听减号
        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exception();
                Numbers numbers = new Numbers();
                numbers.setMunis(true);
                double a = Double.parseDouble(str1);
                numbers.setNumber(a);
                mNumbers.add(numbers);
                str1 = str2;
                mEditText.append("－");
            }
        });


        mButtonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exception();
                Numbers numbers = new Numbers();
                double a = Double.parseDouble(str1);
                numbers.setNumber(a);
                numbers.setDivide(true);
                mNumbers.add(numbers);
                str1 = str2;
                mEditText.append("÷");
            }
        });
        mButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exception();
                Numbers numbers = new Numbers();
                double a = Double.parseDouble(str1);
                numbers.setNumber(a);
                numbers.setMultiply(true);
                mNumbers.add(numbers);
                str1 = str2;
                mEditText.append("×");
            }
        });
    }



    private void Multiply() {
        int n = mNumbers.size();
        for (int i = 0; i < n; i++) {
            if (mNumbers.get(i).isMultiply()) {
                double a = mNumbers.get(i).getNumber() * mNumbers.get(i + 1).getNumber();
                mNumbers.get(i).setNumber(0);
                mNumbers.get(i + 1).setNumber(a);
                i = i + 1;
            }
        }
    }

    private void Divide() {
        int n3 = mNumbers.size();
        for (int i = 0; i < n3; i++) {
            if (mNumbers.get(i).isDivide()) {
                double a = mNumbers.get(i).getNumber() / mNumbers.get(i + 1).getNumber();
                mNumbers.get(i).setNumber(0);
                mNumbers.get(i + 1).setNumber(a);
                i = i + 1;
            }
        }

    }
    private void Plus(){

        for (int i = 0; i < mNumbers.size(); i++)//计算加法
            result += mNumbers.get(i).getNumber();
        exception2();//检测溢出，被除数为0等异常

        mTextView.setText(mEditText.getText().toString());
        mEditText.setText(String.valueOf(result));
    }

    private void Minus() {
        int n2 = mNumbers.size();
        for (int i = 0; i < n2; i++) {
            if (mNumbers.get(i).isMunis()) {
                double a = -mNumbers.get(i + 1).getNumber();
                mNumbers.get(i + 1).setNumber(a);
                i++;
            }
        }
    }

    private void allClear() {
        mEditText.setText("");
        mTextView.setText("");
        str1 = str2;
        mNumbers.clear();
        result=0;
    }

    private void exception(){
        try {
            double a = Double.parseDouble(str1);
        }
        catch (NumberFormatException e){
            allClear();
            Toast.makeText(this,"输入数字格式异常，请点击AC请重新输入",Toast.LENGTH_SHORT).show();
        }
    }
    private void exception2(){
        try {
            if(result>Double.MAX_VALUE||result<Double.MIN_VALUE)
                throw new Exception("double溢出");

        }

        catch (Exception e) {
            e.printStackTrace();
            allClear();
            Toast.makeText(this,"溢出！",Toast.LENGTH_SHORT).show();
        }
    }
}
