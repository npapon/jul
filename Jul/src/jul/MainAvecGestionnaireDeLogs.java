package jul;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainAvecGestionnaireDeLogs {

    // on récupére notre logManager
    public static final LogManager logManager = LogManager.getLogManager();
    // on récupère notre logger
    public static final Logger     LOGGER     = Logger.getLogger( MainAvecGestionnaireDeLogs.class.getName() );

    // comme lorsqu'on paramétré directement les infos de log dans la classe, on
    // le fait dans le bloc statique lancé à l'initialisation de la classe
    // readConfiguration permet de lire le fichier situé à la racine du projet
    // log.properties
    static {
        try {
            logManager.readConfiguration( new FileInputStream( "log.properties" ) );
        } catch ( SecurityException | IOException e ) {
            // TODO Auto-generated catch block
            LOGGER.log( Level.SEVERE, "Fichier illisible", e );
        }
    }

    public static void main( String[] args ) {

        LOGGER.log( Level.INFO, "hi" );

        try {
            int numerateur = 5;
            int denominateur = 0;
            int[] division = { numerateur, denominateur };
            LOGGER.log( Level.INFO, " division  : {numerateur} / {denominateur}", division );
            int result = numerateur / denominateur;

        } catch (

        ArithmeticException e ) {
            LOGGER.log( Level.SEVERE, " division impossible", e );

        }
    }

}
