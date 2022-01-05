package com.example.car;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InformationAdapter.ItemClicked {

    Button btnCarInfo, btnOwnerInfo;
    TextView tvName,tvTel,tvCarName;
    ImageView ivLogo;
    Fragment listFrag,btnFrag,DetailFrag,carInfoFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnInfo);
        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        tvCarName = findViewById(R.id.tvCarName);
        ivLogo = findViewById(R.id.ivLogo);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = fragmentManager.findFragmentById(R.id.fragment);
        btnFrag = fragmentManager.findFragmentById(R.id.fragment2);
        DetailFrag = fragmentManager.findFragmentById(R.id.fragment3);
        carInfoFrag = fragmentManager.findFragmentById(R.id.fragment4);

        fragmentManager.beginTransaction()
                .show(listFrag)
                .show(btnFrag)
                .show(carInfoFrag)
                .hide(DetailFrag)
                .commit();

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .show(DetailFrag)
                        .hide(carInfoFrag)
                        .commit();

               // tvName.setText();

            }
        });

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(DetailFrag)
                        .commit();

            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(ApplicationClass.InfoList.get(index).getPersonName());
        tvCarName.setText(ApplicationClass.InfoList.get(index).getCarName());
        tvTel.setText(ApplicationClass.InfoList.get(index).getPersonTel());

        if(ApplicationClass.InfoList.get(index).getCarLogo().equals("Volkswagen"))
        {
            ivLogo.setImageResource(R.drawable.volkswagen);
        }
        else if(ApplicationClass.InfoList.get(index).getCarLogo().equals("Nissan"))
        {
            ivLogo.setImageResource(R.drawable.nissan);
        }
        else
        {
            ivLogo.setImageResource(R.drawable.mercedes);
        }
    }
}