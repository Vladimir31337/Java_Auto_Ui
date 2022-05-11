import lesson4.Box;
import lesson4.BoxIsAlreadyEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmpty {

        @BeforeEach
        void createEmpty() {
            box = new Box();
        }

        @Test
        void exceptionWhenTryShuffleBoxTest() {
            Assertions.assertThrows(NullPointerException.class, () -> box.shuffleBalls());

        }

        @Test

        void addBalls() {
            box.addBall();
            Assertions.assertEquals(box.getBallsCount(),1);
        }

    }
    @Nested

    class WhenOneBall {
        void addBall() {
            box.addBall();
        }
    }

    @Test
    void deleteBallTest() throws BoxIsAlreadyEmptyException {
        box.deleteBall();
        Assertions.assertEquals(box.getBallsCount(),0);
    }

}


