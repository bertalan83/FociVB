package hu.progmatic.inheritance.model_inheritance;

public class Matches_Inheritance {

    private String stage;
    private String date;
    private String team_a;
    private String team_b;
    private int goals_a;
    private int goals_b;

    public Matches_Inheritance() {
    }

    public Matches_Inheritance(String stage, String date, String team_a, String team_b, int goals_a, int goals_b) {
        this.stage = stage;
        this.date = date;
        this.team_a = team_a;
        this.team_b = team_b;
        this.goals_a = goals_a;
        this.goals_b = goals_b;
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

}
