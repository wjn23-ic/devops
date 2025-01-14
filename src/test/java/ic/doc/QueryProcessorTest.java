package ic.doc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutAsimov() throws Exception {
        assertThat(queryProcessor.process("Asimov"), containsString("science fiction"));
    }

    @Test
    public void knowsAboutClausewitz() throws Exception {
        assertThat(queryProcessor.process("Clausewitz"), containsString("On War"));
    }

    @Test
    public void knowsAboutMeiji() throws Exception {
        assertThat(queryProcessor.process("Meiji"), containsString("Emperor"));
    }

    @Test
    public void knowsAboutRowling() throws Exception {
        assertThat(queryProcessor.process("Rowling"), containsString("Harry Potter"));
    }

    @Test
    public void knowsAboutMJ() throws Exception {
        assertThat(queryProcessor.process("MJ"), containsString("King of Pop"));
    }

    @Test
    public void knowsAboutDarwin() throws Exception {
        assertThat(queryProcessor.process("Darwin"), containsString("evolutionary biology"));
    }

    @Test
    public void knowsAboutEinstein() throws Exception {
        assertThat(queryProcessor.process("Einstein"), containsString("quantum mechanics"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
