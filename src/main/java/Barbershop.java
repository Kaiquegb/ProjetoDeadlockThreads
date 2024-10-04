import java.util.concurrent.Semaphore;

public class Barbershop {
    private final int limit; // número de cadeiras de espera
    private int customers; // variável armazena clientes
    private final Barber barber; // variável barber do tipo Barber

    private final Semaphore customerReady; // semáforo se o cliente está disponível
    private final Semaphore barberReady; // semáforo para saber se o barbeiro está disponível

    private final Semaphore customerDone; // semáforo para informar que o cliente já teve cabelo cortado
    private final Semaphore barberDone; // semáforo para informar que o barbeiro terminou

    public Barbershop(int limit) {
        this.limit = limit; // define a quantidade de cadeiras de espera
        customers = 0; // inicializa sem clientes

        customerReady = new Semaphore(0); // Instancia um semáforo com 0 permissões
        barberReady = new Semaphore(0);

        customerDone = new Semaphore(0);
        barberDone = new Semaphore(0);

        barber = new Barber();
    }

    public void startService() {
        while (true) { // Loop contínuo para o barbeiro
            try {
                customerReady.acquire(); // espera um cliente chegar
            } catch (InterruptedException e) {
                System.out.println("Barber wait task is interrupted: " + e.getMessage());
            }

            barber.wakeUp(); // O barbeiro acorda e se prepara para trabalhar
            barberReady.release(); // sinaliza que o barbeiro está pronto

            barber.cutHair(); // corta o cabelo do cliente

            try {
                customerDone.acquire(); // espera até o corte de cabelo ser concluído
            } catch (InterruptedException e) {
                System.out.println("Barber wait task is interrupted: " + e.getMessage());
            }

            barberDone.release(); // sinaliza que o barbeiro terminou

            synchronized (this) {
                if (customers == 0) { // Se não houver mais clientes, o barbeiro vai dormir
                    barber.goToSleep();
                }
            }
        }
    }

    public void receiveNewCustomer() {
        Customer customer = new Customer(); // instancia um novo cliente

        customer.enter(); // cliente entra na fila

        synchronized (this) {
            if (customers == limit) { // se a quantidade de clientes == número de cadeiras de espera
                customer.leaveDueToFullShop(); // O cliente vai embora porque a barbearia está cheia
                return;
            }

            customers++; // incrementa o número de clientes
            customer.waitingForHaircut();  // Cliente esperando pelo corte
            customerReady.release(); // sinaliza que há um cliente pronto para ser atendido
        }

        try {
            barberReady.acquire(); // espera até que o barbeiro esteja disponível
        } catch (InterruptedException e) {
            System.out.println("Customer wait task is interrupted: " + e.getMessage());
        }

        customer.getHairCut(); // cliente começa a cortar o cabelo

        customerDone.release(); // sinaliza que o corte foi concluído

        try {
            barberDone.acquire(); // espera até que o barbeiro termine
        } catch (InterruptedException e) {
            System.out.println("Customer wait task is interrupted: " + e.getMessage());
        }

        synchronized (this) {
            customers--; // decrementa a contagem de clientes após o corte
            customer.finishedHaircut();  // cliente terminou o corte e sai da barbearia
            customer.leave();  // cliente deixa a barbearia
        }
    }
}