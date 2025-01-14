package ic.doc;

public class QueryProcessor {

    public String process(String query) {
        StringBuilder results = new StringBuilder();
        if (query.toLowerCase().contains("shakespeare")) {
            results.append("William Shakespeare (26 April 1564 - 23 April 1616) was an\n" +
                           "English poet, playwright, and actor, widely regarded as the greatest\n" +
                           "writer in the English language and the world's pre-eminent dramatist. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("asimov")) {
            results.append("Isaac Asimov (2 January 1920 - 6 April 1992) was an\n" +
                           "American writer and professor of Biochemistry, famous for\n" +
                           "his works of hard science fiction and popular science. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("clausewitz")) {
            results.append("Carl Philipp Gottfried von Clausewitz (1 July 1780 - 16 November 1831)\n" +
                           "was a Prussian general and military theorist. His most notable work,\n" +
                           "Vom Kriege (On War), remains unfinished and is considered a seminal\n" +
                           "treatise on military strategy and science.\n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("meiji")) {
            results.append("Mutsuhito (3 November 1852 - 30 July 1912), posthumously honored as\n" +
                           "Emperor Meiji, was the 122nd Emperor of Japan (1867-1912), and is\n" +
                           "known for the Meiji Restoration of 1868, which industrialised Japan,\n" +
                           "turning the isolationist island nation into a great power.\n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("rowling")) {
            results.append("J. K. Rowling (31 July 1965 - present) is a British author and\n" +
                           "philanthropist. She is best known for writing the Harry Potter\n" +
                           "fantasy series, published from 1997 to 2007. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("mj")) {
            results.append("Michael Joseph Jackson (August 29, 1958 – June 25, 2009) was an American\n" +
                           "singer, songwriter, dancer, and philanthropist. Dubbed the 'King of Pop',\n" +
                           "he is regarded as one of the most significant cultural figures ever. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("darwin")) {
            results.append("Charles Robert Darwin (12 February 1809 - 19 April 1882) was an\n" +
                           "English naturalist, geologist, and biologist, widely known for his\n" +
                           "contributions to evolutionary biology.\n");
            results.append(System.lineSeparator());
        }
        if (query.toLowerCase().contains("einstein")) {
            results.append("Albert Einstein (14 March 1879 - 18 April 1955) was a German-born\n" +
                           "theoretical physicist who is best known for developing the theory of\n" +
                           "relativity. Einstein also made important contributions to quantum mechanics.\n"
                           );
            results.append(System.lineSeparator());
        } 
        return results.toString();
    }
}
