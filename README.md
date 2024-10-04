# Barber Shop Problem

## Descrição

Este projeto implementa uma solução para o problema clássico do Barbeiro Dorminhoco, utilizando múltiplos barbeiros e cadeiras de espera. A simulação demonstra a interação entre clientes e barbeiros em uma barbearia, garantindo que os barbeiros atendam os clientes de forma ordenada e eficiente.

## Funcionalidades

- **Múltiplos Barbeiros**: Suporta a operação simultânea de vários barbeiros.
- **Cadeiras de Espera**: Implementa um sistema de filas com um número limitado de cadeiras para clientes esperando.
- **Mensagens Informativas**: Exibe mensagens detalhadas sobre o estado dos clientes e barbeiros durante a execução.

## Tecnologias Utilizadas

- Java
- Concurrency (Java Concurrency API)
- Semáforos
- Executor Service

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

1. **Barber**: Representa um barbeiro que corta o cabelo dos clientes.
2. **Customer**: Representa um cliente que entra na barbearia e espera pelo corte de cabelo.
3. **Barbershop**: Coordena a interação entre barbeiros e clientes, gerenciando o atendimento.
4. **Simulator**: Classe principal que inicia a simulação e gerencia as threads dos clientes e barbeiros.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/barber-shop-problem.git
   cd barber-shop-problem

2. Compile o projeto:
   javac *.java

3. Execute a simulaçao:
   java Simulator

## Exemplo de Saída

  Customer: Enters the shop --- Thread-0
  Customer: Waiting for haircut --- Thread-0
  Barber: Woke up! Starting the work!
  Customer: Getting Haircut --- Thread-0
  Barber: Cutting Hair --- Thread-1
  Customer: Finished haircut... leaving the barbershop!
  Customer: Leaves the shop --- Thread-0
  Barber: Going to sleep... no customers in the barbershop...
