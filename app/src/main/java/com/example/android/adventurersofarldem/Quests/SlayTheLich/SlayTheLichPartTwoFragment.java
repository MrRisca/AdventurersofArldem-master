package com.example.android.adventurersofarldem.Quests.SlayTheLich;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.adventurersofarldem.R;

public class SlayTheLichPartTwoFragment extends Fragment {


    public SlayTheLichPartTwoFragment() {
    }

    public static SlayTheLichPartTwoFragment newInstance() {
        SlayTheLichPartTwoFragment fragment = new SlayTheLichPartTwoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore_the_mine_two, container, false);
        Button exitFragment = (Button)view.findViewById(R.id.confirmButton);
        exitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(SlayTheLichPartTwoFragment.this).commit();
                //getActivity().finish();
            }
        });

        return view;
    }


}
