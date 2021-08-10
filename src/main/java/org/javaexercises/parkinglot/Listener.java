package org.javaexercises.parkinglot;

public interface Listener {
    Listener NULL = new Listener() {
        @Override
        public void notifyLotFull() {

        }

        @Override
        public void notifyWhenAvailable() {

        }
    };


    public void notifyLotFull();

    public void notifyWhenAvailable();
}
