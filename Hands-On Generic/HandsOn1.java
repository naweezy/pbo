enum AccountType1 {
    SAVINGS, CREDIT, DEPOSIT;

    @Override
    public String toString() {
        switch (this) {
            case SAVINGS: return "Tabungan - simpanan nasabah";
            case CREDIT:  return "Kredit - pinjaman nasabah";
            case DEPOSIT: return "Deposito - simpanan berjangka";
            default:      return name();
        }
    }
}

class Account1 {
    private AccountType1 type;

    public Account1(AccountType1 type) {
        this.type = type;
    }

    public AccountType1 getType() {
        return type;
    }
}

public class HandsOn1 {
    public static void main(String[] args) {
        for (AccountType1 t : AccountType1.values()) {
            System.out.println(t.name() + " -> " + t.toString());
        }

        Account1 acc = new Account1(AccountType1.DEPOSIT);
        System.out.println("\nTipe akun yang dibuat: " + acc.getType());
    }
}

