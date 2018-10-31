import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
	
	private Queue<Note> songNotes = new LinkedList<Note>();
	private boolean inRepeatSection = false;

	public Melody (Queue<Note> song) {
		while (!song.isEmpty())  {
			songNotes.add(song.remove());
		}
	}
	
	public double getTotalDuration() {
		double total = 0.0;
		Queue<Note> repeats = new LinkedList<Note>();
		
		for (Note i : songNotes) {
			if (i.isRepeat()) {
				repeats.add(i);
				inRepeatSection = !inRepeatSection;
			} else if (inRepeatSection) {
				repeats.add(i);
			} else if (!repeats.isEmpty()) {
				while (!repeats.isEmpty()) {
					total = total + repeats.remove().getDuration();
				}
			}
			
			total = total + i.getDuration();
		}
		
		inRepeatSection = false;
		return total;
		
	}
	public String toString() {
		String output = "";
		for (Note i : songNotes) {
			output = output + i.toString() + "\n";
		}
		return output;
	}
	
	public void changeTempo(double tempo) {
		for (Note i : songNotes) {
			i.setDuration(i.getDuration()*tempo);
		}
	}
	
	public void reverse() {
		Stack<Note> temp = new Stack<Note>();
		
		while (!songNotes.isEmpty()) {
			temp.push(songNotes.remove());
		}
		
		while (!temp.isEmpty()) {
			songNotes.add(temp.pop());
		}
		
	}
	
	public void append(Melody other) {
		while (!other.songNotes.isEmpty())  {
			songNotes.add(other.songNotes.remove());
		}
	}
	
	public void play() {
		Queue<Note> repeats = new LinkedList<Note>();
		
		for (Note i : songNotes) {
			if (i.isRepeat()) {
				repeats.add(i);
				inRepeatSection = !inRepeatSection;
			} else if (inRepeatSection) {
				repeats.add(i);
			} else if (!repeats.isEmpty()) {
				while (!repeats.isEmpty()) {
					repeats.remove().play();
				}
			}
			
			i.play();
		}
		
		inRepeatSection = false;
	}
}


