package com.example.anujdawar.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    protected ListView lvProduct;
    protected productListAdapter adapter;
    protected List<product> mProductList;

    protected int positionOfCommandSelected;
    protected int EditOrDeleteSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct = (ListView) findViewById(R.id.myListID);
        mProductList = new ArrayList<>();

        mProductList.add(new product("Open The Gate", "ON", "OFF", "ON", "OFF", "NONE"));
        mProductList.add(new product("Turn On The Light", "ON", "OFF", "ON", "OFF", "NONE"));
        mProductList.add(new product("Turn Off Lights", "ON", "OFF", "ON", "OFF", "NONE"));
        mProductList.add(new product("Fan On", "ON", "OFF", "ON", "OFF", "NONE"));
        mProductList.add(new product("WOW", "ON", "OFF", "ON", "OFF", "NONE"));

        adapter = new productListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        this.registerForContextMenu(lvProduct);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v.getId() == R.id.myListID)
        {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

            CharSequence temp;
            temp = mProductList.get(info.position).getMyCommand();

            menu.setHeaderTitle(temp);

            positionOfCommandSelected = info.position;
            Toast.makeText(getApplicationContext(), ":" + String.valueOf(positionOfCommandSelected), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "." + String.valueOf(mProductList.size()), Toast.LENGTH_SHORT).show();

            String[] menuItems = {"Edit","Delete"};

            for(int i = 0; i < menuItems.length; i++)
                menu.add(Menu.NONE, i, i, menuItems[i]);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int menuItemIndex = item.getItemId();

        if(menuItemIndex == 0)
            EditOrDeleteSelected = 0;

        else
            EditOrDeleteSelected = 1;

        return true;
    }
}
