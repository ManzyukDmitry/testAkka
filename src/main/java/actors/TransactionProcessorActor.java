package actors;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messages.ResultMessage;
import messages.TransferMessage;
import messages.WithdrawMessage;

public class TransactionProcessorActor extends UntypedActor {

    private LoggingAdapter LOG = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof TransferMessage){
            LOG.info("transferTo");
            TransferMessage transferMessage = (TransferMessage) message;
            transferMessage.getFrom().tell(new WithdrawMessage(transferMessage.getAmount()), transferMessage.getTo());
        } else if(message instanceof ResultMessage){
            ResultMessage result = (ResultMessage) message;
            LOG.info("Remaining Balance for " + result.getName() + " is " + result.getBalance());
        } else {
            unhandled(message);
        }
    }

}
