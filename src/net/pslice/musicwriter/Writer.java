package net.pslice.musicwriter;

public class Writer {

    public static int[] noteOn(int delta, int note, int velocity, int chan) {
        int[] data = new int[4];
        data[0] = delta;
        data[1] = 0x90 + chan;
        data[2] = note;
        data[3] = velocity;

        return data;
    }

    public static int[] noteOff(int delta, int note, int chan) {
        int[] data = new int[4];
        data[0] = delta;
        data[1] = 0x80 + chan;
        data[2] = note;
        data[3] = 0;

        return data;
    }

    public static byte[] convertToByte(int[] data) {
        byte[] out = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            out[i] = (byte) data[i];
        return out;
    }
}
