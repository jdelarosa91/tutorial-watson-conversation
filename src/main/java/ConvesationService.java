import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import java.util.Map;

public class ConvesationService {

    private String workspaceId;
    private ConversationService service = new ConversationService("2017-05-26");

    public ConvesationService(String username, String password, String workspaceId){
        this.workspaceId = workspaceId;
        service.setUsernameAndPassword(username, password);
    }

    public MessageResponse getResponse(String input, MessageResponse response) {
        //If request is not null, cotnext is passed.
        MessageRequest request;
        if (response != null) {
            request = new MessageRequest.Builder().inputText(input).context(response.getContext()).build();
        }
        else {
            request = new MessageRequest.Builder().inputText(input).build();
        }
        return service.message(workspaceId, request).execute();
    }

}
