package lesson4;

public class Box {
    private Integer ballsCount;

    public Box() {
        this.ballsCount = ballsCount;
    }

    public Integer getBallsCount() {
        return ballsCount;
    }

    public void addBall() {

        ballsCount++;

    }

    public void deleteBall() throws BoxIsAlreadyEmptyException {

        if (ballsCount == 0) {
            throw new BoxIsAlreadyEmptyException();
        }
        ballsCount--;
    }

    public void shuffleBalls() {
        if (ballsCount == 0)
            throw new NullPointerException();
        System.out.println("Перемешать мячи");
    }


}
