package gb.karpenka.N2_OCP;

import gb.karpenka.N1_SRP.OrderProcessor;

public class OCP {
}

public class OrderProcessorWithPreAndPostProcessing extends OrderProcessor {

    @Override
    public void process(Order order) {
        beforeProcessing();
        super.process(order);
        afterProcessing();
    }

    private void beforeProcessing() {
        // Осуществим некоторые действия перед обработкой заказа
    }

    private void afterProcessing() {
        // Осуществим некоторые действия после обработки заказа
    }
}
