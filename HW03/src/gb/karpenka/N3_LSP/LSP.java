package gb.karpenka.N3_LSP;

public class LSP {

}

// Исправим наследник, чтобы поведение стало ожидаемым (как у родителя)
public class OrderStockValidator {

    public boolean isValid(Order order) {
        for (Item item : order.getItems()) {
            if (! item.isInStock()) {
                return false;
            }
        }

        return true;
    }
}

public class OrderStockAndPackValidator extends OrderStockValidator {

    @Override
    public boolean isValid(Order order) {
        for (Item item : order.getItems()) {
            if ( !item.isInStock() || !item.isPacked() ){
                return false;
                );
            }
        }

        return true;
    }
}
