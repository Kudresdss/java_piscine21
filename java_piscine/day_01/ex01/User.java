public class User {
	
	private Integer id;
	private Integer balance;
	private String name;
	
	public User(String name, int balance) {
		this.id = UserIdsGenerator.getInstance().generateId();
		this.setName(name);
		this.setBalance(balance);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void printConsole() {
        System.out.format("\nID: %d\nName: %s\nBalance: %d\n", id, name, balance);
    }
}