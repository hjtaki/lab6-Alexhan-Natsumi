package hjtaki.a2dimengame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private List<String> dataArray;
    private StringBuilder currentAnswer;
    private ImageView imageView;
    private int SCORE_INCREASEMENT = 10;
    private static int imageNum = 5;
    private static int finalScore = 0;
    private int NUMOFLINEINFILE = 5;
    private TextView answer1;
    private String answer;
    private TextView score;
    private ImageButton btn;
    
    TextView textView_A;
    TextView textView_B;
    TextView textView_C;
    TextView textView_D;
    TextView textView_E;
    TextView textView_F;
    TextView textView_G;
    TextView textView_H;
    TextView textView_I;
    TextView textView_J;
    TextView textView_K;
    TextView textView_L;
    TextView textView_M;
    TextView textView_N;
    TextView textView_O;
    TextView textView_P;
    TextView textView_Q;
    TextView textView_R;
    TextView textView_S;
    TextView textView_T;
    TextView textView_U;
    TextView textView_V;
    TextView textView_W;
    TextView textView_X;
    TextView textView_Y;
    TextView textView_Z;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.hangman);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hangman5));
        answer1 = findViewById(R.id.answerLetter1);
        textView_A = findViewById(R.id.textview_A);
        textView_B = findViewById(R.id.textview_B);
        textView_C = findViewById(R.id.textview_C);
        textView_D = findViewById(R.id.textview_D);
        textView_E = findViewById(R.id.textview_E);
        textView_F = findViewById(R.id.textview_F);
        textView_G = findViewById(R.id.textview_G);
        textView_H = findViewById(R.id.textview_H);
        textView_I = findViewById(R.id.textview_I);
        textView_J = findViewById(R.id.textview_J);
        textView_K = findViewById(R.id.textview_K);
        textView_L = findViewById(R.id.textview_L);
        textView_M = findViewById(R.id.textview_M);
        textView_N = findViewById(R.id.textview_N);
        textView_O = findViewById(R.id.textview_O);
        textView_P = findViewById(R.id.textview_P);
        textView_Q = findViewById(R.id.textview_Q);
        textView_R = findViewById(R.id.textview_R);
        textView_S = findViewById(R.id.textview_S);
        textView_T = findViewById(R.id.textview_T);
        textView_U = findViewById(R.id.textview_U);
        textView_V = findViewById(R.id.textview_V);
        textView_W = findViewById(R.id.textview_W);
        textView_X = findViewById(R.id.textview_X);
        textView_Y = findViewById(R.id.textview_Y);
        textView_Z = findViewById(R.id.textview_Z);
        score = findViewById(R.id.score);
        btn = findViewById(R.id.newGameBtn);


        TextView[] textViews = {textView_A, textView_B, textView_C, textView_D, textView_E, textView_F,
                textView_G, textView_H, textView_I, textView_J, textView_K, textView_L, textView_M,
                textView_N, textView_O, textView_P, textView_Q, textView_R, textView_S, textView_T,
                textView_U, textView_V, textView_W, textView_X, textView_Y, textView_Z};


        // 1. read file
        readFile();

        // 2. choose random one word(select one)
        randomVoca();


        // 3. user click one letter
        //   -> right : shows the letter on answer part
        //   -> wrong : change image


//
//        for(int j = 0; j < textViews.length; j++) {
//
//                textViews[j].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(answer.contains(textView_A.getText())){
//                    for (int i = 0; i < answer.length(); i++){
//                        if(answer.charAt(i) == textViews[j].getText().charAt(0)){
//                            currentAnswer.setCharAt(i, textViews[j].getText().charAt(0));
//                        }
//                    }
//                    answer1.setText(currentAnswer);
//
//                    if((answer1.getText().toString()).equals(answer)){
//                        MainActivity.finalScore += SCORE_INCREASEMENT;
//                        score.setText(String.valueOf(MainActivity.finalScore));
//
//                        // 4. check answer
//                        checkAnswer();
//                    }
//
//                }else{
//                    MainActivity.this.changeImage();
//                    String imageName = "hangman"+imageNum;
//                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
//                    imageView.setImageResource(id);
//                    Toast.makeText(MainActivity.this,"wrong!",Toast.LENGTH_LONG).show();
//                }
//                textViews[j].setClickable(false);
//                textViews[j].setTextColor(Color.parseColor("#ffffff"));
//            }
//        });
//
//        }

        textView_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_A.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_A.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_A.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                    Toast.makeText(MainActivity.this,"wrong!",Toast.LENGTH_LONG).show();
                }
                textView_A.setClickable(false);
                textView_A.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();
            }
        });


        textView_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_B.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_B.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_B.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);

                    if((answer1.getText().toString()).equals(answer)){
                        MainActivity.finalScore += SCORE_INCREASEMENT;
                        score.setText(String.valueOf(MainActivity.finalScore));

                    }
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_B.setClickable(false);
                textView_B.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_C.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_B.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_C.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_C.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);

                    if((answer1.getText().toString()).equals(answer)){
                        MainActivity.finalScore += SCORE_INCREASEMENT;
                        score.setText(String.valueOf(MainActivity.finalScore));


                    }
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_C.setClickable(false);
                textView_C.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_D.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_D.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_D.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_D.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_D.setClickable(false);
                textView_D.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_E.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_E.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_E.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_E.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_E.setClickable(false);
                textView_E.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_F.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_F.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_F.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_F.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_F.setClickable(false);
                textView_F.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_G.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_G.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_G.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_G.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_G.setClickable(false);
                textView_G.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_H.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_H.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_H.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_H.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_H.setClickable(false);
                textView_H.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_I.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_I.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_I.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_I.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_I.setClickable(false);
                textView_I.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_J.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_J.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_J.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_J.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_J.setClickable(false);
                textView_J.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_K.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_K.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_K.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_K.getText().charAt(0));

                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_K.setClickable(false);
                textView_K.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_L.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_L.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_L.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_L.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_L.setClickable(false);
                textView_L.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_M.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_M.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_M.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_M.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_M.setClickable(false);
                textView_M.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_N.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_N.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_N.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_N.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_N.setClickable(false);
                textView_N.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_O.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_O.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_O.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_O.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_O.setClickable(false);
                textView_O.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_P.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_P.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_P.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_P.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_P.setClickable(false);
                textView_P.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_Q.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_Q.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_Q.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_Q.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_Q.setClickable(false);
                textView_Q.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_R.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_R.getText())){
                    int index = answer.indexOf(textView_R.getText().charAt(0));
                    currentAnswer.setCharAt(index, textView_R.getText().charAt(0));
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_R.setClickable(false);
                textView_R.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_S.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_S.getText())){
                    int index = answer.indexOf(textView_S.getText().charAt(0));
                    currentAnswer.setCharAt(index, textView_S.getText().charAt(0));
                    answer1.setText(currentAnswer);

                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_S.setClickable(false);
                textView_S.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        textView_T.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_T.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_T.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_T.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_T.setClickable(false);
                textView_T.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_U.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_U.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_U.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_U.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_U.setClickable(false);
                textView_U.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_V.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_V.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_V.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_V.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_V.setClickable(false);
                textView_V.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_W.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_W.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_W.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_W.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_W.setClickable(false);
                textView_W.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_X.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_X.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_X.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_X.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_X.setClickable(false);
                textView_X.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_Y.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_Y.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_Y.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_Y.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_Y.setClickable(false);
                textView_Y.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();

            }
        });

        textView_Z.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(answer.contains(textView_Z.getText())){
                    for (int i = 0; i < answer.length(); i++){
                        if(answer.charAt(i)==textView_Z.getText().charAt(0)){
                            currentAnswer.setCharAt(i, textView_Z.getText().charAt(0));
                        }
                    }
                    answer1.setText(currentAnswer);
                }else{
                    MainActivity.this.changeImage();
                    String imageName = "hangman"+imageNum;
                    int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    imageView.setImageResource(id);
                }
                textView_Z.setClickable(false);
                textView_Z.setTextColor(Color.parseColor("#ffffff"));
                checkAnswer();
            }
        });
    }

    private void randomVoca() {
        Random rand = new Random();
        int n = rand.nextInt(NUMOFLINEINFILE);// 0 ~

        answer = dataArray.get(n).toUpperCase().trim(); //abandon
        String currentAnswer1 ="";

        for (int i = 0; i < dataArray.get(n).length(); i++){
            currentAnswer1 += "x";
        }
        currentAnswer = new StringBuilder(currentAnswer1);
        answer1.setText(currentAnswer);

    }

    private void readFile() {
        // 1. read text file
        inputStream = getResources().openRawResource(R.raw.ieltsvoca);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        dataArray = new ArrayList<>();
        try {
            String line;
            while (true) {
                line = (bufferedReader.readLine());
                if (line == null)
                    break;
                dataArray.add(line);
            }
            bufferedReader.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkAnswer() {
        if((answer1.getText().toString()).equals(answer)){
            MainActivity.finalScore += SCORE_INCREASEMENT;
            score.setText(String.valueOf(MainActivity.finalScore));
            Toast.makeText(this,"correct!, you got 10 points",Toast.LENGTH_LONG).show();
            startNewGame(btn);

        }

    }

    private void changeImage() {
        switch (MainActivity.imageNum){
            case 5:{
                MainActivity.imageNum = 4;
                break;
            }
            case 4:{
                MainActivity.imageNum = 3;
                break;
            }
            case 3:{
                MainActivity.imageNum = 2;
                break;
            }
            case 2:{
                MainActivity.imageNum = 1;
                break;
            }
            case 1: {
                MainActivity.imageNum = 0;
                Toast.makeText(this,"FAILED! -10 points",Toast.LENGTH_LONG).show();
                MainActivity.finalScore -= SCORE_INCREASEMENT;
                score.setText(String.valueOf(MainActivity.finalScore));
                break;
            }
        }
    }

    public void startNewGame(View view) {
        Toast.makeText(this,"NEW GAME STARTED",Toast.LENGTH_LONG).show();
        readFile();
        randomVoca();
        imageNum = 5;
        String imageName = "hangman" + imageNum;
        int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(id);
        TextView textView_A = findViewById(R.id.textview_A);
        TextView textView_B = findViewById(R.id.textview_B);
        TextView textView_C = findViewById(R.id.textview_C);
        TextView textView_D = findViewById(R.id.textview_D);
        TextView textView_E = findViewById(R.id.textview_E);
        TextView textView_F = findViewById(R.id.textview_F);
        TextView textView_G = findViewById(R.id.textview_G);
        TextView textView_H = findViewById(R.id.textview_H);
        TextView textView_I = findViewById(R.id.textview_I);
        TextView textView_J = findViewById(R.id.textview_J);
        TextView textView_K = findViewById(R.id.textview_K);
        TextView textView_L = findViewById(R.id.textview_L);
        TextView textView_M = findViewById(R.id.textview_M);
        TextView textView_N = findViewById(R.id.textview_N);
        TextView textView_O = findViewById(R.id.textview_O);
        TextView textView_P = findViewById(R.id.textview_P);
        TextView textView_Q = findViewById(R.id.textview_Q);
        TextView textView_R = findViewById(R.id.textview_R);
        TextView textView_S = findViewById(R.id.textview_S);
        TextView textView_T = findViewById(R.id.textview_T);
        TextView textView_U = findViewById(R.id.textview_U);
        TextView textView_V = findViewById(R.id.textview_V);
        TextView textView_W = findViewById(R.id.textview_W);
        TextView textView_X = findViewById(R.id.textview_X);
        TextView textView_Y = findViewById(R.id.textview_Y);
        TextView textView_Z = findViewById(R.id.textview_Z);

        TextView[] textViews = {textView_A, textView_B, textView_C, textView_D, textView_E, textView_F,
                textView_G, textView_H, textView_I, textView_J, textView_K, textView_L, textView_M,
                textView_N, textView_O, textView_P, textView_Q, textView_R, textView_S, textView_T,
                textView_U, textView_V, textView_W, textView_X, textView_Y, textView_Z};

        for (int i =0; i<textViews.length; i++){
            textViews[i].setClickable(true);
            textViews[i].setTextColor(Color.parseColor("#000000"));
        }

    }


    }

