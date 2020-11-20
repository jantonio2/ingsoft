package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Score;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreDao {
    public Score findScoreById(Integer scoreId);
}
