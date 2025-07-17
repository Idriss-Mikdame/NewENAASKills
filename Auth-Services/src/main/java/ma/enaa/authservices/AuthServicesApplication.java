package ma.enaa.authservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServicesApplication.class, args);
    }

}
