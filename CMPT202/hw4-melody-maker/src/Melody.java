import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
	
	private Queue<Note> songNotes = new LinkedList<Note>();
	private boolean inRepeatSection = false;

	// Constructor, moves notes from temp song to songNotes
	public Melody (Queue<Note> song) {
		while (!song.isEmpty())  {
			songNotes.add(song.remove());
		}
	}
	
	// get total duration
	public double getTotalDuration() {
		// start total at 0
		double total = 0.0;
		
		// make repeats queue
		Queue<Note> repeats = new LinkedList<Note>();
		
		// go through each note
		for (int i = 0; i < songNotes.size(); i++ ) {
			//remove from queue
			Note j = songNotes.remove();
			
			//check if repeat and add to repeat else empty repeat queue
			if (j.isRepeat()) {
				repeats.add(j);
				inRepeatSection = !inRepeatSection;
			} else if (inRepeatSection) {
				repeats.add(j);
			} else if (!repeats.isEmpty()) {
				while (!repeats.isEmpty()) {
					total = total + repeats.remove().getDuration();
				}
			}
			
			// add duration of note to total
			total = total + j.getDuration();
			
			// add note back to queue
			songNotes.add(j);
		}
		
		// set this to false for next time it repeats incase there was 
		// bad programming of the song and the repeat never ended
		inRepeatSection = false;
		return total;
		
	}
	
	// to sting
	public String toString() {
		// start with no output
		String output = "";
		
		// go through each node
		for (int i = 0; i < songNotes.size(); i++ ) {
			Note j = songNotes.remove();
			
			// append to output
			output = output + j.toString() + "\n";
			
			songNotes.add(j);
		}
		return output;
	}
	
	// change tempo 
	public void changeTempo(double tempo) {
		// go through each node
		for (int i = 0; i < songNotes.size(); i++ ) {
			Note j = songNotes.remove();
			
			// update duration
			j.setDuration(j.getDuration()*tempo);
			
			songNotes.add(j);
		}
	}
	
	public void reverse() {
		// make intermediary stack
		Stack<Note> temp = new Stack<Note>();
		
		// push all to stack
		while (!songNotes.isEmpty()) {
			temp.push(songNotes.remove());
		}
		
		// add to queue (this reverses stuff)
		while (!temp.isEmpty()) {
			songNotes.add(temp.pop());
		}
		
	}
	
	// append
	public void append(Melody other) {
		//check if there are notes to append
		while (!other.songNotes.isEmpty())  {
			// add to queue
			songNotes.add(other.songNotes.remove());
		}
	}
	
	// play
	public void play() {
		// make repeats queue
		Queue<Note> repeats = new LinkedList<Note>();
		
		// go through each note
		for (int i = 0; i < songNotes.size(); i++ ) {
			Note j = songNotes.remove();
			
			// if repeat add to repead
			if (j.isRepeat()) {
				repeats.add(j);
				inRepeatSection = !inRepeatSection;
			// else if were in a repeat section add the node into repeats
			} else if (inRepeatSection) {
				repeats.add(j);
			// else if repeats isn't empty play the note
			} else if (!repeats.isEmpty()) {
				while (!repeats.isEmpty()) {
					repeats.remove().play();
				}
			}
			
			// else play the note
			j.play();
			
			songNotes.add(j);
		}
		
		// reset inRepeatSection to original setting in case of bad song coding
		inRepeatSection = false;
	}
}


