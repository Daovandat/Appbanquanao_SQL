package com.example.DA4_QuanAo.Home.Tai_khoan.dondamua;

import static com.example.DA4_QuanAo.Home.Home.chipNavigationBar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.DA4_QuanAo.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class donhangdamua extends Fragment {
    TabLayout tab;
    ViewPager2 viewPager2;
    dondamuaviewpager dondamuaviewpager;
    ImageView btquaylai;
    public donhangdamua() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donhangdamua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tab=view.findViewById(R.id.tab);
        viewPager2=view.findViewById(R.id.view);
        btquaylai = view.findViewById(R.id.idquaylaihome);
        dondamuaviewpager=new dondamuaviewpager(this);
        viewPager2.setAdapter(dondamuaviewpager);
        chipNavigationBar.setVisibility(View.GONE);
        btquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_donhangdamua_to_thong_tin_ca_nhan);
//                        startActivity(new Intent(getActivity(), MainActivity.class));
//                        getActivity().finish();
            }
        });
        new TabLayoutMediator(tab, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Chờ xác nhận ");

                        break;
                    case 1:
                        tab.setText("Đang giao");

                        break;
                    case 2:
                        tab.setText("Đã giao");

                        break;
                    case 3:
                        tab.setText("Đã hủy");
                        break;
                }

            }
        }).attach();
    }
}