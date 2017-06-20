package coap.exam04.server;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;

public class CoapResource04 extends CoapResource{
    //Field
    private int value;
    //Constructor
    public CoapResource04() {
        super("resource04");
        //관찰 기능 활성화
        setObservable(true);
        //관찰 기능 제공한다라고 클라이언트가 알 수 있도록
        getAttributes().setObservable();
        //테스트
    }
    //Method

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond("value=" + value);
    }

    @Override
    public void handlePOST(CoapExchange exchange) {
        JSONObject jsonObject = new JSONObject(exchange.getRequestText());
        value = jsonObject.getInt("value");
        if(value > 30) {
            changed();
        }
        exchange.respond("ok");
    }
}