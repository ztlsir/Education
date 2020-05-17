package com.ztlsir.homework.homework.command;

import com.ztlsir.shared.value.ClassAndGrade;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
public class CreateCommand {
    public ClassAndGrade classAndGrade;
    public String teacherId;

    @NotEmpty(message = "作业内容不能为空")
    public String content;
}
