package repository.impl;

import entity.DenialCategory;
import jdbcTemplate.DenialCategoryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import repository.DenialCategoryRepository;

import javax.sql.DataSource;
import java.util.List;

@Component
public class DenialCategoryRepositoryImpl implements DenialCategoryRepository {

    private DataSource dataSource;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(DenialCategory denialCategory) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO DenialCategory (id, categoryCode, categoryDescription, classCode, priority)"
                + "VALUES(?,?,?,?,?)", new Object[] { denialCategory.getId(), denialCategory.getCategoryCode(),
                denialCategory.getCategoryDescription(), denialCategory.getClassCode(), denialCategory.getPriority() });
    }

    @Override
    public List<DenialCategory> selectOne(int id) {
        JdbcTemplate selectOne = new JdbcTemplate(dataSource);
        return selectOne.query("select id, categoryCode, categoryDescription, classCode, priority from DenialCategory where id = ?",
                new Object[]{id},
                new DenialCategoryRowMapper());
    }

    @Override
    public List<DenialCategory> selectAll() {
        JdbcTemplate selectAll = new JdbcTemplate(dataSource);
        return selectAll.query("select * from DenialCategory",
                new DenialCategoryRowMapper());
    }

    @Override
    public void deleteAll() {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from DenialCategory");
    }

    @Override
    public void delete(int id) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from DenialCategory where id = ?",
                new Object[] { id});
    }
}
