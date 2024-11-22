import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mycompany.assignment.CarefulStrategy;
import com.mycompany.assignment.Game;
import com.mycompany.assignment.GreedyStrategy;
import com.mycompany.assignment.LuckyField;
import com.mycompany.assignment.Player;
import com.mycompany.assignment.PropertyField;
import com.mycompany.assignment.ServiceField;


public class GameTest {

    @Test
    public void testReadGameFile_ValidInput() throws IOException {
        Game game = new Game();
        game.readGameFile("C:\\Users\\DELL\\Desktop\\Assignment\\src\\main\\java\\com\\mycompany\\assignment\\game2.txt");
        assertFalse(game.board.isEmpty());
        assertFalse(game.players.isEmpty());
        assertFalse(game.diceRolls.isEmpty());
    }

    @Test
    public void testReadGameFile_FileNotFound() {
        Game game = new Game();
        Exception exception = assertThrows(IOException.class, () -> {
            game.readGameFile("C:\\Users\\DELL\\Desktop\\Assignment\\src\\main\\java\\com\\mycompany\\assignment\\none.txt");
        });
        assertTrue(exception.getMessage().contains("Game file not found: "));
    }

    @Test
    public void testReadGameFile_InvalidFieldType() {
        Game game = new Game();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.readGameFile("C:\\Users\\DELL\\Desktop\\Assignment\\src\\main\\java\\com\\mycompany\\assignment\\InvalidField.txt");
        });
        assertTrue(exception.getMessage().contains("Invalid field type"));
    }

    @Test
    public void testReadGameFile_InvalidPlayerStrategy() {
        Game game = new Game();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.readGameFile("C:\\Users\\DELL\\Desktop\\Assignment\\src\\main\\java\\com\\mycompany\\assignment\\InvalidStrategy.txt");
        });
        assertTrue(exception.getMessage().contains("Unknown strategy"));
    }

    @Test
    public void testReadGameFile_InvalidNumberFormat() {
        Game game = new Game();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.readGameFile("C:\\Users\\DELL\\Desktop\\Assignment\\src\\main\\java\\com\\mycompany\\assignment\\InvalidNumber.txt");
        });
        assertTrue(exception.getMessage().contains("Invalid number format in game file"));
    }

    @Test
    public void testPlay() {
        Game game = new Game();
        game.board.add(new PropertyField());
        game.board.add(new LuckyField(50));
        game.players.add(new Player("Player1", new GreedyStrategy()));
        game.diceRolls.add(3);
        game.play();
        assertEquals(1, game.players.get(0).getPosition());
    }

    @Test
    public void testGetSecondLoser() {
        Game game = new Game();
        Player player1 = new Player("Player1", new GreedyStrategy());
        Player player2 = new Player("Player2", new CarefulStrategy());
        game.losers.add(player1);
        game.losers.add(player2);
        assertEquals(player2, game.getSecondLoser());
    }
    @Test
    public void testPlayerBalanceAfterServiceField() {
        Game game = new Game();
        Player player = new Player("Player", new GreedyStrategy());
        game.board.add(new ServiceField(500));
        game.players.add(player);
        game.diceRolls.add(2); 
        game.play();
        assertEquals(9500, player.getBalance()); 
    }
    @Test
    public void testNotEnoughPlayerLost() {
        Game game = new Game();
        Exception exception = assertThrows(IOException.class, () -> {
        game.readGameFile("C:\\Users\\DELL\\Desktop\\Assignment\\src\\main\\java\\com\\mycompany\\assignment\\none.txt");
        });
        game.play();
        assertTrue(exception.getMessage().contains("Game file not found: "));
    }
}