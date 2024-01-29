package gb.karpenka;

import java.util.HashMap;

public class CarCreatorFactory {
    private HashMap<String,CarCreator> factories = new HashMap<>();

    public <T extends CarCreator> void addFactory (T carCreator){
        factories.put(carCreator.getClass().getSimpleName(), carCreator);
    }

    public void carInfo(){
        for (String f:factories.keySet()){
            System.out.println(f);
        }
    }

    public Car createCar(String carCreatorName) {
        CarCreator carCreator = factories.get(carCreatorName);
        if (carCreator == null) {
            return new UnknownCar();
        }
        return carCreator.getCar();
    }


}
