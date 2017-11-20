package com.example.flavius.customcontactsapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainContactsActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;


    ArrayList<ContactsCard> listOfContacts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contacts);

        myRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewID);

        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.requestFocus();
        showList();
        searchBar();
    }


    public void searchBar() {
        EditText searchEditText = (EditText) findViewById(R.id.searchID);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("Un text", charSequence + "");

                ArrayList<ContactsCard> searchList = new ArrayList<ContactsCard>();

                for (int j = 0; j < listOfContacts.size(); j++) {
                    ContactsCard contact = listOfContacts.get(j);
                    if (contact.name.startsWith(charSequence + "")) {
                        searchList.add(contact);
                    }
                }
                if (charSequence.toString().isEmpty()) {
                    myAdapter.setNewList(listOfContacts);
                } else {
                    myAdapter.setNewList(searchList);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    public void showList() {
        for (int i = 1; i <= 100; i++) {
            listOfContacts.add(new ContactsCard("Surname Name " + i, "07000" + i));
        }
        myAdapter = new MyAdapter(listOfContacts);
        myRecyclerView.setAdapter(myAdapter);
    }

    public void AddContacts(ContactsCard contact) {

        listOfContacts.add(contact);
        myAdapter.setNewList(listOfContacts);

    }

    public void clickingFab(View view) {
        AddContactsFragment contactsFrag = new AddContactsFragment();
        FragmentManager fm = getSupportFragmentManager();
        contactsFrag.show(fm, "Fragment");
    }

}
