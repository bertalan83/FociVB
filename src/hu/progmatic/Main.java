package hu.progmatic;

import hu.progmatic.model.Matches;
import hu.progmatic.model.Worldcups;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        try {

            List<Worldcups> worldcupsList = new ArrayList<>();
            List<Matches> matchesList = new ArrayList<>();

            try (BufferedReader reader =
                    new BufferedReader
                            (new FileReader("files/worldcups.csv"))) {
                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    Worldcups worldcups = new Worldcups(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]);
                    worldcupsList.add(worldcups);
                }

                try (BufferedReader reader1 =
                             new BufferedReader
                                     (new FileReader("files/matches_all.csv"))) {
                    String line1;
                    reader1.readLine();
                    while ((line1 = reader1.readLine()) != null) {
                        String[] parts = line1.split(";");
                        Worldcups current = null;
                        for (Worldcups sthing : worldcupsList) {
                            if (Integer.parseInt(parts[0]) == sthing.getYear())
                                current = sthing;
                        }
                        if (parts.length <= 7) {
                            Matches matches = new Matches(current, parts[1], parts[2],
                                    parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
                            matchesList.add(matches);
                        } else {
                            Matches matches = new Matches(current, parts[1], parts[2],
                                    parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
                                    Integer.parseInt(parts[7]), Integer.parseInt(parts[8]));
                            matchesList.add(matches);
                        }
                    }
                }
            }

            System.out.println("Number of matches: " + matchesList.size());

            Scanner scanner = new Scanner(System.in);

            System.out.println("Name of the host:");
            String host = scanner.nextLine();

            List<Matches> selectedMatches = new ArrayList<>();

            try (PrintWriter writer
                    = new PrintWriter
                    (new BufferedWriter
                            (new FileWriter("selected.csv")))) {

                writer.println("stage;date;team_a;team_b;goals_a;goals_b;penalties_a;penalties_b");
                for (Matches sthing : matchesList) {
                    if (sthing.getWorldcup().getHost().equalsIgnoreCase(host)
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
                    } else if (sthing.getWorldcup().getHost().equalsIgnoreCase(host)
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

            for (Matches difference : selectedMatches) {
                int differenceAbs = Math.abs(difference.getGoals_a() - difference.getGoals_b());
                if (differenceAbs > maxDiff) {
                    maxDiff = differenceAbs;
                }
            }

            System.out.println("2. Maximum goal difference: " + maxDiff);


            // 3. feladat

            int counter = 0;

            for (Matches bet : selectedMatches) {
                if (bet.getGoals_a() > bet.getGoals_b()) {
                    counter++;
                }
            }

            System.out.println("3. The player has won " + counter + " bets." );


            // 4. feladat

            Map<String, Integer> goals = new LinkedHashMap<>();

            System.out.println("4. Total goals by stage:");

            for (Matches sthing : selectedMatches) {
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
