package InMemoryModel;

import ModelElemens.*;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger{
    public List<PoligonalModel> models;
    public List<Scene> scenes;
    public List<Flash> flashes;
    public List<Camera> cameras;
    private List<IModelChangedObserver> changedObservers;

    public ModelStore(List<IModelChangedObserver> changedObservers) throws Exception{
        this.changedObservers = changedObservers;
        this.models = new ArrayList<>();
        this.scenes = new ArrayList<>();
        this.flashes = new ArrayList<>();
        this.cameras = new ArrayList<>();
        models.add(new PoligonalModel(new ArrayList<Texture>()));
        flashes.add(new Flash());
        cameras.add(new Camera());
        scenes.add(new Scene(0, models, flashes, cameras));
    }


    public Scene getScene(int id){
        for (Scene scene:
             scenes) {
            if (scene.id == id) {return scene;}
        }
        return null;
    }

    @Override
    public void notyfyChange(IModelChanger sender) {
        //TODO нереализованный метод
    }


}
