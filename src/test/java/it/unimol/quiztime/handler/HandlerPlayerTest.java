package it.unimol.quiztime.handler;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class HandlerPlayerTest {
    @Test
    void checkEmptyListException() {
            HandlerPlayer handlerPlayer = new HandlerPlayer();
            assertFalse(handlerPlayer.getPlayerList().isEmpty());
    }
    @Test
    void checkFileExist(){
        File file = new File("PlayerPoint.serr");
        assert file.exists();
    }
}