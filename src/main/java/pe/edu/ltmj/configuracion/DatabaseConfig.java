package pe.edu.ltmj.configuracion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setAutoCommit(false);
        config.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=encuestas;");
        config.setUsername("sa");
        config.setPassword("password$123");
        config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        config.setMaximumPoolSize(10);
        return new HikariDataSource(config);
    }
}
