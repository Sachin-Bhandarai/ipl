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



    public static void main(String[] args) {
        System.out.println("*********************************");
        System.out.println("NUMBER OF MATCHES PLAYED PER YEAR");



    }
    }

