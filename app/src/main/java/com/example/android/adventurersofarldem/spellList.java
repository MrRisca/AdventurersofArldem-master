package com.example.android.adventurersofarldem;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link spellList.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link spellList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class spellList extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    final static String ARG_POSITION = "position";
    //private static final String ARG_PARAM1 = "param1";
    static int mCurrentPosition = -1;

//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public spellList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment spellList.
     */
    // TODO: Rename and change types and number of parameters
    public static spellList newInstance(String param1, String param2) {
        spellList fragment = new spellList();
        Bundle args = new Bundle();
        args.putString(ARG_POSITION, param1);
        args.putString(String.valueOf(mCurrentPosition), param2);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//   public void onCreate(Bundle savedInstanceState) {
//     super.onCreate(savedInstanceState);
//       if (savedInstanceState != null) {
//            DemoFragment spellListFragment = (DemoFragment)
//                    getSupportFragmentManager().findFragmentById(R.id.fragmentDemo);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spell_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
