public class StateVotes extends Object {
    private String state;
    private String county;
    private String candidate;
    private String party;
    private String total_votes;
    private String won;



    public StateVotes(String state,String county,String candidate, String party, String total_votes, String won){
        this.state = state;
        this.county = county;
        this.candidate = candidate;
        this.party = party;
        this.total_votes = total_votes;
        this.won = won;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public Integer getTotal_votes() {
        return Integer.parseInt(total_votes);
    }

    public void setTotal_votes(String total_votes) {
        this.total_votes = total_votes;
    }


}
