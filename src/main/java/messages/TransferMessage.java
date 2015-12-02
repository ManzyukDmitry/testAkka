package messages;

import java.io.Serializable;
import akka.actor.ActorRef;


public class TransferMessage implements Serializable {

    private ActorRef to;
    private ActorRef from;
    private int amount;

    public TransferMessage(ActorRef from, ActorRef to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public ActorRef getTo() {
        return to;
    }

    public void setTo(ActorRef to) {
        this.to = to;
    }

    public ActorRef getFrom() {
        return from;
    }

    public void setFrom(ActorRef from) {
        this.from = from;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
