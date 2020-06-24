package UI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunFemm {

    /*public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("C:\\femm42\\bin\\femm.exe", "-lua-script=D:\\Projects\\MagneticProjects\\somescript.lua");
        //builder.command("-lua-script=D:\\Projects\\MagneticProjects\\somescript.lua");
        builder.redirectErrorStream( true );
        Process process = builder.start();

        try ( BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream())) ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        process.waitFor();

    }//*/

    public RunFemm() throws IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder("C:\\femm42\\bin\\femm.exe",
                "-lua-script=D:\\Projects\\MagneticProjects\\somescript.lua");
        builder.redirectErrorStream( true );
        Process process = builder.start();

        try ( BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream())) ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        process.waitFor();

    }
}
