package io.eddumelendez.aquillian;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Location("/")
public class HomePage {

    @FindBy(tagName = "h1")
    private WebElement welcomeMessageElement;

    public void assertOnWelcomePage() {
        assertThat(this.welcomeMessageElement.getText().trim(), is("Hello world!"));
    }

}
