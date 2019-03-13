package com.example.volleyball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Button mButton;
    private Map<String,String> map;
    private EditText userName_ed;
    private EditText passWord_ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mButton=findViewById(R.id.login_bt);
        userName_ed=findViewById(R.id.user_name_ed);
        passWord_ed=findViewById(R.id.pass_word);
        ObjectInputStream in=null;

        try {
            in=new ObjectInputStream(openFileInput("userInfo.bat"));
            map=(HashMap<String, String>)in.readObject();
        } catch (FileNotFoundException e) {
            map=new HashMap<>();


            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null)
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mButton.setOnClickListener(v->{
            String name=userName_ed.getText().toString();
            String password=passWord_ed.getText().toString();
            if (map.containsKey(name)){
                if (!map.get(name).equals(password)){
                    Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
                    return;
                }
            }else {
                map.put(name,password);
                Toast.makeText(this,"新建用户名成功",Toast.LENGTH_SHORT).show();
                ObjectOutputStream out=null;
                try {
                    out=new ObjectOutputStream(openFileOutput("userInfo.bat",MODE_PRIVATE));
                    out.writeObject(map);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (out != null);
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("filename",name);
            startActivity(intent);
            finish();

        });


    }

}
