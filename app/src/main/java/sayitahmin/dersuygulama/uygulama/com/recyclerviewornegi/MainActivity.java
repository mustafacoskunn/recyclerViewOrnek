package sayitahmin.dersuygulama.uygulama.com.recyclerviewornegi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<String> ulkeler;
    private MyAdapter adapter; //adapterimiz
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        ulkeler=new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(this)); //linear layout verdik düzgünce yerleşssinn diye
        rv.setHasFixedSize(true); //yatay dönüşte görüntü bozulmaz

        ulkeler.add("Türkiye");
        ulkeler.add("Alamanya");
        ulkeler.add("Fransa");
        ulkeler.add("Italya");
        ulkeler.add("Amerika");

        adapter=new MyAdapter(this,ulkeler); //bu class ile ulkeleri yolla
        rv.setAdapter(adapter); //adapteri bagla


    }
}
