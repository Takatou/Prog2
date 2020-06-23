package Sensor;

import java.util.Set;

public interface DataSetManager {
    public void addDataSet(DataSet dataset);
    public void readLogFile();
    public void printData();
    public void printDataSet(int index);
    public DataSet getDataSet(int index);
}
