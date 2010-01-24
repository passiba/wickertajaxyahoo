package fi.tuntinetti.web.page;


import java.util.Locale;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

public class TuntilaskentaSession extends WebSession {

 /**
 * Tuntilaskenta sovelluksen wicket application Session luokka,joka tallentaa sovelluksen käyttäjäkohtaiset sessiotiedot
 * 
 */
  public static TuntilaskentaSession get() {
    return (TuntilaskentaSession) Session.get();
  }

 

  public TuntilaskentaSession(Request request) {
    super(request);
    setLocale(new Locale("fi"));
  }
   
}
