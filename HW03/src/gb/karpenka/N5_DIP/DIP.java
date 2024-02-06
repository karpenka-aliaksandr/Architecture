package gb.karpenka.N5_DIP;

public class DIP {
}

//Создадим два интерфейса MailSender и OrderRepository, которые и станут нашими абстракциями:
public interface MailSender {
    void sendConfirmationEmail(Order order);
}

public interface OrderRepository {
    boolean save(Order order);
}

//Теперь имплементируем данные интерфейсы в уже готовых для этого классах:
public class ConfirmationEmailSender implements MailSender {

    @Override
    public void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();

        // Шлем письмо клиенту
    }

}

public class MySQLOrderRepository implements OrderRepository {

    @Override
    public boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection("database.url");
        // сохраняем заказ в базу данных

        return true;
    }
}

//Мы провели подготовительную работу, чтобы наш класс OrderProcessor зависел не от конкретных деталей,
// а от абстракций. Внесем в него изменения, внедряя наши зависимости в конструкторе класса:
public class OrderProcessor {

    private MailSender mailSender;
    private OrderRepository repository;

    public OrderProcessor(MailSender mailSender, OrderRepository repository) {
        this.mailSender = mailSender;
        this.repository = repository;
    }

    public void process(Order order){
        if (order.isValid() && repository.save(order)) {
            mailSender.sendConfirmationEmail(order);
        }
    }
}
//Теперь наш класс зависит от абстракций, а не от конкретных реализаций.
// Можно без труда менять его поведение, внедряя нужную зависимость в
// момент создания экземпляра OrderProcessor.

