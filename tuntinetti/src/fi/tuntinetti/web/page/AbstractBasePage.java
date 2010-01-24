package fi.tuntinetti.web.page;

import org.apache.wicket.Component;
import org.apache.wicket.PageParameters;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public abstract class AbstractBasePage extends WebPage {
  public AbstractBasePage(PageParameters pars) {
    super(pars);

    WebMarkupContainer menu = new WebMarkupContainer("abp-menu");
    addMenuItem(menu, "index",TemplatesListPage.class);
    addMenuItem(menu, "book",TemplatesListPage.class);
    addMenuItem(menu, "examples", TemplatesListPage.class);
    addMenuItem(menu, "shop", TemplatesListPage.class);
    addMenuItem(menu, "support",TemplatesListPage.class);
    add(menu);
  }

  public AbstractBasePage() {
    this(null);
  }

  private void addMenuItem(WebMarkupContainer menu, final String id,
      Class page) {
    WebMarkupContainer container = new WebMarkupContainer(id);
    menu.add(container);
    container.add(new AbstractBehavior() {
      @Override
      public void onComponentTag(Component component, ComponentTag tag) {
        WebMarkupContainer wmc = (WebMarkupContainer) component;
        BookmarkablePageLink link = (BookmarkablePageLink) wmc
            .get(id);
        if (link.linksTo(getPage()))
          tag.put("class", tag.getAttributes().getString("class", "")
              + " active");
        super.onComponentTag(component, tag);
      }
    });
    container.add(new BookmarkablePageLink(id, page)
        .setAutoEnable(true));
  }
}
