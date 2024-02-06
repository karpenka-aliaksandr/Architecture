package gb.karpenka.N3_LSP;

public class NoLSP {

}
//Предположим у нас есть класс, который отвечает за валидацию заказа и проверяет,
// все ли из товаров заказа находятся на складе. У данного класса есть метод
// isValid который возвращает true или false:
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

//Также предположим, что некоторые заказы нужно валидировать иначе: проверять,
// все ли товары заказа находятся на складе и все ли товары упакованы.
// Для этого мы расширили класс OrderStockValidator классом OrderStockAndPackValidator:
public class OrderStockAndPackValidator extends OrderStockValidator {

    @Override
    public boolean isValid(Order order) {
        for (Item item : order.getItems()) {
            if ( !item.isInStock() || !item.isPacked() ){
                throw new IllegalStateException(
                        String.format("Order %d is not valid!", order.getId())
                );
            }
        }

        return true;
    }
}

// Однако в данном классе мы нарушили принцип LSP, так как вместо того,
// чтобы вернуть false, если заказ не прошел валидацию, наш метод бросает
// исключение IllegalStateException. Клиенты данного кода не рассчитывают на такое:
// они ожидают возвращения true или false. Это может привести к ошибкам в работе программы.
