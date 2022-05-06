package com.example.wqms.navigation.ui.Live_Data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wqms.databinding.FragmentLiveDataBinding;

public class LiveDataFragment extends Fragment {

    private FragmentLiveDataBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LiveDataViewModel liveDataViewModel =
                new ViewModelProvider(this).get(LiveDataViewModel.class);

        binding = FragmentLiveDataBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLiveData;
        liveDataViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}