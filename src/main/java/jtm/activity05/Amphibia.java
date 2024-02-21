package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Transport {
    private int wheels;
    private byte sails;

    public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
        super(id, consumption, tankSize);
        this.wheels = wheels;
        this.sails = sails;
    }

    @Override
    public String move(Road road) {
        if (road.getClass() == Road.class) {
            super.move(road);
            return this.getType() + " is driving on " + road.toString() + " with " + wheels + " wheels";
        } else if (road instanceof WaterRoad) {
            return this.getType() + " is sailing on " + road.toString() + " with " + sails + " sails";
        }
        return "Something went horribly wrong.";
    }
}
