package com.example.android.adventurersofarldem.Quests.ExploreTheMine;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.adventurersofarldem.R;

public class ExploreTheMinePartTwoFragment extends Fragment {

    public String textToDisplay;
    public TextView textView;

    public ExploreTheMinePartTwoFragment() {


    }

    public static ExploreTheMinePartTwoFragment newInstance(String text) {
        ExploreTheMinePartTwoFragment fragment = new ExploreTheMinePartTwoFragment();
        Bundle args = new Bundle();
        args.putString("KEY", text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            textToDisplay = getArguments().getString("KEY");
        }
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String strtext = getArguments().getString("edttext");
        View view = inflater.inflate(R.layout.fragment_explore_the_mine_two, container, false);
        textView = (TextView)view.findViewById(R.id.dungeonTextInFragment);
        textView.setText(strtext);
        Button exitFragment = (Button)view.findViewById(R.id.confirmButton);
        exitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(ExploreTheMinePartTwoFragment.this).commit();
                //getActivity().finish();
            }
        });

        return view;
    }


}
