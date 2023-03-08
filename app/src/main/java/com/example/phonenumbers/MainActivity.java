package com.example.phonenumbers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
//ازاي اضيف صوره جنب الاسم ؟
        mylist = new ArrayList<>();
        mylist.add("Farha \n +02123456");
        mylist.add("Ezzat \n +021543211");
        mylist.add("maryam\n +021234565");
        mylist.add("selia \n +021235467");
        mylist.add("Ahmed \n +021564786");
        mylist.add("Nancy \n +025469878");
        mylist.add("Morad \n +025469878");
        mylist.add("mohamed \n +025469878");
        mylist.add("fady \n +025469878");

        // Adapter it is like a bridge to conect arraylist with list view

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //مش بيطبغ
                Toast.makeText(MainActivity.this,"this contect is in bloc list",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);


        //  i do this to line to Initialise menu item search bar with id and take its object

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (mylist.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {


                    // Search query not found in List View

                    Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
            }
        }

