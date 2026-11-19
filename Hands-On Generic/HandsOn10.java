import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Produk<T, U, V> {
    private T nama;
    private U harga;
    private V stok;

    private static final DecimalFormat df = new DecimalFormat("#,###");

    public Produk(T nama, U harga, V stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String toFileString() {
        return nama + "," + harga + "," + stok;
    }

    public static Produk<String, Double, Integer> fromString(String line) {
        String[] parts = line.split(",");
        return new Produk<>(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]));
    }

    @Override
    public String toString() {
        String hargaFormatted;
        if (harga instanceof Number) {
            hargaFormatted = df.format(((Number) harga).longValue());
        } else {
            hargaFormatted = harga.toString();
        }
        return "Produk: " + nama + ", Harga: " + hargaFormatted + ", Stok: " + stok;
    }
}

public class HandsOn10 {
    public static void main(String[] args) {
        List<Produk<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new Produk<>("Laptop", 15000000.0, 10));
        produkList.add(new Produk<>("Mouse", 150000.0, 50));
        produkList.add(new Produk<>("Keyboard", 350000.0, 30));

        Path filePath = Paths.get("produk_output.txt");

        try {
            List<String> lines = new ArrayList<>();
            for (Produk<String, Double, Integer> p : produkList) {
                lines.add(p.toFileString());
            }
            Files.write(filePath, lines);
            System.out.println("Data produk berhasil disimpan menggunakan NIO.2");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }

        try {
            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                Produk<String, Double, Integer> p = Produk.fromString(line);
                System.out.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }
}