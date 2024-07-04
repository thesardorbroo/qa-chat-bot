package uz.sardorbroo.qa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devlive.sdk.openai.entity.FileEntity;
import org.springframework.stereotype.Service;
import uz.sardorbroo.qa.OpenAiClient;
import uz.sardorbroo.qa.dto.OpenAiFileResponse;
import uz.sardorbroo.qa.service.OpenAiFileService;

import java.io.File;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiFileServiceImpl implements OpenAiFileService {

    private final OpenAiClient client;

    @Override
    public Optional<OpenAiFileResponse> upload(File file) {
        log.debug("Upload file to OpenAi");

        if (Objects.isNull(file) || file.length() == 0) {
            log.warn("Invalid argument is passed! Uploading file cannot be empty!");
            throw new IllegalArgumentException("Invalid argument is passed! Uploading file cannot be empty!");
        }

        Optional<OpenAiFileResponse> responseOptional = client.upload(file)
                .map(this::convert);

        log.debug("Is file uploaded successfully? {}", responseOptional.isPresent());
        return responseOptional;
    }

    private OpenAiFileResponse convert(FileEntity file) {

        return new OpenAiFileResponse()
                .setId(file.getId())
                .setBytes(Long.valueOf(file.getBytes()))
                .setFilename(file.getFilename())
                .setObject(file.getObject())
                .setPurpose(file.getPurpose())
                .setCreatedAt(file.getCreatedTime());
    }
}
