package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txthi)
    TextView txthi;

    @BindView(R.id.myrecyclerview)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RvCustomAdapter rvCustomAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        linearLayoutManager = new LinearLayoutManager(this);
        rvCustomAdapter = new RvCustomAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvCustomAdapter);
        Observable.just("How are you?").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                txthi.setText(s);
            }
        });
       /* Observable.just("sruthi","virinchi","vijaya","kk","chatur","praveen","nada","likith").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                rvCustomAdapter.addStringtoList(s);
            }
        });*/
        Entry entry1 = new Entry("ps4", BigDecimal.valueOf(1500),new Date());
        Entry entry2 = new Entry("ps5", BigDecimal.valueOf(2500),new Date());
        Entry entry3 = new Entry("xbox", BigDecimal.valueOf(3500),new Date());
        Entry entry4 = new Entry("xbox1", BigDecimal.valueOf(500),new Date());
        Entry entry5 = new Entry("xbox2", BigDecimal.valueOf(1500),new Date());

        Observable.just(entry1,entry2,entry3,entry4,entry5).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Throwable {
                rvCustomAdapter.addentrytoList(entry);
            }
        });

    }
}