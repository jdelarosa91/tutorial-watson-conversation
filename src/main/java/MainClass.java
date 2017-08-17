import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import java.io.*;
import java.util.Properties;

public class MainClass {
    public static void main(String[] args) throws IOException {
        //Setting up property file with configuration
        Properties prop = new Properties();
        InputStream inputProperty = new FileInputStream("config.properties");
        prop.load(inputProperty);

        System.out.println("-----Watson Conversation Chatbot-----");

        //Setting every property value.
        String workspaceId = prop.getProperty("WORKSPACE_ID");
        String username = prop.getProperty("USERNAME");
        String password = prop.getProperty("PASSWORD");
        ConvesationService service = new ConvesationService(username, password, workspaceId);

        MessageResponse response = null;

        do {
            //Getting inputs from system input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            response = service.getResponse(input, response);
            System.out.println(response.getOutput().get("text"));
        } while (true);
    }
}
