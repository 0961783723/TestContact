package com.example.listviewdemo02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    Contact contact1,contact2,contact3,contact4,contact5,contact6,contact7;
    List<Contact> contactList;
    AdapterContact adapterContact;
    RelativeLayout btnAdd;

    //
    private TextView tvName;
    private TextView tvNumber;
    private int a,b;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.lvContact);

        contactList = new ArrayList<>();

        contact1 = new Contact("Mr A",961783723,false);
        contact2 = new Contact("Mr B",345678900,true);
        contact3 = new Contact("Mr C",686868686,true);
        contact4 = new Contact("Mr D",688888888,false);
        contact5 = new Contact("Mr E",968888888,false);
        contact6 = new Contact("Mr F",961234567,true);
        contact7 = new Contact("Mr G",969999999,false);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);
        contactList.add(contact7);

        adapterContact = new AdapterContact(contactList);
        lvContact.setAdapter(adapterContact); //lvContact hiển thị các thông tin đã set ở adapter

        tvName = findViewById(R.id.tvName);
        tvNumber = findViewById(R.id.tvNumber);

        btnAdd = findViewById(R.id.btnAdd);
        /*Intent intent = getIntent();
        String nameNew = intent.getStringExtra(AddNewContact.Name);
        tvName.setText(nameNew);
        //tvNumber.setText(intent.getStringExtra(AddNewContact.Number));

        /*if (intent != null) {
            Bundle bundle = intent.getBundleExtra(AddNewContact.BUNDLE);
            if (bundle != null) {
                tvName.setText(bundle.getString(AddNewContact.Name));
                tvNumber.setText(bundle.getString(AddNewContact.Number));
            } else {
                tvName.setText(bundle.getString(AddNewContact.Name));
                tvNumber.setText(bundle.getString(AddNewContact.Number));
            }
        }
        */

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),TestAddNew.class);
                startActivity(intent);

                //hiển thị thông báo "Done"
                Toast.makeText(getBaseContext(),"Done",Toast.LENGTH_LONG).show();
            }
        });

        //xử lý việc click vào tên ng hiển thị ra thông tin của ng đó
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //hiển thị vị trí khi click
                //Toast.makeText(getBaseContext(),"Vị trí " + i,Toast.LENGTH_SHORT).show();
                String name = contactList.get(i).getName();
                Toast.makeText(getBaseContext(),"Name " + name,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
