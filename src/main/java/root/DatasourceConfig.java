package root;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/comment_section_2")
                .username("root")
                .password("")
                .build();
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
//        properties.setLocation(new FileSystemResource("applications.properties"));
//        properties.setIgnoreResourceNotFound(false);
//        log.info("Props : " + properties);
//        return properties;
//    }
}
