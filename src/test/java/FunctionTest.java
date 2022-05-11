import lesson4.Cat;
import org.junit.jupiter.api.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static lesson4.Function.isPalindrome;
import static lesson4.Function.isPrime;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {


    private static Logger logger = LoggerFactory.getLogger("Function Test");
    //TRACE, DEBUG, INFO, WARN, ERROR



    @BeforeAll
    static void beforeAll() {
        System.out.println("Выполниться 1 раз перед всеми тестами");

    }

    @BeforeEach
    void beforeEach() {

        System.out.println("Выполниться перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка простого числа")
    void givenPrimeNumberWhenCallIsPrimeThenTrue() {
        boolean result = isPrime(7);
        assertTrue(result);
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"1235321", "123321"})
//    void isPalindromePositiveTest(String word) {
//        assertTrue(isPalindrome(word));
//    }
//
//    @Test
//    void isNotPalindrome() {
//        assertFalse(isPalindrome("12"));
//    }
//
//    @ParameterizedTest
//@CsvSource({"true, 123321" , "false, 12"})
//    void commonPalindromeTest(boolean exceptedResult, String word) {
//        assertEquals(exceptedResult, isPalindrome(word));
//    }
//
//    @ParameterizedTest
//    @MethodSource("catAndAgeDataProvider")
//    void catTest(Cat cat, Integer age) {
//        assertEquals(age, cat.getAge());
//    }
//
//    private static Stream<Arguments> catAndAgeDataProvider() {
//        return Stream.of(
//              Arguments.of(new Cat("Barsik", 10),10),
//                Arguments.of(new Cat("Murzik",10),11));
//
//
//    }

    @AfterEach

    void afterEach() {

        System.out.println(" Метод выполниться 1 раз после каждого теста");

    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполниться 1 раз после всех тестов");
    }

}
