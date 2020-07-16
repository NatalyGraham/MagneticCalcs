package UI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunFemm {

    public RunFemm(String femmPath, String luaScriptPath) throws IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder(femmPath,
                luaScriptPath);
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
