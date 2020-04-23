package com.ztlsir.homework.homework.command;

import com.ztlsir.shared.value.ClassAndGrade;
import lombok.Value;

@Value
public class CreateCommand {
    public ClassAndGrade classAndGrade;
    public String teacherId;
    public String content;
}
