package com.example.flavius.customcontactsapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddContactsFragment extends DialogFragment {


    public AddContactsFragment() {

    }

    EditText storeName;
    EditText storeNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View mainFragmentView = inflater.inflate(R.layout.fragment_add_contacts, container, false);
        storeName = mainFragmentView.findViewById(R.id.StoreNameID);
        storeNumber = mainFragmentView.findViewById(R.id.StoreNumberID);
        Button addButton = mainFragmentView.findViewById(R.id.ButtonStoreID);
        Button cancelButton = mainFragmentView.findViewById(R.id.ButtonCancelID);
        final DialogFragment thisFragment = this;


        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                thisFragment.dismiss();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = storeName.getText().toString();
                String number = storeNumber.getText().toString();
                if (name.isEmpty() || number.isEmpty()) {
                    Toast.makeText(getContext(), "Invalid entry !", Toast.LENGTH_SHORT).show();
                } else {
                    ContactsCard contact = new ContactsCard(name, number);
                    MainContactsActivity mainActivity = (MainContactsActivity) getActivity();
                    mainActivity.AddContacts(contact);
                    Toast.makeText(getContext(), "Contact added", Toast.LENGTH_SHORT).show();
                    thisFragment.dismiss();
                }
            }
        });
        return mainFragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
