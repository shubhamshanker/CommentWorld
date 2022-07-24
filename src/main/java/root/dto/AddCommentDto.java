package root.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentDto {

    private String content;

    // rootId, level -> can be determined from parentId
    private Long parentId;

    // maybe include later as a validation
    private Long userId;
}
