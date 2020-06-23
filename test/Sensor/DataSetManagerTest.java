package Sensor;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DataSetManagerTest {

    DataSetManager dsm = new DataSetManagerImpl("testfile");
    float[] aval = {4.2f};
    float[] bval = {1.3f,3.7f};
    float[] cval = {4.2f,0f,6.9f,6.9f};
    DataSet a = new DataSet("MyGoodSensor",System.currentTimeMillis(),aval);
    DataSet b = new DataSet("MyGoodSensor",System.currentTimeMillis()+1337,bval);
    DataSet c = new DataSet("MyGoodSensor",System.currentTimeMillis()+69420,cval);

    @BeforeEach
    void deleteTestfile(){
        File file = new File("testfile");
        file.delete();
    }

    @Test
    void addDataSetWorking(){
        dsm.addDataSet(a);
        dsm.readLogFile();
        DataSet z = dsm.getDataSet(0);
        assert a.sensorName == z.sensorName;
        assert a.timeStamp == z.timeStamp;
        assertArrayEquals(a.values,z.values);
    }

    @Test
    void addDataSetPersistenceWorking(){
        dsm.addDataSet(a);
        dsm.addDataSet(b);
        dsm.readLogFile();
        DataSet z = dsm.getDataSet(0);
        assert a.sensorName == z.sensorName;
        assert a.timeStamp == z.timeStamp;
        assertArrayEquals(a.values,z.values);
        z = dsm.getDataSet(1);
        assert b.sensorName == z.sensorName;
        assert b.timeStamp == z.timeStamp;
        assertArrayEquals(b.values,z.values);
    }

    @Test
    void addDataSetNotWorking(){
        //TODO
    }



}