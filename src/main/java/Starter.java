import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Starter
{
    public static void main(String[] args)
    {
        try
        {
            Document document = Jsoup.connect("https://lenta.ru").get();
            Elements images = document.select("img[src~=(.+)(png|jpg)]");
            images.forEach(Starter::parceImageElement);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage()); }
        finally {
            System.out.println("\nComplete !!!\n");
        }
    }

    private static void parceImageElement(Element image)
    {
        try
        {
            String[] tokens = image.attr("src").split("/");
            String fileName = tokens[tokens.length - 1];
            URL url = new URL(image.attr("src"));
            BufferedImage input = ImageIO.read(url);
            String pathname = "images/" + fileName;
            File output = new File(pathname);
            ImageIO.write(input, "PNG", output);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
