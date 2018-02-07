
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main (String[] args) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter a url: ");
        String input1 = lineScanner.nextLine();
        System.out.println("Enter the word to look for");
        String input2 = lineScanner.nextLine();
        System.out.println(wordcount(urlToString(input1), input2));
    }

    public static int wordcount(String toCount, String toCompare) {
        int indicator = 0;
        String[] transformer = toCount.split("[^a-zA-Z0-9]");
        for (int i = 0; i < transformer.length; i++) {
            if (transformer[i].compareToIgnoreCase(toCompare) == 0) {
                indicator++;
            }
        }
        return indicator;
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    }
