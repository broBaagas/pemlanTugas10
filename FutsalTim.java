import java.util.*;

public class FutsalTim {
    public static void main(String[] args) {
        // Menyimpan data pemain tim A dalam array list
        List<Pemain> timA = new ArrayList<>(Arrays.asList(
                new Pemain(168, 50), new Pemain(170, 60), new Pemain(165, 56), new Pemain(168, 55),
                new Pemain(172, 60), new Pemain(170, 70), new Pemain(169, 66), new Pemain(165, 56),
                new Pemain(171, 72), new Pemain(166, 56)));

        // Menyimpan data pemain tim B dalam array list
        List<Pemain> timB = new ArrayList<>(Arrays.asList(
                new Pemain(170, 66), new Pemain(167, 60), new Pemain(165, 59), new Pemain(166, 58),
                new Pemain(168, 58), new Pemain(175, 71), new Pemain(172, 68), new Pemain(171, 68),
                new Pemain(168, 65), new Pemain(169, 60)));

        // a. Sort berdasarkan getTinggi()
        System.out.println("\nTinggi Ascending Tim A:");
        timA.stream().map(p -> p.getTinggi()).sorted().forEach(System.out::println);

        System.out.println("\nTinggi Descending Tim A:");
        timA.stream().map(p -> p.getTinggi()).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // b. Sort berdasarkan getBerat()
        System.out.println("\nBerat Ascending Tim B:");
        timB.stream().map(p -> p.getBerat()).sorted().forEach(System.out::println);

        System.out.println("\nBerat Descending Tim B:");
        timB.stream().map(p -> p.getBerat()).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // c. Nilai maksimum dan minimum
        Pemain maxTinggiA = Collections.max(timA, Comparator.comparingInt(p -> p.getTinggi()));
        Pemain minTinggiA = Collections.min(timA, Comparator.comparingInt(p -> p.getTinggi()));
        Pemain maxBeratA = Collections.max(timA, Comparator.comparingInt(p -> p.getBerat()));
        Pemain minBeratA = Collections.min(timA, Comparator.comparingInt(p -> p.getBerat()));

        Pemain maxTinggiB = Collections.max(timB, Comparator.comparingInt(p -> p.getTinggi()));
        Pemain minTinggiB = Collections.min(timB, Comparator.comparingInt(p -> p.getTinggi()));
        Pemain maxBeratB = Collections.max(timB, Comparator.comparingInt(p -> p.getBerat()));
        Pemain minBeratB = Collections.min(timB, Comparator.comparingInt(p -> p.getBerat()));

        System.out.println("\nMaksimum Tinggi Tim A: " + maxTinggiA.getTinggi());
        System.out.println("Minimum Tinggi Tim A: " + minTinggiA.getTinggi());
        System.out.println("Maksimum Berat Tim A: " + maxBeratA.getBerat());
        System.out.println("Minimum Berat Tim A: " + minBeratA.getBerat());
        System.out.println("\nMaksimum Tinggi Tim B: " + maxTinggiB.getTinggi());
        System.out.println("Minimum Tinggi Tim B: " + minTinggiB.getTinggi());
        System.out.println("Maksimum Berat Tim B: " + maxBeratB.getBerat());
        System.out.println("Minimum Berat Tim B: " + minBeratB.getBerat());

        // d. Copy Tim B ke Tim C
        List<Pemain> timC = new ArrayList<>(timB);
        System.out.println("\nTim C (Copy dari Tim B):");
        timC.forEach(System.out::println);

        // 2. Binary Search Implementasi
        // Sort getTinggi() badan tim B
        List<Integer> tinggiB = new ArrayList<>();
        for (Pemain p : timB)
            tinggiB.add(p.getTinggi());
        Collections.sort(tinggiB);

        System.out.println("\nJumlah pemain Tim B getTinggi() 168: " + Collections.frequency(tinggiB, 168));
        System.out.println("Jumlah pemain Tim B getTinggi() 160: " + Collections.frequency(tinggiB, 160));

        List<Integer> beratA = new ArrayList<>();
        for (Pemain p : timA)
            beratA.add(p.getBerat());
        Collections.sort(beratA);

        System.out.println("Jumlah pemain Tim A getBerat() 56: " + Collections.frequency(beratA, 56));
        System.out.println("Jumlah pemain Tim A getBerat() 53: " + Collections.frequency(beratA, 53));

        // d. Apakah ada pemain Tim A dengan getTinggi()/getBerat() yang sama dengan Tim B?
        Set<Integer> tinggiA = new HashSet<>();
        Set<Integer> beratB = new HashSet<>();
        for (Pemain p : timA)
            tinggiA.add(p.getTinggi());
        for (Pemain p : timB)
            beratB.add(p.getBerat());

        boolean adaSamaTinggi = timB.stream().anyMatch(p -> tinggiA.contains(p.getTinggi()));
        boolean adaSamaBerat = timA.stream().anyMatch(p -> beratB.contains(p.getBerat()));

        System.out.println("\nAda getTinggi() yang sama antara Tim A dan Tim B? " + adaSamaTinggi);
        System.out.println("Ada getBerat() yang sama antara Tim A dan Tim B? " + adaSamaBerat);
    }
}
