package repository;

import entity.DenialCategory;

import javax.sql.DataSource;
import java.util.List;

public interface DenialCategoryRepository {

    public void setDataSource(DataSource dataSource);

    void create(DenialCategory denialCategory);

    List<DenialCategory> selectOne(int id);

    List<DenialCategory> selectAll();

    void deleteAll();

    void delete(int id);
}
