package CustomException;

class LowScoreException extends Exception {
    LowScoreException(String message) {
        super(message);
    }
}

public class CustomExceptionEx {

    public static void checkScore(int score) throws LowScoreException {
        if (score < 40) {
            throw new LowScoreException("Candidate failed with a low score of " + score);
        } else {
            System.out.println("Score is acceptable. Candidate has passed! ✅");
        }
    }

        public static void main(String[] args) {

            try {
                System.out.println("Checking a passing score:");
                checkScore(85);

                System.out.println("Checking a failing score:");
                checkScore(30);

            } catch (LowScoreException e) {
                System.out.println("Error details: " + e.getMessage());
            } finally {
                System.out.println("--- Score validation process finished. ---");
            }
    }
}
