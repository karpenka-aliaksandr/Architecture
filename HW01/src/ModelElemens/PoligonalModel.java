package ModelElemens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PoligonalModel {
    public List<Poligon> poligons;
    public List<Texture> textures;

    public PoligonalModel(List<Texture> textures) throws Exception {
        this.textures = textures;
        this.poligons = new ArrayList<>();
        poligons.add(new Poligon());
    }
}
