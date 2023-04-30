package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.first.adapters.MyRecyclerViewAdapter;
import com.example.first.model.MyRecyclerViewModel;

import java.util.ArrayList;

public class TextToImage extends AppCompatActivity {

    Button bSubmit;
    EditText editText;
    RecyclerView recyclerView;
    String text;
    ArrayList<MyRecyclerViewModel> list;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_image);
        getSupportActionBar().hide();
        bSubmit = findViewById(R.id.submitButton);
        editText = findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recyclerView);
        text="";
        list = new ArrayList<>();



        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();

                text = editText.getText().toString();
                String temp="";

                for(int i=0;i<text.length();i++)
                {
                    char ch=text.charAt(i);
                    if(ch!=' ')
                    {
                        if((ch>=97&&ch<=122) ||   (ch>=48&&ch<=57) )
                        {
                            temp=temp+text.charAt(i);
                        }
                        else if(ch>=65&&ch<=90)
                        {
                            temp=temp+Character.toLowerCase(text.charAt(i));
                        }


                        if(i==text.length()-1)
                        {
                            if(temp.equals(""))
                            {
                                break;
                            }
                            //make new linear layout and inflate temp.lenght() images
                            setImages(temp);
                            temp="";
                        }
                    }
                    else
                    {
                        if(temp.equals(""))
                        {
                            temp="";
                            continue;
                        }
                        setImages(temp);
                        temp="";
                    }
                }
                adapter = new MyRecyclerViewAdapter(list,TextToImage.this);
                recyclerView.setAdapter(adapter);

                LinearLayoutManager layoutManager = new LinearLayoutManager(TextToImage.this);
                recyclerView.setLayoutManager(layoutManager);

            }


        });
    }
    public void setImages(String temp)
    {
        list.add(new MyRecyclerViewModel(temp,temp));
    }
}
