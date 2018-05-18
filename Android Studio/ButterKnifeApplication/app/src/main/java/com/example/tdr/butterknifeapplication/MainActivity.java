package com.example.tdr.butterknifeapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.swipeMenu) SwipeMenu listView;
    UsuarioAdapter usuarioAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ArrayList<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "Wender Galan"));
        listUser.add(new User(2, "Jose Costa"));
        listUser.add(new User(3, "Ferreira Souza"));
        listUser.add(new User(4, "Bruno Pereira"));
        listUser.add(new User(5, "Jose Jamiton"));
        listUser.add(new User(1, "Wender Galan"));
        listUser.add(new User(2, "Jose Costa"));
        listUser.add(new User(3, "Ferreira Souza"));
        listUser.add(new User(4, "Bruno Pereira"));
        listUser.add(new User(5, "Jose Jamiton"));
        listUser.add(new User(1, "Wender Galan"));
        listUser.add(new User(2, "Jose Costa"));
        listUser.add(new User(3, "Ferreira Souza"));
        listUser.add(new User(4, "Bruno Pereira"));
        listUser.add(new User(5, "Jose Jamiton"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        usuarioAdapter = new UsuarioAdapter(listUser);
        recyclerView.setAdapter(usuarioAdapter);

       /* SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        listView.setMenuCreator(creator);*/


    }

}
