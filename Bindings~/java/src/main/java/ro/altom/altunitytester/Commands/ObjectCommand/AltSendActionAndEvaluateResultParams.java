package ro.altom.altunitytester.Commands.ObjectCommand;

import ro.altom.altunitytester.AltUnityObject;

public class AltSendActionAndEvaluateResultParams extends AltUnityObjectParams {

    AltSendActionAndEvaluateResultParams(AltUnityObject altUnityObject) {
        super.altUnityObject = altUnityObject;
    }

    public AltUnityObject getAltUnityObject() {
        return altUnityObject;
    }

    public void setAltUnityObject(AltUnityObject altUnityObject) {
        this.altUnityObject = altUnityObject;
    }
}
