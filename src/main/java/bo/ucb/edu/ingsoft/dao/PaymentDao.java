package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.Contact;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactDao {
    public Integer create(Payment payment);

    public Integer getLastInsertId();
}
