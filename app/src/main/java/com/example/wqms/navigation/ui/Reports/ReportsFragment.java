package com.example.wqms.navigation.ui.Reports;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wqms.R;
import com.example.wqms.databinding.FragmentHomeBinding;
import com.example.wqms.databinding.ReportsFragmentBinding;
import com.example.wqms.navigation.ui.home.HomeViewModel;

public class ReportsFragment extends Fragment {

    private ReportsFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReportsViewModel reportsViewModel =
                new ViewModelProvider(this).get(ReportsViewModel.class);

        binding = ReportsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textReports;
        reportsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}