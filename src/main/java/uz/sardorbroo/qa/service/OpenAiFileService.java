package uz.sardorbroo.qa.service;

import uz.sardorbroo.qa.dto.OpenAiFileResponse;

import java.io.File;
import java.util.Optional;

public interface OpenAiFileService {

    Optional<OpenAiFileResponse> upload(File file);

}
