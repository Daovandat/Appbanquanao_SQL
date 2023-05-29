package com.example.DA4_QuanAo.Home.Trang_chu;

import static com.example.DA4_QuanAo.xuly.on_back_home1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.DA4_QuanAo.API.API;
import com.example.DA4_QuanAo.Home.Home;
import com.example.DA4_QuanAo.R;
import com.example.DA4_QuanAo.models.danh_muc;
import com.example.DA4_QuanAo.models.san_pham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class trang_chu extends Fragment {

    RecyclerView recy_1,recy_2;
    danh_muc_adpater danh_muc_adpater;
    sp_adapter sp_adapter;
    EditText timkiem;

    public ImageSlider imageSlider;

    ArrayList<danh_muc>danh_mucs=new ArrayList<>();
    ArrayList<san_pham>san_phams=new ArrayList<>();
    ArrayList<SlideModel> slideModels = new ArrayList<>();
    public trang_chu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trang_chu, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        anhxa(view);
        getdata();

        slideModels.add( new SlideModel("https://img5.thuthuatphanmem.vn/uploads/2021/12/02/banner-flash-sale_083649302.jpg", ScaleTypes.FIT));
        slideModels.add( new SlideModel("https://dichvuquangcao.vn/wp-content/uploads/2021/04/Facebook-Marketing-La-Gi-4-1700x956.jpg", ScaleTypes.FIT));
        slideModels.add( new SlideModel("https://www.phanmemninja.com/wp-content/uploads/2021/12/mau-content-thoi-trang-hay.jpg", ScaleTypes.FIT));
        slideModels.add( new SlideModel("https://intphcm.com/data/upload/banner-thoi-trang.jpg", ScaleTypes.FIT));
        slideModels.add( new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkfSlpNDscW7e568WKyqbwNBj3rbL6ig7xK8ZbJ-pimh0839w_ETM3oTiL8sZDZvP_DY0&usqp=CAU", ScaleTypes.FIT));
        slideModels.add( new SlideModel("https://footwearnews.com/wp-content/uploads/2022/01/adidas-logo-worth.jpg?w=700&h=437&crop=1", ScaleTypes.FIT));
        slideModels.add( new SlideModel("https://leika.vn/wp-content/uploads/2021/01/185e8bf5ef761f284667-scaled.jpg", ScaleTypes.FIT));
        slideModels.add( new SlideModel("https://kenh14cdn.com/thumb_w/600/pr/2022/photo-1-1642084813075839231838-0-159-1079-1885-crop-1642085021525-63777710768355.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_trang_chu_to_timkiem2);
            }
        });
        Home home= (Home) getActivity();
        on_back_home1(home);
    }

    private void getdata() {
        API.API.Get_Danh_muc().enqueue(new Callback<List<danh_muc>>() {
            @Override
            public void onResponse(Call<List<danh_muc>> call, Response<List<danh_muc>> response) {
                danh_mucs= (ArrayList<danh_muc>) response.body();
                recy_1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
                danh_muc_adpater=new danh_muc_adpater(danh_mucs,trang_chu.this);
                recy_1.setAdapter(danh_muc_adpater);
            }

            @Override
            public void onFailure(Call<List<danh_muc>> call, Throwable t) {

            }
        });
        API.API.Get_san_pham().enqueue(new Callback<List<san_pham>>() {
            @Override
            public void onResponse(Call<List<san_pham>> call, Response<List<san_pham>> response) {
                san_phams= (ArrayList<san_pham>) response.body();
                recy_2.setLayoutManager(new GridLayoutManager(getContext(),2));
                sp_adapter=new sp_adapter(san_phams,trang_chu.this,0);
                recy_2.setAdapter(sp_adapter);
            }

            @Override
            public void onFailure(Call<List<san_pham>> call, Throwable t) {

            }
        });

    }

    private void anhxa(View view) {
        recy_1=view.findViewById(R.id.recy_1);
        recy_2=view.findViewById(R.id.recy_2);
        timkiem=view.findViewById(R.id.timkiem);
        imageSlider = view.findViewById(R.id.imageSlide);

    }
}