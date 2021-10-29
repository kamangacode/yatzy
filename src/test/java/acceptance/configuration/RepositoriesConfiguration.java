package acceptance.configuration;

import acceptance.adapter.InMemoryPlayerRepository;
import fr.muludiki.yatzy.domain.repositories.PlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoriesConfiguration {

    @Bean
    @Scope("cucumber-glue")
    public PlayerRepository playerRepository() {
        return new InMemoryPlayerRepository();
    }

}
