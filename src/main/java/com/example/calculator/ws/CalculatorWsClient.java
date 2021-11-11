package com.example.calculator.ws;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.tempuri.Add;
import org.tempuri.AddResponse;
import org.tempuri.Divide;
import org.tempuri.DivideResponse;
import org.tempuri.Multiply;
import org.tempuri.MultiplyResponse;
import org.tempuri.Subtract;
import org.tempuri.SubtractResponse;

public class CalculatorWsClient extends WebServiceGatewaySupport {

    public AddResponse add(final int first, final int second){
        Add request = new Add();
        request.setIntA(first);
        request.setIntB(second);
        return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/Add"));
    }

    public SubtractResponse subtract(final int first, final int second){
        Subtract request = new Subtract();
        request.setIntA(first);
        request.setIntB(second);
        return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/Subtract"));
    }

    public MultiplyResponse multiply(final int first, final int second){
        Multiply request = new Multiply();
        request.setIntA(first);
        request.setIntB(second);
        return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/Multiply"));
    }

    public DivideResponse divide(final int first, final int second){
        Divide request = new Divide();
        request.setIntA(first);
        request.setIntB(second);
        return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/Divide"));
    }

}
