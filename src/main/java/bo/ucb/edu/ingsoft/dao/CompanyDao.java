package bo.ucb.edu.ingsoft.dao;


import bo.ucb.edu.ingsoft.modelo.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDao {
    public Company findCompanyById(Integer companyId);
    public void createCompany(Company company);
}
