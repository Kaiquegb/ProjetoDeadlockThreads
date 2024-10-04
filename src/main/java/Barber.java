public class Barber {
    // Procedimento para cortar o cabelo do cliente.
    public void cutHair() {
        System.out.println("Barber: Cutting Hair --- " + Thread.currentThread().getName());
    }

    // Mensagem quando o barbeiro vai dormir
    public void goToSleep() {
        System.out.println("Barber: Going to sleep... no customers in the barbershop...");
    }

    // Mensagem quando o barbeiro acorda
    public void wakeUp() {
        System.out.println("Barber: Woke up! Starting the work!");
    }
}