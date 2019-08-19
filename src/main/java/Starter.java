import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Starter
{
    public static void main(String[] args)
    {
        try
        {
            String url = "https://lenta.ru";
            Document document = Jsoup.connect(url).get();
            Elements images = document.select("img[src~=(.+)(png|jpg)]");
            images.forEach(image -> System.out.println(image.attr("src")));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
