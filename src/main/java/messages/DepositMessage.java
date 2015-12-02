package messages;

import java.io.Serializable;

public class DepositMessage implements Serializable {

    private int amount;

    public DepositMessage(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
