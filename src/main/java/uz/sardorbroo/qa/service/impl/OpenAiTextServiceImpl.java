package uz.sardorbroo.qa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import uz.sardorbroo.qa.OpenAiClient;
import uz.sardorbroo.qa.service.OpenAiTextService;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiTextServiceImpl implements OpenAiTextService {

    private final OpenAiClient client;

    @Override
    public Optional<String> answer(String question) {
        log.debug("Answer to the question. Question: {}", question);

        if (StringUtils.isBlank(question)) {
            log.warn("Invalid argument is passed! Question must not be blank!");
            throw new IllegalArgumentException("Invalid argument is passed! Question must not be blank!");
        }

        return Optional.empty();
    }

    @Override
    public Optional<String> answer(String question, String instruction) {
        return Optional.empty();
    }
}
