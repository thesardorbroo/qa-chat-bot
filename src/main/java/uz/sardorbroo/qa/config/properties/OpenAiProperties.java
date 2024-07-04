package uz.sardorbroo.qa.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import uz.sardorbroo.qa.utils.StringMaskUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "open-ai")
public class OpenAiProperties {

    private String key;

    private String host;

    @Override
    public String toString() {
        return String.format("OpenAiProperties{" +
                "key=" + StringMaskUtils.mask(key) +
                "host=" + host +
                "}");
    }
}
