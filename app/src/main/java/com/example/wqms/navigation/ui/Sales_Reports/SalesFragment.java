package com.example.wqms.navigation.ui.Sales_Reports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wqms.databinding.FragmentSalesBinding;

public class SalesFragment extends Fragment {

    private FragmentSalesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SalesViewModel salesViewModel =
                new ViewModelProvider(this).get(SalesViewModel.class);

        binding = FragmentSalesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSales;
        salesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}