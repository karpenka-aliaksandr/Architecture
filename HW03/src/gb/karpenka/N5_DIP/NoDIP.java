package gb.karpenka.N5_DIP;

public class NoDIP {
}

//Программное обеспечение нужно разрабатывать так, чтобы различные модули были
// автономными и соединялись друг с другом с помощью абстракции.
//
//Классическое применение этого принципа — Spring framework. В рамках Spring framework
// все модули выполнены в виде отдельных компонентов, которые могут работать вместе.
// Они настолько автономны, что могут быть быть с такой же легкостью задействованы
// в других программных модулях помимо Spring framework.
//
// Говоря о принципе единственной ответственности, мы рассматривали некоторый OrderProcessor.
// Взглянем еще раз на код данного класса:

public class OrderProcessor {
        public void process(Order order){

                MySQLOrderRepository repository = new MySQLOrderRepository();
                ConfirmationEmailSender mailSender = new ConfirmationEmailSender();

                if (order.isValid() && repository.save(order)) {
                        mailSender.sendConfirmationEmail(order);
                }
        }

}

//В данном примере наш OrderProcessor зависит от двух конкретных классов
// MySQLOrderRepository и ConfirmationEmailSender. Приведем также код данных классов:
public class MySQLOrderRepository {
        public boolean save(Order order) {
                MySqlConnection connection = new MySqlConnection("database.url");
                // сохраняем заказ в базу данных

                return true;
        }
}

public class ConfirmationEmailSender {
        public void sendConfirmationEmail(Order order) {
                String name = order.getCustomerName();
                String email = order.getCustomerEmail();

                // Шлем письмо клиенту
        }
}
//Эти классы далеки от того, чтобы называться абстракциями. И с точки зрения принципа DIP
//было бы правильнее для начала создать некоторые абстракции, которые позволят нам
// оперировать в дальнейшем ими, а не конкретными реализациями.