package hu.progmatic.model;

public class Matches {

    private Worldcups worldcup;
    private String stage;
    private String date;
    private String team_a;
    private String team_b;
    private int goals_a;
    private int goals_b;
    private int penalties_a;
    private int penalties_b;

    public Matches() {
    }

    public Matches(Worldcups worldcup, String stage, String date, String team_a, String team_b, int goals_a, int goals_b) {
        this.worldcup = worldcup;
        this.stage = stage;
        this.date = date;
        this.team_a = team_a;
        this.team_b = team_b;
        this.goals_a = goals_a;
        this.goals_b = goals_b;
    }

    public Matches(Worldcups worldcup, String stage, String date, String team_a, String team_b, int goals_a, int goals_b, int penalties_a, int penalties_b) {
        this.worldcup = worldcup;
        this.stage = stage;
        this.date = date;
        this.team_a = team_a;
        this.team_b = team_b;
        this.goals_a = goals_a;
        this.goals_b = goals_b;
        this.penalties_a = penalties_a;
        this.penalties_b = penalties_b;
    }

    public Worldcups getWorldcup() {
        return worldcup;
    }

    public void setWorldcup(Worldcups worldcup) {
        this.worldcup = worldcup;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeam_a() {
        return team_a;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public int getGoals_a() {
        return goals_a;
    }

    public void setGoals_a(int goals_a) {
        this.goals_a = goals_a;
    }

    public int getGoals_b() {
        return goals_b;
    }

    public void setGoals_b(int goals_b) {
        this.goals_b = goals_b;
    }

    public int getPenalties_a() {
        return penalties_a;
    }

    public void setPenalties_a(int penalties_a) {
        this.penalties_a = penalties_a;
    }

    public int getPenalties_b() {
        return penalties_b;
    }

    public void setPenalties_b(int penalties_b) {
        this.penalties_b = penalties_b;
    }
}
