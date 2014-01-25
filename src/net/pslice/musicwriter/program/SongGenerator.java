package net.pslice.musicwriter.program;

import net.pslice.musicwriter.program.music.scale.Scale;
import net.pslice.musicwriter.program.tracks.Track;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SongGenerator {

    /*
     * ================================================
     * Variables, Objects, Sets, Lists and Maps:
     * ================================================
     */

    // The song being generated
    private final Song song;

    // Random used in generation
    private static final Random random = new Random();

    // Static integer array representations of track header and footer bytes
    private static final int[]
            trackHeader = {0x4d, 0x54, 0x72, 0x6B},
            trackFooter = {0x01, 0xFF, 0x2F, 0x00};

    // Integer array representations of various song parts
    private final int[]
            header,
            key,
            tempo,
            timeSignature;





    /*
     * ================================================
     * Initializer:
     * Parameters:
     *      [Song] song: The song being generated
     * ================================================
     */

    public SongGenerator(Song song)
    {
        this.song = song;

        header = new int[]{
                0x4d, 0x54, 0x68, 0x64, 0x00, 0x00, 0x00, 0x06,
                0x00, 0x01,
                0x00, song.getTracks().size(),
                0x00, 0x10,
        };

        key = new int[] {
                0x00, 0xFF, 0x59, 0x02,
                song.getKey().getID(),
                0x00
        };

        tempo = new int[] {
                0x00, 0xFF, 0x51, 0x03,
                1000000 / (song.getTempo() / 60)
        };

        timeSignature = new int[] {
                0x00, 0xFF, 0x58, 0x04,
                0x04,
                0x02,
                0x30,
                0x08
        };
    }





    /*
     * ================================================
     * Method to generate the components of the song:
     * Parameters:
     *      [None]
     * Returns:
     *      [None]
     * Currently incomplete until song-generation process has been finalized
     * ================================================
     */

    public void generateComponents()
    {
        Scale scale = song.getScale();
        List<Component> components = song.getComponents();
    }





    /*
     * ================================================
     * Method to generate the tracks in the song:
     * Parameters:
     *      [None]
     * Returns:
     *      [None]
     * ================================================
     */

    public void generateTracks()
    {
        Set<Track> tracks = song.getTracks();

        for (Track track : tracks)
            track.generate();
    }





    /*
     * ================================================
     * Static method to convert a int[] to a byte[]
     * Parameters:
     *      [int[]] data: The int[] being converted
     * Returns:
     *      [byte[]] The byte[] of the input data
     * ================================================
     */

    private static byte[] convert(int[] data)
    {
        byte[] out = new byte[data.length];
        for (int i = 0; i < data.length; i++)
            out[i] = (byte) data[i];
        return out;
    }





    /*
     * ================================================
     * Method to complete the song-generating process
     *  and save the song as a MIDI file.
     * Parameters:
     *      [None]
     * Returns:
     *      [None]
     * ================================================
     */

    public void writeSong()
    {
        File file = new File(song.getName() + ".mid");

        for (int i = 1; i < Integer.MAX_VALUE; i++)
        {
            if (file.exists())
                file = new File(song.getName() + " " + i + ".mid");
            else
                break;
        }

        try (FileOutputStream output = new FileOutputStream(file))
        {
            output.write(convert(header));

            int initialSize = trackFooter.length + key.length + tempo.length + timeSignature.length;
            for (Track track : song.getTracks())
            {
                output.write(convert(trackHeader));

                int trackSize = initialSize;
                for (int[] data : track.getData())
                    trackSize += data.length;

                output.write((byte) 0);
                output.write((byte) 0);
                output.write((byte) trackSize / 256);
                output.write((byte) 0);

                output.write(convert(tempo));
                output.write(convert(key));
                output.write(convert(timeSignature));

                for (int[] data : track.getData())
                    output.write(convert(data));

                output.write(convert(trackFooter));
            }

            output.close();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
