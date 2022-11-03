import java.util.UUID;

public class Transaction {
	
	private final UUID id;
	private User sender;
	private User recipient;
	private String transferType;
	private int transferAmount;
	
	Transaction() {
		id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
	
	public User getSender() {
		return sender;
	}
	
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	public User getRecipient() {
		return recipient;
	}
	
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
	
	public String getTransferType() {
        return transferType;
    }
	
	public void setTransferType(String transferType) {
        this.transferType = transferType;
    }
	
	public int getTransferAmount() {
        return transferAmount;
    }
	
	public void setTransferAmount(int transferAmount) {
		
		if (transferAmount <= 0) {
			if (sender.getBalance() < transferAmount) {
				System.err.print("\nНе хватает средств для осуществления транзакции");
                System.exit(-1);
			}
			this.setTransferType("OUTCOME");
		}
		else {
			if (Math.abs(recipient.getBalance()) < Math.abs(transferAmount) || recipient.getBalance() < Math.abs(transferAmount)) {
				System.err.print("\nНе хватает средств для осуществления транзакции");
                System.exit(-1);
			}
			this.setTransferType("INCOME");
		}
		
		sender.setBalance(sender.getBalance() - transferAmount);
        recipient.setBalance(recipient.getBalance() + transferAmount);
        this.transferAmount = transferAmount;
	}
	
	public void printConsole() {
        System.out.print("\nID: " + getId() +
                "\nSender: " + getSender().getName() + " " + -1 * getTransferAmount() +
                "\nRecipient: " + getRecipient().getName() + " " + getTransferAmount() +
                "\n\n||SENDER||\n" + "ID: " + sender.getId() + "\nName: " + sender.getName() + "\nBalance: " + sender.getBalance() +
                "\n\n||RECIPIENT||\n" + "ID: " + recipient.getId() + "\nName: " + recipient.getName() + "\nBalance: " + recipient.getBalance() + "\n");
    }
}
