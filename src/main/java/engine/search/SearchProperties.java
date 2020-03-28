package engine.search;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : LiuYong at 2020-03-28
 * @package: engine.search
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "search.config")
@Configuration
public class SearchProperties {

    private int timeOut = 300;
    private int aggTimeOut = 400;
}
