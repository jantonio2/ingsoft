package bo.ucb.edu.ingsoft.modelo;



public class Score {
    private Integer scoreId;
    private Integer vehicleId;
    private Integer userId;
    private Double score;
    private Integer status;
    private Transaction transaction;

    public Score() {
        transaction = new Transaction();
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
                ", userId=" + userId +
                ", score=" + score +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
