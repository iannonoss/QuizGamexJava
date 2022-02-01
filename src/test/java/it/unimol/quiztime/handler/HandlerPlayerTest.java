package it.unimol.quiztime.handler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerPlayerTest {
    @Test
    void checkEmptyListException() {
        try {
            HandlerPlayer handlerPlayer = new HandlerPlayer();
            handlerPlayer.checkListIsNotEmpty();
            fail();
        } catch (EmptyListException e) {

        }

    }
}