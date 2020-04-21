package com.example.android.adventurersofarldem.Quests.SlayTheBigRatQuests;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Fragment;

import com.example.android.adventurersofarldem.R;

public class SlayTheBigRatStoryPartOneFragment extends Fragment {


    public SlayTheBigRatStoryPartOneFragment() {
    }

    public static SlayTheBigRatStoryPartOneFragment newInstance() {
        SlayTheBigRatStoryPartOneFragment fragment = new SlayTheBigRatStoryPartOneFragment();
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
        View view = inflater.inflate(R.layout.fragment_slay_the_big_rat_story_part_one, container, false);
        Button exitFragment = (Button)view.findViewById(R.id.confirmButton);
        exitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(SlayTheBigRatStoryPartOneFragment.this).commit();
                //getActivity().finish();
            }
        });

        return view;
    }


}
