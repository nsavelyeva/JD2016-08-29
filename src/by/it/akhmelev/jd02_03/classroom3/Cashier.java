package by.it.akhmelev.jd02_03.classroom3;

public class Cashier implements Runnable {

    private int number;

    public Cashier() {
        number = Dispatcher.countCashiers.incrementAndGet();
    }

    @Override
    public void run() {

        System.out.println(this + " opened +++++++++++++++++++++++++++");
        System.out.println("QueueBuyers Size = "+QueueBuyers.getSize());

        while (QueueBuyers.needService()) {
                Buyer buyer = QueueBuyers.extract();
                System.out.println(this + "Start service " + buyer);
                Helper.sleep(Helper.rnd(1000));
                System.out.println(this + "Billing ... " + buyer);
                System.out.println(this + "Stop service " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
                if (!QueueBuyers.needService())
                    Helper.sleep(500);
            }
        System.out.println(this + " closed -------------------------------");
        Dispatcher.countCashiers.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}
