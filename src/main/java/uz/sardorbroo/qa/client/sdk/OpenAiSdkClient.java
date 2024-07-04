package uz.sardorbroo.qa.client.sdk;

import org.devlive.sdk.openai.entity.FileEntity;
import org.devlive.sdk.openai.response.CompleteResponse;
import uz.sardorbroo.qa.OpenAiClient;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface OpenAiSdkClient extends OpenAiClient {

    Optional<FileEntity> upload(File file);

    List<FileEntity> getAll();

    Optional<CompleteResponse> sendText(String text, String instruction);
}
