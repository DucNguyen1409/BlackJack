package com.nguyenduc.blackjack.model;

import com.nguyenduc.blackjack.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "activity_history")
public class ActivityHistory {

    @Id
    private String id;

    private String gameId;

    private int turnNumber;

    private List<PlayerHistory> playerHistories;

    private LocalDateTime createdDate;

    public ActivityHistory(Game game) {
        this.gameId = game.getId();
        this.turnNumber = Constant.INITIAL_GAME_TURN;
        this.createdDate = LocalDateTime.now();
        this.playerHistories = game.getPlayers().stream()
                .map(PlayerHistory::new)
                .collect(Collectors.toList());
    }

}
