package com.fea.project.model.appendix;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class AppendixId {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
}
