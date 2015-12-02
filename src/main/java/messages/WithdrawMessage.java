package messages;

import java.io.Serializable;

public class WithdrawMessage implements Serializable {

    private int amount;

    public WithdrawMessage(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
