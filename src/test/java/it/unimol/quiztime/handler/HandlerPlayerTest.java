package it.unimol.quiztime.handler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerPlayerTest {
    @Test
    void checkEmptyListException() {
            HandlerPlayer handlerPlayer = new HandlerPlayer();
            assertFalse(handlerPlayer.getPlayerList().isEmpty());
    }
}