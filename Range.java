package org.networks.sock;

public class Range {
  private int start;
	private int end;

	public Range(int r_start, int r_end) {
		start = r_start;
		end = r_end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
