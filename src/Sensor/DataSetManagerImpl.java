package Sensor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DataSetManagerImpl implements DataSetManager {
    private String fileName = "logfile.txt";
    private List<DataSet> data = new ArrayList<>();
    final String sensorName = "MyGoodSensor"; //TODO

    @Override
    public void addDataSet(DataSet dataset) {
        try {
            OutputStream os = new FileOutputStream(fileName,true);
            DataOutputStream dos = new DataOutputStream(os);
            //dos.writeChars(dataset.sensorName); //TODO
            dos.writeLong(dataset.timeStamp);
            dos.writeInt(dataset.values.length);
            for(int i = 0; i<= dataset.values.length; i++){
                dos.writeFloat(dataset.values[i]);
            }
            dos.close();
            os.close();
        }catch (Exception e){
            //TODO
        }

    }

    @Override
    public void readLogFile() {
        List<DataSet> fileData = new ArrayList<>();
        try{
            FileInputStream is = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(is);
            String name = sensorName;

            while(dis.available()>=1){
                long time = dis.readLong();
                int valcount = dis.readInt();
                float[] vals = new float[valcount];
                for (int i = 0; i < valcount; i++){
                    vals[i]=dis.readFloat();
                }
                DataSet a = new DataSet(name,time,vals);
                fileData.add(a);
            }
            is.close();
            dis.close();
            this.data = fileData;


        }catch (Exception e){
            //TODO
        }
    }

    @Override
    public void printData() {
        for (DataSet dataset:data) {
            System.out.println(dataset.asString());
        }

    }

    @Override
    public void printDataSet(int index) {
        if(index<0){
            System.out.println(data.get(data.size()+index).asString());
        }
        else{
            System.out.println(data.get(index).asString());
        }
    }

    @Override
    public DataSet getDataSet(int index) {
        if(index<0){
            return (data.get(data.size()+index));
        }
        else{
            return (data.get(index));
        }
    }

    public DataSetManagerImpl(String fileName){
        this.fileName = fileName;
    }
    public DataSetManagerImpl(){}
}
