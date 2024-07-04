package uz.sardorbroo.qa.service;

import java.util.Optional;

public interface OpenAiTextService {

    Optional<String> answer(String question);

    Optional<String> answer(String question, String instruction);

}
