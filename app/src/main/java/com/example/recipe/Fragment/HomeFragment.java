package com.example.recipe.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.denzcoskun.imageslider.models.SlideModel;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;


import com.example.recipe.R;
import com.example.recipe.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Create a list of SlideModel
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.img, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.img_1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.img_2, ScaleTypes.FIT));

        // Get the ImageSlider from binding
        ImageSlider imageSlider = binding.imageSlider;

        // Set the image list to the ImageSlider
        imageSlider.setImageList(imageList);
        // Optionally set the image list with ScaleTypes (only if needed)
        imageSlider.setImageList(imageList, ScaleTypes.FIT);
    }


}
