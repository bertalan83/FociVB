package hu.progmatic.inheritance;

import hu.progmatic.inheritance.model_inheritance.Matches_Inheritance;
import hu.progmatic.inheritance.model_inheritance.Matches_Inheritance_WithPenalties;

import java.io.*;
import java.util.*;

public class Main_Inheritance {
    public static void main(String[] args) {


        try {

            List<Matches_Inheritance> wc2010 = new ArrayList<>();
            List<Matches_Inheritance> wc2014 = new ArrayList<>();
            List<Matches_Inheritance> wc2018 = new ArrayList<>();
            List<Matches_Inheritance_WithPenalties> wcAll = new ArrayList<>();


            try (BufferedReader reader =
                         new BufferedReader
                                 (new FileReader("files/matches_2010.csv"))) {
                String line1;
                reader.readLine();
                while ((line1 = reader.readLine()) != null) {
                    String[] parts = line1.split(";");

                    if (parts.length <= 7) {
                        Matches_Inheritance_WithPenalties matches = new Matches_Inheritance_WithPenalties(parts[0], parts[1], parts[2],
                                parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                        wc2010.add(matches);
                        wcAll.add(matches);
                    } else {
                        Matches_Inheritance_WithPenalties matches = new Matches_Inheritance_WithPenalties(parts[0], parts[1], parts[2],
                                parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                Integer.parseInt(parts[7]));
                        wc2010.add(matches);
                        wcAll.add(matches);
                    }
                }
            }

            try (BufferedReader reader =
                         new BufferedReader
                                 (new FileReader("files/matches_2014.csv"))) {
                String line1;
                reader.readLine();
                while ((line1 = reader.readLine()) != null) {
                    String[] parts = line1.split(";");

                    if (parts.length <= 7) {
                        Matches_Inheritance_WithPenalties matches = new Matches_Inheritance_WithPenalties(parts[0], parts[1], parts[2],
                                parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                        wc2014.add(matches);
                        wcAll.add(matches);
                    } else {
                        Matches_Inheritance_WithPenalties matches = new Matches_Inheritance_WithPenalties(parts[0], parts[1], parts[2],
                                parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                Integer.parseInt(parts[7]));
                        wc2014.add(matches);
                        wcAll.add(matches);
                    }
                }
            }

            try (BufferedReader reader =
                         new BufferedReader
                                 (new FileReader("files/matches_2018.csv"))) {
                String line1;
                reader.readLine();
                while ((line1 = reader.readLine()) != null) {
                    String[] parts = line1.split(";");

                    if (parts.length <= 7) {
                        Matches_Inheritance_WithPenalties matches = new Matches_Inheritance_WithPenalties(parts[0], parts[1], parts[2],
                                parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                        wc2018.add(matches);
                        wcAll.add(matches);
                    } else {
                        Matches_Inheritance_WithPenalties matches = new Matches_Inheritance_WithPenalties(parts[0], parts[1], parts[2],
                                parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                Integer.parseInt(parts[7]));
                        wc2018.add(matches);
                        wcAll.add(matches);
                    }
                }
            }

            System.out.println("Number of matches: " + wcAll.size());

            Scanner scanner = new Scanner(System.in);

            System.out.println("Year of worldcup:");
            String year = scanner.nextLine();

            List<Matches_Inheritance_WithPenalties> selectedMatches = new ArrayList<>();

            try (PrintWriter writer
                         = new PrintWriter
                    (new BufferedWriter
                            (new FileWriter("selected_inheritance.csv")))) {

                writer.println("stage;date;team_a;team_b;goals_a;goals_b;penalties_a;penalties_b");
                for (Matches_Inheritance_WithPenalties sthing : wcAll) {
                    if (sthing.getDate().startsWith(year)
                        && sthing.getPenalties_a()- sthing.getPenalties_b() == 0) {
                        writer.print(sthing.getStage());
                        writer.print(";");
                        writer.print(sthing.getDate());
                        writer.print(";");
                        writer.print(sthing.getTeam_a());
                        writer.print(";");
                        writer.print(sthing.getTeam_b());
                        writer.print(";");
                        writer.print(sthing.getGoals_a());
                        writer.print(";");
                        writer.print(sthing.getGoals_b());
                        writer.print(";");
                        writer.println();
                        selectedMatches.add(sthing);
                    } else if (sthing.getDate().startsWith(year)
                            && sthing.getPenalties_a()- sthing.getPenalties_b() != 0) {
                        writer.print(sthing.getStage());
                        writer.print(";");
                        writer.print(sthing.getDate());
                        writer.print(";");
                        writer.print(sthing.getTeam_a());
                        writer.print(";");
                        writer.print(sthing.getTeam_b());
                        writer.print(";");
                        writer.print(sthing.getGoals_a());
                        writer.print(";");
                        writer.print(sthing.getGoals_b());
                        writer.print(";");
                        writer.print(sthing.getPenalties_a());
                        writer.print(";");
                        writer.print(sthing.getPenalties_b());
                        writer.print(";");
                        writer.println();
                        selectedMatches.add(sthing);
                    }
                }
            }


            // 2. feladat

            int maxDiff = Integer.MIN_VALUE;

            for (Matches_Inheritance_WithPenalties difference : selectedMatches) {
                int differenceAbs = Math.abs(difference.getGoals_a() - difference.getGoals_b());
                if (differenceAbs > maxDiff) {
                    maxDiff = differenceAbs;
                }
            }

            System.out.println("2. Maximum goal difference: " + maxDiff);



            // 3. feladat

            int counter = 0;

            for (Matches_Inheritance_WithPenalties bet : selectedMatches) {
                if (bet.getGoals_a() > bet.getGoals_b()) {
                    counter++;
                } else if (bet.getPenalties_a() > bet.getPenalties_b()) {
                    counter++;
                }
            }

            System.out.println("3. The player has won " + counter + " bets." );



            // 4. feladat

            Map<String, Integer> goals = new LinkedHashMap<>();

            System.out.println("4. Total goals by stage:");

            for (Matches_Inheritance_WithPenalties sthing : selectedMatches) {
                goals.put(sthing.getStage(), goals.getOrDefault(sthing.getStage(),0) + (sthing.getGoals_b() + sthing.getGoals_a()));
            }

            for (String sthing : goals.keySet()) {
                System.out.println(sthing + ": " + goals.get(sthing));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
