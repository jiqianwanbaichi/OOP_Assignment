import java.io.*; // for File
import java.util.*; // for Scanner

public class DNA {
    public static void main(String args[]) throws FileNotFoundException {
        System.out.println(
                "This program reports information about DNA\nnucleotide sequences that may encode proteins.\nInput file name?");

        Scanner scan = new Scanner(System.in);
        String inTxt = scan.next();
        System.out.println("Output file name?");
        String outTxt = scan.next();
        // input txt and output txt
        Scanner input = new Scanner(new File(inTxt));
        PrintStream output = new PrintStream(new File(outTxt));

        output.println(
                "This program reports information about DNA\nnucleotide sequences that may encode proteins.\nInput file name?");
        output.println(inTxt);
        output.println("Output file name?\n" + outTxt + "\n");

        while (input.hasNextLine()) {
            String line = input.nextLine();
            output.println("Region Name:" + line);

            line = input.nextLine();
            line = line.toUpperCase();
            output.println("Nucleotides:" + line);

            // print Nuc. Counts
            int[] countArr = nucCounts(line);
            output.println("Nuc. Counts:" + Arrays.toString(countArr));

            // print Total Mass%
            double[] massACGT_ = totalMass(line, countArr);
            double[] massACGT = Arrays.copyOfRange(massACGT_, 0, 4);
            output
                    .println("Total Mass%: [" + String.format("%.1f", massACGT[0]).toString() + ", "
                            + String.format("%.1f", massACGT[1]).toString() + ", "
                            + String.format("%.1f", massACGT[2]).toString() + ", "
                            + String.format("%.1f", massACGT[3]).toString()
                            + "] of " + String.format("%.1f", massACGT_[4]).toString());

            // print Codons List
            String[] condonlist = codonsList(line);
            output.println("Codons List:" + Arrays.toString(condonlist));

            // print Is Protein?
            output.println("Is Protein?:" + isProtein(condonlist, massACGT));

            output.println();
        }

    }

    private static int[] nucCounts(String line) {

        char[] charArr = line.toCharArray();
        int[] countArr = new int[4];
        Arrays.fill(countArr, 0);
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'A')
                countArr[0]++;
            if (charArr[i] == 'C')
                countArr[1]++;
            if (charArr[i] == 'G')
                countArr[2]++;
            if (charArr[i] == 'T')
                countArr[3]++;
        }

        return countArr;
    }

    private static double[] totalMass(String line, int[] countArr) {
        double[] mass = new double[5];
        double totalWeight = 0;
        totalWeight = countArr[0] * 135.128 + countArr[1] * 111.103 + countArr[2] * 151.128
                + countArr[3] * 125.107;
        int junkNum = line.length() - countArr[0] - countArr[1] - countArr[2] - countArr[3];
        totalWeight += junkNum * 100;
        mass[4] = totalWeight;
        mass[0] = countArr[0] * 135.128 / totalWeight * 100;
        mass[1] = countArr[1] * 111.103 / totalWeight * 100;
        mass[2] = countArr[2] * 151.128 / totalWeight * 100;
        mass[3] = countArr[3] * 125.107 / totalWeight * 100;
        return mass;
    }

    private static String[] codonsList(String line) {
        int count_ = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '-')
                count_++;
        }

        String[] condons = new String[(line.length() - count_) / 3];
        int condonIdx = 0;
        for (int i = 0; i < line.length(); i = i + 3) {
            StringBuilder builder = new StringBuilder();
            for (int j = i; j < i + 3; j++) {
                if (line.charAt(j) == '-') {
                    i++;
                    continue;
                }
                builder.append(line.charAt(j));
            }
            String condon = builder.toString();
            condons[condonIdx] = condon;
            condonIdx++;
        }
        return condons;
    }

    private static boolean isProtein(String[] condonlist, double[] massACGT) {

        if (condonlist[0] != "ATG")
            return false;
        if (condonlist[condonlist.length - 1] != "TAA" && condonlist[condonlist.length - 1] != "TAG"
                && condonlist[condonlist.length - 1] != "TGA")
            return false;
        if (condonlist.length < 5)
            return false;
        if (massACGT[1] + massACGT[2] < 30)
            return false;
        else
            return true;
    }
}
