package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Company;
import bo.ucb.edu.ingsoft.modelo.Driver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDao {

    public void updateCompanyDriver(Company company);
    Integer companyIdByDriver(Driver driver);
}
