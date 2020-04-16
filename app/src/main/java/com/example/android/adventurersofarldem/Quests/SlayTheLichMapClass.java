//package com.example.android.adventurersofarldem.Quests;
//
//public class SlayTheLichMapClass {
//    String[][] lichMap;
//    Boolean[][] lichMapGoLeft;
//    Boolean[][] lichMapGoUp;
//    Boolean[][] lichMapGoDown;
//    Boolean[][] lichMapGoRight;
//
//    public SlayTheLichMapClass() {
//        //T = Treasure
//        //B = Boss (obviously has loot too)
//        //O = Orc
//        //G = Goblin
//        //E = Empty
//        //M = Minotaur
//
//        lichMap = new String[][]{
//
//                {"T", "E", "E", "E", "E", "E", "E", "E", "E", "E", "T", "E", "O", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"M", "E", "E", "E", "E", "E", "E", "E", "E", "E", "T", "E", "T", "O", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "B", "E", "E", "E", "E", "E", "E", "O", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "T", "E", "E", "E", "E"},
//                {"M", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "O", "E", "E", "E", "E", "O", "E", "E", "T", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"T", "E", "E", "T", "E", "E", "E", "E", "E", "E", "E", "E", "E", "M", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "O", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "T", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "O", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "O", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "M", "E", "E", "E", "E", "E", "O", "E", "E", "E", "E", "E", "O"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "O", "E", "E", "E", "E", "T", "O", "E", "E", "E", "E"},
//                {"E", "M", "O", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "T", "T", "M", "E", "E", "E", "E", "E", "O", "T", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "O", "E", "E", "E", "E", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "O", "E", "E", "E", "E", "E", "E", "E", "E", "T", "O", "E", "E", "E", "E"},
//                {"E", "E", "E", "E", "E", "E", "E", "E", "O", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E"},
//        };
//
//        lichMapGoDown = new Boolean[][]{
//                     C    D      E      F     G       H     I      J      K     L     M     N      O     P       Q     R     S      T    U     V      W     X
//                0{true, false, false, false, false, true, false, false, false, true, true, true, false, false, false, false, true, true, false, false, true, true},
//                1{true, false, false, false, false, true, true, false, true, true, true, true, false, false, false, true, false, true, true, true, true, true},
//                2{true, false, false, false, false, false, true, false, false, false, true, false, false, false, false, true, true, true, false, true, true, true},
//                3{false, false, false, true, true, true, true, false, false, false, true, false, false, false, false, true, true, false, true, true, true, true},
//                4{true, true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true},
//                5{true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true},
//                6{false, true, false, false, true, false, false, true, true, true, true, false, true, true, false, false, false, false, false, false, false, true},
//                7{false, false, false, false, false, false, true, true, true, true, false, true, true, true, false, false, false, false, false, false, false, false},
//                8{true, true, true, true, true, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, true, true},
//                    C     D      E      F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//                9{true, true, false, false, false, false, true, true, false, false, false, true, false, false, false, false, false, false, false, false, false, true},
//                10{true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
//                11{false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, true},
//                12{true, true, false, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                13{true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                14{true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                15{true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                16{true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                17{true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                18{true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                19{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
//                  C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//        };
//
//        lichMapGoUp = new Boolean[][]{
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//                1{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                2{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                3{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                4{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                5{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                6{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                7{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                8{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                9{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//                10{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                11{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                12{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                13{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                14{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                15{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                16{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                17{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                18{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                19{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                20{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//        };
//
//        lichMapGoLeft = new Boolean[][]{
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//                1{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                2{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                3{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                4{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                5{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                6{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                7{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                8{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                9{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//                10{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                11{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                12{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                13{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                14{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                15{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                16{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                17{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                18{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                19{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                20{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//        };
//
//        lichMapGoRight = new Boolean[][]{
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//                1{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                2{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                3{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                4{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                5{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                6{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                7{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                8{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                9{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//                10{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                11{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                12{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                13{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                14{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                15{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                16{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                17{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                18{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                19{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                20{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//                C    D      E    F     G     H     I      J    K     L     M     N     O     P     Q     R     S      T    U     V      W     X
//        };
//
//
//    }
//}
