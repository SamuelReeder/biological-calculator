package cs20models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A class to model the problem or situation your program solves
 *
 * @author cheng
 */
public class GeneticMaterialModel {

    private String dNA, tRNA, mRNA, dNAComplementaryStrand, aminoAcid, input, output, inputType, outputType;
    private boolean error;

    public GeneticMaterialModel() {
        this.dNA = "";
        this.tRNA = "";
        this.mRNA = "";
        this.dNAComplementaryStrand = "";
        this.aminoAcid = "";
        this.input = "";
        this.output = "";
        this.inputType = "DNA";
        this.outputType = "DNA";
        this.error = false;
    }

    public String getDNAComplementaryStrand() {
        return this.dNAComplementaryStrand;
    }

    public void setDNAComplementaryStrand(String str) {
        this.dNAComplementaryStrand = str;
    }

    public String getDNA() {
        return this.dNA;
    }

    public void setDNA(String str) {
        this.dNA = str;
    }

    public String gettRNA() {
        return this.tRNA;
    }

    public void settRNA(String str) {
        this.tRNA = str;
    }

    public String getmRNA() {
        return this.mRNA;
    }

    public void setmRNA(String str) {
        this.mRNA = str;
    }

    public String getAminoAcid() {
        return this.aminoAcid;
    }

    public void setAminoAcid(String str) {
        this.aminoAcid = str;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String str) {
        this.input = str;
    }

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String str) {
        this.output = str;
    }

    public String getInputType() {
        return this.inputType;
    }

    public void setInputType(String str) {
        this.inputType = str;
    }

    public String getOutputType() {
        return this.outputType;
    }

    public void setOutputType(String str) {
        this.outputType = str;
    }

    public boolean getError() {
        return this.error;
    }

    public void reset() {
        this.dNA = "";
        this.dNAComplementaryStrand = "";
        this.tRNA = "";
        this.mRNA = "";
        this.aminoAcid = "";
        this.input = "";
        this.output = "";
        this.error = false;
    }

    public void error(char ch) {
        this.error = true;
        this.output = "Your " + this.inputType + " sequence is invalid," + " refrain from using the character \"" + ch + "\".";
    }

    public void resolveError() {
        String errorCh;
        String fix;
        if (this.inputType.equals("DNA")) {
            errorCh = "U";
            fix = "T";
        } else {
            errorCh = "T";
            fix = "U";
        }
        String newStr = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.toString(input.charAt(i)).equals(errorCh)) {
                newStr += fix;
            } else {
                newStr += Character.toString(input.charAt(i));
            }
        }
        this.input = newStr;
    }

    public void formatInputAndOutput() {
        String formattedStr = "";
        for (int i = 0; i < this.input.length(); i++) {
            formattedStr += this.input.charAt(i);
            if ((i + 1) % 3 == 0) {
                formattedStr += " ";
            }
        }
        this.input = formattedStr;
        if (this.outputType.equals("Amino Acid")) {
            return;
        }
        formattedStr = "";
        for (int i = 0; i < this.output.length(); i++) {
            formattedStr += this.output.charAt(i);
            if ((i + 1) % 3 == 0 && i > 1) {
                formattedStr += " ";
            }
        }
        this.output = formattedStr;
    }

    public void deFormat() {
        String deFormattedStr = "";
        for (int i = 0; i < this.input.length(); i++) {
            if (!this.input.substring(i, i + 1).equals(" ")) {
                deFormattedStr += this.input.substring(i, i + 1);
            }
        }
        this.input = deFormattedStr;
        if (this.outputType.equals("Amino Acid")) {
            return;
        }
        deFormattedStr = "";
        for (int i = 0; i < this.output.length(); i++) {
            if (!this.output.substring(i, i + 1).equals(" ")) {
                deFormattedStr += this.output.substring(i, i + 1);
            }
        }
        this.output = deFormattedStr;
    }

    public void doConversion() {
        this.input = this.input.toUpperCase();
        if (this.inputType.equals("DNA")) {
            for (int i = 0; i < this.input.length(); i++) {
                if (this.input.charAt(i) == 'A') {
                    this.dNA += "A";
                    this.dNAComplementaryStrand += "T";
                    this.mRNA += "U";
                    this.tRNA += "A";
                } else if (this.input.charAt(i) == 'T') {
                    this.dNA += "T";
                    this.dNAComplementaryStrand += "A";
                    this.mRNA += "A";
                    this.tRNA += "U";
                } else if (this.input.charAt(i) == 'G') {
                    this.dNA += "G";
                    this.dNAComplementaryStrand += "C";
                    this.mRNA += "C";
                    this.tRNA += "G";
                } else if (this.input.charAt(i) == 'C') {
                    this.dNA += "C";
                    this.dNAComplementaryStrand += "G";
                    this.mRNA += "G";
                    this.tRNA += "C";
                } else if (this.input.charAt(i) == ' ') {
                    continue;
                } else {
                    error(this.input.charAt(i));
                    return;
                }
            }
        } else if (this.inputType.equals("mRNA")) {
            for (int i = 0; i < this.input.length(); i++) {
                if (this.input.charAt(i) == 'A') {
                    this.dNA += "T";
                    this.dNAComplementaryStrand += "A";
                    this.mRNA += "A";
                    this.tRNA += "U";
                } else if (this.input.charAt(i) == 'U') {
                    this.dNA += "A";
                    this.dNAComplementaryStrand += "T";
                    this.mRNA += "U";
                    this.tRNA += "A";
                } else if (this.input.charAt(i) == 'G') {
                    this.dNA += "C";
                    this.dNAComplementaryStrand += "G";
                    this.mRNA += "G";
                    this.tRNA += "C";
                } else if (this.input.charAt(i) == 'C') {
                    this.dNA += "G";
                    this.dNAComplementaryStrand += "C";
                    this.mRNA += "C";
                    this.tRNA += "G";
                } else if (this.input.charAt(i) == ' ') {
                    continue;
                } else {
                    error(this.input.charAt(i));
                    return;
                }
            }
        } else if (this.inputType.equals("tRNA")) {
            for (int i = 0; i < this.input.length(); i++) {
                if (this.input.charAt(i) == 'A') {
                    this.dNA += "A";
                    this.dNAComplementaryStrand += "T";
                    this.mRNA += "U";
                    this.tRNA += "A";
                } else if (this.input.charAt(i) == 'U') {
                    this.dNA += "T";
                    this.dNAComplementaryStrand += "A";
                    this.mRNA += "A";
                    this.tRNA += "U";
                } else if (this.input.charAt(i) == 'G') {
                    this.dNA += "G";
                    this.dNAComplementaryStrand += "C";
                    this.mRNA += "C";
                    this.tRNA += "G";
                } else if (this.input.charAt(i) == 'C') {
                    this.dNA += "C";
                    this.dNAComplementaryStrand += "G";
                    this.mRNA += "G";
                    this.tRNA += "C";
                } else if (this.input.charAt(i) == ' ') {
                    continue;
                } else {
                    error(this.input.charAt(i));
                    return;
                }
            }
        }

        if (this.outputType.equals("DNA")) {
            this.output = this.dNA;
        } else if (this.outputType.equals("DNA Complementary Strand")) {
            this.output = this.dNAComplementaryStrand;
        } else if (this.outputType.equals("mRNA")) {
            this.output = this.mRNA;
        } else if (this.outputType.equals("tRNA")) {
            this.output = this.tRNA;
        } else if (this.outputType.equals("Amino Acid")) {
            buildAminoAcid();
            this.output = this.aminoAcid;
        }
    }

    public void buildAminoAcid() {
        if (this.mRNA.length() < 3) {
            aminoAcid = "You need three nucleotides to create an Amino Acid";
            return;
        }
        for (int i = 0; i < this.mRNA.length(); i += 3) {
            String codon = this.mRNA.substring(i, i + 3);
            if (codon.equals("UUU") || codon.equals("UUC")) {
                this.aminoAcid += "Phenylalanine ";
            } else if (codon.equals("UUA") || codon.equals("UUG") || codon.equals("CUU") || codon.equals("CUC") || codon.equals("CUA") || codon.equals("CUG")) {
                this.aminoAcid += "Leucine ";
            } else if (codon.equals("UCU") || codon.equals("UCC") || codon.equals("UCA") || codon.equals("UCG") || codon.equals("AGU") || codon.equals("AGC")) {
                this.aminoAcid += "Serine ";
            } else if (codon.equals("UAU") || codon.equals("UAC")) {
                this.aminoAcid += "Tyrosine ";
            } else if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
                this.aminoAcid += "STOP ";
            } else if (codon.equals("UGU") || codon.equals("UGC")) {
                this.aminoAcid += "Cysteine ";
            } else if (codon.equals("UGG")) {
                this.aminoAcid += "Trytophan ";
            } else if (codon.equals("CCU") || codon.equals("CCC") || codon.equals("CCA") || codon.equals("CCG")) {
                this.aminoAcid += "Proline ";
            } else if (codon.equals("CAU") || codon.equals("CAC")) {
                this.aminoAcid += "Histidine ";
            } else if (codon.equals("CAA") || codon.equals("CAG")) {
                this.aminoAcid += "Glutamine ";
            } else if (codon.equals("CGU") || codon.equals("CGC") || codon.equals("CGA") || codon.equals("CGG") || codon.equals("AGA") || codon.equals("AGG")) {
                this.aminoAcid += "Arginine ";
            } else if (codon.equals("AUU") || codon.equals("AUC") || codon.equals("AUA")) {
                this.aminoAcid += "Isoleucine ";
            } else if (codon.equals("AUG")) {
                this.aminoAcid += "Methionine ";
            } else if (codon.equals("ACU") || codon.equals("ACC") || codon.equals("ACA") || codon.equals("ACG")) {
                this.aminoAcid += "Threonine ";
            } else if (codon.equals("AAU") || codon.equals("AAC")) {
                this.aminoAcid += "Asparagine ";
            } else if (codon.equals("AAA") || codon.equals("AAG")) {
                this.aminoAcid += "Lysine ";
            } else if (codon.equals("GUU") || codon.equals("GUC") || codon.equals("GUA") || codon.equals("GUG   ")) {
                this.aminoAcid += "Valine ";
            } else if (codon.equals("GCU") || codon.equals("GCC") || codon.equals("GCA") || codon.equals("GCG")) {
                this.aminoAcid += "Alanine ";
            } else if (codon.equals("GAU") || codon.equals("GAC")) {
                this.aminoAcid += "Aspartic Acid ";
            } else if (codon.equals("GAA") || codon.equals("GAG")) {
                this.aminoAcid += "Glutamic Acid ";
            } else if (codon.equals("GGU") || codon.equals("GGC") || codon.equals("GGA") || codon.equals("GGG")) {
                this.aminoAcid += "Threonine ";
            } else {
                this.aminoAcid += "INVALID CODON";
            }
            if (this.mRNA.substring(i + 3).length() < 3 && !this.mRNA.substring(i + 3).equals("")) {
                System.out.println("." + this.mRNA.substring(i + 3) + ".");
                this.aminoAcid += "INVALID CODON";
                break;
            }
        }
    }

    public void saveToFile(String pathToFile) throws IOException {
        FileWriter fw = new FileWriter(pathToFile);
        PrintWriter pw = new PrintWriter(fw);
        String saveStr = this.outputType + "\n" + this.inputType + "\n" + this.input;
        pw.print(saveStr);
        pw.close();
    }

    public void openFromFile(String pathToFile) throws IOException {
        File f = new File(pathToFile);
        Scanner sc = new Scanner(f);
        for (int i = 0; sc.hasNextLine(); i++) {
            if (i == 0) {
                this.outputType = sc.nextLine();
            } else if (i == 1) {
                this.inputType = sc.nextLine();
            } else {
                this.input = sc.nextLine();
            }
        }
    }
}
