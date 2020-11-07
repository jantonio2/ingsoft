package bo.ucb.edu.ingsoft.modelo;

public class Score {
    private Integer scoreId;
    private Integer vehicleId;
    private Double score;
    private String status;
    private Transaction transaction;

    public Score(){
        transaction = new Transaction();
    }
    public Score(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", vehicleId=" + vehicleId +
                ", score=" + score +
                ", status='" + status + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
