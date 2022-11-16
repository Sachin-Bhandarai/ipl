import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
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
    //public static final int MATCH_PLAYER_OF_MATCH = MATCH_PLAYER_OF_THE_MATCH;
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
                delivery.setBattingTeam((singleLineData.get(2)));
                delivery.setBowlingTeam(singleLineData.get(3));
                delivery.setBatsMan(singleLineData.get(6));
                delivery.setNonStriker(singleLineData.get(7));
                delivery.setBowler(singleLineData.get(8));
                try {
                    delivery.setDismissalKind(singleLineData.get(19));
                    delivery.setPlayerDismissed(singleLineData.get(18));
                    delivery.setFielder(singleLineData.get(20));
                } catch (IndexOutOfBoundsException e) {

                }
                try {
                    Integer ball = Integer.parseInt(singleLineData.get(5));

                    delivery.setBall(ball);
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
    private static String getNumberOfMatchesPlayedPerYear() {
        List<Match> matchData = readMatchData("../ipl/matches.csv");
        Hashtable<String, Integer> mapOfMatch = new Hashtable<>();
        for (Match m : matchData) {
            if (mapOfMatch.containsKey(m.getSeason())) {
                Integer value = mapOfMatch.get(m.getSeason());
                mapOfMatch.put(m.getSeason(), value + 1);
            } else {
                mapOfMatch.put(m.getSeason(), 1);
            }


        }
        return mapOfMatch.toString();
    }
    private static String totalNumberOfMatchesWon() {
        Hashtable<String, Integer> mapOfData = new Hashtable<>();
        List<Match> matchData = readMatchData("../ipl/matches.csv");
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

        return mapOfData.toString();
    }
    private static String getExtraRunConcededPerTeamIn2016() {
        Hashtable<String, String> mapOfMatch = new Hashtable<>();
        Hashtable<String, Integer> mapOfDelivery = new Hashtable<>();
        List<Match> matchData = readMatchData("../ipl/matches.csv");
        List<Delivery> deliveryData = readDeliveryData("../ipl/deliveries.csv");
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
        return mapOfDelivery.toString();
    }
    private  static String getMostEconomicalBowlerIn2015() {
        Hashtable<String, Integer> runsGivenByBowler = new Hashtable<>();
        Hashtable<String, Integer> ballsBowledByBaller = new Hashtable<>();
        List<Match> matchData = readMatchData("../ipl/matches.csv");
        List<Delivery> deliveryData = readDeliveryData("../ipl/deliveries.csv");
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

                Integer ballsToAdd = 0;
                if (d.getWideRuns() + d.getNoBallRuns() == 0) {
                    ballsToAdd = 1;
                }
                if (ballsBowledByBaller.containsKey(d.getBowler())) {
                    Integer ballsTillNow = ballsBowledByBaller.get(d.getBowler());
                    ballsBowledByBaller.put(d.getBowler(), ballsToAdd + ballsTillNow);
                } else {
                    ballsBowledByBaller.put(d.getBowler(), ballsToAdd);
                }
                Integer totalRuns = d.getBatsmanRuns() + d.getWideRuns() + d.getNoBallRuns();
                if (runsGivenByBowler.containsKey(d.getBowler())) {
                    Integer runsTillNow = runsGivenByBowler.get(d.getBowler());
                    runsGivenByBowler.put(d.getBowler(), runsTillNow + d.getBatsmanRuns() + d.getWideRuns() + d.getNoBallRuns());
                } else {
                    runsGivenByBowler.put(d.getBowler(), totalRuns);
                }

            }


        }
        // System.out.println(isAvailable);
        Double leastEconomy = Double.MAX_VALUE;
        Double highestEconomy = Double.MIN_VALUE;
        String economicBowlerName = null;
        String expensiveBowlerName = null;
        Double economy = 0d;
        for (String bowler : runsGivenByBowler.keySet()) {
            Integer balls = ballsBowledByBaller.get(bowler);
            Integer runs = runsGivenByBowler.get(bowler);
            economy = (runs * 6d / balls);
            if (economy < leastEconomy) {
                economicBowlerName = bowler;
                leastEconomy = economy;
            }
            if (economy > highestEconomy) {
                expensiveBowlerName = bowler;
                highestEconomy = economy;
            }

        }
        return "Least economy bowler -- " + economicBowlerName + "with the economy of " + leastEconomy;
    }




    public static void main(String[] args) {
        System.out.println("*********************************");
        System.out.println("NUMBER OF MATCHES PLAYED PER YEAR");
        System.out.println(getNumberOfMatchesPlayedPerYear());
        System.out.println("*********************************");
        System.out.println("TOTAL NUMBER OF MATCHES WON IN ALL SEASONS");
        System.out.println(totalNumberOfMatchesWon());
        System.out.println("*********************************");
        System.out.println("EXTRA RUNS CONCEDED BY EACH TEAM IN 2016 SEASON");
        System.out.println(getExtraRunConcededPerTeamIn2016());
        System.out.println("*********************************");
        System.out.println("MOST ECONOMICAL BOWLER IN 2015 SEASON");
        System.out.println(getMostEconomicalBowlerIn2015());




    }
    }

