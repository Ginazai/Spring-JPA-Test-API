package com.dashboard.Config;

import javax.annotation.PreDestroy;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSourceManager {

    private final HikariDataSource dataSource;

    public DataSourceManager(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PreDestroy
    public void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}

