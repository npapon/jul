package jul;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainJulPerf {

    private final static LogManager logManager = LogManager.getLogManager();
    private final static Logger     LOGGER     = Logger.getLogger( MainJulPerf.class.getName() );

    static {
        try {
            logManager.readConfiguration( new FileInputStream( "log.properties" ) );
        } catch ( SecurityException | IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private double randomValue = Math.random() * 10;
    private int    boucle      = 10_000_000;

    public void incremente() {

        for ( int i = 0; i < boucle; i++ ) {
            randomValue += 1;
            if ( LOGGER.isLoggable( Level.INFO ) ) {
                LOGGER.log( Level.INFO, "valeur random " + randomValue );
            }
        }
    }

    public static void main( String[] args ) {

        MainJulPerf mainJulPerf = new MainJulPerf();

        long debut = System.currentTimeMillis();
        mainJulPerf.incremente();
        long fin = System.currentTimeMillis();
        long tempsEcoule = fin - debut;
        System.out.println( tempsEcoule );
        LOGGER.log( Level.INFO, "temp écoulé " + tempsEcoule );

    }

}
