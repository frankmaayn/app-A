package com.example.appa.ui.tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appa.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TutorialTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TutorialTextFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    FragmentTransaction fragmentTransaction;

    public TutorialTextFragment() {
        // Required empty public constructor
    }

    public static TutorialTextFragment newInstance() {
        return new TutorialTextFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorial_text,container,false);



        return view;
    }

}