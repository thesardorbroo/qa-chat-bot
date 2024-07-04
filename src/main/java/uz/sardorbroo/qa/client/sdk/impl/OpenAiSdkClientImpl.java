package uz.sardorbroo.qa.client.sdk.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.devlive.sdk.openai.OpenAiClient;
import org.devlive.sdk.openai.entity.CompletionEntity;
import org.devlive.sdk.openai.entity.FileEntity;
import org.devlive.sdk.openai.model.CompletionModel;
import org.devlive.sdk.openai.response.CompleteResponse;
import org.devlive.sdk.openai.response.FileResponse;
import org.springframework.stereotype.Service;
import uz.sardorbroo.qa.client.sdk.OpenAiSdkClient;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiSdkClientImpl implements OpenAiSdkClient {

    private final OpenAiClient client;

    @Override
    public Optional<FileEntity> upload(File file) {
        log.debug("Upload file to OpenAi storage with SDK");

        if (Objects.isNull(file) || file.length() == 0) {
            log.warn("Invalid argument is passed! Uploading file cannot be empty!");
            throw new IllegalArgumentException("Invalid argument is passed! Uploading file cannot be empty!");
        }

        FileEntity entity = FileEntity.builder()
                .file(file)
                .build();

        entity = client.uploadFile(entity);
        log.debug("File is uploaded successfully. File: {}", entity.getFilename());
        return Optional.ofNullable(entity);
    }

    @Override
    public List<FileEntity> getAll() {
        log.debug("Get all uploaded files");

        FileResponse response = client.files();
        List<FileEntity> files = response.getFiles();

        log.debug("Uploaded files are fetched successfully. Files count: {}", files.size());
        return files;
    }

    @Override
    public Optional<CompleteResponse> sendText(String text, String instruction) {
        log.debug("Send text to chat with instructions. Text: {} | Instruction: {}", text, instruction);

        if (StringUtils.isBlank(text)) {
            log.warn("Invalid argument is passed! Text must not be blank!");
            throw new IllegalArgumentException("Invalid argument is passed! Text must not be blank!");
        }

        CompletionEntity configure = CompletionEntity.builder()
                .model(CompletionModel.TEXT_DAVINCI_003)
                .prompt(text)
                .temperature(2D)
                .build();

        CompleteResponse completeResponse = client.createCompletion(configure);
        return Optional.of(completeResponse);
    }
}
