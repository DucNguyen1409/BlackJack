package com.nguyenduc.blackjack.service.impl;

import com.nguyenduc.blackjack.dto.BlackJackResult;
import com.nguyenduc.blackjack.dto.HistoryRecordDto;
import com.nguyenduc.blackjack.dto.PlayerRecordDto;
import com.nguyenduc.blackjack.exception.ResourceNotFoundException;
import com.nguyenduc.blackjack.model.ActivityHistory;
import com.nguyenduc.blackjack.model.Game;
import com.nguyenduc.blackjack.model.PlayerHistory;
import com.nguyenduc.blackjack.model.SettingGame;
import com.nguyenduc.blackjack.repository.ActivityHistoryRepository;
import com.nguyenduc.blackjack.repository.GameRepository;
import com.nguyenduc.blackjack.service.BlackJackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlackJackServiceImpl implements BlackJackService {

    private final GameRepository gameRepository;
    private final ActivityHistoryRepository activityHistoryRepository;

    @Override
    public ActivityHistory calculateResult(HistoryRecordDto historyRecordDto) throws ResourceNotFoundException {
        // Get setting game (point)
        Game gameById = gameRepository.findById(historyRecordDto.getGameId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy ván chơi"));

        // Check activity history (get init point)
        ActivityHistory activityHistoryOld = activityHistoryRepository.findFirstByGameIdOrderByCreatedDateDesc(historyRecordDto.getGameId())
                .orElse(new ActivityHistory(gameById));
        ActivityHistory activityHistory = new ActivityHistory(gameById);

        // get Map of playerID and result
        Map<Integer ,BlackJackResult> playerBlackJackResultMap = historyRecordDto.getPlayerRecordDtos().stream()
                .collect(Collectors.toMap(PlayerRecordDto::getId, PlayerRecordDto::getBlackJack));

        int totalPoints = 0;
        // update all player point
        for (PlayerHistory history : activityHistoryOld.getPlayerHistories()) {
            if (history.getId() != gameById.getDealerId()) {
                BlackJackResult blackJackResult = playerBlackJackResultMap.get(history.getId());
                int newPoint = getPlayerPoint(history.getPoint(), blackJackResult, gameById.getSettingGame());
                history.setPoint(newPoint);
                history.setBlackJackResult(blackJackResult);
                totalPoints += newPoint;
            }
        }

        // update dealer point
        for (PlayerHistory history : activityHistoryOld.getPlayerHistories()) {
            if (history.getId() == gameById.getDealerId()) {
                history.setPoint(Math.negateExact(totalPoints));
                history.setBlackJackResult(playerBlackJackResultMap.get(history.getId()));
            }
        }

        // Save ActivityHistory
        activityHistory.setGameId(historyRecordDto.getGameId());
        activityHistory.setPlayerHistories(activityHistoryOld.getPlayerHistories());
        activityHistory.setTurnNumber(activityHistoryOld.getTurnNumber() + 1);
        return activityHistoryRepository.save(activityHistory);
    }

    private int getPlayerPoint(int oldPoint, BlackJackResult jackResult, SettingGame settingGame) {
        switch (jackResult) {
            case WIN -> { 
                return oldPoint + settingGame.getPointTurn();
            }
            case LOSE -> {
                return oldPoint - settingGame.getPointTurn();
            }
            case WIN_BLACKJACK -> {
                return oldPoint + settingGame.getWinPointsBlackJack();
            }
            case LOSE_BLACKJACK -> {
                return oldPoint - settingGame.getWinPointsBlackJack();
            }
            case WIN_FIVE_CARD -> {
                return oldPoint + settingGame.getWinPointsFiveCardCharlie();
            }
            case LOSE_FIVE_CARD -> {
                return oldPoint - settingGame.getWinPointsFiveCardCharlie();
            }
            default -> {
                return oldPoint;
            }
        }
    }

}
