package com.nguyenduc.blackjack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "activity_history_details")
public class ActivityHistoryDetails {
    @Id
    private long id;

    private String detailName;

    private String playWith;

    private Date createdDate;

    private Date lastTurn;
}
