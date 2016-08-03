package com.ociweb.iot.project.lightblink;

import static com.ociweb.iot.grove.GroveTwig.LED;
import static com.ociweb.iot.grove.GroveTwig.Button;

import com.ociweb.iot.hardware.Hardware;
import com.ociweb.iot.maker.CommandChannel;
import com.ociweb.iot.maker.DeviceRuntime;
import com.ociweb.iot.maker.IoTSetup;


public class IoTApp implements IoTSetup {
           
    public static void main( String[] args) {
        DeviceRuntime.run(new IoTApp());
    }    
    
    @Override
    public void declareConnections(Hardware hardware) {
        hardware.useConnectD(LED, 5);
        hardware.useConnectD(Button, 6);
    }

    @Override
    public void declareBehavior(DeviceRuntime runtime) {
        
        final CommandChannel ledChannel = runtime.newCommandChannel(); 
        
        runtime.addDigitalListener((connection,time,durationMillis, value)->{
        	
            ledChannel.digitalSetValue(5,value);
        	        	
        });
              
    }  
}

