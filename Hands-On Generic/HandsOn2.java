enum AccountType2 {
    SAVINGS("SA", 3.5),
    CREDIT("CR", 0.0),
    DEPOSIT("DP", 5.0);

    private String code;
    private double interestRate;

    private AccountType2(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() { return code; }
    public double getInterestRate() { return interestRate; }
}

class Account2 {
    private AccountType2 type;
    public Account2(AccountType2 type) { this.type = type; }
    public AccountType2 getType() { return type; }
}

public class HandsOn2 {
    public static void main(String[] args) {
        for (AccountType2 t : AccountType2.values()) {
            System.out.println("Nama: " + t.name() + 
                               " | Kode: " + t.getCode() + 
                               " | Bunga: " + t.getInterestRate() + "%");
        }
    }
}

