package bo.ucb.edu.ingsoft.dto;

public class CompanyRequest {
    private Integer companyId;
    private String name;

    public CompanyRequest() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyRequest{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                '}';
    }
}
