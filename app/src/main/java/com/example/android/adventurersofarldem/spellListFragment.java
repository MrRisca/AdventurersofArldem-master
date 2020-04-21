package com.example.android.adventurersofarldem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class spellListFragment extends Fragment {

    public String selectedSpellName;


    public spellListFragment() {
        // Required empty public constructor
    }

    public interface Listener {
        void spellListDidSelectSpell(String selectedSpellName);
    }

    protected Listener mListener;

    public spellListFragment setListener(Listener listener) {
        mListener = listener;
        return null;
    }






    // TODO: Rename and change types and number of parameters
    public static spellListFragment newInstance(String selectedSpellName){
        spellListFragment fragment = new spellListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
   public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
        }

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_spell_list, container, false);
        Button fireballButton = view.findViewById(R.id.fireballButton);
        fireballButton.setOnClickListener((View.OnClickListener) this);
                return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onFireballButtonPressed(Uri uri) {
        if (mListener != null) {
            selectedSpellName = "Fireball";
            mListener.spellListDidSelectSpell(selectedSpellName);
            Intent intent = new Intent(getContext(), level1Activity.class);
            intent.putExtra("spellChoice", selectedSpellName);
            startActivity(intent);
        }
    }




   @Override
   public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Listener) {
            mListener = (Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    private void spellListFragment() {
    }}
