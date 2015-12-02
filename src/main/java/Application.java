import actors.AccountActor;
import actors.TransactionProcessorActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import messages.TransferMessage;

public class Application {

    public static void main(String[] args) throws InterruptedException{
        ActorSystem system = ActorSystem.create("bankSystem");

        ActorRef processor = system.actorOf(Props.create(TransactionProcessorActor.class),"processor");

        ActorRef bobAccount = system.actorOf(Props.create(AccountActor.class,"Bob",processor,100));
        ActorRef aliceAccount = system.actorOf(Props.create(AccountActor.class,"Alice",processor,50));

        processor.tell(new TransferMessage(bobAccount,aliceAccount,10),processor);
        processor.tell(new TransferMessage(aliceAccount,bobAccount,3),processor);

        Thread.sleep(50);
        system.shutdown();
    }
}
