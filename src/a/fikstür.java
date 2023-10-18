package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



class Team {
    String name;
    List<String> players;
    int points;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(String player) {
        if (players.size() < 110) {
            players.add(player);
        } else {
            System.out.println("Takım " + name + " maksimum oyuncu sayısına ulaştı.");
        }
    }
    public void displayPlayers() {
        System.out.println(name + " Oyuncuları:");
        for (String player : players) {
            System.out.println(player);
        }
    }
}



class Match {
    Team team1;
    Team team2;
    int result; 
    int scoreTeam1;
    int scoreTeam2;
    
    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Match(Team team1, Team team2, int result, int scoreTeam1, int scoreTeam2) {
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }
}


public class fikstür{
	
	
	
        
    public static void main(String[] args) {
    	List<String> takımlar = new ArrayList<>();
        takımlar.add ("Takım1");
        takımlar.add ("Takım2");
        takımlar.add ("Takım3");
        takımlar.add ("Takım4");
        takımlar.add ("takım5");
        takımlar.add ("takım6");
        takımlar.add ("takım7");
        takımlar.add ("takım8");
        takımlar.add ("takım9");
        takımlar.add ("takım10");
        
        List<String> allPlayers = new ArrayList<>();
        for (int playerNumber = 1; playerNumber <= 110; playerNumber++) {
            allPlayers.add("Oyuncu " + playerNumber);
        }
        Collections.shuffle(allPlayers);
        Map<String, List<String>> teamPlayersMap = new HashMap<>();
        

        for (String team : takımlar) {
            List<String> players = new ArrayList<>();
            for (int i = 0; i < 11; i++) {
                players.add(allPlayers.remove(0)); // Oyuncuları diğer takımlara geçmeden ata
            }
            teamPlayersMap.put(team, players);
        }
        
        
        List<String> formations = new ArrayList<>();
        formations.add("4-3-3");
        formations.add("4-5-1");
        formations.add("4-4-2");
        formations.add("3-2-5");
        formations.add("3-3-4");
        formations.add("3-4-3");
        formations.add("3-5-2");
        formations.add("4-2-4");
        formations.add("5-2-3");
        formations.add("5-3-2");
        formations.add("5-4-1");
        formations.add("6-3-1");
        Collections.shuffle(formations);

        Map<String, String> teamFormationMap = new HashMap<>();
        Map<String, Map<String, String>> teamPlayerPositionMap = new HashMap<>();

        for (int i = 0; i < takımlar.size(); i++) {
        	String team = takımlar.get(i);
        	String formation = formations.get(i);
            teamFormationMap.put(team, formation);

            
            Map<String, String> playerPositions = new HashMap<>();
            String[] positions = formation.split("-");
            int defenders = Integer.parseInt(positions[0]);
            int midfielders = Integer.parseInt(positions[1]);
            int forwards = Integer.parseInt(positions[2]);
            for (int j = 1; j <= defenders; j++) {
                playerPositions.put("Oyuncu " + j, "Defans");
            }
            for (int j = defenders + 1; j <= defenders + midfielders; j++) {
                playerPositions.put("Oyuncu " + j, "Orta Saha");
            }
            for (int j = defenders + midfielders + 1; j <= defenders + midfielders + forwards; j++) {
                playerPositions.put("Oyuncu " + j, "Forvet");
            }
            teamPlayerPositionMap.put(team, playerPositions);
        }

        List<Team> teams = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            teams.add(new Team("Takım" + i));
        }

        int totalTeams = teams.size();
        int totalMatches = (totalTeams - 1) * 2;
        int matchesPerWeek = totalTeams / 2;
        
        List<List<Match>> fixture = new ArrayList<>();
        for (int i = 0; i < totalMatches; i++) {
            fixture.add(new ArrayList<>());
        }
        
        
       //Map<String, List<String>> teamPlayersMap = new HashMap<>();
        //Random random = new Random();
        //for (String takim : takımlar) {
          //  List<String> players = new ArrayList<>();
            //for (int playerNumber = 1; playerNumber <= 110; playerNumber++) {
              //  players.add("Oyuncu " + playerNumber);
                
          //  }
           // Collections.shuffle(players);
            //teamPlayersMap.put(takim, players);
        //}
        int numberOfTeams = takımlar.size();
        int numberOfWeeks = numberOfTeams - 1;

        Collections.shuffle(takımlar);// Takımları karıştır
        
        System.out.println("Futbol Fiksturu");
        Map<String, Integer> puanlar = new HashMap<>();

        for (String takim : takımlar) {
            puanlar.put(takim, 0);
        }
        List<Match> matches = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
        	System.out.println("\n");
            System.out.println("1. Maçları oynat");
            System.out.println("2. Puan Durumu");
            System.out.println("3. oyuncuları gör");
            System.out.println("4. takımların formasyonlarını gör");
            System.out.println("5. Exit");
            System.out.print("\nBir Seçim Yapınız: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	

                	for (int week = 1; week < totalTeams - 1; week++) {
                        System.out.println("Hafta " +(week + 1) + " Fikstürü: ");
                        List<Team> weekTeams = new ArrayList<>(teams);

                        Collections.shuffle(teams); // random şekilde karıştırıyor takımları

                        for (int match = 0; match < matchesPerWeek; match++) {
                            Team evsahibi =weekTeams.get(match);
                            Team misafir = weekTeams.get(totalTeams - 1 - match);
                            fixture.get(week).add(new Match(evsahibi, misafir));

                            // maç sonuçlarını simüle ediyoruz(berabere/galibiyet/mağlubiyet)
                            int result = (int) (Math.random() * 3); // 0:berabere  1:evsahibi galibiyet 2: misafir galibiyet
                            int scoreTeam1 = (result == 0) ? (int) (Math.random() * 5) : (int) (Math.random() * 5) + 1;
                            int scoreTeam2 = (result == 0) ? (int) (Math.random() * 5) : (int) (Math.random() * 5) + 1;

                           

                            System.out.println("\n"+ evsahibi.name + " vs " + misafir.name + "-> " + scoreTeam1 + " - " + scoreTeam2);
                            if (result == 0) {
                                System.out.println("berabere");
                                evsahibi.points += 1;
                                misafir.points += 1;
                            } else if (result == 1) {
                                System.out.println(evsahibi.name + " galibiyet");
                                evsahibi.points += 3;
                            } else {
                                System.out.println(misafir.name + " galibiyet");
                                misafir.points += 3;
                            }
                        }
                        Collections.rotate(weekTeams.subList(1, totalTeams - 1), 1);
                        System.out.println();
                    }

                    
                
                
            
                    break;
                case 2:
                	System.out.println("Final Sonuçları: ");
                    teams.sort((t1, t2) -> Integer.compare(t2.points, t1.points)); // puanları düzenleme

                    for (int i = 0; i < teams.size(); i++) {
                        Team team = teams.get(i);
                        System.out.println((i + 1) + ". " + team.name + " - " + team.points + " puan");
                    }
                    break;
                case 3:
                	
                	System.out.println("\nOyuncular:");
                	for (int match = 0; match < numberOfTeams / 2; match++) {
                        String evsahibi = takımlar.get(match);
                        String misafir = takımlar.get(numberOfTeams - 1 - match);
                        
                        
                        System.out.println("\n" + evsahibi + ": " + teamPlayersMap.get(evsahibi));
                        System.out.println("\n");
                        System.out.println("\n" + misafir + ": " + teamPlayersMap.get(misafir));
                        System.out.println("\n");
                    }
                    Collections.rotate(takımlar.subList(1, numberOfTeams), 1);
                    System.out.println();
                    break;
                case 4:
                	System.out.println("Oyuncu Pozisyonları:");
                	
                	for (int week = 1; week <= totalTeams - 1; week++) {
                        System.out.println("Hafta " +( week + 1 ) + ":");
                        for (int match = 0; match < numberOfTeams / 2; match++) {
                            String evsahibi = takımlar.get(match);
                            String misafir = takımlar.get(numberOfTeams - 1 - match);
                            String formation1 = teamFormationMap.get(evsahibi);
                            String formation2 = teamFormationMap.get(misafir);
                            Map<String, String> evsahibiPlayerPositions = teamPlayerPositionMap.get(evsahibi);
                            Map<String, String> misafirPlayerPositions = teamPlayerPositionMap.get(misafir);
                           
                           
                           
                            System.out.println("\n" + evsahibi + " (" + formation1 + ") vs " + misafir + " (" + formation2 + ")");
                            System.out.println();
                            for (Map.Entry<String, String> entry : evsahibiPlayerPositions.entrySet()) {
                                String playerName = entry.getKey();
                                String playerPosition = entry.getValue();
                                System.out.println(playerName + " - " + playerPosition);
                                
                            }
                            System.out.println();
                            for (Map.Entry<String, String> entry : misafirPlayerPositions.entrySet()) {
                                String playerName = entry.getKey();
                                String playerPosition = entry.getValue();
                                System.out.println(playerName + " - " + playerPosition);
                            }

                        }
                        Collections.rotate(takımlar.subList(1, numberOfTeams), 1);
                        System.out.println();
                        
                    }
                	
                	break;
                case 5:
                	System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                	
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } 
    }

    public static void simulateMatches(List<String> takimlar, Map<String, Integer> puanlar) {
       
    }

    public static void displayPointsStandings(Map<String, Integer> puanlar) {
        
    }
   
}























