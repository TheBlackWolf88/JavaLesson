package solution.bestiary;

import solution.bestiary.utils.BeastNameComparator;
import solution.bestiary.utils.BeastPowerComparator;
import solution.bestiary.utils.BeastType;

import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            boolean init = true;
            Beastmaster[] beastmasters = new Beastmaster[0];
            while (!sc.nextLine().equalsIgnoreCase("exit")) {
                if (init) {
                    System.out.println("How many players are playing?");
                    int players = sc.nextInt();
                    beastmasters = new Beastmaster[players];
                    for (int i = 0; i < beastmasters.length; i++) {
                        System.out.println("Player " + (i+1) + "'s name: ");
                        beastmasters[i] = new Beastmaster(sc.nextLine());
                    }
                    init = false;
                }
                for(Beastmaster p : beastmasters) {
                    String input = "";
                    do {
                        input = sc.nextLine();
                        switch (input) {
                            case "newBook" -> {
                                System.out.println("What type are you storing? (Oxlike, Birdlike, Wolflike, Fishlike, Antlike");
                                input = sc.nextLine();
                                switch (input.toLowerCase()) {
                                    case "oxlike" -> {
                                        p.pledgeBook(BeastType.Oxlike);
                                    }
                                    case "birdlike" -> {
                                        p.pledgeBook(BeastType.Birdlike);
                                    }
                                    case "wolflike" -> {
                                        p.pledgeBook(BeastType.Wolflike);
                                    }
                                    case "fishlike" -> {
                                        p.pledgeBook(BeastType.Fishlike);
                                    }
                                    case "antlike" -> {
                                        p.pledgeBook(BeastType.Antlike);
                                    }
                                    default -> System.err.println("Invalid option, returning...");
                                }
                            }
                            case "battle" -> {


                            }
                            case "catch" -> {

                            }
                            case "setFree" -> {

                            }
                            case "info" -> {

                            }
                            case "makeSpeak" -> {

                            }
                            case "printBook" -> {
                                System.out.println(p.getMyBook());
                            }
                            case "sortABC" -> {
                                p.getMyBook().sort(new BeastNameComparator());
                            }
                            case "sortPL" -> {
                                p.getMyBook().sort(new BeastPowerComparator());

                            }
                        }
                    }
                    while(!Objects.equals(input, "end"));

                }
            }
        }
    }
}
