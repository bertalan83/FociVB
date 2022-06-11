package hu.progmatic.inheritance.model_inheritance;

public class Matches_Inheritance_WithPenalties extends Matches_Inheritance {

    private int penalties_a;
    private int penalties_b;

    public Matches_Inheritance_WithPenalties() {
    }

    public Matches_Inheritance_WithPenalties(String stage, String date, String team_a, String team_b, int goals_a, int goals_b) {
        super(stage, date, team_a, team_b, goals_a, goals_b);
    }

    public Matches_Inheritance_WithPenalties(String stage, String date, String team_a, String team_b, int goals_a, int goals_b, int penalties_a, int penalties_b) {
        super(stage, date, team_a, team_b, goals_a, goals_b);
        this.penalties_a = penalties_a;
        this.penalties_b = penalties_b;
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
