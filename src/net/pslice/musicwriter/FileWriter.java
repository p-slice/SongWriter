package net.pslice.musicwriter;

import net.pslice.musicwriter.tracks.Track;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

class FileWriter {

    /*
    ** Data for track header and footer.
     */
    private static final int[] trackHeader = new int[]{
            0x4d, 0x54, 0x72, 0x6B
    };
    private static final int[] trackFooter = new int[]{
            0x01, 0xFF, 0x2F, 0x00
    };

    /*
    ** Data for song information.
     */
    private static int[] keyData;
    private static int[] tempoData;
    private static int[] timeSignatureData;

    /*
    ** Setters for song information data.
     */
    public static void setKeyData(int key) {
        keyData  = new int[]{
                0x00, 0xFF, 0x59, 0x02,
                key,
                0x00
        };
    }
    public static void setTempoData(int tempo) {
        int finalTempo = 1000000 / (tempo / 60);

        tempoData = new int[]{
                0x00, 0xFF, 0x51, 0x03,
                finalTempo
        };
    }
    public static void setTimeSignatureData() {
        timeSignatureData  = new int[]{
                0x00, 0xFF, 0x58, 0x04,
                0x04,
                0x02,
                0x30,
                0x08
        };
    }

    /*
    ** Method to write the MIDI file.
     */
    public static void write(Set<Track> tracks, String path) throws IOException {
        FileOutputStream output = new FileOutputStream(path);
        int initialSize = trackFooter.length + keyData.length + tempoData.length + timeSignatureData.length;

        int[] header = new int[]{
                0x4d, 0x54, 0x68, 0x64, 0x00, 0x00, 0x00, 0x06,
                0x00, 0x01,
                0x00, tracks.size(),
                0x00, 0x10,
        };
        output.write(Writer.convertToByte(header));

        for (Track track : tracks) {
            if (Song.isVerbose())
                System.out.println("Now saving track: " + track.getName());
            output.write(Writer.convertToByte(trackHeader));

            int trackSize = initialSize;
            for (int[] data : track.getData())
                trackSize += data.length;

            output.write((byte) 0);
            output.write((byte) 0);
            output.write((byte) trackSize / 256);
            output.write((byte) 0);

            output.write(Writer.convertToByte(tempoData));
            output.write(Writer.convertToByte(keyData));
            output.write(Writer.convertToByte(timeSignatureData));

            for (int[] data : track.getData())
                output.write(Writer.convertToByte(data));

            output.write(Writer.convertToByte(trackFooter));
        }

        output.close();
    }
}
