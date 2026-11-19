// Latihan3.java
interface EngineStarter { void startEngine(); }
interface FuelPowered { void isiBahanBakar(); }
interface BatteryPowered { void isiBaterai(); }
interface PedalPowered { void kayuh(); }

class ElectricCar implements EngineStarter, BatteryPowered {
    public void startEngine() { System.out.println("Menyalakan mesin kendaraan..."); }
    public void isiBaterai() { System.out.println("Mengisi baterai kendaraan listrik..."); }
}

class GasolineCar implements EngineStarter, FuelPowered {
    public void startEngine() { System.out.println("Menyalakan mesin kendaraan..."); }
    public void isiBahanBakar() { System.out.println("Mengisi bahan bakar kendaraan..."); }
}

class Bicycle implements PedalPowered {
    public void kayuh() { System.out.println("Mengayuh sepeda..."); }
}

// OCP: kendaraan baru = kelas baru, kode lama tidak diubah
class HybridCar implements EngineStarter, FuelPowered, BatteryPowered {
    public void startEngine() { System.out.println("Menyalakan mesin kendaraan..."); }
    public void isiBahanBakar() { System.out.println("Mengisi bahan bakar kendaraan..."); }
    public void isiBaterai() { System.out.println("Mengisi baterai kendaraan listrik..."); }
}

// DIP: controller bergantung pada abstraksi
class SmartVehicleController {
    private EngineStarter vehicle;

    public SmartVehicleController(EngineStarter vehicle) { this.vehicle = vehicle; }

    public void operate() { vehicle.startEngine(); }
}

public class Latihan3 {
    public static void main(String[] args) {
        ElectricCar mobilListrik = new ElectricCar();
        mobilListrik.startEngine();
        mobilListrik.isiBaterai();

        GasolineCar mobilBensin = new GasolineCar();
        mobilBensin.startEngine();
        mobilBensin.isiBahanBakar();

        Bicycle sepeda = new Bicycle();
        sepeda.kayuh();
        // sepeda.startEngine();   // ERROR kompilasi: sepeda tidak punya mesin

        SmartVehicleController controller = new SmartVehicleController(new HybridCar());
        controller.operate();
    }
}