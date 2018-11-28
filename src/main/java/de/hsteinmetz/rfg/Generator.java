/**
 *
 */
package de.hsteinmetz.rfg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Hendrik Steinmetz
 */
public class Generator {

    private static FileWriter fw;
    private static BufferedWriter bw;

    // TODO add path parameter
    public static void generate(String name, int size) {
        String dir = System.getProperty("user.dir");
        java.io.File f = new java.io.File(dir + "\\" + name);
        try {
            System.out.println("Creating File \"" + name + "\"...");
            f.createNewFile();

            System.out.println("Opening Stream to file...");
            fw = new java.io.FileWriter(f);
            bw = new BufferedWriter(fw);

            System.out.println("Genererating random String...");
            String rndm = generateRandomString(size);

            System.out.println("Writing random String...");
            bw.write(rndm);
            System.out.println("Flushing output...");
            bw.flush();
            System.out.println("Closing Stream...");
            bw.close();
            System.out.println("Success");
        }
        catch (IOException e) {
            System.out.println(
                    "Error while creating file. Read below for further "
                            + "information\n\n");
            e.printStackTrace();
        }
    }

    private static String generateRandomString(int size) {
        StringBuffer sb = new StringBuffer();

        long now = new java.util.Date().getTime();
        Random rndm = new Random(now);

        for (int i = 0; i < size; i++) {
            sb.append((char) rndm.nextInt(50));
            if (i % 200 == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}