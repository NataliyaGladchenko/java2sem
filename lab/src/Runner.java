import by.gsu.pms.NewsParser;
import by.gsu.pms.SportNews;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            NewsParser newsParser = new NewsParser();
            SAXParser parser = factory.newSAXParser();
            final String FILE_NAME = "src//news.xml";
            parser.parse(new File(FILE_NAME), newsParser);

            List<SportNews> sportNewsList = newsParser.getNewsList();
            System.out.println(sportNewsList.size());
            for (SportNews sportNews : sportNewsList) {
                System.out.println(sportNews);
            }
        } catch (SAXException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

}
