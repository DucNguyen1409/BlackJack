package com.nguyenduc.blackjack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class BlackJackResultNotValid extends Exception {

    private static final long serialVersionUID = 1L;

    public BlackJackResultNotValid(String message) {
        super(message);
    }
}
