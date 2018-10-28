package com.example.bruker.friends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/*
* Exercise 3 IINI4014 at NTNU
* Created fall 2018 by Rune Vedøy
*/

public class MainActivity extends AppCompatActivity {

    EditText etAddFriend;
    EditText addBDay;
    Button buAdd;
    Switch edit;
    ListView lvFriends;
    TextView tvChosen;

    ArrayAdapter<String> adapter;
    int positionToEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAddFriend =findViewById(R.id.etFriend);
        addBDay = findViewById(R.id.etbdate);
        buAdd = findViewById(R.id.buAddFriend);
        edit = findViewById(R.id.editFriend);
        lvFriends = findViewById(R.id.lvFriend);
        tvChosen = findViewById(R.id.tvChosen);
    }

    public void buDelete(View view) {
        if (positionToEdit<0){
            //Populate an arraylist
            ArrayList<String> arrayToBeSent  = new ArrayList<>();
            for (int i = lvFriends.getChildCount() - 1 ; i>=0; i--) {
                String itemValue = (String) lvFriends.getItemAtPosition( i );
                arrayToBeSent.add(itemValue);
            }
            //Remove item by position found in method initiateList()
            arrayToBeSent.remove(positionToEdit);

            //Initiate the updated arraylist
            initiateList(arrayToBeSent);
        }
    }

    public void buAddFriend(View view) {
        // Using the EditText elements and creating a single string to be put into the ListView
        String listItem= createString();

        // Gets the current list from listview and populates an ArrayList
        ArrayList<String> arrayToBeSent  = new ArrayList<>();
        for (int i = lvFriends.getChildCount() - 1 ; i>=0; i--) {
            String itemValue = (String) lvFriends.getItemAtPosition( i );
            arrayToBeSent.add(itemValue);
        }

        if (edit.isChecked()){
            arrayToBeSent.set(positionToEdit,listItem);
        }else{
            // Add New element to list
            arrayToBeSent.add(listItem);
        }

        initiateList(arrayToBeSent);

    }

    //Initiate list and also code for editing
    private void initiateList(final ArrayList<String> stringArray){
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1,stringArray);
        lvFriends.setAdapter(adapter);
        lvFriends.setChoiceMode(lvFriends.CHOICE_MODE_SINGLE);

        //If list item is clicked send its data to TextView or the EditTex elements
        lvFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String setTextView = stringArray.get(position);
                tvChosen.setText(setTextView);
                positionToEdit = adapter.getPosition(stringArray.get(position))-1;

                //Populates the textfields with what is selected if one wants to edit
                if (edit.isChecked()){
                    String[] split = stringArray.get(position).split(":");
                    String editName=split[0].trim();
                    String editBDay=split[1].trim();
                    etAddFriend.setText(editName);
                    addBDay.setText(editBDay);
                }
            }
        });
    }

    //Put together the input from the to text fields
    public String createString(){
        String name = etAddFriend.getText().toString();
        String bday = addBDay.getText().toString();
        String friend= name + " : " +bday;

        return friend;
    }

}
