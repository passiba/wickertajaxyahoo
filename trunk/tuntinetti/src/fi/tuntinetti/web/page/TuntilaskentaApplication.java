package fi.tuntinetti.web.page;

import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequestCycleProcessor;
import org.apache.wicket.protocol.http.request.CryptedUrlWebRequestCodingStrategy;
import org.apache.wicket.protocol.http.request.WebRequestCodingStrategy;
import org.apache.wicket.request.IRequestCodingStrategy;
import org.apache.wicket.request.IRequestCycleProcessor;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Tuntilaskenta sovelluksen wicket application perusluokka.Wicket framework luokan perusluokka jonka pohjalta rakentuu
 * sovelluksen rakentaminen.
 * 
 * @see fi.tuntinetti.Start#main(String[])
 */
public class TuntilaskentaApplication extends WebApplication
{    
    /**
     * Constructor
     */
	public TuntilaskentaApplication()
	{
	}

        @Override
        public Class<TemplatesListPage> getHomePage() {
          return TemplatesListPage.class;
        }
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	/*public Class<DiscountsList> getHomePage()
	{
		return   DiscountsList.class;
	}*/

        

        /**
         * Alustetaan uusi Wicket Sessio olio uuden k�ytt�j�n session tallentamiseksi
         * 
         * @param request
         * @param response
         * @return fi.tuntinetti.TuntilaskentaSession
         */
        @Override
     public Session newSession(Request request, Response response) {
       // return new BibleStudySession(request);
        return new  TuntilaskentaSession(request);
    }

    private ApplicationContext getContext() {
        return WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
    }

   @Override
    protected void init() {
      // super.init();
       addComponentInstantiationListener(new SpringComponentInjector(
                this));

        //authorization settings
        //BibleStudyAuthorizationStrategy authStrat = new BibleStudyAuthorizationStrategy();
       // getMarkupSettings().setStripWicketTags(true);

    }
   
   @Override
   protected IRequestCycleProcessor newRequestCycleProcessor() {
       return new WebRequestCycleProcessor() {

           @Override
           protected IRequestCodingStrategy newRequestCodingStrategy() {
               return new CryptedUrlWebRequestCodingStrategy(
                       new WebRequestCodingStrategy());
           }
       };
   }


}
