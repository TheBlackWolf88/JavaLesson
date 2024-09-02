package solution.bestiary;

import solution.bestiary.beast.*;
import solution.bestiary.utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String input = "";
        //you shouldn't do a 100 line try, with multiple catches
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            boolean init = true;
            Beastmaster[] beastmasters = new Beastmaster[0];
            System.out.println("Welcome!");
            do {
                while (init) {
                    try {

                        System.out.println("How many players are playing?");
                        int players = Integer.parseInt(br.readLine());
                        beastmasters = new Beastmaster[players];
                    for (int i = 0; i < beastmasters.length; ) {
                        String name;
                        do {
                            System.out.println("Player " + (i+1) + "'s name: ");
                            name = br.readLine();
                            Beastmaster b = new Beastmaster(name);
                            if (!Arrays.stream(beastmasters).toList().contains(b)) {
                                beastmasters[i] = b;
                                i++;
                            }
                        } while (name.isEmpty());
                    }

                        System.out.println("Init finished");
                        init = false;
                    } catch (NumberFormatException e) {
                        System.err.println("Wrong number format!");
                    }
                }
                for(Beastmaster p : beastmasters) {
                    System.out.println("Round: " + p);
                    do {
                        input = br.readLine();
                        switch (input) {
                            case "newBook" -> {
                                p.newBook();
                                System.out.println("Acquired a new bestiary");
                            }
                            case "battle" -> {
                                System.out.println("Who do you want to battle? (1.." + beastmasters.length + ")");
                                input = br.readLine();
                                try {
                                    Beastmaster e = beastmasters[Integer.parseInt(input)-1];
                                    if (p == e) {
                                        System.err.println("You can't fight yourself!");
                                    } else {
                                        Beastmaster w = p.battle(beastmasters[Integer.parseInt(input)-1]);
                                        System.out.println(w + " has won!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("Wrong number format!");
                                }

                            }
                            case "catch" -> {

                                try {
                                    System.out.println("What type is your catch?");
                                    String type = br.readLine();
                                    System.out.println("What is its name?");
                                    String name = br.readLine();
                                    System.out.println("What color is it?");
                                    String color = br.readLine();
                                    System.out.println("What is its power level?");
                                    double pl = Double.parseDouble(br.readLine());
                                    System.out.println("What size? (1-5)");
                                    int size = Integer.parseInt(br.readLine());
                                    System.out.println("What does it say?");
                                    String cry = br.readLine();
                                    switch (type.toLowerCase()) {
                                        case "oxlike" -> {
                                            p.getMyBook().add(new Oxlike(name, color, pl, Size.sizes[size-1], cry));
                                        }
                                        case "birdlike" -> {
                                            p.getMyBook().add(new Birdlike(name, color, pl, Size.sizes[size-1], cry));
                                        }
                                        case "wolflike" -> {
                                            p.getMyBook().add(new Wolflike(name, color, pl, Size.sizes[size-1], cry));
                                        }
                                        case "fishlike" -> {
                                            p.getMyBook().add(new Fishlike(name, color, pl, Size.sizes[size-1], cry));
                                        }
                                        case "antlike" -> {
                                            p.getMyBook().add(new Antlike(name, color, pl, Size.sizes[size-1], cry));
                                        }
                                    }
                                    System.out.println("Succesfull catch");
                                } catch (NoBookException | DuplicateNameException e ) {
                                    System.err.println(e.getMessage());
                                }
                                catch (NumberFormatException e) {
                                    System.err.println("Wrong number format!");
                                }


                            }
                            case "setFree" -> {

                                System.out.println("Who do you want to set free?");
                                input = br.readLine();
                                try{
                                    p.getMyBook().rem(input);
                                    System.out.println("Succesfull remove");
                                } catch (NoBookException | NoBeastFoundException e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                            case "info" -> {
                                System.out.println("Who do you want to inspect?");
                                input = br.readLine();
                                try {
                                    Beast b = p.getMyBook().get(input);
                                    System.out.println(b);
                                } catch (NoBookException | NoBeastFoundException e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                            case "makeSpeak" -> {
                                System.out.println("Who do you want speaking?");
                                input = br.readLine();
                                try {
                                    Beast b = p.getMyBook().get(input);
                                    b.speak();
                                }
                                catch (NoBookException | NoBeastFoundException e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                            case "printBook" -> {
                                try {
                                    System.out.println(p.getMyBook());
                                } catch (NoBookException e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                            case "sortABC" -> {
                                try {
                                    p.getMyBook().sort(new BeastNameComparator());
                                    System.out.println("Sorted");
                                } catch (NoBookException e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                            case "sortPL" -> {
                                try {
                                    p.getMyBook().sort(new BeastPowerComparator());
                                    System.out.println("Sorted");
                                } catch (NoBookException e) {
                                    System.err.println(e.getMessage());
                                }

                            }

                            case "help" -> {
                                System.out.println("=============");
                                System.out.println("  HELP");
                                System.out.println("=============");
                                System.out.println("newBook - Use it to give the player a new, empty book");
                                System.out.println("catch - Use it to generate a new beast for your bestiary");
                                System.out.println("setFree - Use it to release a beast from your bestiary");
                                System.out.println("battle - Use it to battle another player");
                                System.out.println("makeSpeak - Use it to make one of your beast speak");
                                System.out.println("info - Use it to inspect your beast");
                                System.out.println("sortABC - Use it to sort your bestiary alphabetically");
                                System.out.println("sortPL - Use it to sort your bestiary by power level");
                                System.out.println("printBook - Use it to print your bestiary");
                                System.out.println("end - Use it to end your turn");
                                System.out.println("exit - Use it to exit the program");
                            }

                            case "exit" -> {
                                System.out.println("Exited, goodbye!");
                                //0 means it was a graceful exit
                                System.exit(0);
                            }
                            case "end" -> {}

                            default -> System.out.println("To get information about commands type \"help\"");
                        }
                    }
                    while(!Objects.equals(input, "end"));
                }
            } while (true);
            //mental note here: to catch multiple exceptions you only need one variable (only one 'e')
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
