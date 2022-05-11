package lesson4;



public class Function {

    public static boolean isPrime(Integer number) {
        // 1 2 3 5 простые числа те которые деляться на единицу и на самих себя без остатка
        if (number <= 0) return false;
        if (number <= 3) return true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;

    }

    // Палиндром числа которые читаются в обе стороны 123321, 1235321, 12, 1
    public static boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length()) - 1) {
            return false;
        }
        return isPalindrome(word.substring(1, word.length() - 1));

    }
    //1235321    isPalindrome     = true
    //23532      isPalindrome
    //353        isPalindrome
    //5          isPalindrome   - true

}
