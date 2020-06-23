import Sensor.DataSet;
import Sensor.DataSetManager;
import Sensor.DataSetManagerImpl;

public class main {
    public static void main(String[] args) {
        float[] avals = new float[1];
        float[] bvals = new float[2];
        float[] cvals = new float[4];
        avals[0] = (float) 4.2;
        bvals[0] = (float) 1.3;
        bvals[1] = (float) 3.7;
        cvals[0] = (float) 4.2;
        cvals[1] = (float) 0;
        cvals[2] = (float) 6.6;
        cvals[3] = (float) 9.9;

        DataSet a = new DataSet("MyGoodSensor",System.currentTimeMillis(),avals);
        DataSet b = new DataSet("MyGoodSensor",System.currentTimeMillis()+1,bvals);
        DataSet c = new DataSet("MyGoodSensor",System.currentTimeMillis()+1000,cvals);

        DataSetManager dsm = new DataSetManagerImpl();
        dsm.addDataSet(c);
        dsm.readLogFile();
        dsm.printData();
    }
}
