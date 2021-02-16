package tests;

import model.ExpBar;

public class Tests {

    public static void main(String[] args) {

            ExpBar expTest = new ExpBar(1, 10, "");
            ExpBar expTest2 = new ExpBar(2, 10, "");
            ExpBar expTest3 = new ExpBar(3,10, "");
            ExpBar expTest4 = new ExpBar(5, 3,"expBar with limit");

            System.out.println("-------------------------------");
            System.out.println("Level = " + expTest.getLevel());
            System.out.println("EXP = " + expTest.getExp());

            System.out.println("-------------------------------");
            System.out.println("Level = " + expTest2.getLevel());
            System.out.println("EXP = " + expTest2.getExp());

            System.out.println("-------------------------------");
            System.out.println("Level = " + expTest3.getLevel());
            System.out.println("EXP = " + expTest3.getExp());

            System.out.println("-------------------------------");
            System.out.println("Level = " + expTest4.getLevel());
            System.out.println("EXP = " + expTest4.getExp());

    }

}
