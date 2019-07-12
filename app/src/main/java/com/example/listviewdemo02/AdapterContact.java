package com.example.listviewdemo02;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//sử dụng Adapter để xử lý và hiển thị listview
public class AdapterContact extends BaseAdapter {
    List<Contact> contactList; //khởi tạo giá trị của contactList

    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.item_contacl,viewGroup,false);

        TextView tvName = v.findViewById(R.id.tvName);
        TextView tvNumber = v.findViewById(R.id.tvNumber);
        ImageView imgContact = v.findViewById(R.id.imgContact);
        Contact contact =contactList.get(i);


        tvName.setText(contact.getName());
        tvNumber.setText(String.valueOf(contact.getNumber()));

        if(contact.isIcon() == true)
        {
            imgContact.setImageResource(R.drawable.ninjasimple12);

        }


        return v;

    }
}
