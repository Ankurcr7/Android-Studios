package com.example.multiplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text,multi,next,prev;
    EditText get;
    ImageButton imageButton;
    int c,n=1;
    String s,name,line="";

    public static boolean isNumeric(String string) {
        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get=findViewById(R.id.search);
        imageButton=findViewById(R.id.s);


        if(n>=1){
            multi=findViewById(R.id.table);
            for (int i=1;i<=10;i++){
                s=String.format("%d x %d = %d\n",n,i,n*i);
                line+=s;
                multi.setText(line);
            }

        }

        imageButton.setOnClickListener(v -> {
            name = get.getText().toString();
            if(!name.isEmpty()){
                if (isNumeric(name)){
                    n = Integer.parseInt(name);
                    if(n>=1) {
                        multi=findViewById(R.id.table);
                        line="";
                        multi.setText(line);
                        text = findViewById(R.id.count);
                        text.setText(Integer.toString(n));
                        multi = findViewById(R.id.table);
                        for (int i = 1; i <= 10; i++) {
                            s = String.format("%d x %d = %d\n", n, i, n * i);
                            line += s;
                            multi.setText(line);
                        }
                        c=n;
                        if(c>1){
                            c++;
                            next=findViewById(R.id.next);
                            next.setText(Integer.toString(c));
                            c-=2;
                            prev=findViewById(R.id.pre);
                            prev.setText(Integer.toString(c));

                        }
                        else if (c==1){
                            next=findViewById(R.id.next);
                            next.setText("2");
                            prev=findViewById(R.id.pre);
                            prev.setText(".....");
                        }
                    }

                }
            }
            else{
                multi=findViewById(R.id.table);
                line="";
                multi.setText(line);
                multi=findViewById(R.id.table);
                line="Give a\nNatural\nnumber\n";
                multi.setText(line);
                text = findViewById(R.id.count);
                text.setText(".....");
                next=findViewById(R.id.next);
                next.setText(".....");
                prev=findViewById(R.id.pre);
                prev.setText(".....");
            }
        });

    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void next(View view) {
        if(n>=1){
            multi=findViewById(R.id.table);

            multi.setTranslationX(1000f);

            if(line.equals("")){
                multi=findViewById(R.id.table);
            }
            else{
                multi=findViewById(R.id.table);
                line="";
                multi.setText(line);
            }
            multi.setTranslationX(1000f);
                text = findViewById(R.id.count);
                n++;
                text.setText(Integer.toString(n));
                multi = findViewById(R.id.table);
                for (int i = 1; i <= 10; i++) {
                    s = String.format("%d x %d = %d\n", n, i, n * i);
                    line += s;
                    multi.setText(line);
                }
            multi.animate().translationX(0f).setDuration(300);
            c=n;
            if(c>=1){
                c++;
                next=findViewById(R.id.next);
                next.setText(Integer.toString(c));
                c-=2;
                prev=findViewById(R.id.pre);
                prev.setText(Integer.toString(c));

            }

        }

    }
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void pre(View view) {
        if (n<=2){
                next=findViewById(R.id.next);
                next.setText("2");
                prev=findViewById(R.id.pre);
                prev.setText(".....");

        }
        if(n>1){
            multi=findViewById(R.id.table);
            multi.setTranslationX(-1000f);
            if(line.equals("")){
                multi=findViewById(R.id.table);
            }
            else{
                multi=findViewById(R.id.table);
                line="";
                multi.setText(line);
            }


                text=findViewById(R.id.count);
                n--;
                text.setText(Integer.toString(n));
                multi=findViewById(R.id.table);
                for (int i=1;i<=10;i++){
                    s=String.format("%d x %d = %d\n",n,i,n*i);
                    line+=s;
                    multi.setText(line);
                }
            multi.animate().translationX(0f).setDuration(300);
            c=n;
            if(c>1){
                c++;
                next=findViewById(R.id.next);
                next.setText(Integer.toString(c));
                c-=2;
                prev=findViewById(R.id.pre);
                prev.setText(Integer.toString(c));

            }
        }
    }
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void reset(View view){
        if (n!=1){
            multi.setTranslationY(200f);
            n=1;
            if(line.equals("")){
                multi=findViewById(R.id.table);
            }
            else{
                multi=findViewById(R.id.table);
                line="";
                multi.setText(line);
            }
            if (n<=2){
                next=findViewById(R.id.next);
                next.setText("2");
                prev=findViewById(R.id.pre);
                prev.setText(".....");

            }
            text=findViewById(R.id.count);
            text.setText(Integer.toString(n));
            multi=findViewById(R.id.table);
            for (int i=1;i<=10;i++){
                s=String.format("%d x %d = %d\n",n,i,n*i);
                line+=s;
                multi.setText(line);
            }
            multi.animate().translationYBy(-200f).setDuration(300);
        }
    }
}