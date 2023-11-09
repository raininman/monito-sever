package com.raininman.monito.petItem;


import com.raininman.monito.email.EmailRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PetItemConfig {
    @Bean
    CommandLineRunner commandLineRunner(PetItemRepository repository){
        return args -> {
            PetItem shiba = new PetItem(
                    "Shiba",
                    "Shiba desc",
                    "1 months",
                    "10.0",
                    "Male",
                    "Red",
                    "Small",
                    true,
                    true,
                    true,
                    true,
                    "Minsk",
                    LocalDate.now(),
                    "none",
                    List.of("img1", "img2")
            );
            PetItem shiba2 = new PetItem(
                    "Shiba2",
                    "Shiba desc",
                    "2 months",
                    "10.0",
                    "Male",
                    "Red",
                    "Small",
                    true,
                    true,
                    true,
                    true,
                    "Minsk",
                    LocalDate.now(),
                    "none",
                    List.of("img1", "img2")
            );
            repository.saveAll(
                    List.of(shiba, shiba2)
            );
        };
    }
}
