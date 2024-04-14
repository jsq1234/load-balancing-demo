package com.tuningbill.postservice.dto;

import jakarta.validation.constraints.NotNull;

public record PostBody(
    @NotNull(message = "Title field required.") String title,
    @NotNull(message = "Content field required.") String content) {

}
