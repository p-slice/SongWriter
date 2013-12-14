SongWriter
==========

The newest edition of my Music Writer

At long last, a brand new version is here! This entirely new take on my old Music Writer is much more configurable, customizeable, and efficient than the previous version. Although it is still incomplete and doesn't fully function properly, fixes will be released as soon as I can find out what is wrong with it.

Some of the major highlights include:

- Completely new Track implementation:
	- Tracks have no defined limit, so as many or as few as you want can be added.
	- Users can add pre-defined track types (Chord, melody, bass, drums, for example), or create their own - the program is designed to accept any type of track. *Note: not all pre-defined tracks are currently written*
	- Creating a new track gives it a default set of information, which can then be configured.
- Components are much more configurable:
	- Similar to tracks, new components can simply be loaded into the song.
	- The song auto-generates with at least one intro and outro, and any number of components in between (up to a set maximum).
	- Pre-defined components include Intro, Verse, Chorus, Bridge, Solo and Outro, the original six from the first music writer. Verses and choruses are added automatically, while bridges and solos are optional, as are any custom-made components.
- Make-over of scales:
	- As with the previous two, users can use pre-defined scales in the song, or create their own.
- New probability system:
	- Unlike the old system, things like the next note or component are not determined by what came before it.
	- Instead, a probability generator capable of working with any object is used.
	- Simply create a new generator, add each object and how likely it is to appear, and get the result!

The main idea behind this new Music Writer is to make it a lot easier for the user to create their own things to use in the song.

Anything that was mentioned in the above that isn't added yet will be soon. Sometimes I just get ahead of myself and start talking about them before they're actually added. Also, note to self: fix the actual file saving. If anyone were to run this right now, you'd see what I mean...
