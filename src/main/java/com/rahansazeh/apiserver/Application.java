package com.rahansazeh.apiserver;

import com.mongodb.MongoClient;
import com.rahansazeh.apiserver.model.*;
import com.rahansazeh.apiserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedMethods("GET", "POST", "DELETE");
            }
        };
    }

    /*
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }
    */

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectLineRepository projectLineRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    private static class LogFilter extends CommonsRequestLoggingFilter {

    }

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
                = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /**
        if (userRepository.count() < 1) {
            userRepository.save(new User("0010220887"));
        }

        if (vehicleTypeRepository.count() < 1) {
            vehicleTypeRepository.save(new VehicleType( "ون"));
            vehicleTypeRepository.save(new VehicleType("پژو (۴۰۵-روآ-آردی)"));
            vehicleTypeRepository.save(new VehicleType("سمند"));
            vehicleTypeRepository.save(new VehicleType("پیکان"));
            vehicleTypeRepository.save(new VehicleType("سایر"));
        }

        if (projectRepository.count() < 1 || projectLineRepository.count() < 1) {
            projectRepository.deleteAll();
            projectLineRepository.deleteAll();


            ProjectLine line = projectLineRepository.save(new ProjectLine(
                    "293", "میدان فاطمی", "پایانه سازمان آب"));

            Project project = projectRepository.save(new Project("ساماندهی سامانه تاکسی‌رانی تهران"));
            project.addLine(line);
            projectRepository.save(project);
        }

        if (vehicleRepository.count() < 1) {
            VehicleType vehicleType = vehicleTypeRepository.findAll().get(0);

            Vehicle v = vehicleRepository.save(new Vehicle(
                23, 'ت', 764,
                10));
            v.setVehicleType(vehicleType);
            vehicleRepository.save(v);

            v = vehicleRepository.save(new Vehicle(
                46, 'ت', 234,
                10));
            v.setVehicleType(vehicleType);
            vehicleRepository.save(v);

            v = vehicleRepository.save(new Vehicle(
                80, 'ت', 912,
                10));
            v.setVehicleType(vehicleType);
            vehicleRepository.save(v);
        }**/
    }
}
