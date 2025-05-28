class Pemain {
   private int tinggi;
   private int berat;

    public Pemain(int tinggi, int berat) {
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public int getTinggi() {
        return tinggi;
    }

    public int getBerat() {
        return berat;
    }

    @Override
    public String toString() {
        return "Tinggi: " + tinggi + ", Berat: " + berat;
    }
}