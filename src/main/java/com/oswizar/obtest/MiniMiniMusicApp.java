package com.oswizar.obtest;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.util.Scanner;

public class MiniMiniMusicApp {
	public static void main(String[] args) throws InterruptedException {

		String s;
		while(true){



			Thread.sleep(2000);
			MiniMiniMusicApp mini = new MiniMiniMusicApp();
			mini.play();

			Scanner reader=new Scanner(System.in);

			s=reader.next();

			if ("0".equals(s)){
				System.exit(0);
			}

		}

	}

	public void play(){
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,44,100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			player.setSequence(seq);

			player.start();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
