package rest;

import entity.DenialCategory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repository.DenialCategoryRepository;
import repository.impl.DenialCategoryRepositoryImpl;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/denial_category")
public class DenialCategoryRest {

    @GET
    @Produces("application/json")
    public List<DenialCategory> getAllDenialCategories() {
        DenialCategoryRepository denialCategoryRepository = new DenialCategoryRepositoryImpl();
        denialCategoryRepository.setDataSource(dataSource());
        return denialCategoryRepository.selectAll();
    }

    private DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.ibm.db2.jcc.DB2Driver");
        dataSource.setUrl("jdbc:db2://10.9.0.3:50000/pam");
        dataSource.setUsername("pam121");
        dataSource.setPassword("pam121");
        return dataSource;
    }
}
