public class User {
	
	private Integer id;
	private Integer balance;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
        System.out.printf("\nID: %d\nName: %s\nBalance: %d\n", id, name, balance);
    }
}