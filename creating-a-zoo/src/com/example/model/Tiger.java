public class Tiger extends Animal implements Eat,Walk{
    private int numberOfStripes;
    private int speed = 30;
    private int soundLevel;


    public Tiger() {
        super  ("Tiger");
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(int sounLevel) {
        this.soundLevel = sounLevel;
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Tiger: I have eaten meat");

    }

    @Override
    public void walking() {
        System.out.println("Tiger: I am walking at the speed " + speed + " mph");

    }
}
