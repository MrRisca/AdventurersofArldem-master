package com.example.android.adventurersofarldem.Quests.SlayTheBigRatQuests;

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

public class SlayTheBigRatStoryPartThreeFragment extends Fragment {

    public Equippable lootChoice;


    public SlayTheBigRatStoryPartThreeFragment() {
    }

    public static SlayTheBigRatStoryPartThreeFragment newInstance() {
        SlayTheBigRatStoryPartThreeFragment fragment = new SlayTheBigRatStoryPartThreeFragment();
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
        View view = inflater.inflate(R.layout.fragment_slay_the_big_rat_story_part_three, container, false);
        TextView goldGained = view.findViewById(R.id.gold_earned);
        goldGained.setText(String.valueOf(SlayTheBigRatQuest.getQuestGold()));
        TextView experienceGained = view.findViewById(R.id.experience_gained);
        experienceGained.setText(String.valueOf(SlayTheBigRatQuest.getQuestExperience()));
        final ImageView rewardOne = view.findViewById(R.id.RewardOne);
        rewardOne.setImageResource(SlayTheBigRatQuest.questRewardOne().iconPath);
        rewardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewardOne.setImageResource(SlayTheBigRatQuest.questRewardOne().iconSelected);
                lootChoice = SlayTheBigRatQuest.questRewardOne();
            }
        });
        final ImageView rewardTwo = view.findViewById(R.id.RewardTwo);
        rewardTwo.setImageResource(SlayTheBigRatQuest.questRewardTwo().iconPath);
        rewardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewardTwo.setImageResource(SlayTheBigRatQuest.questRewardTwo().iconSelected);
                lootChoice = SlayTheBigRatQuest.questRewardTwo();
            }
        });
        Button exitFragment = (Button)view.findViewById(R.id.confirmButton);
        exitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lootChoice != null) {
                    Player.getInstance().addToInventory(lootChoice);
                    SlayTheBigRatQuest.completeQuest();
                    Intent intent = new Intent(getActivity(), fight_launcher.class);
                    startActivity(intent);
                    getFragmentManager().beginTransaction().remove(SlayTheBigRatStoryPartThreeFragment.this).commit();
                }
            }
        });

        return view;
    }


}
