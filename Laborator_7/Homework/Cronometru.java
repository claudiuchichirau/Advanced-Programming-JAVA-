package laborator_7.homework;

import java.util.concurrent.*;
import laborator_7.homework.MapExplorer;

public class Cronometru implements Runnable {
    private MapExplorer explorer;
    private ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
    private int limitaDeTimp; // limita de timp in secunde
    private long timpDeStart;

    public Cronometru(int limitaDeTimp, MapExplorer explorer) {
        this.limitaDeTimp = limitaDeTimp;
        this.explorer = explorer;
    }

    public void start() {
        timer.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS); // ruleaza cronometrul la fiecare secunda
        timpDeStart = System.currentTimeMillis();
    }

    public void stop() {
        timer.shutdownNow(); // opreste cronometrul
    }

    @Override
    public void run() {
        long timpDeRulare = System.currentTimeMillis() - timpDeStart;
        if(timpDeRulare / 1000 == 15 || timpDeRulare / 1000 == 30 || timpDeRulare / 1000 == 45 || timpDeRulare / 1000 == 50 || timpDeRulare / 1000 == 55)
            System.out.println("Exploration runtime: " + timpDeRulare / 1000 + " seconds");

        if (timpDeRulare / 1000 > limitaDeTimp) {
            System.out.println("The runtime has exceeded the time limit of " + limitaDeTimp + " seconds.\nExploration completed insuccessfully!");
            stop();
            explorer.countTokens();
            explorer.stopAllRobots();
        }
    }
}
