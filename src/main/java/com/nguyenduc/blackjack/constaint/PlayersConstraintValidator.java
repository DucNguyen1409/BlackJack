package com.nguyenduc.blackjack.constaint;

import com.nguyenduc.blackjack.dto.PlayerDto;
import com.nguyenduc.blackjack.model.Player;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PlayersConstraintValidator implements ConstraintValidator<PlayersConstraint, List<PlayerDto>> {
    @Override
    public boolean isValid(List<PlayerDto> list, ConstraintValidatorContext constraintValidatorContext) {
            return list.size() > 1;
    }
}
