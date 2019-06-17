package com.test.buttons.enums;

import java.util.*;

public enum Colour
{
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    GREEN("GREEN"),
    RED("RED"),
    WHITE("WHITE"),
    ORANGE("ORANGE");

    private String colour;
    private static String RED_FLAG = "RED";
    private static String WHITE_FLAG = "WHITE";

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    private static final List<Colour> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static List<Colour> randomColourList()  {

        return Arrays.asList(VALUES.get(RANDOM.nextInt(SIZE)),
                             VALUES.get(RANDOM.nextInt(SIZE)),
                             VALUES.get(RANDOM.nextInt(SIZE)),
                             VALUES.get(RANDOM.nextInt(SIZE)));

    }

    public static List<String> checkParamList(List<Colour> originalList, List<Colour> paramList) {
        List<String> flagList = new ArrayList<>();

        int index = 0;
        for(Colour colourElement : paramList) {
            if(colourElement.equals(originalList.get(index))) {
                flagList.add(RED_FLAG);
            } else if(originalList.contains(colourElement)){
                flagList.add(WHITE_FLAG);
            }
            index++;
        }

        return flagList;
    }

    public static Boolean isResolved(List<String> flagList) {

        if(flagList.size() < 4 ) return false;

        for(String flag : flagList) {
            if(flag.equals(WHITE_FLAG))
                return false;
        }
        return true;
    }
}