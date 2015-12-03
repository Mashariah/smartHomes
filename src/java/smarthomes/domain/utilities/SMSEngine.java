package smarthomes.domain.utilities;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.BasicConfigurator;
import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.Service;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

/**
 * http://wazza.co.ke
 *
 * @author Kelli
 * @date Dec 1, 2015 8:12:31 PM
 * Handle all SMS messaging tasks.
 */
public class SMSEngine {

    public SMSEngine() {
        try {
            //logging to console using log4j
            BasicConfigurator.configure();

            //set up the sms gateway
            OutboundNotification outboundNotification
                    = new OutboundNotification();
            //setup gateway and start the service
            SerialModemGateway gateway = new SerialModemGateway("greenfield.modem",
                    "COM4", 460800, "Huawei", "");
            gateway.setInbound(true);
            gateway.setOutbound(true);
            gateway.setSimPin("1320");

            Service.getInstance().setOutboundMessageNotification(outboundNotification);
            Service.getInstance().addGateway(gateway);
            Service.getInstance().startService();
        } catch (SMSLibException | IOException | InterruptedException exp) {
            Logger.getLogger(SMSEngine.class.getName()).log(Level.SEVERE, null, exp);
        }
    }

    //send SMS message
    public void sendMessage(String message, String recepient){
        try {
            OutboundMessage outboundMessage
                    = new OutboundMessage(recepient, message);
            Service.getInstance().sendMessage(outboundMessage);
        } catch (TimeoutException | GatewayException | IOException | InterruptedException ex) {
            Logger.getLogger(SMSEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //notification for outgoing messages
    public class OutboundNotification implements IOutboundMessageNotification {

        @Override
        public void process(AGateway ag, OutboundMessage om) {
            System.out.println("Outbound handler called from gateway: " + ag.getGatewayId());
        }

    }
    
    public static void main(String[] args) {
        new SMSEngine().sendMessage("Testing send", "+254737570742");
    }
}
