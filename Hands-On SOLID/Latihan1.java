interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim Email: " + message);
    }
}

class SMSNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}

class WhatsAppNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}

// OCP: kanal baru cukup kelas baru, kode lama tidak diubah
class TelegramNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Mengirim Telegram: " + message);
    }
}

// DIP: service bergantung pada abstraksi Notifier
class NotificationService {
    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String message) {
        notifier.send(message);
    }
}

public class Latihan1 {
    public static void main(String[] args) {
        NotificationService emailService = new NotificationService(new EmailNotifier());
        emailService.notifyUser("Halo, ini email test!");

        NotificationService smsService = new NotificationService(new SMSNotifier());
        smsService.notifyUser("Ini SMS test!");

        NotificationService waService = new NotificationService(new WhatsAppNotifier());
        waService.notifyUser("Ini pesan WhatsApp test!");

        NotificationService telegramService = new NotificationService(new TelegramNotifier());
        telegramService.notifyUser("Kanal baru tanpa mengubah kode lama");
    }
}

