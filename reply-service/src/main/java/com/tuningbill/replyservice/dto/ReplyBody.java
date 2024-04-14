package com.tuningbill.replyservice.dto;

import jakarta.validation.constraints.NotNull;

public record ReplyBody(
    @NotNull(message="content is required") String content
) {
    
}
