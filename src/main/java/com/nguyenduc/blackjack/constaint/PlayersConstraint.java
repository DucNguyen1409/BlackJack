package com.nguyenduc.blackjack.constaint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = PlayersConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PlayersConstraint {
    String message() default "Cần có ít nhất 2 người chơi";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
