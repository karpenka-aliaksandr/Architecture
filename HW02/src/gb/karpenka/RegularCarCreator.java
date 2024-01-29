package gb.karpenka;

public class RegularCarCreator implements CarCreator{
    @Override
    public Car getCar() {
        return new RegularCar();
    }
}
