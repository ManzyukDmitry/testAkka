package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messages.DepositMessage;
import messages.ResultMessage;
import messages.WithdrawMessage;

public class AccountActor extends UntypedActor {

    private LoggingAdapter LOG = Logging.getLogger(getContext().system(), this);

    private String name;
    private int balance;
    private ActorRef transactionProcessor;

    public AccountActor(String name, int balance, ActorRef transactionProcessor) {
        this.name = name;
        this.balance = balance;
        this.transactionProcessor = transactionProcessor;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof WithdrawMessage){
            LOG.info("withdraw");
            balance -= ((WithdrawMessage) message).getAmount();
            getSender().tell(new DepositMessage(((WithdrawMessage) message).getAmount()), getSelf());
        } else if(message instanceof DepositMessage){
            LOG.info("deposit");
            balance += ((DepositMessage) message).getAmount();
            transactionProcessor.tell(new ResultMessage(name,balance), getSelf());
        } else {
            unhandled(message);
        }
    }
}
