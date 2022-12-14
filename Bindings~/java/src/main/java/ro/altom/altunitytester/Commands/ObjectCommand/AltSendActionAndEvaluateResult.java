package ro.altom.altunitytester.Commands.ObjectCommand;

import ro.altom.altunitytester.IMessageHandler;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.AltBaseCommand;

public class AltSendActionAndEvaluateResult extends AltBaseCommand {

    private AltSendActionAndEvaluateResultParams params;

    public AltSendActionAndEvaluateResult(IMessageHandler messageHandler, AltUnityObject altUnityObject,
            String command) {
        super(messageHandler);
        params = new AltSendActionAndEvaluateResultParams(altUnityObject);
        params.setCommandName(command);
    }

    public AltUnityObject Execute() {
        SendCommand(params);
        return recvall(params, AltUnityObject.class);
    }
}
