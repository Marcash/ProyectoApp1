package com.example.proyectoapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AppActivity extends AppCompatActivity {

    private GridView gridView;
    private MyAdapter myAdapter;
    private List<String> item;
    private int c_nota=0;
    private int c_img=0;
    private int element;

    int mDefaultColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        mDefaultColor = ContextCompat.getColor(AppActivity.this, R.color.black);

        item = new ArrayList<String>();
        gridView = findViewById(R.id.gridView);
        element = R.layout.grid_item;

        myAdapter = new MyAdapter(this, (element), item);
        gridView.setAdapter(myAdapter);
        registerForContextMenu(gridView);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.add_img:
                this.item.add("imagen"+(++c_img));
                this.myAdapter.addImagen();
                return true;
            case R.id.add_item:
                this.item.add("nota"+(++c_nota));
                this.myAdapter.addNotes();
                return true;
            case R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.item.get(info.position));
        inflater.inflate(R.menu.context_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.color_item:
                openColorPicker();
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }


    public void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                //note.setBackgroundColor(mDefaultColor);
            }
        });
        colorPicker.show();
    }

}