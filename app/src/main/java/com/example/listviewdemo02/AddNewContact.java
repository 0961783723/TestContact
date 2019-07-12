package com.example.listviewdemo02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewContact extends AppCompatActivity {
    public static String Name;
    //public static final String BUNDLE = "BUMDLE";
    //public static String Name = "NAME";
    //public static String Number = "number";
    private EditText edName;
    private EditText edNumber;
    private Button btnGroup;
    private Spinner spPhoneContact;
    private Button btnTune;
    private Button btnSend;

    Spinner spinner;
    ArrayList<String> phoneType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        spinner = findViewById(R.id.spPhoneContact);
        edName = findViewById(R.id.edName);
        edNumber = findViewById(R.id.edNumber);
        btnGroup = findViewById(R.id.btnGroup);
        btnTune = findViewById(R.id.btnTune);
        btnSend = findViewById(R.id.btnSend);
        //final String Name = edName.getText().toString();
        //final String Number = edNumber.getText().toString();


        phoneType = new ArrayList<>();
        phoneType.add("Home");
        phoneType.add("Facebook");
        phoneType.add("Friend");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, phoneType);
        spinner.setAdapter(arrayAdapter);

        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewContact.this, MainActivity.class);
                //intent.putExtra("K", edName.getText().toString());
                //intent.putExtra(Number, edNumber.getText().toString());
                startActivity(intent);
            }
        });

        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //bắt sự kiện hiển thị dialog ok hoặc cancle
                String[] tune = {"Bố mày biết mà", "Hãy trao cho anh", "Quện"};
                AlertDialog dialog = new AlertDialog.Builder(AddNewContact.this)
                        .setTitle("Mesenger")
                        //hiển thị single voice
                        .setSingleChoiceItems(tune, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //khi click vào 1 vị trí, sẽ lấy đc vị trí của single,
                                //đồng thời nhận đc chuỗi String của vị trí đấy
                                Toast.makeText(getBaseContext(), "Đã chọn" + (i + 1),
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                        //hiển thị click ok
                        //.setMessage("Click Ok")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "Oke", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "Cancle", Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();
                dialog.show();
            }
        });

        //send
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_item_menu,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnItemSave:
                                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.mnItemCancle:
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

    }



    /*public void byBundle() {
        Intent intent = new Intent(AddNewContact.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Name, edName.getText().toString());
        bundle.putString(Number, edNumber.getText().toString());
        intent.putExtra(BUNDLE, bundle);
        startActivity(intent);
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contact, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnSaveContact:
                Toast.makeText(getBaseContext(), "Save Done", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnCancel:
                Toast.makeText(getBaseContext(), "Cancel Done", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.mnOK:
                Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
