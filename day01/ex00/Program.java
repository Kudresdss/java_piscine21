public class Program {
	
	public static void main(String[] args) {
		User sender = new User();
		User recipient = new User();
		Transaction transaction = new Transaction();
		
		sender.setId(0);
		sender.setName("John");
		sender.setBalance(100000);
		sender.printConsole();
		
		recipient.setId(1);
		recipient.setName("Hannah");
		recipient.setBalance(300000);
		recipient.printConsole();
		
		transaction.setSender(sender);
		transaction.setRecipient(recipient);
		transaction.setTransferAmount(2000);
		transaction.printConsole();
	}
}