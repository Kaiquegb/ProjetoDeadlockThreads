import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulator {

    private static final int NUM_CUSTOMERS = 8; // número total de clientes
    private static final int NUM_BARBERS = 2; // número total de barbeiros
    private static final int WAITING_CHAIRS = 4; // número de cadeiras de espera

    public static void main(String[] args) {

        Barbershop barbershop = new Barbershop(WAITING_CHAIRS); // instancia uma barbearia com 4 cadeiras

        ExecutorService executor = Executors.newFixedThreadPool(NUM_BARBERS + NUM_CUSTOMERS); // cria um pool de threads

        // Inicia as threads dos barbeiros
        for (int i = 0; i < NUM_BARBERS; i++) {
            executor.submit(barbershop::startService);
        }

        // Inicia as threads dos clientes com um intervalo controlado
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            executor.submit(() -> barbershop.receiveNewCustomer());

            try {
                Thread.sleep(2000);  // Simula a chegada dos clientes em intervalos maiores (2 segundos)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown(); // Finaliza o executor após todas as tarefas serem concluídas
    }
}