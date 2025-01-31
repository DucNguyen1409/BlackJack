package com.nguyenduc.ghidiem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "activity_history")
public class ActivityHistory {
    @Id
    private long id;

    @Indexed(unique = true)
    private String name;

}
