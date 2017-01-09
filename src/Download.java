import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gosia on 2017-01-08.
 */
public class Download {
    private String jsonURL;
    private String jsonResult = "";

    public Download(String jsonURL){
        this.jsonURL = jsonURL;
    }

    public void download(){
        System.out.println(jsonURL);
        URL url = null;
        try {
            url = new URL(jsonURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(InputStream, "UTF-8"));

            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                jsonResult += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getJsonResult(){
        return  jsonResult;
    }
}
