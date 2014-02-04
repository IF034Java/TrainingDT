package jdbcTemplate;

import entity.DenialCategory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DenialCategoryResultExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        DenialCategory denialCategory = new DenialCategory();
        denialCategory.setId(resultSet.getInt(1));
        denialCategory.setCategoryCode(resultSet.getInt(2));
        denialCategory.setCategoryDescription(resultSet.getString(3));
        denialCategory.setClassCode(resultSet.getInt(4));
        denialCategory.setPriority(resultSet.getInt(5));
        return denialCategory;
    }
}
