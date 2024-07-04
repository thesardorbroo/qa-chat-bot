package uz.sardorbroo.qa;

import org.devlive.sdk.openai.entity.FileEntity;
import org.devlive.sdk.openai.response.CompleteResponse;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface OpenAiClient {

    Optional<FileEntity> upload(File file);

    List<FileEntity> getAll();

    Optional<CompleteResponse> sendText(String text, String instruction);

    default Optional<CompleteResponse> sendText(String text) {
        return sendText(text, null);
    }
}
