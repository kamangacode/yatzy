package acceptance.configuration;

import acceptance.adapter.InMemoryContext;
import fr.muludiki.yatzy.domain.context.PlayerContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextPlayerConfiguration {

    @Bean
    @Scope("cucumber-glue")
    public PlayerContext playerContext() {
        return new InMemoryContext();
    }
}
