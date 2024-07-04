package uz.sardorbroo.qa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OpenAiFileResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("object")
    private String object;

    @JsonProperty("bytes")
    private Long bytes;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("purpose")
    private String purpose;

}
