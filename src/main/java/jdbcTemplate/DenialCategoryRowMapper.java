package jdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DenialCategoryRowMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        DenialCategoryResultExtractor resultExtractor = new DenialCategoryResultExtractor();
        return resultExtractor.extractData(resultSet);
    }
}
