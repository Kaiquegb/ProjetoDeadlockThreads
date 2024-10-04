public class Customer {
    // procedimento para o cliente entrar na barbearia
    public void enter() {
        System.out.println("Customer: Enters the shop --- " + Thread.currentThread().getName());
    }

    // mensagem quando o cliente está esperando
    public void waitingForHaircut() {
        System.out.println("Customer: Waiting for haircut --- " + Thread.currentThread().getName());
    }

    // procedimento que informa que o cliente está cortando o cabelo.
    public void getHairCut() {
        System.out.println("Customer: Getting Haircut --- " + Thread.currentThread().getName());
    }

    // mensagem que informa que o cliente saiu da barbearia.
    public void leave() {
        System.out.println("Customer: Leaves the shop --- " + Thread.currentThread().getName());
    }

    // mensagem quando o cliente tenta entrar, mas a barbearia está lotada
    public void leaveDueToFullShop() {
        System.out.println("Customer: Tried to enter the barbershop, but it's full... going for a walk.");
    }

    // mensagem quando o cliente terminou o corte
    public void finishedHaircut() {
        System.out.println("Customer: Finished haircut... leaving the barbershop!");
    }
}