package gb.karpenka;

public class RacingCarCreator implements CarCreator {
    @Override
    public Car getCar() {
        return new RacingCar();
    }
}
