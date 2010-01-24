package fi.tuntinetti.web.page;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;
import org.apache.wicket.model.IModel;


public class BasePage extends WebPage {

    
      /**
     * Constructor
     */
    public  BasePage()
    {

        super();

       

      
           
        add(new FeedbackPanel("feedback"));
         add(new BaseYuiPageBehavior());
    }
    /**
	 * Construct.
	 *
	 * @param model
     */
    public BasePage(IModel<?> model)
   {
	      super(model);

       add(new FeedbackPanel("feedback"));

       add(new BaseYuiPageBehavior());

   }
      private class BaseYuiPageBehavior extends AbstractDefaultAjaxBehavior {

        @Override
        public void renderHead(IHeaderResponse response) {
            super.renderHead(response);
            response.renderJavascriptReference(new JavascriptResourceReference(BasePage.class, "js/yahoo-dom-event.js"));
            response.renderJavascriptReference(new JavascriptResourceReference(BasePage.class, "js/dragdrop-min.js"));
            response.renderJavascriptReference(new JavascriptResourceReference(BasePage.class, "js/element-min.js"));
            response.renderJavascriptReference(new JavascriptResourceReference(BasePage.class, "js/datasource-min.js"));
            response.renderJavascriptReference(new JavascriptResourceReference(BasePage.class, "js/datatable-min.js"));
            response.renderJavascriptReference(new JavascriptResourceReference(BasePage.class, "js/data.js"));
            response.renderCSSReference(new CompressedResourceReference(BasePage.class, "css/fonts-min.css"));
            response.renderCSSReference(new CompressedResourceReference(BasePage.class, "css/datatable.css"));
           /* response.renderJavascript("var " + getJsVarName() + ";", getJsVarName());
            response.renderOnDomReadyJavascript(getJsVarName() + " = new YAHOO.widget.WicketAutoComplete('"
                    + textField.getMarkupId() + "', '" + getCallbackUrl() + "', '" + container.getMarkupId() + "');");*/
        }

        @Override
        protected void respond(AjaxRequestTarget art) {
           
        }

      /*  @Override
        protected void respond(AjaxRequestTarget target) {*/


    }

    
}


