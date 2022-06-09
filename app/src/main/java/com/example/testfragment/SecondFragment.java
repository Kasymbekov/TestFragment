package com.example.testfragment;

import static com.example.testfragment.MainFragment.KEY_FOR_BUNDLE;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondFragment extends Fragment {
    private EditText editText;
    private Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.et_f2);
        btn = view.findViewById(R.id.btn_f2);

        if (getArguments() != null) {
            editText.setText(getArguments().getString(KEY_FOR_BUNDLE));
        }

        btn.setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_FOR_BUNDLE, editText.getText().toString());
            ThirdFragment thirdFragment = new ThirdFragment();
            thirdFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).addToBackStack(null).commit();
        });
    }
}