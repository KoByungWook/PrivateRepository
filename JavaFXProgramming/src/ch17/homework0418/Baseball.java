package ch17.homework0418;

public class Baseball {
    private String teamName;
    private int rank;
    
    public Baseball() {
        
    }

    public Baseball(String teamName, int rank) {
        this.teamName = teamName;
        this.rank = rank;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    
}
