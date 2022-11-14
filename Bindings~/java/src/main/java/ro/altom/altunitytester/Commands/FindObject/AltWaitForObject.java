package ro.altom.altunitytester.Commands.FindObject;

import ro.altom.altunitytester.Utils;
import ro.altom.altunitytester.IMessageHandler;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.altUnityTesterExceptions.WaitTimeOutException;

/**
 * Wait until there are no longer any objects that respect the given criteria or
 * times run out and will throw an error.
 */
public class AltWaitForObject extends AltBaseFindObject {
    /**
     * @param altFindObjectsParameters the properties parameter for finding the
     *                                 objects in a scene.
     */
    private AltWaitForObjectsParams altWaitForObjectsParameters;

    public AltWaitForObject(IMessageHandler messageHandler, AltWaitForObjectsParams altWaitForObjectsParameters) {
        super(messageHandler);
        this.altWaitForObjectsParameters = altWaitForObjectsParameters;
    }

    public AltUnityObject Execute() {
        double time = 0;
        AltUnityObject altElement = null;
        while (time < altWaitForObjectsParameters.getTimeout()) {
            logger.debug("Waiting for element where name contains "
                    + altWaitForObjectsParameters.getAltFindObjectsParameters().getPath() + "....");
            try {
                altElement = new AltFindObject(messageHandler,
                        altWaitForObjectsParameters.getAltFindObjectsParameters()).Execute();
                if (altElement != null) {
                    return altElement;
                }
            } catch (Exception e) {
                logger.warn("Exception thrown: " + e.getLocalizedMessage());
            }
            Utils.sleepFor(altWaitForObjectsParameters.getInterval());
            time += altWaitForObjectsParameters.getInterval();
        }
        throw new WaitTimeOutException("Element " + altWaitForObjectsParameters.getAltFindObjectsParameters().getPath()
                + " still not found after " + altWaitForObjectsParameters.getTimeout() + " seconds");
    }
}
