package com.jangelroa.mymodule.todoapp.app;
//package com.jangelroa.todoapp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class TodoActivity extends Activity {

    private ArrayList<String> todoItems;
    private ArrayAdapter<String> todoAdapter;
    private ListView lvItems;
    private EditText etNewItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        lvItems =  (ListView) findViewById(R.id.lvItems);
        etNewItem = (EditText) findViewById(R.id.etNewItem);

        populateItems();
        todoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
        lvItems.setAdapter(todoAdapter);
        setupListViewListener();


    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View item, int pos, long id) {
                // remove an item from the ArrayList and notify the adapter
//                        todoItems.remove(pos);
//                        todoAdapter.notifyDataSetChanged();
                // remove an item directly from the adapter
                todoAdapter.remove(todoItems.get(pos));
                return true;
            }
        });
    }

    private void populateItems() {
        todoItems = new ArrayList<String>();
        todoItems.add("Item 1");
        todoItems.add("Item 2");
        todoItems.add("Item 3");
    }

    public void onAddedItem(View v){
        // get the text from the EditText
        String itemText = etNewItem.getText().toString();
        // add that text (item) to the adapter
        todoAdapter.add(itemText);
        // clear out the EditText
        etNewItem.setText("");
    }

//    private void readItem(){
//
//    }

}
