package Sensor;

import java.text.SimpleDateFormat;

public class DataSet {
    public String sensorName;
    public long timeStamp;
    public float[] values;
    public DataSet(String name,long time, float[]vals){
        this.sensorName=name;
        this.timeStamp=time;
        this.values=vals;
    }

    public String asString(){
        String valuesAsString =  "";
        for(int i=0; i<values.length;i++){
            valuesAsString += values[i] + ", ";
        }
        return "Sensor name: " + this.sensorName + " Date: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timeStamp)  +" Values: " + valuesAsString;
    }
}
