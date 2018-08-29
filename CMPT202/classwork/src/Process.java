/**
 * A simple class that represents a process in an operating system.
 */
public class Process
{
    public enum State {READY, RUNNING, BLOCKED};

    private String command;
    private int processId;
    private State state;

    public Process(String command, int processId, State state) {
        this.command = command;
        this.processId = processId;
        this.state = state;
    }
    
    public boolean equals(Object other) {
    	// check null
    	if (other == null) {
    		return false;
    	}
    	
    	// check same mem obj
    	if (this == other) {
    		return true;
    	}
    	
    	// if instance of then cast
    	if (!(other instanceof Process)) {
    		return false;
    	}
    	
    	Process o = (Process) other;
    	
    	// check variables of the processes
    	return ((this.command.equals(o.command) && (this.state.equals(o.state))));
    }
}
