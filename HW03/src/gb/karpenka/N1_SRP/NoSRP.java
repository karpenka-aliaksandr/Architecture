package gb.karpenka.N1_SRP;

public class NoSRP {
//    Такой модуль может измениться по трем причинам.
//    Во-первых может стать другой логика обработки заказа,
//    во-вторых, способ его сохранения (тип базы данных),
//    в-третьих — способ отправки письма подтверждения
//    (скажем, вместо email нужно отправлять SMS).
//
//    Принцип единственной обязанности подразумевает,
//    что три аспекта этой проблемы на самом деле — три
//    разные обязанности. А значит, должны находиться в разных
//    классах или модулях. Объединение нескольких сущностей,
//    которые могут меняться в разное время и по разным причинам,
//    считается плохим проектным решением.

}
public class OrderProcessor {

    public void process(Order order){
        if (order.isValid() && save(order)) {
            sendConfirmationEmail(order);
        }
    }

    private boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection("database.url");
        // сохраняем заказ в базу данных

        return true;
    }

    private void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();

        // Шлем письмо клиенту
    }
}
