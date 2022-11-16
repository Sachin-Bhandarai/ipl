import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static String pathOfMatchFile = "com iplFiles/matches.csv";
    static String pathOfDeliveryFile = "com iplFiles/deliveries.csv";

    public static final int DELIVERY_MATCH_ID = 0;
    public static final int DELIVERY_INNING = 1;
    public static final int DELIVERY_BATTING_TEAM = 2;
    public static final int DELIVERY_BOWLING_TEAM = 3;
    public static final int DELIVERY_OVER = 4;
    public static final int DELIVERY_BALL = 5;
    public static final int DELIVERY_BATSMAN = 6;
    public static final int DELIVERY_NON_STRIKER = 7;
    public static final int DELIVERY_BOWLER = 8;
    public static final int DELIVERY_IS_SUPER_OVER = 9;
    public static final int DELIVERY_WIDE_RUNS = 10;
    public static final int DELIVERY_BYE_RUNS = 11;
    public static final int DELIVERY_LEG_BYE_RUNS = 12;
    public static final int DELIVERY_NO_BALL_RUNS = 13;
    public static final int DELIVERY_PENALTY_RUNS = 14;
    public static final int DELIVERY_BATSMAN_RUNS = 15;
    public static final int DELIVERY_EXTRA_RUNS = 16;
    public static final int DELIVERY_TOTAL_RUNS = 17;
    public static final int DELIVERY_PLAYER_DISMISSED = 18;
    public static final int DELIVERY_DISMISSAL_KIND = 19;
    public static final int DELIVERY_FIELDER = 20;
    public static final int MATCH_ID = 0;
    public static final int MATCH_SEASON = 1;
    public static final int MATCH_CITY = 2;
    public static final int MATCH_DATE = 3;
    public static final int MATCH_TEAM1 = 4;
    public static final int MATCH_TEAM2 = 5;
    public static final int MATCH_TOSS_WINNER = 6;
    public static final int MATCH_TOSS_DECISION = 7;
    public static final int MATCH_RESULT = 8;
    public static final int MATCH_DL_APPLIED = 9;
    public static final int MATCH_WINNER = 10;
    public static final int MATCH_WIN_BY_RUNS = 11;
    public static final int MATCH_WIN_BY_WICKETS = 12;
    public static final int MATCH_PLAYER_OF_THE_MATCH = 13;
    public static final int MATCH_VENUE = 14;
    public static final int MATCH_UMPIRE1 = 15;
    public static final int MATCH_UMPIRE2 = 16;
    public static final int MATCH_UMPIRE3 = 17;

    private static List<Match> readMatchData(String filePath) {
        List<Match> matches = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(filePath));
            while (buffReader.ready()) {
                List<String> singleLineData = new ArrayList<>(Arrays.asList(buffReader.readLine().split(",")));
                Match match = new Match();
                match.setId(singleLineData.get(MATCH_ID));
                match.setSeason(singleLineData.get(MATCH_SEASON));
                match.setCity(singleLineData.get(MATCH_CITY));
                match.setDate(singleLineData.get(MATCH_DATE));
                match.setTeam1(singleLineData.get(MATCH_TEAM1));
                match.setTeam2(singleLineData.get(MATCH_TEAM2));
                match.setTossWinner(singleLineData.get(MATCH_TOSS_WINNER));
                match.setTossDecision(singleLineData.get(MATCH_TOSS_DECISION));
                match.setResult(singleLineData.get(MATCH_RESULT));
                match.setWinner(singleLineData.get(MATCH_WINNER));
                match.setDlApplied(singleLineData.get(MATCH_WIN_BY_RUNS));
                match.setWinByRuns(singleLineData.get(MATCH_WIN_BY_WICKETS));
                matches.add(match);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        matches.remove(0);
        return matches;
    }

    private static List<Delivery> readDeliveryData(String filePath) {
        List<Delivery> deliveries = new ArrayList<>();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(filePath));
            buffReader.readLine();

            while (buffReader.ready()) {
                List<String> singleLineData = new ArrayList<>(Arrays.asList(buffReader.readLine().split(",")));
                Delivery delivery = new Delivery();
                delivery.setBattingTeam((singleLineData.get(DELIVERY_BATTING_TEAM)));
                delivery.setBowlingTeam(singleLineData.get(DELIVERY_BOWLING_TEAM));
                delivery.setBatsMan(singleLineData.get(DELIVERY_BATSMAN));
                delivery.setNonStriker(singleLineData.get(DELIVERY_NON_STRIKER));
                delivery.setBowler(singleLineData.get(DELIVERY_BOWLER));
                try {
                    delivery.setDismissalKind(singleLineData.get(DELIVERY_DISMISSAL_KIND));
                    delivery.setPlayerDismissed(singleLineData.get(DELIVERY_PLAYER_DISMISSED));
                    delivery.setFielder(singleLineData.get(DELIVERY_FIELDER));
                } catch (IndexOutOfBoundsException e) {

                }
                try {

                    Integer matchId = Integer.parseInt(singleLineData.get(DELIVERY_MATCH_ID));
                    delivery.setMatchId(matchId);
                    Integer inning = Integer.parseInt(singleLineData.get(DELIVERY_INNING));
                    delivery.setInning(inning);
                    Integer wideRuns = Integer.parseInt(singleLineData.get(DELIVERY_WIDE_RUNS));
                    delivery.setWideRuns(wideRuns);
                    Integer byeRuns = Integer.parseInt(singleLineData.get(DELIVERY_BYE_RUNS));
                    delivery.setByeRuns(byeRuns);
                    Integer legByeRuns = Integer.parseInt(singleLineData.get(DELIVERY_LEG_BYE_RUNS));
                    delivery.setLegByeRuns(legByeRuns);
                    Integer noBallRuns = Integer.parseInt(singleLineData.get(DELIVERY_NO_BALL_RUNS));
                    delivery.setNoBallRuns(noBallRuns);
                    Integer penaltyRuns = Integer.parseInt(singleLineData.get(DELIVERY_PENALTY_RUNS));
                    delivery.setPenaltyRuns(penaltyRuns);
                    Integer batsmanRuns = Integer.parseInt(singleLineData.get(DELIVERY_BATSMAN_RUNS));
                    delivery.setBatsmanRuns(batsmanRuns);
                    Integer extraRuns = Integer.parseInt(singleLineData.get(DELIVERY_EXTRA_RUNS));
                    delivery.setExtraRuns(extraRuns);
                    Integer totalRuns = Integer.parseInt(singleLineData.get(DELIVERY_TOTAL_RUNS));
                    delivery.setTotalRuns(totalRuns);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                deliveries.add(delivery);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    private static void findNumberOfMatchesPlayedPerYear() {
        List<Match> matchData = readMatchData(pathOfMatchFile);

        Hashtable<String, Integer> mapOfMatch = new Hashtable<>();
        for (Match m : matchData) {
            if (mapOfMatch.containsKey(m.getSeason())) {
                Integer value = mapOfMatch.get(m.getSeason());
                mapOfMatch.put(m.getSeason(), value + 1);
            } else {
                mapOfMatch.put(m.getSeason(), 1);
            }


        }
        System.out.println(mapOfMatch.toString());
    }

    private static void findTotalNumberOfMatchesWon() {
        Hashtable<String, Integer> mapOfData = new Hashtable<>();
        List<Match> matchData = readMatchData(pathOfMatchFile);
        for (Match m : matchData) {
            if (m.getResult().equals("normal")) {
                if (mapOfData.containsKey(m.getWinner())) {
                    Integer value = mapOfData.get(m.getWinner());
                    mapOfData.put(m.getWinner(), value + 1);
                } else {
                    mapOfData.put(m.getWinner(), 1);
                }
            }
        }

        System.out.println(mapOfData.toString());
    }

    private static void findExtraRunConcededPerTeamIn2016() {
        Hashtable<String, String> mapOfMatch = new Hashtable<>();
        Hashtable<String, Integer> mapOfDelivery = new Hashtable<>();
        List<Match> matchData = readMatchData("../ipl/matches.csv");
        List<Delivery> deliveryData = readDeliveryData(pathOfDeliveryFile);
        for (Match m : matchData) {
            if (m.getSeason().equals("2016")) {
                mapOfMatch.put(m.getId(), m.getSeason());
            }
        }
        String matchId = "";
        for (Delivery d : deliveryData) {
            try {
                matchId = d.getMatchId().toString();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (mapOfMatch.get(matchId) == null) {
                continue;
            }
            if (mapOfDelivery.containsKey(d.getBowlingTeam())) {
                Integer runsToAdd = mapOfDelivery.get(d.getBowlingTeam());
                mapOfDelivery.put(d.getBowlingTeam(), runsToAdd + d.getExtraRuns());
            } else {
                mapOfDelivery.put(d.getBowlingTeam(), d.getExtraRuns());

            }
        }
        System.out.println(mapOfDelivery.toString());
    }

    private static void findMostEconomicalBowlerIn2015() {
        Hashtable<String, Integer> bowlerAndRuns = new Hashtable<>();
        Hashtable<String, Integer> bowlerAndBowls = new Hashtable<>();
        List<Match> matchData = readMatchData(pathOfMatchFile);
        List<Delivery> deliveryData = readDeliveryData(pathOfDeliveryFile);
        Hashtable<String, Integer> isAvailable = new Hashtable<>();
        for (Match m : matchData) {
            if (m.getSeason().equals("2015")) {
                try {
                    Integer season = Integer.parseInt(m.getSeason());
                    isAvailable.put(m.getId(), season);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Delivery d : deliveryData) {
            if (isAvailable.get(d.getMatchId().toString()) != null) {

                int ballsToAdd = 0;
                if (d.getWideRuns() + d.getNoBallRuns() == 0) {
                    ballsToAdd = 1;
                }
                String bowler=d.getBowler();
                Integer ballsTillNow = bowlerAndBowls.get(d.getBowler());
                if(ballsTillNow==null) ballsTillNow=0;
                bowlerAndBowls.put(bowler,bowlerAndBowls.getOrDefault(bowler,ballsTillNow)+ballsToAdd);
                Integer totalRuns = d.getBatsmanRuns() + d.getWideRuns() + d.getNoBallRuns();
                if(totalRuns==null){
                    totalRuns=0;
                }
                Integer wideRuns=d.getWideRuns();
                Integer noBallRuns=d.getNoBallRuns();
                Integer batsmanRuns=d.getBatsmanRuns();
                Integer runsTillNow = bowlerAndRuns.get(bowler);
                if(runsTillNow==null) runsTillNow=0;

                bowlerAndRuns.put(bowler,bowlerAndRuns.getOrDefault(bowler,runsTillNow)+totalRuns);
                /*if (bowlerAndRuns.containsKey(bowler)) {
                    Integer runsTillNow = bowlerAndRuns.get(bowler);
                    bowlerAndRuns.put(bowler, runsTillNow + batsmanRuns + wideRuns + noBallRuns);
                } else {
                    bowlerAndRuns.put(bowler, totalRuns);
                }*/
            }
        }
        double leastEconomy = Double.MAX_VALUE;
        String economicBowlerName = null;
        double economy = 0d;
        for (String bowler : bowlerAndRuns.keySet()) {
            Integer balls = bowlerAndBowls.get(bowler);
            Integer runs = bowlerAndRuns.get(bowler);
            economy = (runs * 6d / balls);
            if (economy < leastEconomy) {
                economicBowlerName = bowler;
                leastEconomy = economy;
            }
        }
        System.out.println("Least economy bowler -- " + economicBowlerName + "with the economy of " + leastEconomy);
    }

    private static void findMostCatchTaker() {
        Hashtable<String, Integer> mostCatches = new Hashtable<>();
        List<Delivery> deliveryData = readDeliveryData(pathOfDeliveryFile);
        for (Delivery delivery : deliveryData) {
            if (delivery.isCaught()) {
                String fielder = delivery.getFielder();
                mostCatches.put(fielder,mostCatches.getOrDefault(fielder,0)+1);
            }
        }
        Integer mostNoOfCatches = Integer.MIN_VALUE;
        String mostCatchTaker = null;
        for (String fielderName : mostCatches.keySet()) {
            if (mostCatches.get(fielderName) > mostNoOfCatches) {
                mostNoOfCatches = mostCatches.get(fielderName);
                mostCatchTaker = fielderName;
            }
        }
        System.out.println( "most number of catch in all seasons are " + mostNoOfCatches + " by " + mostCatchTaker);
    }


    public static void main(String[] args) {

        System.out.println("*********************************");
        System.out.println("NUMBER OF MATCHES PLAYED PER YEAR");
        findNumberOfMatchesPlayedPerYear();
        System.out.println("*********************************");
        System.out.println("TOTAL NUMBER OF MATCHES WON IN ALL SEASONS");
        findTotalNumberOfMatchesWon();
        System.out.println("*********************************");
        System.out.println("EXTRA RUNS CONCEDED BY EACH TEAM IN 2016 SEASON");
        findExtraRunConcededPerTeamIn2016();
        System.out.println("*********************************");
        System.out.println("MOST ECONOMICAL BOWLER IN 2015 SEASON");
        findMostEconomicalBowlerIn2015();
        System.out.println("*********************************");
        System.out.println("MOST CATCHES BY A PLAYER IN OVERALL SEASONS");
       findMostCatchTaker();
    }
}

