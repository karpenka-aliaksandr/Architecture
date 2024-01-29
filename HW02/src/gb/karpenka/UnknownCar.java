package gb.karpenka;

public class UnknownCar implements Car{
    @Override
    public void drive() {
        System.out.println("Что-то пошло не так и создался неизвестный автомобиль");
    }
}
