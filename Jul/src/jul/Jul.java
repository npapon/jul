package jul;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Jul {

    // on peut mettre en nom du logger un string au choix
    // private static final Logger LOGGER = Logger.getLogger( "nom du logger" );
    // ou le nom de la classe (mais le paramétrage sera plus fin)
    // private static final Logger LOGGER = Logger.getLogger(
    // Jul.class.getName() );

    // ou le nom du package

    // on récupère un Logger de la classe logger et on l'initie en static final
    // pour que ca soit le meme pour tous
    private static final Logger LOGGER = Logger.getLogger( Jul.class.getPackage().getName() );

    // Le bloc statique est exécuté par un « ClassLoader » au chargement de la
    // classe
    static {
        try {
            FileHandler fireHandler = new FileHandler( "fichier.log" );
            fireHandler.setFormatter( new SimpleFormatter() );
            LOGGER.addHandler( fireHandler );
            LOGGER.setLevel( Level.SEVERE );
        } catch ( SecurityException | IOException e ) {
            LOGGER.log( Level.SEVERE, "Fichier log non lisible", e );
        }
    }

    public static void main( String[] args ) {
        Utilisateur npapon = new Utilisateur( "Nicolas", "Papon" );
        LOGGER.log( Level.INFO, "L'utilisateur qui s'est connecté est " + npapon.getPrenom() + " " + npapon.getNom() );

        LOGGER.info( "L'utilisateur qui s'est connecté est " + npapon.getPrenom() + " " + npapon.getNom() );

        int chiffre = 4;
        int chiffre2 = 0;

        try {

            Integer[] tableau = { chiffre, chiffre2 };
            LOGGER.log( Level.INFO, "Operation menée " + "{0}" + "/" + "{1}", tableau );
            int resultat0 = 4 / 0;

        } catch ( ArithmeticException e ) {
            LOGGER.log( Level.SEVERE, "" + e.getMessage() );
        }

        try {
            int resultat = 4 / 0;
        } catch ( ArithmeticException e ) {
            LOGGER.severe( "Exception remontée" + e.getMessage() );
            ;
        }
    }

}
