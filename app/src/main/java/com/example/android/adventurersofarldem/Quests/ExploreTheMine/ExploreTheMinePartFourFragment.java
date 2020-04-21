package com.example.android.adventurersofarldem.Quests.ExploreTheMine;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.Items.Equippable;
import com.example.android.adventurersofarldem.R;
import com.example.android.adventurersofarldem.fight_launcher;

public class ExploreTheMinePartFourFragment extends Fragment {

    public Equippable lootChoice;


    public ExploreTheMinePartFourFragment() {
    }

    public static ExploreTheMinePartFourFragment newInstance() {
        ExploreTheMinePartFourFragment fragment = new ExploreTheMinePartFourFragment();
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
        View view = inflater.inflate(R.layout.fragment_explore_the_mine_four, container, false);
        TextView goldGained = view.findViewById(R.id.gold_earned);
        goldGained.setText(String.valueOf(ExploreTheMineQuest.getQuestGold()));
        TextView experienceGained = view.findViewById(R.id.experience_gained);
        experienceGained.setText(String.valueOf(ExploreTheMineQuest.getQuestExperience()));
        final ImageView rewardOne = view.findViewById(R.id.RewardOne);
        rewardOne.setImageResource(ExploreTheMineQuest.questRewardOne().iconPath);
        rewardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewardOne.setImageResource(ExploreTheMineQuest.questRewardOne().iconSelected);
                lootChoice = ExploreTheMineQuest.questRewardOne();
            }
        });
        final ImageView rewardTwo = view.findViewById(R.id.RewardTwo);
        rewardTwo.setImageResource(ExploreTheMineQuest.questRewardTwo().iconPath);
        rewardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewardTwo.setImageResource(ExploreTheMineQuest.questRewardTwo().iconSelected);
                lootChoice = ExploreTheMineQuest.questRewardTwo();
            }
        });
        Button exitFragment = (Button)view.findViewById(R.id.confirmButton);
        exitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lootChoice != null) {
                    Player.getInstance().addToInventory(lootChoice);
                    ExploreTheMineQuest.completeQuest();
                    Intent intent = new Intent(getActivity(), fight_launcher.class);
                    startActivity(intent);
                    getFragmentManager().beginTransaction().remove(ExploreTheMinePartFourFragment.this).commit();
                }
            }
        });

        return view;
    }


}
