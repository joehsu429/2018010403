package com.example.student.a2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp,sp2;
    ArrayList<String> al;
    TextView tv,tv2,tv3;
    EditText ed;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        al=new ArrayList<String>();
        sp=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        tv=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        ed=findViewById(R.id.editText);
        al.add("A");
        al.add("B");
        al.add("C");
        adapter=
                new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,al);

        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(al.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str[]=getResources().getStringArray(R.array.animal);
                tv3.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void click1(View v)
    {
        int pos=sp.getSelectedItemPosition();
        tv2.setText(al.get(pos));
    }
    public void clickadd(View v)
    {
        al.add(ed.getText().toString());
        adapter.notifyDataSetChanged();
    }
    public void clickdelete(View v)
    {
        al.remove(sp.getSelectedItemPosition());
        adapter.notifyDataSetChanged();
    }
}
