/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class getMoveSingleton {

    private String value = "0";
    private String distanceTemperature="0,0";
    private static getMoveSingleton instance = null;
    private final Object lock = new Object();
    private final Object lock2 = new Object();

    protected getMoveSingleton() {
        // Exists only to defeat instantiation.
    }

    public static getMoveSingleton getInstance() {
        if (instance == null) {
            instance = new getMoveSingleton();
        }
        return instance;
    }

    public String getValue() {
        synchronized (lock) {
            return value;
        }
    }

    public String getTempDist() {
        synchronized (lock2) {
            return distanceTemperature;
        }
    }

    public void setValue(String value) {
        synchronized (lock) {
            this.value = value;
        }
    }

    public void setTempDist(String tempDist) {
        synchronized (lock2) {
            this.distanceTemperature = tempDist;
        }
    }

}
