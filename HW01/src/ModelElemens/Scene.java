package ModelElemens;

import java.util.List;

public class Scene {
    public int id;
    public List<PoligonalModel> models;
    public List<Flash> flashes;
    public List<Camera> cameras;

    public Scene(int id,
                 List<PoligonalModel> models,
                 List<Flash> flashes,
                 List<Camera> cameras) throws Exception{
        if (models.size() == 0) throw new IllegalArgumentException("There must be at least one element PoligonalModel");
        if (cameras.size() == 0) throw new IllegalArgumentException("There must be at least one element Camera");
        this.id = id;
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;

    }

    public Object method1 (Object obj){return null;}
    public Object method2 (Object obj1, Object obj2){return null;}


}
