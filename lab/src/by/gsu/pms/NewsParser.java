package by.gsu.pms;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class NewsParser extends DefaultHandler {
    private SportNews sportNews = null;
    private boolean isNews = false;
    private String tempElement = null;

    private List<SportNews> newsList = new ArrayList<>();

    public List<SportNews> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<SportNews> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        tempElement = qName;
        if (tempElement.equals("item")) {
            isNews = true;
            sportNews = new SportNews();


        }
    }

    @Override
    public void characters(char[] ch, int start, int end) {
        String string = new String(ch, start, end).replace("\n", "").trim();
        if (sportNews != null) {
            if (tempElement.equals("title") && !string.isEmpty()) {
                sportNews.setTitle(string);
            }
            if (tempElement.equals("description") && !string.isEmpty()) {
                sportNews.setDescription(string);
            }
            if (tempElement.equals("pubDate") && !string.isEmpty()) {

                sportNews.setPubDate(string);
            }

        }

    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        if (isNews) {
            isNews = false;
            newsList.add(sportNews);
        }
    }


}
