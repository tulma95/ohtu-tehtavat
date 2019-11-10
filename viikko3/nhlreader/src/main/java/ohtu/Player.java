
package ohtu;

public class Player {
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;
    private int points;

    public int getPoints() {
        return this.goals + this.assists;
    }
    
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + "\t team " + this.team + "\t goals " + this.goals + "\t assists " + this.assists;
    }
      
}
